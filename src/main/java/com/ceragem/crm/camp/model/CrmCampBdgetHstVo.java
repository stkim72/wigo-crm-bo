package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampBdgetHstVo
 * @author    user
 * @date    2022. 6. 22.
 * @Version    1.0
 * @description    undefined Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampBdgetHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 발송현황기본번호 
    */
    private String bdgetHstNo;
    /**
    * 해당년월 
    */
    private String applyYear;
    /**
    * 부서코드 
    */
    private String orgId;
    private String orgIdNm;
    /**
    * 예산수 
    */
    private Integer bdgetCnt;
    /**
    * 채널코드 
    */
    private String chlCd;
    private String chlCdNm;
    /**
    * 발송수량 
    */
    private Integer dspCnt;
    /**
    * 발송금액 
    */
    private Integer occurAmt;
    /**
    * 예상금액 
    */
    private Integer forecDspExpns;
    /**
    * 차액 
    */
    private Integer gapAmt;

    private String hstStaYmd;
    private String hstEndYmd;
}
