package org.kosta.gat.controller;

import javax.annotation.Resource;

import org.kosta.gat.model.service.DonationService;
import org.springframework.stereotype.Controller;

@Controller
public class DonationController {
	@Resource
	private DonationService donationService;
}
