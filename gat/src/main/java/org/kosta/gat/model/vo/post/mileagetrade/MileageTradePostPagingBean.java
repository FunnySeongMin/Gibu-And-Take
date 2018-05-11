package org.kosta.gat.model.vo.post.mileagetrade;

public class MileageTradePostPagingBean {
	//현재 페이지
	private int nowPage=1;
	//페이지당 게시물 수
	private int postCountPerPage=10;
	//페이지 그룹당 페이지 수
	private int pageCountPerPageGroup=5;
	//저장된 총 게시물 수
	private int totalPostCount;
	
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MileageTradePostPagingBean() {
		super();
	}
	public MileageTradePostPagingBean(int totalPostCount) {
		super();
		this.totalPostCount = totalPostCount;
	}
	public MileageTradePostPagingBean(int totalPostCount, int nowPage) {
		super();
		this.totalPostCount = totalPostCount;
		this.nowPage = nowPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	//현재 페이지 번호에 해당하는 시작 게시물의 row number를 반환
	public int getStartRowNumber() {
		return ((nowPage-1)*postCountPerPage)+1;
	}
	//현제 페이지 번호에 해당하는 마지막 게시물의 row number를 반환
	public int getEndRowNumber() {
		int endRowNumber=nowPage*postCountPerPage;
		if(totalPostCount<endRowNumber)
			endRowNumber=totalPostCount;
		return endRowNumber;
	}
	//총 페이지 수를 반환
	public int getTotalPage() {
		int num=this.totalPostCount % this.postCountPerPage;
		int totalPage=0;
		if(num==0) {
			totalPage=this.totalPostCount / this.postCountPerPage;
		}else {
			totalPage=this.totalPostCount / this.postCountPerPage+1;
		}
		return totalPage;
	}
	//총 페이지 그룹의 수 반환
	public int getTotalPageGroup() {
		int num=this.getTotalPage() % this.pageCountPerPageGroup;
		int totalPageGroup=0;
		if(num==0) {
			totalPageGroup=this.getTotalPage() / this.pageCountPerPageGroup;
		}else {
			totalPageGroup=this.getTotalPage() / this.pageCountPerPageGroup+1;
		}
		return totalPageGroup;
	}
	//현재 페이지가 속한 페이지 그룹의 번호를 반환
	//페이지 그룹 : 목록 아래에 나오는 한 줄의 페이지들이 하나의 페이지 그룹이다.
	public int getNowPageGroup() {
		int num=this.nowPage % this.pageCountPerPageGroup;
		int nowPageGroup=0;
		if(num==0) {
			nowPageGroup=this.nowPage / this.pageCountPerPageGroup;
		}else {
			nowPageGroup=this.nowPage / this.pageCountPerPageGroup+1;
		}
		return nowPageGroup;
	}
	//현재 페이지가 속한 페이지 그룹의 시작 페이지 번호 반환
	//ex) 페이지 그룹이 1,2,3,4 이고 현제 페이지가 3이라면 시작페이지 번호는 1이다.
	public int getStartPageOfPageGroup() {
		int num=this.pageCountPerPageGroup*(this.getNowPageGroup()-1)+1;
		return num;
	}
	//현재 페이지가 속한 그룹의 마지막 페이지 번호 반환
	public int getEndPageOfPageGroup() {
		int num=this.getNowPageGroup()*this.pageCountPerPageGroup;
		if(this.getTotalPage()<num)
			num=this.getTotalPage();
		return num;
	}
	//이전 페이지 그룹이 있는지 확인한다. 결과값은 boolean이다.
	public boolean isPreviousPageGroup() {
		boolean flag=false;
		if(this.getNowPageGroup()>1) {			
			flag=true;
		}
		return flag;
	}
	//파음 페이지 그룹이 있는지 확인한다.
	public boolean isNextPageGroup() {
		boolean flag=false;
		if(this.getNowPageGroup()<this.getTotalPageGroup()) {			
			flag=true;
		}
		return flag;
	}
	public static void main(String args[]) {
		 MileageTradePostPagingBean p = new MileageTradePostPagingBean(470, 10);
		 // 현페이지의 시작 row number 를 조회 181
		 System.out.println("getBeginRowNumber:" + p.getStartRowNumber());
		 // 현페이지의 마지막 row number 를 조회 200
		 System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		 // 전체 페이지 수 : 24
		 System.out.println("getTotalPage:" + p.getTotalPage());
		 // 전체 페이지 그룹 수 : 3
		 System.out.println("getTotalPageGroup:" + p.getTotalPageGroup());
		 System.out.println("////////////////////////////");
		 p = new MileageTradePostPagingBean(710, 14);// 게시물수 31 현재 페이지 6
		 // 현페이지의 시작 row number 를 조회 101
		 System.out.println("getStartRowNumber:" + p.getStartRowNumber());
		 // 현페이지의 마지막 row number 를 조회 120
		 System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		 // 게시물수 31 -> 총페이지수 7 -> 총페이지그룹->2
		 // 현재 페이지 그룹 : 1
		 System.out.println("getNowPageGroup:" + p.getNowPageGroup());
		 // 페이지 그룹의 시작 페이지 : 1
		 System.out.println("getStartPageOfPageGroup:" + p.getStartPageOfPageGroup());
		 // 페이지 그룹의 마지막 페이지 : 1
		 System.out.println("getEndPageOfPageGroup:" + p.getEndPageOfPageGroup());
		 // 이전 페이지 그룹이 있는 지 : false
		 System.out.println("isPreviousPageGroup:" + p.isPreviousPageGroup());
		 // 다음 페이지 그룹이 있는 지 : true
		 System.out.println("isNextPageGroup:" + p.isNextPageGroup());
		 }
}
