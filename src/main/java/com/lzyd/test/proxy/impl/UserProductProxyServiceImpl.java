package com.lzyd.test.proxy.impl;

import com.alibaba.fastjson.JSONObject;
import com.lzyd.test.pojo.UserProduct;
import com.lzyd.test.proxy.UserProductProxyService;
import com.lzyd.test.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserProductProxyServiceImpl implements UserProductProxyService {
	@Autowired
	private UserProductService userProductService;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void test1(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		String name = jsonObject.getString("name");
		UserProduct userProduct = new UserProduct();
		userProduct.setV(id);
		userProduct.setProductName(name);
		userProductService.updateById(userProduct);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("结束test1");
//		userProduct = new UserProduct();
//		userProduct.setV(1);
//		userProduct.setProductName("666");
		userProductService.updateById(userProduct);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void test2(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		String name = jsonObject.getString("name");
		UserProduct userProduct = new UserProduct();
		userProduct.setV(id);
		userProduct.setProductName(name);
		userProductService.updateById(userProduct);

//		userProduct = new UserProduct();
//		userProduct.setV(2);
//		userProduct.setProductName("333");
		userProductService.updateById(userProduct);
	}

	@Override
	public void test3(JSONObject jsonObject) {
		Integer v = jsonObject.getInteger("v");
		userProductService.selectByV(v);
	}
}
