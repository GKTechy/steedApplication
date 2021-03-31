package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.DealerOrderVO;

public interface DealerOrderService {

	DealerOrderVO getAllDealerOrder();

	DealerOrderVO findDealerOrderbyId(int id);

	DealerOrderVO deleteDealerOrderbyId(int id);

	DealerOrderVO saveDealerOrder(DealerOrderVO obj);

}
