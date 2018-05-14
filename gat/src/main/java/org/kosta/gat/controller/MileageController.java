package org.kosta.gat.controller;

import javax.annotation.Resource;

import org.kosta.gat.model.service.MileageService;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MileageController {
	@Resource
	private MileageService mileageService;
	/**
	* 작성이유 : 마일리지 충전
	* 
	* @author 은성민
	*/
	@RequestMapping("addMileage.do")
	public String addMileage(int mileage) {
		mileageService.addMileage(mileage);
		return null;
	}
	/**
	* 작성이유 : 마일리지 거래
	* 
	* @author 은성민
	*/
	@RequestMapping("tradeMileage.do")
	public String tradeMileage(int mileage) {
		mileageService.tradeMileage(mileage);
		return null;
	}
	/**
	* 작성이유 : 마일리지 환전
	* 
	* @author 은성민
	*/
	@RequestMapping("exchangeMileage.do")
	public String exchangeMileage(int mileage) {
		mileageService.exchangeMileage(mileage);
		return null;
	}
	/**
	* 작성이유 : 마일리지 사용내역
	* 
	* @author 은성민
	*/
	@RequestMapping("readMyMileageTradeList.do")
	public String readMyMileageTradeList(String id,int nowPage) {
		MileageTradePostListVO mtListVO=mileageService.readMyMileageTradeList(id,nowPage);
		return null;
	}
}
