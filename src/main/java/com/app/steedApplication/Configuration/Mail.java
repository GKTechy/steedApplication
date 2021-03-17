package com.app.steedApplication.Configuration;

public class Mail {
	
	private String from;
    private String[] to;
    private String[] cc;
    private String bcc;
    private String subject;
    private String content;
    private String attachmentfile;
    private String fileName;
    
    public Mail() {
    }

    public Mail(String from, String[] to, String[] cc, String bcc, String subject, String content,String attachmentfile,String fileName) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.content = content;
        this.attachmentfile = attachmentfile;
        this.fileName = fileName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }
    
    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }
    
    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachmentfile() {
		return attachmentfile;
	}

	public void setAttachmentfile(String attachmentfile) {
		this.attachmentfile = attachmentfile;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Mail [from=" + from + ", to=" + to + ", cc=" + cc + ", bcc=" + bcc + ", subject=" + subject + ", content=" + content
				+ ", attachmentfile=" + attachmentfile + ", fileName=" + fileName + "]";
	}

	
    
}
