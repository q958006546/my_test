package com.lzyd.juc.service;

import java.util.Arrays;
import java.util.List;

public class CompanyUserBatchServiceImpl implements CompanyUserBatchService {
	private static List<Integer> arr;

	static {
		Integer[] ar = {1,2,3,4,5};
		arr = Arrays.asList(ar);
	}

	public static void main(String[] args) {

		for (Integer a : arr) {

		}

	}
}
