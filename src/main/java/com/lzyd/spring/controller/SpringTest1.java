package com.lzyd.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.logging.LoggerMessageFormat;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class SpringTest1 {
//	private static Logger log = LogManager.getLogger(SpringTest1.class);

	//	@Autowired
//	private SpringTest2 springTest2;
//
//	public SpringTest1(SpringTest2 springTest2) {
//		this.springTest2 = springTest2;
//	}
//
//	public void setSpringTest2(SpringTest2 springTest2) {
//		this.springTest2 = springTest2;
//	}
//
//	public SpringTest2 getSpringTest2() {
//		return springTest2;
//	}
	public static void main(String[] args) {

		try {
			String s = null;
			System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
			//正常打印信息
			s = "name";
			log.info("打印系统信息：{}",s);
			//CRLF 注入 打印信息
			s = "${java:hw}";
			log.info("打印系统硬件信息：{}" , s);
			//CRLF 注入 打印信息
			s = "${java:os}";
			log.info("打印操作系统信息：{}" , s);



		}catch (Exception e){
			log.error("报错信息信息：{}",e);
		}

	}
}
