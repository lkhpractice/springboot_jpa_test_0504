package com.lkhpractice.jpa;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lkhpractice.jpa.dto.MemberDto;

@Controller
public class HomeController {

	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); //문자열을 int로 변환
		int grade = Integer.parseInt(request.getParameter("grade"));
		String etc = request.getParameter("etc");
	
		MemberDto memberDto = new MemberDto();
		
		memberDto.setName(name);
		memberDto.setAge(age);
		memberDto.setGrade(grade);
		memberDto.setEtc(etc);
		
		return "joinOk";
	}
}