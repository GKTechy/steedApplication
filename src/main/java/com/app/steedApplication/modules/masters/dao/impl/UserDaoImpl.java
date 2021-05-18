package com.app.steedApplication.modules.masters.dao.impl;


import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.MainMenuEntity;
import com.app.steedApplication.entity.MenuEntity;
import com.app.steedApplication.entity.SubMenuEntity;
import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.entity.UserRoleEntity;
import com.app.steedApplication.entity.UserRoleMappingEntity;
import com.app.steedApplication.modules.masters.dao.UserDao;
import com.app.steedApplication.modules.masters.dao.constant.UserConstant;
import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;
import com.app.steedApplication.modules.masters.model.UserVO;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	private Logger logger = Logger.getLogger(getClass().getName());

	@SuppressWarnings("unchecked")
	@Override
	public UserVO getAllUsers() {

		Session session = this.sessionFactory.openSession();
		UserVO uservoObj=new UserVO();
		List<UserEntity> userList= new ArrayList<UserEntity>();
		try {

			userList = session.createSQLQuery(" SELECT u.user_id AS userId,u.user_name AS userName,cast(AES_DECRYPT(u.password, 'steed_app') as char(255)) AS password,u.status as status FROM user u WHERE u.`status`='Active'")
					.setResultTransformer(Transformers.aliasToBean(UserEntity.class)).list();
			//System.out.println("userList------"+userList.size());
			
			for(UserEntity obj: userList ) {
				String roles= (String) session.createSQLQuery("SELECT  GROUP_CONCAT(CONCAT(r.role_name,'')) AS roles FROM user u,user_roles_mapping ur,roles r WHERE u.`status`='Active' AND u.user_id=ur.user_id AND r.role_id=ur.role_id and u.user_id="+obj.getUserId()).uniqueResult();
				//System.out.println("roles-->"+roles);
				obj.setUserRoles(roles);
				
			}
			uservoObj.setValid(true);
			uservoObj.setUsersList(userList);
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return uservoObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserVO findUserbyId(int id) {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj=new UserVO();
		List<UserEntity> userList= new ArrayList<UserEntity>();
		try {

			userList = session.createQuery(" FROM UserEntity r where r.status='Y' and userId="+id).list();
			//System.out.println("userList------"+userList.size());
			uservoObj.setValid(true);
			uservoObj.setUsersList(userList);
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return uservoObj;
	}

	@Override
	public UserVO deleteUserbyId(int id) {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj=new UserVO();
		Transaction tx=session.beginTransaction();
		try {

			session.createQuery(" UPDATE UserEntity SET status='N' WHERE userId="+id).executeUpdate();
			tx.commit();
			uservoObj.setValid(true);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return uservoObj;
	}

	@Override
	public UserVO CreateOrUpdateUser(UserEntity usr) {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj=new UserVO();
		Transaction tx=session.beginTransaction();
		try {

			if(usr.getUserId() == 0) {

				BigInteger userCount = (BigInteger)session.createSQLQuery("SELECT COUNT(*) FROM UserEntity u WHERE u.username='"+usr.getUserName()+"'").uniqueResult();

				if(userCount.intValue() > 0) {
					uservoObj.setValid(false);
					uservoObj.setResponseMsg("UserName Already Exists!");

				}else {
					session.save(usr);
					uservoObj.setUserObj(usr);
				}

			}else {

				UserEntity rt=  session.get(UserEntity.class, usr.getUserId());
				rt.setStatus(usr.getStatus());
				rt.setUserName(usr.getUserName());
				
				rt.setPwdToBeChanged("Y");
				rt.setExpiryDate(new Date());

				session.saveOrUpdate(rt);
				uservoObj.setUserObj(usr);
			}

			tx.commit();
			uservoObj.setValid(true);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		

		return uservoObj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public UserVO userLogin(UserVO userVO) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();
		List<UserEntity> userList = new ArrayList<UserEntity>();
		List<MainMenuEntity> menuList =null;
		
		try {
			userList = session.createSQLQuery(" SELECT u.user_id AS userId,u.user_name AS userName,u.pwdtobechanged AS pwdToBeChanged,u.expirydate AS expiryDate FROM user u WHERE u.user_name = '"+userVO.getUserName()+"' AND u.password = AES_ENCRYPT('"+userVO.getPassword().trim()+"','steed_app') ")
					.setResultTransformer(Transformers.aliasToBean(UserEntity.class)).list();
	//		System.out.println("userList------"+userList.size());
			if(userList.size() > 0) {
				uservoObj.setValid(true);
				uservoObj.setResponseMsg("Successfully Logged");
				
			
				
				menuList = session.createSQLQuery("SELECT distinct mm.main_menu_id mainMenuId ,mm.main_menu_name AS mainMenuName,mm.icon AS icon  FROM main_menu mm, menu m,role_menu_mapping AS rm\r\n" + 
						" WHERE  m.main_menu_id=mm.main_menu_id AND rm.menu_id=m.menu_id AND rm.roleId in (SELECT role_id FROM user_roles_mapping WHERE user_id="+userList.get(0).getUserId()+")")
						.setResultTransformer(Transformers.aliasToBean(MainMenuEntity.class)).list();
				
				for(MainMenuEntity mboj: menuList) {
					List<SubMenuEntity> sList = session.createQuery("FROM SubMenuEntity WHERE mainMenuId="+mboj.getMainMenuId()+" AND component!='' order by subMenuId").list();
					mboj.setSubMenuList(sList);
				}
				//uservoObj.setMenuList(menuList);
				userList.get(0).setMenuList(menuList);
				uservoObj.setUsersList(userList);
			} else {
				uservoObj.setValid(false);
				uservoObj.setResponseMsg("Invalid Login Credentials");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
			logger.info(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
			userList = null;
		}		
		return uservoObj;
	}

	@Override
	public UserVO changePassword(String userName, String currentPassword, String newPassword) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();
		Transaction tx=session.beginTransaction();
		try {
//			UserEntity rt=  session.get(UserEntity.class, Long.valueOf(userName.trim()));
//			rt.setPassword(newPassword);
//			session.saveOrUpdate(rt);
//			session.flush();
			
			session.createSQLQuery(UserConstant.Change_PWD_Update).setParameter("password", newPassword).setParameter("userName", userName).executeUpdate();

			tx.commit();
			uservoObj.setValid(true);
			uservoObj.setResponseMsg("Password Changed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return uservoObj;
	}
	
	@Override
	public UserVO forgotPassword(String userName, String currentPassword, String newPassword) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();
		Transaction tx=session.beginTransaction();
		try {
			session.createSQLQuery(UserConstant.Forgot_PWD_Update).setParameter("userName", userName).executeUpdate();
			tx.commit();
			uservoObj.setValid(true);
			uservoObj.setResponseMsg("Forgot Password Process Done Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return uservoObj;
	}
	
	
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		/*Properties javaMailProperties = new Properties();
		List<Map<String,Object>> mailList = null;
		Session session = this.sessionFactory.openSession();
		mailList = session.createSQLQuery("select id as id, company_code as companyCode, mail_server as mailServer, mail_server_port as mailServerPort, sender_mail_address as senderMailAddress, CAST(AES_DECRYPT(ea.password,'o2web_mail') as char(50)) as password, cc_mail_address as ccMailAddress, bcc_mail_address as bccMailAddress, status as status from email_account as ea where ea.status = 'Y'")
				.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
		for (Map<String, Object> entry : mailList) {
			mailSender.setHost((String) entry.get("mailServer"));
			mailSender.setPort(Integer.valueOf((String) entry.get("mailServerPort")));
	        mailSender.setUsername((String) entry.get("senderMailAddress"));
	        mailSender.setPassword((String) entry.get("password"));
	 
	        
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.properties.mail.tls", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.tls", "true");
	        //javaMailProperties.put("mail.smtp.ssl.trust", (String) entry.get("mailServer"));
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.writetimeout", "5000");
	        javaMailProperties.put("mail.debug", "true");
	        		 
	        mailSender.setJavaMailProperties(javaMailProperties);
		} */
		return mailSender;
	}
	

	@SuppressWarnings("unchecked")
	public UserVO saveUserList(UserVO userVO) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO robj = new UserVO();
		UserEntity user = new UserEntity();
		Transaction tx=session.beginTransaction();
		try {
			
			Date date = new Date();
		    SimpleDateFormat df  = new SimpleDateFormat("YYYY-MM-dd");
		    Calendar c1 = Calendar.getInstance();
		    String currentDate = df.format(date);// get current date here

		    // now add 30 day in Calendar instance 
		    c1.add(Calendar.DAY_OF_YEAR, 90);
		    df = new SimpleDateFormat("yyyy-MM-dd");
		    Date resultDate = c1.getTime();
		    
			user = userVO.getUserObj();
			if(user.getUserId() == 0) {
				
				user.setDisplayName(user.getUserName());
				user.setPwdToBeChanged("N");
				user.setExpiryDate(resultDate);
				user.setCreated(new Date());
				user.setUpdated(new Date());
				
				session.save(user);
				
				for(UserRoleEntity role : userVO.getRoleList()) {
					
					if(role.getIsChecked()) {
						
						UserRoleMappingEntity urobj =new UserRoleMappingEntity();
						urobj.setRoleId(role.getRoleId());
						urobj.setUserId(user.getUserId());
						session.save(urobj);
					}
				}
			}else {
					
			//	user.setCreated(new Date());
				//user.setUpdated(new Date());
				session.createSQLQuery("delete  from user_roles_mapping where user_id="+user.getUserId()).executeUpdate();
				
				for(UserRoleEntity role : userVO.getRoleList()) {
					
					if(role.getIsChecked()) {
						
						UserRoleMappingEntity urobj =new UserRoleMappingEntity();
						urobj.setRoleId(role.getRoleId());
						urobj.setUserId(user.getUserId());
						session.save(urobj);
					}
				}
			}
			tx.commit();
			robj.setValid(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			robj.setValid(false);
			robj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return robj;
	}
	
	@SuppressWarnings("unchecked")
	public UserVO deleteUser(int id, String employeeId, String loginUser, String companyCode) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();		
		Transaction tx=session.beginTransaction();		
		String reportEmployeeId = null;
		String subEeportToEmployeeId = null;
		List<Map<String,Object>> reportToList = null;
		try {
			session.createSQLQuery(UserConstant.USER_HISTROY).setParameter("id", id).setParameter("movedby", loginUser).setParameter("movedon", new Date()).executeUpdate();
			session.createSQLQuery(UserConstant.SALESMAN_HISTROY).setParameter("id", employeeId).setParameter("movedby", loginUser).setParameter("movedon", new Date()).executeUpdate();
			session.createSQLQuery(UserConstant.USER_REPORTING_DETAILS_HISTROY).setParameter("id", employeeId).setParameter("movedby", loginUser).setParameter("movedon", new Date()).executeUpdate();
			session.createSQLQuery(UserConstant.USER_PREFERENCE_HISTROY).setParameter("id", id).setParameter("movedby", loginUser).setParameter("movedon", new Date()).executeUpdate();

			session.createSQLQuery("delete from user_reporting_details where company_code =:companyCode and user_id =:employeeId").setParameter("employeeId", employeeId).setParameter("companyCode", companyCode).executeUpdate();			
			reportToList = session.createSQLQuery("select u.employee_id as employeeId from user as u where u.company_code =:companyCode and u.report_to =:employeeId").setParameter("companyCode", companyCode).setParameter("employeeId", employeeId).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();			
			if(reportToList.size() > 0) {
				for (Map<String, Object> entry : reportToList) {
					reportEmployeeId = (String) entry.get("employeeId");
					session.createSQLQuery("delete from user_reporting_details where company_code =:companyCode and user_id =:reportEmployeeId").setParameter("reportEmployeeId", reportEmployeeId).setParameter("companyCode", companyCode).executeUpdate();
					int i = 0;
					while (i < 1) {
						subEeportToEmployeeId = (String) session.createSQLQuery("select u.employee_id as employeeId from user as u where u.company_code =:companyCode and u.report_to =:reportEmployeeId").setParameter("companyCode", companyCode).setParameter("reportEmployeeId", reportEmployeeId).uniqueResult();
						if(subEeportToEmployeeId == null) {
							i = 2;
							reportEmployeeId = null;
							subEeportToEmployeeId = null;
						} else {
							session.createSQLQuery("delete from user_reporting_details where company_code =:companyCode and user_id =:subEeportToEmployeeId").setParameter("subEeportToEmployeeId", subEeportToEmployeeId).setParameter("companyCode", companyCode).executeUpdate();
							reportEmployeeId = subEeportToEmployeeId;
						}
					}
				}
			}
			
			session.createSQLQuery("update user as u set u.report_to = null where u.report_to =:employeeId and u.company_code =:companyCode").setParameter("employeeId", employeeId).setParameter("companyCode", companyCode).executeUpdate();
			session.createSQLQuery("delete from user where company_code =:companyCode and employee_id =:id").setParameter("id", employeeId).setParameter("companyCode", companyCode).executeUpdate();
			session.createSQLQuery("delete from salesman where salesman_code =:id").setParameter("id", employeeId).executeUpdate();
			session.createSQLQuery("delete from user_reporting_details where company_code =:companyCode and user_id =:id").setParameter("id", employeeId).setParameter("companyCode", companyCode).executeUpdate();
			session.createSQLQuery("delete from user_preference where company_code =:companyCode and user_id =:id").setParameter("id", id).setParameter("companyCode", companyCode).executeUpdate();
			tx.commit();
			uservoObj.setValid(true);			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
			reportEmployeeId = null;
			subEeportToEmployeeId = null;
			reportToList = null;
		}		
		return uservoObj;
	}
	
	public UserVO resetPassword(UserVO userVO) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		UserVO robj = new UserVO();
		try {
			if(!userVO.getChangeFlag()) {
				session.createSQLQuery(UserConstant.UPDATE_USER_PASSWORD).setParameter("id", userVO.getId()).setParameter("companyCode", userVO.getCompanyCode()).setParameter("password", userVO.getResetPassword()).setParameter("changeFlag", "Y").setParameter("movedby", userVO.getLoginUser()).setParameter("movedon", new Date()).executeUpdate();
			} else {
				BigInteger oldPassword = (BigInteger) session.createSQLQuery(UserConstant.CHECK_OLD_PASSWORD).setParameter("id", userVO.getId()).setParameter("companyCode", userVO.getCompanyCode()).setParameter("password", userVO.getOldPassword()).uniqueResult();
				if(oldPassword.intValue() > 0) {										
					session.createSQLQuery(UserConstant.UPDATE_USER_PASSWORD).setParameter("id", userVO.getId()).setParameter("companyCode", userVO.getCompanyCode()).setParameter("password", userVO.getResetPassword()).setParameter("changeFlag", "N").setParameter("movedby", userVO.getLoginUser()).setParameter("movedon", new Date()).executeUpdate();
				} else {
					robj.setOldPasswordFlag(true);					
				}
			}			
			tx.commit();
			robj.setValid(true);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			robj.setValid(false);
			robj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}
		}
		return robj;
	}
	
	public UserVO getTMPasswordValidation(int id, String companyCode) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO robj = new UserVO();
		try {
			//System.out.println(java.time.LocalDate.now()); 
			BigInteger oldPassword = (BigInteger) session.createSQLQuery(UserConstant.CHECK_PASSWORD_VALIDATION).setParameter("id", id).setParameter("companyCode", companyCode).setParameter("date", java.time.LocalDate.now()).uniqueResult();
			if(oldPassword.intValue() > 0) {					
				robj.setOldPasswordFlag(true);
			}
			robj.setValid(true);
		} catch (Exception e) {			
			e.printStackTrace();
			robj.setValid(false);
			robj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}
		}
		return robj;
	}

	
}
