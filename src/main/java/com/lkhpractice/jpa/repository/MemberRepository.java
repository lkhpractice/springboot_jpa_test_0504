package com.lkhpractice.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkhpractice.jpa.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long> {
	// <엔티티 클래스의 타입, 기본키의 타입>
	
	public List<MemberDto> findByName(String name);
	
}
