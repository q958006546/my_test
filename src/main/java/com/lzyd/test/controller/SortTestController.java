package com.lzyd.test.controller;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/userProduct")
public class SortTestController {

	private static List<Integer> arr = Arrays.asList(new Integer[]{9, 3, 4, 8, 2, 1, 0, 6, 7, 5});

	@Test
	public void bubbling() {
		Integer len = null;
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int i1 = 0; i1 < arr.size() - i - 1; i1++) {
				if (arr.get(i1) > arr.get(i1 + 1)) {
					len = arr.get(i1);
					arr.set(i1, arr.get(i1 + 1));
					arr.set(i1 + 1, len);
				}
				System.out.println("---" + i1);
			}
			for (Integer integer : arr) {
				System.out.print(integer);
			}
			System.out.println("--------------");
		}
		for (Integer integer : arr) {
			System.out.print(integer);
		}

	}

	@Test
	public void choice() {
		for (int i = 0; i < arr.size(); i++) {
			int min = i;
			for (int i1 = i + 1; i1 < arr.size(); i1++) {
				if (arr.get(i1) < arr.get(min)){
					min = i1;
				}
			}
			if (min != 1){
				int temp = arr.get(i);
				arr.set(i,arr.get(min));
				arr.set(min,temp);
			}


		}
		for (Integer integer : arr) {
			System.out.print(integer);
		}

	}
	@Test
	public void insertion() {
		for (int i = 0; i < arr.size()-1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr.get(j) < arr.get(j - 1)){
					int len = arr.get(j);
					arr.set(j, arr.get(j-1));
					arr.set(j-1, len);
				}
			}
			for (Integer integer : arr) {
				System.out.print(integer);
			}
			System.out.println("--------------");
		}
		for (Integer integer : arr) {
			System.out.print(integer);
		}


	}





}
