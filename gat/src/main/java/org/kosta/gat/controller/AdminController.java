package org.kosta.gat.controller;

import javax.annotation.Resource;

import org.kosta.gat.model.service.AdminService;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
	@Resource
	private AdminService adminService;
}
