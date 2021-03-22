package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.ProductVO;

public interface ProductDao {

	ProductVO getAllProducts();

	ProductVO findProductbyId(int id);

	ProductVO deleteProductbyId(int id);

	ProductVO saveProduct(ProductVO obj);

}
