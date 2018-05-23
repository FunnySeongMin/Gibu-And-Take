package org.kosta.gat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
