package com.lkhpractice.jpa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lkhpractice.jpa.dto.MemberDto;
import com.lkhpractice.jpa.repository.MemberRepository;

@Controller
public class HomeController {
	
	@Autowired
	MemberRepository memberRepository;

	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(MemberDto memberDto, Model model) {
		
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age")); //문자열을 int로 변환
//		int grade = Integer.parseInt(request.getParameter("grade"));
//		String etc = request.getParameter("etc");
//	
//		MemberDto memberDto = new MemberDto();
//		
//		memberDto.setName(name);
//		memberDto.setAge(age);
//		memberDto.setGrade(grade);
//		memberDto.setEtc(etc);
		
		memberRepository.save(memberDto);
		
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/search")
	public String search( ) {
		return "search";
	}
	
	@RequestMapping(value = "/searchOk")
	public String seacrhOk(HttpServletRequest request, Model model) {
		
		String searchName = request.getParameter("searchName");
		
		List<MemberDto> memberDtos = memberRepository.findByName(searchName);
		
		model.addAttribute("memberDtos", memberDtos);
		
		return "searchOk";
	}
}