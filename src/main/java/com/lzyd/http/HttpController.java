package com.lzyd.http;

import com.alibaba.fastjson.JSONObject;
import com.lzyd.config.AlipayConfig;
import com.lzyd.http.entity.HttpTestVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.lzyd.pay.controller.utils.PayUtils.getUTF8XMLString;

@RequestMapping(value = "/http")
@RestController
public class HttpController {

	@RequestMapping("/test")
	@ResponseBody
	public void test(@RequestParam("file") MultipartFile file, @RequestParam("date") String date) throws IOException {
		File file1 = new File("C:\\Users\\mayn\\Desktop\\0331\\te\\test" + System.currentTimeMillis());
		file.transferTo(file1);
		System.out.println(date);
		InputStream inputStream = new FileInputStream(file1);
	}




}
