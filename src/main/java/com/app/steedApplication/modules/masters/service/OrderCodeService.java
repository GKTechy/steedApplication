package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.OrderCodeVO;

public interface OrderCodeService {

	OrderCodeVO getAllOrderCodes();

	OrderCodeVO findOrderCodebyId(int id);

	OrderCodeVO deleteOrderCodebyId(int id);

	OrderCodeVO saveOrderCode(OrderCodeVO obj);

	
}
