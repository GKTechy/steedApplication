package com.app.steedApplication.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


 
public class SynDataJob implements Job {

	@Autowired
	private SessionFactory sessionFactory;

	//@Autowired
	//private AdwebDao adwebDao;

	private final Logger log = LoggerFactory.getLogger(SynDataJob.class);

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("SimpleJob executed!");
		System.out.println("SimpleJob executed!");

		log.info("Calling job method---->"+new Date());

//		Session session = this.sessionFactory.openSession();
//		AdwebVO returnObj = new AdwebVO();
//		List<DataSyncTablesEntity> synctableList = null;
//		try {
//			synctableList = session.createSQLQuery("SELECT ds.seqId AS seqId,ds.tablename AS tablename,ds.lastsyncdatetime AS lastsyncdatetime,ds.`status` AS status,ds.comments AS comments,ds.lastupdatedby AS lastupdatedby,ds.lastupdateddatetime AS lastupdateddatetime,CAST(STR_TO_DATE(ds.lastsyncdatetime,'%Y-%m-%d') AS CHAR(50)) AS lastSyncDate FROM data_sync_tables AS ds WHERE ds.batch_process = 'Y' AND ds.`status` = 'active'")
//					.setResultTransformer(Transformers.aliasToBean(DataSyncTablesEntity.class)).list();
//			if(synctableList.size() > 0) {
//				for(DataSyncTablesEntity obj : synctableList) {
//					String sDate1= obj.lastSyncDate;;  
//					Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
//					obj.setLastsyncdatetime(date1);
//					obj.setIsSelected(true);
//					System.out.println(obj);
//				}
//			}
//			returnObj.setSynctableList(synctableList);
//			returnObj.setUserName("System-Admin");
//			returnObj.setBatchMode(true);
//			adwebDao.importBasicAdempiereDetails(returnObj);
//		}  catch (Exception e) {
//			e.printStackTrace();
//			returnObj.setResponseMsg(e.getMessage());
//			log.info("Error--------"+e.getMessage());
//		} finally {
//			if(session != null){
//				session.close();
//				session = null;
//			}	
//			synctableList = null;
//		}
	}

}
