package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.EzMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpTargetCondVo {
	
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	
	//고객마스터 조건정보 관련
	private CrmCustGrpMstrCondVo custMasterCond;
	
	//접촉이력 조건정보 관련
	private CrmCustGrpCnttHstCondVo cnttHstCond;
	
	//거래이력 조건정보 관련
	private CrmCustGrpDealHstCondVo dealHstCond;
	
	
	//페이징 관련
	private int page = 1;
	private int pageSize = 5;
	private int perPage = 30;
	private int totalCount = 0;
	
	public int getTotalPageCount() {
		if (getTotalCount() == 0) {
			return 0;
		}
		return ((getTotalCount() - 1) / getPerPage()) + 1;
	}

	public int getFirstPageNo() {
		return 1;
	}

	public int getLastPageNo() {
		return getTotalPageCount();
	}

	public int getFirstPageNoOnPageList() {
		if (getPageSize() == 0) {
			return 0;
		}

		return ((getPage() - 1) / getPageSize()) * getPageSize() + 1;
	}

	public int getLastPageNoOnPageList() {
		int lastPageNoOnPageList = getFirstPageNoOnPageList() + getPageSize() - 1;
		if (lastPageNoOnPageList > getTotalPageCount()) {
			lastPageNoOnPageList = getTotalPageCount();
		}
		return lastPageNoOnPageList;
	}

	public int getFirstRecordIndex() {
		return (getPage() - 1) * getPerPage() + 1;
	}

	public int getLastRecordIndex() {
		return getPage() * getPerPage();
	}

	public EzMap toToastPage() {
		EzMap ezMap = new EzMap();
		ezMap.setInt("page", getPage());
		ezMap.setInt("totalCount", getTotalCount());
		ezMap.setInt("perPage", getPerPage());
		return ezMap;
	}
}
