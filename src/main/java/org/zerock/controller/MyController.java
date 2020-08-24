package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
//@RequestMapping("/my/*")
@Log4j
public class MyController {
	
	@RequestMapping("")
	public void myHandler1() {
		log.info("my controller is working.....");
	}
	
	@RequestMapping("/a")
	public void myHandler2() {
		log.info("myHandler2 is working........");
	}
	
	@RequestMapping("/b")
	public void myHandler3() {
		log.info("myHandler3 is working........");
	}
	
	@RequestMapping(value = "/c", method = RequestMethod.GET)
	public void myHandler4() {
		log.info("myHandler4...................");
	}
	
	@RequestMapping(value = "/c", method = RequestMethod.POST)
	public void myHandler5() {
		log.info("myHandler5...................");
	}
	
	@GetMapping("/d")  //@RequestMapping(value = "/d", method = RequestMethod.GET) 와 같음
	public void myHandler6() {
		log.info("myHandler6...................");
	}
	
	@PostMapping("/d") //@RequestMapping(value = "/d", method = RequestMethod.POST) 와 같음
	public void myHandler7() {
		log.info("myHandler7...................");
	}
}
