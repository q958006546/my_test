package com.lzyd.h5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/h5")
public class H5Controller {
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}

	@GetMapping("/test4")
	public String test4() {
		return "test4";
	}

}
