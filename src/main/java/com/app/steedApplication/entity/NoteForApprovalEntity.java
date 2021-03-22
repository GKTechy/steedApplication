package com.app.steedApplication.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

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
	public Date nfaDocumentDate;
	
	@Column(name = "nfa_title")
	public String nfaTitle;
	
	@Column(name = "nfa_description")
	public String nfaDescription;
	
	@Column(name = "is_active")
	public Boolean isActive;
	
	@Column(name = "prepared_on")
	public Date preparedON;
	
	@Column(name = "prepared_by")
	public String preparedBy;
	
	@Column(name = "approved_on")
	public Date approvedOn;
	
	@Column(name = "approved_by")
	public Date approvedBy;
	
	@Column(name = "updated_on")
	public String updatedOn;
	
	@Column(name = "updated_by")
	public String updatedBy;	
		
	@Transient
	public String readOnly;
	
	@Transient
	public String changeFlag;

}
