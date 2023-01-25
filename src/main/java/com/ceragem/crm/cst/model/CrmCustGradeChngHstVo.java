package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustGradeChngHstVo
 * @author    user
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    CRM고객등급변경이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustGradeChngHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;

	/**
	* 등급변경시작일 
	*/
	private String strtDt5;
	/**
	* 등급변경종료일 
	*/
	private String strtDt6;
	/**
	* 등급만료시작일 
	*/
	private String endDt5;
	/**
	* 등급만료종료일 
	*/
	private String endDt6;

    /**
    * 등급변경이력일련번호 
    */
    private String gradeChngHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 적용기준시작년월일 
    */
    private String applyStdStaYmd;
    /**
    * 적용기준종료년월일 
    */
    private String applyStdEndYmd;
    /**
    * 회원등급코드 
    */
    private String mshpGradeCd;
    /**
    * 변경전회원등급코드 
    */
    private String chngPreMshpGradeCd;
    /**
    * 회원등급유형코드 
    */
    private String mshpGradeTypeCd;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
}
