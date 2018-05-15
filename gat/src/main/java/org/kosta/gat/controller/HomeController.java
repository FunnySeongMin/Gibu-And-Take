package org.kosta.gat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("home.do")
	public String home() {
		//반환하는 viewName 이 home.tiles 즉 
		// tiles-config.xml 의 definition name 이면 
		// tiles view로 응답된다. 
		//<definition name="home.tiles" template="/WEB-INF/views/templates/layout.jsp">
		return "home.tiles";
	}
	
}
