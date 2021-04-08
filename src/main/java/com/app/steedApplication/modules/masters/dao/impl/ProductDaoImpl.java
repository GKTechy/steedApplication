package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.ProductEntity;
import com.app.steedApplication.entity.ProductVarientEntity;
import com.app.steedApplication.entity.UserRoleEntity;
import com.app.steedApplication.modules.masters.dao.ProductDao;
import com.app.steedApplication.modules.masters.model.DealerVO;
import com.app.steedApplication.modules.masters.model.ProductVO;
import com.app.steedApplication.modules.masters.model.RoleVO;

@Repository
public class ProductDaoImpl implements ProductDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public ProductVO getAllProducts() {
		Session session = this.sessionFactory.openSession();
		ProductVO returnobj=new ProductVO();
		List<ProductEntity> tableList= new ArrayList<ProductEntity>();
		try {
			tableList = session.createQuery(" FROM ProductEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setProductList(tableList);
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
	public ProductVO findProductbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO deleteProductbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO saveProduct(ProductVO obj) {
		Session session = this.sessionFactory.openSession();
		ProductVO returnobj=new ProductVO();
		List<ProductEntity> roleList= new ArrayList<ProductEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			ProductEntity roleObj=obj.getProductObj();
			if(roleObj.getProductId() == 0) { // New Row
				roleList = session.createQuery(" FROM ProductEntity AS u WHERE u.productName = '"+roleObj.getProductName()+"'").list();
				System.out.println("IF userList------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					roleObj.setCreated(new Date());
					roleObj.setUpdated(new Date());
					session.save(roleObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Product Name Already Exists");
				}
			}else { // update
				roleList = session.createQuery(" FROM ProductEntity AS u WHERE u.productName = '"+roleObj.getProductName()+"' AND productId!="+roleObj.getProductId()).list();
				System.out.println("ELSE userList------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					roleObj.setCreated(new Date());
					roleObj.setUpdated(new Date());
					session.saveOrUpdate(roleObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Product Name Already Exists");
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
	public ProductVO allProductVarients() {
		Session session = this.sessionFactory.openSession();
		ProductVO returnobj=new ProductVO();
		List<ProductVarientEntity> tableList= new ArrayList<ProductVarientEntity>();
		try {
			tableList = session.createQuery(" FROM ProductVarientEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setProductVarientList(tableList);
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
	public ProductVO saveProductVarient(ProductVO obj) {
		Session session = this.sessionFactory.openSession();
		ProductVO returnobj=new ProductVO();
		List<ProductVarientEntity> roleList= new ArrayList<ProductVarientEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			ProductVarientEntity roleObj=obj.getProductVarientObj();
			if(roleObj.getVarientId() == 0) { // New Row
				roleList = session.createQuery(" FROM ProductVarientEntity AS u WHERE u.name = '"+roleObj.getName()+"'").list();
				System.out.println("IF userList------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					roleObj.setCreated(new Date());
					roleObj.setUpdated(new Date());
					session.save(roleObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Product Varient Name Already Exists");
				}
			}else { // update
				roleList = session.createQuery(" FROM ProductVarientEntity AS u WHERE u.name = '"+roleObj.getName()+"' AND varientId!="+roleObj.getVarientId()).list();
				System.out.println("ELSE userList------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					roleObj.setCreated(new Date());
					roleObj.setUpdated(new Date());
					session.saveOrUpdate(roleObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Product Varient Name Already Exists");
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

}
