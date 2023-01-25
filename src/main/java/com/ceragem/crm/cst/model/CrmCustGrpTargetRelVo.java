package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpTargetRelVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	* 고객그룹대상자관계번호 
	*/
	private String custGrpTgtrRelNo;
	
	/**
	* 고객그룹번호 
	*/
	private String custGrpNo;
	
	/**
	* 통합고객번호 
	*/
	private String itgCustNo;
	
	/**
	* 고객명 
	*/
	private String custNm;
	
	/**
	* 성별코드 
	*/
	private String gndrCd;
	
	/**
	* 생년월일 
	*/
	private String birthday;
	
	/**
	* 이동전화번호 
	*/
	private String mphonNo;
	
	/**
	* 이동전화번호 복호화
	*/
	private String mphonNoMasking;
	
	/**
	* 이동전화뒤자리번호 
	*/
	private String mphonBkDgtNo;
	
	/**
	* 대상여부 
	*/
	private String tgtYn;
	
	/**
	* 등록채널코드 
	*/
	private String regChlCd;
}
