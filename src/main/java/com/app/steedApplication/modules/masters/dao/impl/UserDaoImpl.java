package com.app.steedApplication.modules.masters.dao.impl;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.Configuration.MailConfiguration;
import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.modules.masters.dao.UserDao;
import com.app.steedApplication.modules.masters.dao.constant.UserConstant;
import com.app.steedApplication.modules.masters.model.UserVO;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MailConfiguration mailConfiguration;

	private Logger logger = Logger.getLogger(getClass().getName());

	@SuppressWarnings("unchecked")
	@Override
	public UserVO getAllUsers() {

		Session session = this.sessionFactory.openSession();
		UserVO uservoObj=new UserVO();
		List<UserEntity> userList= new ArrayList<UserEntity>();
		try {

			userList = session.createQuery(" FROM UserEntity r where r.status='Y'").list();
			System.out.println("userList------"+userList.size());
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
			System.out.println("userList------"+userList.size());
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

			if(usr.getUserId() == null) {

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
	public UserVO userLogin(String userName, String userPassword) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();
		List<UserEntity> userList = new ArrayList<UserEntity>();
		List<String[]> menuDetail = new ArrayList<String[]>();
		Query query = null;
	
		String retailerCode = "";
		try {
//			userList = session.createQuery(" FROM UserEntity r where r.status='Y' and r.userName='"+userName+"' and r.password='"+userPassword.trim()+"'").list();
			userList = session.createQuery(" FROM UserEntity AS u WHERE u.loginUserId = '"+userName+"' AND u.password = AES_ENCRYPT('"+userPassword.trim()+"','o2web_ng') ").list();
			System.out.println("userList------"+userList.size());
			if(userList.size() > 0) {
				uservoObj.setValid(true);
				uservoObj.setResponseMsg("Successfully Logged");
				
				//Date datetmp=(Date) session.createSQLQuery("SELECT dp.business_dtm FROM distributor_pref dp WHERE dp.`status`='Y' AND dp.distributor_code='"+userList.get(0).getDistributorCode()+"'").uniqueResult();
				//SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd yyyy");
				//String businessDtm = sdf.format(datetmp.getTime());

				//uservoObj.setBusinessDtm(businessDtm);
//				menuDetail = (List<String[]>) session.createSQLQuery("select m.display_name, case when ura.write_access = 'Y' then 'true' else 'false' end from menus as m, user_role_access as ura, user_roles as ur where ur.role_name =:userType and ura.role_id = ur.role_id and m.menu_id = ura.screen_id")
	//					.setParameter("userType", userList.get(0).getUserType()).list();
		//		 for (Object[] mm : menuDetail) {
					
			//	 }
				// uservoObj.setUsersList(userList);
				 
				// BigInteger oldPassword = (BigInteger) session.createSQLQuery(UserConstant.CHECK_PASSWORD_VALIDATION).setParameter("id", userList.get(0).getUserId()).setParameter("companyCode", userList.get(0).getCompanyCode()).setParameter("date", java.time.LocalDate.now()).uniqueResult();
				//	if(oldPassword.intValue() > 0) {					
				//		uservoObj.setOldPasswordFlag(true);
				//	}

						
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
			menuDetail = null;
			query = null;
		
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
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public UserVO getMMMenuList(String userType) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();
		List<Map<String,Object>> menuList = null;
		try {
			menuList = session.createSQLQuery(UserConstant.GET_MENU).setParameter("userType", userType).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			uservoObj.setMenuList(menuList);
			uservoObj.setValid(true);			
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}
			menuList = null;
		}		
		return uservoObj;
	}
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties javaMailProperties = new Properties();
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
		}
		return mailSender;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public UserVO getUMuserList(String companyCode) throws Exception {
		Session session = this.sessionFactory.openSession();
		UserVO uservoObj = new UserVO();
		List<Map<String,Object>> umUsersList = null;
		List<Map<String,Object>> umUserTypeList = null;
		List<Map<String,Object>> umUserLanguageList = null;
		List<Map<String,Object>> umDistributorList = null;
		List<Map<String,Object>> umReportList = null;
		try {
			//umUsersList = session.createSQLQuery("select u.id as id, u.distributor_code as distributorCode, u.brand_code as brandCode, u.device_id as deviceId, u.phone_number as phoneNumber, u.email as email, u.username as userName, u.user_type as userType, u.`status` as userStatus, u.pwdtobechanged as pwdtobechanged, u.erp_user_id as erpUserId, u.employee_id as employeeId, DATE_FORMAT(u.expirydate,'%d/%m/%Y') as expiryDate, DATE_FORMAT(u.expirydate,'%Y-%m-%d') AS savedExpiryDate, CAST(AES_DECRYPT(u.password,'o2web_ng') as char(50)) as password, u.report_to as reportTo, up.language as language, up.display_image_order as displayImageOrder, up.`status` as status, ur.role_position as rolePosition, u.role_position as userTypePosition, md.display_seq as languageId from user as u left join user_preference as up on u.id = up.user_id and up.company_code =:companyCode left join user_roles as ur on u.user_type = ur.role_name and ur.`status` = 'Y' and ur.company_code =:companyCode left join metadata as md on up.language = md.Meta_Data_Name and md.is_deleted = 'N' and md.Meta_Data_Type = 'Language' where u.company_code =:companyCode order by u.id desc").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			umUsersList = session.createSQLQuery("select u.id as id, u.distributor_code as distributorCode, u.brand_code as brandCode, u.device_id as deviceId, u.phone_number as phoneNumber, u.email as email, u.user_id as loginUserId, u.display_name as userName, u.user_type as userType, u.`status` as userStatus, u.pwdtobechanged as pwdtobechanged, ifnull(u.employee_number,'') as employeeNumber, u.erp_user_id as erpUserId, ifnull(u.employee_id,'') as employeeId, DATE_FORMAT(u.expirydate,'%d/%m/%Y') as expiryDate, DATE_FORMAT(u.expirydate,'%Y-%m-%d') AS savedExpiryDate, CAST(AES_DECRYPT(u.password,'o2web_ng') as char(50)) as password, u.report_to as reportTo, up.language as language, up.display_image_order as displayImageOrder, up.`status` as status, md.display_seq as languageId, ur.role_id as userTypeId, u.salesman_code as salesmanCode from user as u left join user_preference as up on u.id = up.user_id and up.company_code =:companyCode left join user_roles AS ur on u.user_type = ur.role_name and ur.`status` = 'Y' and ur.company_code =:companyCode left join metadata as md on up.language = md.Meta_Data_Name and md.is_deleted = 'N' and md.Meta_Data_Type = 'Language' where u.company_code =:companyCode order by u.id desc").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			//umUserTypeList = session.createSQLQuery("select ur.role_id as value, ur.role_name as label, ur.role_position as userTypePosition from user_roles as ur where ur.`status` = 'Y' and ur.company_code =:companyCode order by ur.role_id desc").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			umUserTypeList = session.createSQLQuery("select ur.role_id as value, ur.role_name as label from user_roles as ur where ur.`status` = 'Y' and ur.company_code =:companyCode order by ur.role_id asc").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			umUserLanguageList = session.createSQLQuery("select md.display_name as label, md.display_seq as value from metadata as md where md.is_deleted <> 'Y' and md.Meta_Data_Type = 'Language' order by md.display_seq asc").setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			umDistributorList = session.createSQLQuery("select md.distributor_code as value, md.distributor_name as label from md_distributor as md where md.`status` = 'Y' and md.company_code =:companyCode order by md.id asc").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			//umReportList = session.createSQLQuery("select ur.role_id as value, ur.role_name as label from user_roles as ur where ur.`status` = 'Y' and ur.company_code =:companyCode and ur.role_name <> 'salesman' order by ur.role_id desc").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			umReportList = session.createSQLQuery("select u.salesman_code as value, u.display_name as label from user as u where u.`status` = 'Y' and u.company_code =:companyCode and u.user_type not in ('salesman','BA')").setParameter("companyCode", companyCode).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
			uservoObj.setUmUsersList(umUsersList);
			uservoObj.setUmUserTypeList(umUserTypeList);
			uservoObj.setUmUserLanguageList(umUserLanguageList);
			uservoObj.setUmDistributorList(umDistributorList);
			uservoObj.setUmReportList(umReportList);
			uservoObj.setValid(true);			
		} catch (Exception e) {
			e.printStackTrace();
			uservoObj.setValid(false);
			uservoObj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}
			umUsersList = null;
			umUserTypeList = null;
			umUserLanguageList = null;
			umDistributorList = null;
			umReportList = null;
		}		
		return uservoObj;
	}
	
	@SuppressWarnings("unchecked")
	public UserVO saveUserList(UserVO userVO) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		UserVO robj = new UserVO();
		UserEntity user = new UserEntity();
			
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
