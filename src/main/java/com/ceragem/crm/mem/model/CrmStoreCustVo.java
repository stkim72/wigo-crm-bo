package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmStoreCustVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	* 매장번호 
	*/
	private String storNo;
	
	/**
	* 고객번호 
	*/
	private String itgCustNo;
	
	/**
	* 멤버십ID
	*/
	private String mshipLoginId;
	
	/**
	* 이름 
	*/
	private String custNm;
	
	/**
	* 성별
	*/
	private String gndrCd;
	
	/**
	* 연령
	*/
	private String birthday;
	
	/**
	* 연락처 
	*/
	private String mphonNo;
	
	/**
	* 연락처 마스킹
	*/
	private String mphonNoMasking;
	
	/**
	* 구매제품코드 
	*/
	private String godsNo;
	
	/**
	* 구매제품명 
	*/
	private String godsNm;
	
	/**
	* 구매일자
	*/
	private String ordDate;
	
	/**
	* 포인트
	*/
	private String remainPointScore;
}