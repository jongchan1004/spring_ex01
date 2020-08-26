package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.CustomMemberEditor;
import org.zerock.domain.Member;
import org.zerock.domain.MemberList;

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
	
	// /arg/b?name=john
	@RequestMapping("/b")
	public void method2(@RequestParam("name") String name) {
		log.info("b method");
		log.info(name);
	}
	
	// /arg/c?name=john
	@RequestMapping("/c")
	public void method3(@RequestParam String name) { //param이 arg와 같으면 값도 생략가능
		log.info("c method");
		log.info(name);
	}
	
	// /arg/d?name=john
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
	
	// /f?name=jane&age=100
	@RequestMapping("/f")
	public void method6(String name, String age) {
		log.info("f method");
		log.info(name);
		log.info(age);
		
		int ageInt = Integer.valueOf(age);
		log.info(ageInt);
	}
	
	// /g?name=jane&age=100
	@RequestMapping("/g")
	public void method7(String name, int age) {
		log.info("g method");
		log.info(name);
		log.info(age);
	}
	
	// /h?name=jane&age=100
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
	
	// /i?name=jane&age=100
	@RequestMapping("/i")
	public void method9(Member member) { //java bean의 property활용하여 Member객체 만들어 넣어 줌
		log.info("i method");
		log.info(member);
	}
	
	// /j?name=john&name=jane&name=donald
	@RequestMapping("/j")
	public void method10(@RequestParam String[] name) {
		log.info("j method");
		log.info(name.length);
		for(String n: name) {
			log.info(n);
		}
	}
	
	// /k?name=john&name=jane&name=donald
	@RequestMapping("/k")
	public void method11(@RequestParam List<String> name) {
		log.info("k method");
		log.info(name.size());
		for(String n: name) {
			log.info(n);
		}
	}
	
	// /kk?n=john&n=jane&n=donald
	@RequestMapping("/kk")
	public void method111(@RequestParam("n") List<String> name) {
		log.info("kk method");
		log.info(name.size());
		for(String n: name) {
			log.info(n);
		}
	}
	
	// /l?name=trump&age=99
	@RequestMapping("/l")
	public void method12(Member member) {
		log.info("l method");
		log.info(member);
	}
	
	// Custom Class는 아래와 같이 하면 안됨?? 별도의 Class(MemberList)를 만들어서 해야 함
	@RequestMapping("/ll")
	public void method122(ArrayList<Member> member) {
		log.info("ll method");
		log.info(member);
	}
	
	// /lll?list[0].name=john&list[1].name=jane
	// /lll?list%5B0%5D.name=john&list%5B1%5D.name=jane
	@RequestMapping("/lll")
	public void method122(MemberList member) {
		log.info("lll method");
		log.info(member);
	}
	
	// /m?date=2020-08-25 String을 Date로 convert 못함
	@RequestMapping("/m")
	public void method13(@RequestParam("date") Date date) {
		log.info("m method");
		log.info(date);
	}
	
	// 1) url요청을 실행하기 전에 InitBinder를 먼저 실행시킴 2) Spring이 제공해 주는 특별한 Editor 사용해 처리
	@InitBinder
	public void initBind(WebDataBinder binder) {
		log.info("init binder");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registCustomEditor(Date.class, propertyEditor);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false)); //false - 빈값을 허용할지 여부
		binder.registerCustomEditor(Member.class, new CustomMemberEditor());
	}
	
	// /n?mem=john-99 --> CustomMemberEditor()를 이용해 변환
	@RequestMapping("/n")
	public void method14(@RequestParam("mem") Member member) {
		log.info("n method");
		log.info(member);
		
	}
	
	@RequestMapping("/o")
	public void method15(Model model) { //Model은 DispatcherServlet으로 부터 받음
		log.info("o method");
		log.info(model); // {} 출력 -> model이 있다는 것을 확인함
		
		model.addAttribute("my-attr", "my-value");
		
		log.info(model); // {my-attr=my-value} 출력
	}
	
	// /p?str=seoul
	@RequestMapping("/p")
	public void method16(String str, Model model) {
		log.info("p method");
		log.info(model);
		
		//model.addAttribute("attr", service.get(str));
		model.addAttribute("str", str); // 파라미터로 받은 값을 model에 넣음
		
		log.info(model); //{str=seoul}
	}
	
	// /pp?str=seoul
	@RequestMapping("/pp")
	public void method166(@ModelAttribute("str") String str, Model model) { //기본타입은 @ModelAttribute를 붙여줘야 등록됨. 잘 등록되었는지 확인도 함
		log.info("pp method");
		log.info(model); //{str=seoul, org.springframework.validation.BindingResult.str=org.springframework.validation.BeanPropertyBindingResult: 0 errors}
	}
	
	@RequestMapping("/q")
	public void method17(Model model) {
		log.info("q method");
		model.addAttribute("str", "str-value");
		model.addAttribute("str-value2"); //{string=str-value2} 넣어준 값의 타입의 소문자가 이름이 됨
		model.addAttribute(new Member());
		model.addAttribute(new String[] {"a", "b"}); //Attribute 이름은 원소타입에 List가 붙음
		//model.addAttribute(new ArrayList<Member>()); //Attribute 이름은 원소타입에 List가 붙음. 비어 있는 collection은 등록 안됨
		
		List<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member());
		model.addAttribute(mlist); //Attribute 이름은 원소타입에 List가 붙음. 비어 있는 collection은 등록 안됨
		
		log.info(model); // {str=str-value, string=str-value2, member=Member(name=null, age=0), stringList=[Ljava.lang.String;@55ed679f, memberList=[Member(name=null, age=0)]}
	}
	
	@RequestMapping("/qq")
	public void method177(Model model) {
		log.info("qq method");
		model.addAttribute(new String[] {"a", "b"});
		log.info(model); // {stringList=[Ljava.lang.String;@1734e894}
	}
	
	// /r?name=donald&age=22
	@RequestMapping("/r")
	public void method18(@ModelAttribute Member member, Model model) { //기본타입이 아닌 경우는 @ModelAttribute가 생략되어도 model에 등록됨
		log.info("r method");
		log.info(model);
	}
}
