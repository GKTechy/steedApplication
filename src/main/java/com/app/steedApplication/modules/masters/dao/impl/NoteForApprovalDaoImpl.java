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

import com.app.steedApplication.entity.MaterialTypeEntity;
import com.app.steedApplication.entity.NoteForApprovalEntity;
import com.app.steedApplication.modules.masters.dao.NoteForApprovalDao;
import com.app.steedApplication.modules.masters.model.MaterialTypeVO;
import com.app.steedApplication.modules.masters.model.NoteForApprovalVO;

@Repository
public class NoteForApprovalDaoImpl implements NoteForApprovalDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public NoteForApprovalVO getAllNoteForApprovals() {
		Session session = this.sessionFactory.openSession();
		NoteForApprovalVO returnobj=new NoteForApprovalVO();
		List<NoteForApprovalEntity> tableList= new ArrayList<NoteForApprovalEntity>();
		try {

			tableList = session.createQuery(" FROM NoteForApprovalEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setNoteForApprovalList(tableList);
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
	public NoteForApprovalVO findNoteForApprovalbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteForApprovalVO deleteNoteForApprovalbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteForApprovalVO saveNoteForApproval(NoteForApprovalVO obj) {
		Session session = this.sessionFactory.openSession();
		NoteForApprovalVO returnobj=new NoteForApprovalVO();
		List<NoteForApprovalEntity> tableList= new ArrayList<NoteForApprovalEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			NoteForApprovalEntity robj=obj.getNoteForApprovalObj();
			System.out.println("robj-->"+robj.toString());
			if(robj.getNfaId() == 0) { // New Row
				tableList = session.createQuery(" FROM NoteForApprovalEntity AS u WHERE u.nfaDocumentNo = '"+robj.getNfaDocumentNo()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(tableList.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					robj.setApprovedBy(100);
					robj.setApprovedOn(new Date());
					robj.setPreparedBy("100");
					robj.setPreparedON(new Date());
					robj.setNfaActive("Active");
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Documet No Already Exists");
				}
			}else { // update
				tableList = session.createQuery(" FROM NoteForApprovalEntity AS u WHERE u.nfaDocumentNo = '"+robj.getNfaDocumentNo()+"' AND nfaId!="+robj.getNfaId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(tableList.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					robj.setApprovedBy(100);
					robj.setApprovedOn(new Date());
					robj.setPreparedBy("100");
					robj.setPreparedON(new Date());
					robj.setNfaActive("Active");
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Documet No Already Exists");
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
