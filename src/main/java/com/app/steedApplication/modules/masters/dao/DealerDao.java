package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.DealerVO;

public interface DealerDao {
	
	DealerVO getAllDealer();

	DealerVO finddealerbyId(int id);

	DealerVO deleteDealerbyId(int id);

	DealerVO saveDealer(DealerVO obj);
	
}
