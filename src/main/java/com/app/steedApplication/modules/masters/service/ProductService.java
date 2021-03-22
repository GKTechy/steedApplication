package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.ProductVO;

public interface ProductService {

	ProductVO getAllProducts();

	ProductVO findProductbyId(int id);

	ProductVO deleteProductbyId(int id);

	ProductVO saveProduct(ProductVO obj);

}
