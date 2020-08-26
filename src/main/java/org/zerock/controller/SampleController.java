package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;
import org.zerock.domain.TodoDTO2;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..........................");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get.......................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get...............");
	}
	
	// /sample/ex01?name=AAA&age=10
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);;
		return "ex01";
	}
	
	// /sample/ex02?name=AAA&age=10
	@GetMapping("/ex02")
	public String ex02(String name, int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		System.out.println(name+" "+age);
		return "ex02";
	}
	
	// /sample/ex02List?ids=111&ids=222&ids=333
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids: " + ids);
		return "ex02List";
	}
	
	// /sample/ex02Array?ids=111&ids=222&ids=333
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids")String[] ids) {
		log.info("array ids: " + Arrays.deepToString(ids));
		return "ex02Array";
	}
	// 134 page
	// /sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb&list%5B2%5D.name=ccc
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList sampleList) {
		log.info("list dtos: " + sampleList);
		return "ex02Bean";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	// /sample/ex03?title=test&dueDate=2018-01-01  TodoDTO는 initBinder가 있어야 함
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex03";
	}
	
	// /sample/ex03dtformat?title=test&dueDate=2018/01/01 TodoDTO2는 field에 @DateTimeFormat(pattern="yyyy/MM/dd") 넣어 놔서 initBinder 필요 없음
	@GetMapping("/ex03dtformat")
	public String ex03(TodoDTO2 todo) {
		log.info("todo: " + todo);
		return "ex03dtformat";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) { //page는 전달 안됨
		log.info("dto: " + dto);
		log.info("page: " + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex04model")
	public String ex04model(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		return "/sample/ex04model";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05........................");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06........................");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto; //jackson-databind 라이브러리를 pom.xml에 추가하면 JSON으로 처리되어 body에 추가됨. 
		// JSON은 스프링이 별도 설정없이 변환하여 보여 줌
	}
	/*
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07........................");
		
		// {"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
*/
}
