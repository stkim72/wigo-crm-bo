package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmStoreBasVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	* 매장번호 
	*/
	private String storNo;
	
	/**
	* 매장명 
	*/
	private String storNm;
	
	/**
	* 등록채널코드 
	* 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	*/
	private String regChlCd;
	
	/**
	* 전화번호 
	*/
	private String telNo;
	
	/**
	* 시작시간 
	*/
	private String staHour;
	
	/**
	* 종료시간 
	*/
	private String endHour;
	
	/**
	* 영업시간 
	*/
	private String useHour;
	
	/**
	* 우편번호 
	*/
	private String zipCd;
	
	/**
	* 주소1내용 
	*/
	private String addr1Ctnts;
	
	/**
	* 주소2내용 
	*/
	private String addr2Ctnts;
	
	/**
	* 메모 
	*/
	private String memoCtnts;
	
	/**
	* 위도 
	*/
	private String lati;
	
	/**
	* 경도 
	*/
	private String longi;
	
	/**
	* 매장채널코드 
	*/
	private String storChlCd;
	
	/**
	* 매장유형코드 
	*/
	private String storTypeCd;
	
	/**
	* 매장구분코드 
	*/
	private String storDivCd;
	
	/**
	* POS매장번호 
	*/
	private String posStorNo;
	
	/**
	* 매장상태코드 
	*/
	private String storStatusCd;
	
	/**
	* 지역코드 
	*/
	private String distrctCd;
	
	/**
	* 지역명
	*/
	private String distrctNm;
	
	/**
	* 고객수 
	*/
	private String memberCnt;
	
	/**
	* 직원수 
	*/
	private String staffCnt;
}