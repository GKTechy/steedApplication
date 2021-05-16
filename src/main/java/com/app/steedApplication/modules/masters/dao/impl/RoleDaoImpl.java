package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.MainMenuEntity;
import com.app.steedApplication.entity.SubMenuEntity;
import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.entity.UserRoleEntity;
import com.app.steedApplication.modules.masters.dao.RoleDao;
import com.app.steedApplication.modules.masters.model.RoleVO;
import com.app.steedApplication.modules.masters.model.UserVO;


@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public RoleVO getAllRoles() {
		Session session = this.sessionFactory.openSession();
		RoleVO returnobj=new RoleVO();
		List<UserRoleEntity> roleList= new ArrayList<UserRoleEntity>();
		try {

			roleList = session.createQuery(" FROM UserRoleEntity r").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setRoleList(roleList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
			roleList=null;
		}		
		return returnobj;
	}

	@Override
	public RoleVO deleteRolebyId(int id) {
		Session session = this.sessionFactory.openSession();
		RoleVO returnobj=new RoleVO();
		Transaction tx=session.beginTransaction();
		try {

			session.createQuery(" UPDATE UserRoleEntity SET status='N' WHERE roleId="+id).executeUpdate();
			tx.commit();
			returnobj.setValid(true);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
		}		
		return returnobj;
	}

	@Override
	public RoleVO findRolebyId(int id) {
		Session session = this.sessionFactory.openSession();
		RoleVO returnobj=new RoleVO();
		List<UserRoleEntity> roleList= new ArrayList<UserRoleEntity>();
		try {

			roleList = session.createQuery(" FROM UserRoleEntity r where r.status='Y' and roleId="+id).list();
			//System.out.println("userList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setRoleList(roleList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}
			roleList=null;
		}		
		return returnobj;
	}

	@Override
	public RoleVO saveRole(RoleVO obj) {
		Session session = this.sessionFactory.openSession();
		RoleVO returnobj=new RoleVO();
		List<UserRoleEntity> roleList= new ArrayList<UserRoleEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			UserRoleEntity roleObj=obj.getRoleObj();
			if(roleObj.getRoleId() == 0) { // New Row
				roleList = session.createQuery(" FROM UserRoleEntity AS u WHERE u.roleName = '"+roleObj.getRoleName()+"'").list();
				System.out.println("IF userList------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					roleObj.setCreated(new Date());
					roleObj.setUpdated(new Date());
					session.save(roleObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Role Name Already Exists");
				}
			}else { // update
				roleList = session.createQuery(" FROM UserRoleEntity AS u WHERE u.roleName = '"+roleObj.getRoleName()+"' AND roleId!="+roleObj.getRoleId()).list();
				System.out.println("ELSE userList------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					roleObj.setCreated(new Date());
					roleObj.setUpdated(new Date());
					session.saveOrUpdate(roleObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Role Name Already Exists");
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
			logger.info(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
	
		}		
		return returnobj;
	}

	@Override
	public RoleVO allRolesModules() {
		Session session = this.sessionFactory.openSession();
		RoleVO returnobj=new RoleVO();
		List<MainMenuEntity> mainMenuList= new ArrayList<MainMenuEntity>();
		try {

			mainMenuList = session.createQuery(" FROM MainMenuEntity ").list();
			
			for(MainMenuEntity mobj: mainMenuList) {
				List<SubMenuEntity> sMenuList = session.createQuery(" FROM SubMenuEntity s where s.mainMenuId="+mobj.getMainMenuId()).list();
				mobj.setSubMenuList(sMenuList);
			}
			
			returnobj.setValid(true);
			returnobj.setMainMenuList(mainMenuList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
			mainMenuList=null;
		}		
		return returnobj;
	}

	
	
}
