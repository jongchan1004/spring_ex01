package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/res")
@Log4j
public class ResponseController {
	
	@RequestMapping("/a")
	public String methoda() {
		log.info("a method");
		
		return "/res/a";
	}
	
	@RequestMapping("/b")
	@ResponseBody
	public String methodb() {
		log.info("b method");
		
		return "hello b method"; //jsp안 거쳐서 기본세팅인 Content-Type: text/html;charset=ISO-8859-1로 응답 10:09
								//응답데이터를 페이지의 일부만 로딩되게 사용할 수 있음(ajax)
	}
	
	@RequestMapping("/bb")
	@ResponseBody
	public String methodbb() {
		log.info("bb method");
		
		return "<body><h1>hello b method</h1></body>";
	}
	
	@RequestMapping("/c")
	@ResponseBody
	public String methodc() {
		log.info("c method");
		return "<li>john, 22</li><li>jane, 33</li>"; //페이지 일부만 데이터로 전송할때 html형식이 꼭 바람직하지 않음
	}
	
	@RequestMapping("/d")
	@ResponseBody
	public String method() {
		log.info("d method");
		return "{\"name\":\"john\", \"age\":22}"; //JSON타입, header는 안 바뀜, text header로 응답
	}
	
	@RequestMapping("/e")
	public ResponseEntity<String> methode() {
		log.info("e method");
		String body = "{\"name\":\"john\", \"age\":22}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		ResponseEntity<String> response = new ResponseEntity<>(body, header, HttpStatus.OK); //몸통정보,헤더정보를 다 구성할 수 있음
		
		return response;
	}
	
	@RequestMapping("/f")
	public ResponseEntity<String> methodf() {
		log.info("f method");
		Member member = new Member(); // service.get(3);
		member.setName("donald");
		member.setAge(99);
		
		String body = "{\"name\":\""+ member.getName() + ", \"age\":" + member.getAge() + "}"; //JSON값을 변수로
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		ResponseEntity<String> response = new ResponseEntity<>(body, header, HttpStatus.OK);
		
		return response;
	}
	
	@RequestMapping("/g")
	@ResponseBody
	public Member methodg() {
		log.info("g method");
		Member member = new Member();
		member.setName("donald");
		member.setAge(99);
		
		return member; // f와 같은 처리를 jackson-databind 라이브러리가 헤더정보 추가도 해줌. json으로 전달됨
	}
	
	@RequestMapping("/h")
	@ResponseBody
	public List<Member> methodh(){
		List<Member> members = new ArrayList<>();
		
		// json의 배열 []
		// ex: [{"name": "donald", "age":22}, {"name": "jane", "age":2}]
		
		Member m1 = new Member();
		m1.setName("donald");
		m1.setAge(22);
		
		Member m2 = new Member();
		m2.setName("jane");
		m2.setAge(2);
		
		members.add(m1);
		members.add(m2);
		
		return members; //json 배열로 전달됨
	}
	
	
	@RequestMapping("/i")
	public void methodi(HttpServletRequest req) {
		log.info("i method");
		
		log.info(req.getQueryString()); // $.get("/res/i", "mystring");-->res/i?mystring
		log.info(req.getParameter("name")); // $.get("/res/i", "name=myname");-->res/i?name=myname
		
	}
	
	// $.get("/res/j", "name=myname");-->res/j?name=myname
	@RequestMapping("/j")
	public void methodj(String name) {
		log.info("j method");
		
		log.info(name); // /i와 동일함
		
	}
	
	@RequestMapping("/jj")
	public void methodjj(String name, int age) {
		log.info("jj method");
		log.info(name);
		log.info(age); 
		
	}
	
	// var o = {name:"myname", age:22};
	// $.get("/res/k", o); 객체를 보냄
	@RequestMapping("/k")
	public void methodk(HttpServletRequest req) {
		log.info("k method");
		log.info(req.getQueryString()); // 객체를 받아 name=myname&age=22로 해석함
		
	}
	
//	@RequestMapping("/l")
//	@ResponseBody
//	public Member methodl(int id) {
//		log.info("l method");
//		Member mem = service.get(id); //service가 있을때
//		
//		return mem;
//		
//	}
	
	@RequestMapping("/l")
	@ResponseBody
	public Member methodl(int id) {
		log.info("l method");
		Member mem = new Member();
		mem.setName("korea");
		mem.setAge(11);
		
		return mem;
		
	}
}
