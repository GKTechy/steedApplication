package com.app.steedApplication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name="user")
@Data
public class UserEntity implements Serializable, Cloneable {
	
	public static final String TYPE = UserEntity.class.getName();
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long userId;
	
	@Column(name = "ref_code")
	public String refCode;
	
	@Column(name = "company_code")
	public String companyCode;
	
	@Column(name = "distributor_code")
	public String distributorCode;
	
	@Column(name = "ba_retailer_code")
	public String baRetailerCode;
	
	@Column(name = "brand_code")
	public String brandCode;
	
	@Column(name = "device_id")
	public String deviceId;
	
	@Column(name = "salesman_code")
	public String salesmanCode;
	
	@Column(name = "phone_number")
	public String phoneNumber;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "user_id")
	public String loginUserId;
	
	@Column(name = "username")
	public String userName;
	
	@Column(name = "user_type")
	public String userType;
	
	
	@Column(name = "password")
	@ColumnTransformer(
//			read = "cast(AES_DECRYPT(password, 'o2web_ng') as char(255))",
			write = "AES_ENCRYPT(?, 'o2web_ng')"
			)
	public String password;
	
	@Column(name = "status")
	public String status;
	
	@Column(name = "display_name")
	public String displayName;
	
	@Column(name = "pwdtobechanged")
	public String pwdToBeChanged;
	
	@Column(name = "expirydate")
	public Date ExpiryDate;
	
	@Column(name = "employee_number")
	public String employeeNumber;
	
	@Column(name = "erp_user_id")
	public String erpUserId;
	
	@Column(name = "employee_id")
	public String employeeId;
	
	@Column(name = "report_to")
	public String reportTo;
	
	@Column(name = "expense_approver")
	public String expenseApprover;
	
	@Column(name = "expense_approval_limit")
	private double expenseApprovalLimit;
	
	@Column(name = "modified_date")
	public Date modifiedDate;
	
	@Column(name = "modified_by")
	public String modifiedBy;
	
	@Transient
	public boolean orderWriteAccess;
	
	@Transient
	public boolean collectionWriteAccess;
	
	@Transient
	public boolean salesReturnWriteAccess;
	
	@Transient
	public boolean retailerWriteAccess;
	
	@Transient
	public boolean competitorWriteAccess;
	
	@Transient
	public boolean priceWriteAccess;
	
	@Transient
	public boolean roleAccessWriteAccess;
	
	@Transient
	public boolean menuMaintenanceWriteAccess;
	
	@Transient
	public boolean distributorWriteAccess;
	
	@Transient
	public boolean distributorStockWriteAccess;
	
	@Transient
	public boolean dsrReportsWriteAccess;
	
	@Transient
	public boolean erpUploadedOrderWriteAccess;
	
	@Transient
	public boolean salesmanRouteWriteAccess;
	
	@Transient
	public boolean routeMasterWriteAccess;
	
	@Transient
	public boolean salesmanWriteAccess;
	
	@Transient
	public boolean dayMasterWriteAccess;
	
	@Transient
	public boolean productWriteAccess;
	
	@Transient
	public boolean productPriceWriteAccess;
	
	@Transient
	public boolean retailerPriceWriteAccess;
	
	@Transient
	public boolean productGroupWriteAccess;
	
	@Transient
	public boolean productTypeWriteAccess;
	
	@Transient
	public boolean dataSyncWriteAccess;
	
	@Transient
	public boolean priceTypeWriteAccess;
	
}
