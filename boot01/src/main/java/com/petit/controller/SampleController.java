package com.petit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petit.domain.SampleVO;


@RestController	// REST 방식의 컨트롤러
public class SampleController {
	
	@GetMapping("/hello")
	public String sayHello() {
		
		return "Hello World";
	}
	
	@GetMapping("sample")
	public SampleVO makeSample() {
	
		SampleVO vo = new SampleVO();
		vo.setVal1("v1");
		vo.setVal2("v2");
		vo.setVal3("v3");
		
		System.out.println(vo);
		
		return vo;
	}

}
