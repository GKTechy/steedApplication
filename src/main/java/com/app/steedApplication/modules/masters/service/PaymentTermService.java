package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.PaymentTermVO;

public interface PaymentTermService {

	PaymentTermVO getAllPaymentTerms();

	PaymentTermVO findPaymentTermbyId(int id);

	PaymentTermVO deletePaymentTermbyId(int id);

	PaymentTermVO savePaymentTerm(PaymentTermVO obj);

}
