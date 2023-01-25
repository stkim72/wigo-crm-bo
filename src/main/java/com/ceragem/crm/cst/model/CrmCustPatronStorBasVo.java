package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustPatronStorBasVo
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM고객단골매장기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustPatronStorBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;


	/**
	* 검색 시작일 : 최근방문일 
	*/
	private String strtDt;
	/**
	* 검색 종료일 : 최근방문일 
	*/
	private String endDt;

    /**
    * 단골매장일련번호 
    */
    private String patronStorSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 매장번호 
    */
    private String storNo;
	/**
	* 매장명 
	*/
	private String storNm;    
    /**
    * 매장채널코드 
    */
    private String storChlCd;
    /**
    * 최근방문일시 
    */
    private String rcntlyVisitDt;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
}
