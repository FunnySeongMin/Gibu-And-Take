package org.kosta.gat.controller;

import javax.annotation.Resource;

import org.kosta.gat.model.service.MileageService;
import org.springframework.stereotype.Controller;

@Controller
public class MileageController {
	@Resource
	private MileageService mileageService;
}
