package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.MachineEntity;
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
		// TODO Auto-generated method stub
		return null;
	}

}
