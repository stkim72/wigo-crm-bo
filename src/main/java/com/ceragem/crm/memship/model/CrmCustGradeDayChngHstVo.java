package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustGradeDayChngHstVo
 * @author    user
 * @date    2022. 6. 3.
 * @Version    1.0
 * @description    CRM고객등급일일예정변경이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustGradeDayChngHstVo extends BaseVo {
    /**
    *
    *
    */
private static final long serialVersionUID = 1L;
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
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS]
    */
    private String regChlCd;
    /**
    * 승급점수 
    */
    private Integer mshipAdvncmtScore;
    private String custNm;
    private String mshipGradeCdNm;
    private String mshpGradeCdNm;
    private String chngPreMshpGradeCdNm;
    
}
