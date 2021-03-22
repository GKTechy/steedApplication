package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.PaymentTermVO;

public interface PaymentTermDao {

	PaymentTermVO getAllPaymentTerms();

	PaymentTermVO findPaymentTermbyId(int id);

	PaymentTermVO deletePaymentTermbyId(int id);

	PaymentTermVO savePaymentTerm(PaymentTermVO obj);

}
