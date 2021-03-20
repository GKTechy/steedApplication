package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

			roleList = session.createQuery(" FROM UserRoleEntity r where r.status='Y'").list();
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
		}		
		return returnobj;
	}

	@Override
	public RoleVO saveRole(RoleVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
