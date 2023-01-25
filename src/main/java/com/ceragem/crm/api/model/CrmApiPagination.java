package com.ceragem.crm.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmApiPagination  {
	/**
	 * Required Fields - 이 필드들은 페이징 계산을 위해 반드시 입력되어야 하는 필드 값들이다.
	 * 
	 * currentPageNo : 현재 페이지 번호 recordCountPerPage : 한 페이지당 게시되는 게시물 건 수 pageSize :
	 * 페이지 리스트에 게시되는 페이지 건수, totalRecordCount : 전체 게시물 건 수.
	 */

	private int currentPageNo = 1;
	private int recordCountPerPage = 30;
	private int totalRecordCount = 0;

	public int getFirstRecordIndex() {
		return (getCurrentPageNo() - 1) * getRecordCountPerPage() + 1;
	}

	public int getLastRecordIndex() {
		return getCurrentPageNo() * getRecordCountPerPage();
	}

}
