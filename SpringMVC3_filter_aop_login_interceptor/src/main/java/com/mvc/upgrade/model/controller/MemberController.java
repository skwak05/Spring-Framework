package com.mvc.upgrade.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[Controller] loginform.do");
		
		return "memberlogin";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		
		/*
		 * @RequestBody : request 객체의 body에 저장되어 넘어오는 데이터 (json 객체 / 문자열이 아닌 타입의 값) -> java object에 binding
		 * @ResponseBody : java object (Map) -> response 객체의 body에 binding
		 * 
		 * jackson (pom.xml에서 추가한 dependency)이 response body에 담긴 map을 json으로 바꿔줌
		 * 
		 */
		
		
		logger.info("[Controller] ajaxlogin.do");
		
		MemberDto res = biz.login(dto);
		
		boolean check = false;
		
		if(res != null) {
			check = true;
			session.setAttribute("login", res);
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
}
