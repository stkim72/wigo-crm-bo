package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusSurveyListVo
 * @author    황의겸
 * @date    2022. 4. 27.
 * @Version    1.0
 * @description    CRM설문이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusSurveyListVo extends BaseVo {
    /**
    *
    */
	private static final long serialVersionUID = 1L;
	/**
    * 설문이력일련번호 
    */
    private String qstnrHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 발송콘텐츠유형코드 
    */
    private String dspCtntTypeCd;
    /**
    * 발송콘텐츠유형
    */
    private String dspCtntTypeNm;
    /**
    * 이동전화번호 
    */
    private String mphonNo;
    /**
    * 이메일주소 
    */
    private String emailAddr;
    /**
    * 설문구분코드 
    */
    private String qstnrDivCd;
    /**
    * 설문구분 
    */
    private String qstnrDivNm;
    /**
    * 고객만족도점수 
    */
    private Integer custSdegScore;
    /**
    * 응답일시 
    */
    private String answrDt;
    /**
    * 발송채널코드 
    */
    private String dspChlCd;
    /**
    * 발송채널
    */
    private String dspChlNm;
    /**
    * 프로모션번호 
    */
    private String promNo;
    /**
    * 캠페인번호 
    */
    private String campNo;
    /**
    * 매장번호 
    */
    private String storNo;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
}
