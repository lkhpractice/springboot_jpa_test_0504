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
	
	@RequestMapping(value = "/delete")
	public String delete( ) {
		return "delete";
	}
	
	@RequestMapping(value = "/deleteOk")
	public String deleteOk(HttpServletRequest request) {
		
		String hakbun = request.getParameter("hakbun");
		
		memberRepository.deleteById(Long.parseLong(hakbun));
		
		return "redirect:memberList";
	}
	
	@RequestMapping(value = "/deleteOk2")	//이름으로 조회하여 삭제
	public String deleteOk2(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		
		memberRepository.deleteAllByName(name);
		
		return "redirect:memberList";
	}
	
	@RequestMapping(value = "/memberList")
	public String memberList(Model model) {
		
		//model.addAttribute("memberDtos", memberRepository.findAll());
		model.addAttribute("memberDtos", memberRepository.findAllByOrderByHakbunDesc());
		//학번의 내림차순 정렬 후 모든 회원 리스트 가져오기
		
		return "memberList";
	}
}