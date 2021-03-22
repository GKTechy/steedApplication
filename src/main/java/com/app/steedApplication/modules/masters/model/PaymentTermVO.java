package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.PaymentTermsEntity;

import lombok.Data;


@Data
public class PaymentTermVO {

	public Boolean valid;
	public String responseMsg;
	public List<PaymentTermsEntity> paymentTermList;
	public PaymentTermsEntity paymentTermObj;

}
