 package com.app.steedApplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="note_for_approval")
public class NoteForApprovalEntity {
	public static final String TYPE = NoteForApprovalEntity.class.getName();

	@Id
	@Column(name = "nfa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nfaId;	
	
	@Column(name = "nfa_document_no")
	public String nfaDocumentNo;
	
	@Column(name = "nfa_document_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	public Date nfaDocumentDate;
	
	@Column(name = "nfa_title")
	public String nfaTitle;
	
	@Column(name = "nfa_description")
	public String nfaDescription;
	
	@Column(name = "status")
	public String status;
	
	@Column(name = "is_active")
	public String isActive;
	
	@Column(name = "nfa_active")
	public String nfaActive;
	
	@Column(name = "nfa_prepared_on")
	public Date preparedON;
	
	@Column(name = "nfa_prepared_by")
	public String preparedBy;
	
	@Column(name = "nfa_approved_on")
	public Date approvedOn;
	
	@Column(name = "nfa_approved_by")
	public int approvedBy;
	
	@Column(name = "created")
	public Date created;
	
	@Column(name = "created_by")
	public String createdBy;
	
	@Column(name = "updated")
	public Date updated;
	
	@Column(name = "updated_by")
	public String updatedBy;	
		
	@Transient
	public String readOnly;
	
	@Transient
	public String changeFlag;

}
