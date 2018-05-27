package org.kosta.gat.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.gat.model.service.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@Resource
	DonationService donationService;

	@RequestMapping("home.do")
	public String home(Model model) {
		// 반환하는 viewName이 home.tiles  
		// 즉 tiles-config.xml 의 definition name 이면 tiles view로 응답된다. 
		// <definition name="home.tiles" template="/WEB-INF/views/templates/layout.jsp">
		
		// 재능기부 리스트 상위 3명
		List<Map<String, Object>> rank = donationService.DonationListRank();
		model.addAttribute("rank", rank);
		return "home.tiles";
	}
	/**
	 * 
	 * 작성이유 : tiles가 적용된 view
	 * 
	 * @author 조민경
	 * 
	 */
	@RequestMapping("{dirName}/{viewName}.do")
	public String showTiles(@PathVariable String dirName, @PathVariable String viewName) {
		return dirName+"/"+viewName+".tiles";
	}
}
