package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/arg/*")
@Log4j
public class ArgumentController {
	
	// /arg/a?name=john
	@RequestMapping("/a")
	public void method1(HttpServletRequest req) {
		log.info(req);
		log.info(req.getParameter("name")); //john
	}
	
	@RequestMapping("/b")
	public void method2(@RequestParam("name") String name) {
		log.info("b method");
		log.info(name);
	}
	
	@RequestMapping("/c")
	public void method3(@RequestParam String name) { //param이 arg와 같으면 값도 생략가능
		log.info("c method");
		log.info(name);
	}
	
	@RequestMapping("/d")
	public void method4(String name) { //RequestParam 삭제하면 Arg명에 해당하는 Param을 가져옴
		log.info("d method");
		log.info(name);
	}
	
	// /e?name=jane&age=100
	@RequestMapping("/e")
	public void method5(HttpServletRequest req) {
		log.info("e method");
		log.info(req.getParameter("name"));
		log.info(req.getParameter("age"));
	}
	
	@RequestMapping("/f")
	public void method6(String name, String age) {
		log.info("f method");
		log.info(name);
		log.info(age);
		
		int ageInt = Integer.valueOf(age);
	}
	
	@RequestMapping("/g")
	public void method7(String name, int age) {
		log.info("g method");
		log.info(name);
		log.info(age);
	}
	
	@RequestMapping("/h")
	public void method8(String name, int age) {
		log.info("h method");
		
		// 과거 방식
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		
		//service.execute(member);
		
		log.info(member);
		
	}
	
	@RequestMapping("/i")
	public void method9(Member member) { //java bean의 property활용하여 Member객체 만들어 넣어 줌
		log.info("i method");
		log.info(member);
	}
}
