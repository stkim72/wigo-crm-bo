package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustCrckDnaHstVo
 * @author    황의겸
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    CRM고객세라체크DNA이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusCeraDnaListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 검체번호 
    */
    private String sampleId;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 유전자분석상태값 
    */
    private String status;
    /**
    * 계약번호 
    */
    private String contractNum;
    /**
    * 검사유형 
    */
    private String prodNm;
    /**
    * 검체일 
    */
    private String receiptDate;
    /**
    * 검체발송일 
    */
    private String receiptDt;
    /**
    * 검체수령일 
    */
    private String carryDt;
    /**
    * 분석완료일 
    */
    private String analysisDt;
    /**
    * 결과지발송일 
    */
    private String sendDt;
}
