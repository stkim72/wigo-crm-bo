package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustPhnCnslDtlHistVo
 * @author    user
 * @date    2022. 5. 13.
 * @Version    1.0
 * @description    CRM고객상담상세이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustPhnCnslDtlHistVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;

//검색조건 시작
	/**
	* 현재페이지번호 
	*/
	private String currentPageNo;
	/**
	* 페이지당로우수 
	*/
	private String recordCountPerPage;
	/**
	* 고객전화번호 
	*/
	private String custTelNo;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;	
	/**
	* 검색시작일 
	*/
	private String startDt;
	/**
	* 검색종료일 
	*/
	private String endDt;
// 검색조건 끝
	
    /**
    * 상담이력번호 
    */
    private String cnslHistNo;
    /**
    * 상담이력상세번호 
    */
    private String cnslHistDtlNo;
    /**
    * ASP_고객사_키 
    */
    private String aspCustKey;
    /**
    * 상담유형코드 
    */
    private String cnslTypCd;
    /**
    * 상담유형코드2 
    */
    private String cnslTypCd2;
    /**
    * 상담유형코드3 
    */
    private String cnslTypCd3;
    /**
    * 처리코드대분류 : 처리결과코드 
    */
    private String procCodeLcls;
    /**
    * 처리코드중분류 
    */
    private String procCodeMdcls;
    /**
    * 처리코드소분류 
    */
    private String procCodeScls;
    /**
    * 상담내용 
    */
    private String cnslCntn;
    /**
    * 답변내용 
    */
    private String repleCntn;
    
    /**
    * 상담시작일
    */
    private String  cnslBeginDate  ;
    /**
    * 상담시작시간
    */    
    private String  cnslBeginTime  ;
    private String  callTy         ;
    private String  channel        ;
    
    /**
    * 제품명
    */    
    private String  productNm      ;
    private String  productCd      ;
    
    /**
    * AS접수번호
    */    
    private String  asRecpNo       ;
    
    /**
    * 고객명
    */    
    private String  custNm         ;
    private String  cnslTypNm      ;
    private String  cnslTypNm2     ;
    private String  cnslTypNm3     ;
    private String  cmplYn         ;
    private String  rdwtId         ;
    private String  userNm         ;
    /**
    * 처리결과명
    */    
    private String  procNmLcls     ;

}
