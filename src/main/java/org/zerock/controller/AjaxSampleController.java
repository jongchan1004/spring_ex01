package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/as")
@Log4j
public class AjaxSampleController {
	@RequestMapping("/signup")
	public void signup() {
		log.info("signup method");
	}
	
	@RequestMapping("/dup")
	@ResponseBody
	public String dup(String id) {
		log.info("dup method");
		
		if(id.equals("seoul")) {
			return "dup";
		} else {
			return "nodup";
		}
	}
}
