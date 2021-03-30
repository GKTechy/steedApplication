package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.MachineEntity;
import com.app.steedApplication.entity.MachineProcessMap;
import com.app.steedApplication.modules.masters.dao.MachineDao;
import com.app.steedApplication.modules.masters.model.MachineVO;

@Repository
public class MachineDaoImpl implements MachineDao {


	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Override
	public MachineVO getAllMachines() {
		Session session = this.sessionFactory.openSession();
		MachineVO returnobj=new MachineVO();
		List<MachineEntity> tableList= new ArrayList<MachineEntity>();
		try {

			tableList = session.createQuery(" FROM MachineEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setMachineList(tableList);
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
	public MachineVO findMachinebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MachineVO deleteMachinebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MachineVO saveMachine(MachineVO obj) {
		Session session = this.sessionFactory.openSession();
		MachineVO returnobj=new MachineVO();
		List<MachineEntity> mlist= new ArrayList<MachineEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			MachineEntity robj=obj.getMachineObj();
			if(robj.getMachineId() == 0) { // New Row
				mlist = session.createQuery(" FROM MachineEntity AS u WHERE u.machineName = '"+robj.getMachineName()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Machine Name Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM MachineEntity AS u WHERE u.machineName = '"+robj.getMachineName()+"' AND machineId!="+robj.getMachineId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Machine Name Already Exists");
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
	public MachineVO allMachinesProcessMapDetails() {
		Session session = this.sessionFactory.openSession();
		MachineVO returnobj=new MachineVO();
		List<MachineProcessMap> tableList= new ArrayList<MachineProcessMap>();
		try {
			tableList = session.createSQLQuery(" SELECT mp.machine_process_map_id AS machineprocessMapId,mp.machine_name_id AS machineNameId,m.machine_name AS machineName,p.process_id AS processId,p.process_name as processName FROM machine_process_map mp, machine m, process p WHERE\r\n"
					+ " mp.machine_name_id=m.machine_id AND p.process_id=mp.process_id")
					.setResultTransformer(Transformers.aliasToBean(MachineProcessMap.class)).list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setMachineProcessMapList(tableList);
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
	public MachineVO saveMachinesProcessMapDetails(MachineVO obj) {
		Session session = this.sessionFactory.openSession();
		MachineVO returnobj=new MachineVO();
		List<MachineProcessMap> mlist= new ArrayList<MachineProcessMap>();
		Transaction tx=session.beginTransaction();		
		try {
			MachineProcessMap robj=obj.getMachineProcessMapObj();
			if(robj.getMachineprocessMapId() == 0) { // New Row
				mlist = session.createQuery(" FROM MachineProcessMap AS u WHERE u.machineNameId = '"+robj.getMachineNameId()+"' AND u.processId = '"+robj.getProcessId()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Machine Process Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM MachineProcessMap AS u WHERE u.machineNameId = '"+robj.getMachineNameId()+"' AND u.processId = '"+robj.getProcessId()+"' AND machineprocessMapId!="+robj.getMachineprocessMapId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Machine Process Already Exists");
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
