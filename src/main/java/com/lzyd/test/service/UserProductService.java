package com.lzyd.test.service;

import com.lzyd.test.pojo.UserProduct;

public interface UserProductService {
	void updateById(UserProduct userProduct);

	void selectByV(Integer v);
}
