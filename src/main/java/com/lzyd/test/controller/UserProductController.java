package com.lzyd.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.lzyd.test.pojo.Prize;
import com.lzyd.test.proxy.UserProductProxyService;
import com.lzyd.test.proxy.impl.UserProductProxyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Length;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/userProduct")
public class UserProductController {

	@Autowired
	private UserProductProxyService userProductProxyService;


	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	private static String str = null;


	@PostMapping("/test1")
	public void test1(@RequestBody JSONObject jsonObject) {
		userProductProxyService.test1(jsonObject);
	}

	@PostMapping("/test2")
	public void test2(@RequestBody JSONObject jsonObject) {
		userProductProxyService.test2(jsonObject);
	}


	@PostMapping("/test3")
	public void test3(@RequestBody JSONObject jsonObject) {
		atomicInteger.set(0);
	}


	@GetMapping("/test4/{id}")
	public String test4(@PathVariable(value = "id") Integer id) {
		System.out.println("id=" + id + ",时间:" + new Date());
		int i = atomicInteger.get();
		String con = null;
		if (i == 0){
			con = "别看了，看啥呢！";
		}
		if (i == 1){
			con = "还点！";
		}
		if (i == 2){
			con = "想要抽奖嘛!";
		}
		if (i == 3){
			con = "抽奖在点我!";
		}
		if (i == 4){
			Map<String, Integer> map = prizeList();
			Set<Map.Entry<String, Integer>> entries = map.entrySet();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("今天的奖品有:").append("<br>");
			for (Map.Entry<String, Integer> entry : entries) {
				stringBuilder.append(entry.getKey()).append("  概率:").append(entry.getValue()).append("%").append("<br>");
			}
			con = stringBuilder.toString();
		}
		if (i == 5){
			con = luckyDraw();
		}
		if (i > 5){
			con = "没机会了呀！你抽到了" + str;
		}

		atomicInteger.addAndGet(1);
		System.out.println(con);
		return con;
	}

	public static Map<String,Integer> prizeList() {
		Map<String,Integer> map = new HashMap<>();
		map.put("Apple 13",1);
		map.put("Apple watches",4);
		map.put("谢谢惠顾",50);
		map.put("红包10元",10);
		map.put("红包5元",15);
		map.put("红包1元",20);
		return map;
	}


	public static String luckyDraw() {
		Map<String, Integer> map = prizeList();
		Prize prizeIndex = getPrizeIndex(map);
		str = prizeIndex.getName();
		if ("谢谢惠顾".equals(prizeIndex.getName())){
			return "很遗憾你啥都没抽到== 虽然我早就猜到了";
		}
		return "呀，运气可以的，恭喜你抽到了" + prizeIndex.getName();
	}

	/**
	 * 根据Math.random()产生一个double型的随机数，判断每个奖品出现的概率
	 * @return random：奖品列表prizes中的序列（prizes中的第random个就是抽中的奖品）
	 */
	public static Prize getPrizeIndex(Map<String, Integer> map) {
		List<Prize> prizes = new ArrayList<>();
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		int length = 1;
		for (Map.Entry<String, Integer> entry : entries) {
			Prize prize = new Prize(length,entry.getKey(),entry.getValue());
			prizes.add(prize);
			++length;
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		int random = -1;
		try{
			//计算总权重
			double sumWeight = 0;

			for (Map.Entry<String, Integer> entry : entries) {
				sumWeight += entry.getValue();
			}


			//产生随机数
			double randomNumber;
			randomNumber = Math.random();

			//根据随机数在所有奖品分布的区域并确定所抽奖品
			double d1 = 0;
			double d2 = 0;
			for(int i=0;i<prizes.size();i++){
				d2 += Double.parseDouble(String.valueOf(prizes.get(i).getProportion()))/sumWeight;
				if(i==0){
					d1 = 0;
				}else{
					d1 +=Double.parseDouble(String.valueOf(prizes.get(i-1).getProportion()))/sumWeight;
				}
				if(randomNumber >= d1 && randomNumber <= d2){
					random = i;
					break;
				}
			}
		}catch(Exception e){
			System.out.println("生成抽奖随机数出错，出错原因：" +e.getMessage());
		}
		return prizes.get(random);
	}

}
