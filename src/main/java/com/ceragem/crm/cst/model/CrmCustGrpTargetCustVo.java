package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpTargetCustVo extends BaseVo {
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
	* 이동전화번호 
	*/
	private String mphonNo;
	
	/**
	* 이동전화번호 복호화
	*/
	private String mphonNoMasking;
	
	/**
	* 이메일주소 
	*/
	private String emailAddr;
	
	/**
	* 멤버십등급코드 
	*/
	private String mshipGradeCd;
	
	/**
	* SMS수신동의여부 
	*/
	private String smsRcvAgreeYn;
	
	/**
	* 이메일수신동의여부 
	*/
	private String emailRcvAgreeYn;
	
	/**
	* 알람톡수신동의여부 
	*/
	private String alrmTkRcvAgreeYn;
	
	/**
	* PUSH수신동의여부 
	*/
	private String pushRcvAgreeYn;
}
