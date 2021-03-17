package com.app.steedApplication.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {
	
	@Autowired
    private Environment env;
	
	@Autowired
	private SessionFactory sessionFactory;
 
//    @Bean
//    public JavaMailSender getMailSender(List<Map<String, Object>> mailList) {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        Properties javaMailProperties = new Properties();
//        List<Map<String,Object>> mailList1 = null;
//        Session session = this.sessionFactory.openSession();
//        
//        mailList1 = session.createSQLQuery("select id as id, company_code as companyCode, mail_server as mailServer, mail_server_port as mailServerPort, sender_mail_address as senderMailAddress, password as password, cc_mail_address as ccMailAddress, bcc_mail_address as bccMailAddress, status as status from email_account as ea where ea.status = 'Y'")
//				.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
//        
//        for (Map<String, Object> entry : mailList1) {
//        	
//        	mailSender.setHost((String) entry.get("mailServer"));
//        	System.out.println("<--1-->");
////            mailSender.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));
////            mailSender.setUsername(env.getProperty("spring.mail.username"));
////            mailSender.setPassword(env.getProperty("spring.mail.password"));
////     
////            
////            javaMailProperties.put("mail.transport.protocol", "smtp");
////            javaMailProperties.put("mail.properties.mail.tls", "true");
////            javaMailProperties.put("mail.smtp.auth", "true");
////            javaMailProperties.put("mail.tls", "true");
////            javaMailProperties.put("mail.smtp.ssl.trust", "smtp.office365.com");
////            javaMailProperties.put("mail.smtp.starttls.enable", "true");
////            javaMailProperties.put("mail.smtp.writetimeout", "5000");
////            javaMailProperties.put("mail.debug", "true");
//        }
// 
//        
//        		 
//        mailSender.setJavaMailProperties(javaMailProperties);
//        return mailSender;
//    }
	
}