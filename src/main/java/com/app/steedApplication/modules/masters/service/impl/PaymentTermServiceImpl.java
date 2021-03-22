package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.PaymentTermDao;
import com.app.steedApplication.modules.masters.model.PaymentTermVO;
import com.app.steedApplication.modules.masters.service.PaymentTermService;


@Service
@Transactional
public class PaymentTermServiceImpl implements PaymentTermService {

	@Autowired
	private PaymentTermDao paymentTermDao;

	
	@Override
	public PaymentTermVO getAllPaymentTerms() {
		PaymentTermVO returnobj = new PaymentTermVO();
		try {
			returnobj= paymentTermDao.getAllPaymentTerms();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public PaymentTermVO findPaymentTermbyId(int id) {
		PaymentTermVO returnobj = new PaymentTermVO();
		try {
			returnobj= paymentTermDao.findPaymentTermbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public PaymentTermVO deletePaymentTermbyId(int id) {
		PaymentTermVO returnobj = new PaymentTermVO();
		try {
			returnobj= paymentTermDao.deletePaymentTermbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public PaymentTermVO savePaymentTerm(PaymentTermVO obj) {
		PaymentTermVO returnobj = new PaymentTermVO();
		try {
			returnobj= paymentTermDao.savePaymentTerm(obj) ;
			returnobj.setPaymentTermList(paymentTermDao.getAllPaymentTerms().getPaymentTermList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

}
