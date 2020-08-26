package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ret")
@Log4j
public class ReturnController {

	@RequestMapping("/a")
	public void methoda() { // void - 요청받은 경로.jsp로 forwarding
		log.info("a method");
	}

	@RequestMapping("/b")
	public String methodb() { // return된 string.jsp로 forwarding
		log.info("b method");
		return "/ret/a";
	}

	@RequestMapping("/c")
	@ResponseBody // 사용자에게 return string 자체가 응답의 몸통이 됨
	public String methodc() {
		log.info("c method");
		return "hello world";
	}

	@RequestMapping("/d")
	public String methodd(Model model) {
		log.info("d method");

		model.addAttribute("myAttr", "my-val");

		return "/ret/a";
	}

	@RequestMapping("/e")
	public String methode(Model model) {
		log.info("e method");

		Member member = new Member();
		member.setName("john");
		member.setAge(999);

		model.addAttribute("mem", member);

		return "/ret/a";
	}

	@RequestMapping("/f")
	public String methodf(Model model) {
		log.info("f method");

		Member member = new Member();
		member.setName("seoul");
		member.setAge(1000);

		model.addAttribute(member);

		return "/ret/a";
	}

	@RequestMapping("/g")
	public String methodg(Model model) {
		log.info("g method");

		String[] strs = new String[] { "seoul", "jeju", "korea" };

		model.addAttribute("cities", strs);

		return "/ret/b";
	}

	@RequestMapping("/h")
	public String methodh(Model model) {
		log.info("h method");

		Member m1 = new Member();
		m1.setName("seoul");
		m1.setAge(22);

		Member m2 = new Member();
		m2.setName("korea");
		m2.setAge(33);

		// 1.배열
//		Member[] members = new Member[]{m1,m2};
//		//model.addAttribute("memberList", members);
//		model.addAttribute(members); //배열이름일 경우 원소이름+List로 전달됨

		// 2.List
		List<Member> members2 = new ArrayList<Member>();
		members2.add(m1);
		members2.add(m2);
//		model.addAttribute("memberList", members2);
		model.addAttribute(members2); // List도 원소이름+List로 전달됨

		return "/ret/b";
	}

	// /i?name=jeju
	@RequestMapping("/i")
	public String methodi(@ModelAttribute("name") String name) { // 기본+String타입일 경우 Model에 추가되지 않음~3:31. 이름을 안 정해 주면
																	// 타입명을 따라감. 이름명시해야 됨
		log.info("i method");
		log.info(name);

		// model.addAttribute("name", name); 안하고 할 수 있는 방법

		return "/ret/c";
	}

	// /j?name=jeju&age=33
	@RequestMapping("/j")
	public String methodj(Member member) { // 파라미터가 Member에 저장되고, Model로 자동 등록됨
		log.info("j method");

		return "/ret/c";
	}

	// /j?name=jeju&age=33
	@RequestMapping("/k")
	public String methodk(@ModelAttribute("mem") Member member) { // "mem"을 안쓰면 타입을 따라 이름이 결정됨
		log.info("k method");

		return "/ret/c";
	}
	
	//08월26일
	// /l
	@RequestMapping("/l")
	public String methodl(Model model) { //rttr을 활용해 redirect당하는 url에 데이터를 전달
		log.info("l method");
		
		/*옛날 것
		String contextPath = request().getContextPath();
		response.sendRedirect(contextPath + "/ret/m"); forward는 contextPath 안 붙임 */
		
		model.addAttribute("myAttr1", "myValue1"); //RedirectAttributes사용안하면 request param에 붙어 있음
		
		//return "redirect:/ret/m";
		return "redirect:m"; // myAttr1: myValue1
	}
	
	// /ll
	@RequestMapping("/ll")
	public String methodll(Model model, RedirectAttributes rttr) { //rttr을 활용해 redirect당하는 url에 데이터를 전달
		log.info("l method");
		
		/*옛날 것
		String contextPath = request().getContextPath();
		response.sendRedirect(contextPath + "/ret/m"); forward는 contextPath 안 붙임 */
		
		model.addAttribute("myAttr1", "myValue1"); //RedirectAttributes사용안하면 request param에 붙어 있음
		rttr.addFlashAttribute("myRedirectAttr1", "myRedirectValue1"); //휘발성-session에 잠깐 붙었다가 떨어짐
		rttr.addAttribute("myRedirectAttr2", "myRedirectValue2"); //request param에 붙어 있음
		
		//return "redirect:/ret/m";
		return "redirect:m";
	}
	
	@RequestMapping("/m")
	public String methodm(Model model) {
		log.info("m method");
		
		//model.addAttribute("myAttr1", "myValue1"); //됨
		
		return "/ret/m";
	}
}
