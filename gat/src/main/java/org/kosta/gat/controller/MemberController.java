package org.kosta.gat.controller;

import javax.annotation.Resource;

import org.kosta.gat.model.service.MemberService;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
}
