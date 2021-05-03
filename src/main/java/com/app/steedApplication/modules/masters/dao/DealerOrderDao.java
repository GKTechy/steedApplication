package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.DealerOrderVO;

public interface DealerOrderDao {

	DealerOrderVO getAllDealerOrder();

	DealerOrderVO saveDealerOrder(DealerOrderVO obj);

	DealerOrderVO findDealerOrderbyId(int id);

}
