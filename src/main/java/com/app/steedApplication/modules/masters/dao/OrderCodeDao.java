package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.OrderCodeVO;

public interface OrderCodeDao {

	OrderCodeVO getAllOrderCodes();

	OrderCodeVO findOrderCodebyId(int id);

	OrderCodeVO deleteOrderCodebyId(int id);

	OrderCodeVO saveOrderCode(OrderCodeVO obj);

}
