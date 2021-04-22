package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.ProductVO;

public interface ProductDao {

	ProductVO getAllProducts();
	ProductVO getProductsWithOrderCode();

	ProductVO findProductbyId(int id);

	ProductVO deleteProductbyId(int id);

	ProductVO saveProduct(ProductVO obj);

	ProductVO allProductVarients();

	ProductVO saveProductVarient(ProductVO obj);

}
