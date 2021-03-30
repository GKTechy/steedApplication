package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.DealerVO;

public interface DealerService {

	DealerVO getAllDealer();

	DealerVO finddealerbyId(int id);

	DealerVO deleteDealerbyId(int id);

	DealerVO saveDealer(DealerVO obj);


}
