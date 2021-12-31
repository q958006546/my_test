package com.lzyd.test.service.impl;

import com.lzyd.test.mapper.UserProductMapper;
import com.lzyd.test.pojo.UserProduct;
import com.lzyd.test.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserProductServiceImpl implements UserProductService {

	@Autowired
	private UserProductMapper mapper;

	@Override
	public void updateById(UserProduct userProduct) {
		mapper.updateByPrimaryKey(userProduct);
	}

	@Override
	public void selectByV(Integer v) {
		mapper.selectByPrimaryKey(v);
	}
}
