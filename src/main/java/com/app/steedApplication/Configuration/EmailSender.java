package com.app.steedApplication.Configuration;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	
	@Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Mail mail) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		//String[] receivers = new String[] {"glsgokulbca@gmail.com","glapskrish@gmail.com","gokulkrishna@msconsortium.co.in"};
		
		
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getContent());
		helper.setTo(mail.getTo());
        //helper.setTo(receivers);
        helper.setFrom(mail.getFrom());
       // helper.setCc(mail.getCc());
//        if(mail.getCc().length - 1 > 0) {
//        	helper.setCc(mail.getCc());
//        }  
        if(!mail.getCc()[0].equalsIgnoreCase("")) {
        	helper.setCc(mail.getCc());
        }        
        if(!mail.getBcc().equalsIgnoreCase("") && !mail.getBcc().equalsIgnoreCase(null)) {
        	helper.setBcc(mail.getBcc());
        }        

        FileSystemResource file = new FileSystemResource(new File(mail.getAttachmentfile()));
        helper.addAttachment(mail.getFileName(), file);
        
//        System.out.println("********************Sending E-Mail*****************************");
        emailSender.send(message);

    }


}
