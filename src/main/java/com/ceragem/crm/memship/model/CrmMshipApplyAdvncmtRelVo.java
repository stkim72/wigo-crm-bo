package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipApplyAdvncmtRelVo
 * @author    user
 * @date    2022. 5. 15.
 * @Version    1.0
 * @description    맴버십기본정책-승급점수정책 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyAdvncmtRelVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 승급점수기본번호 
    */
    private String advncmtScoreBasNo;
    /**
    * 승급공통코드 
    */
    private String advncmtComnCd;
    /**
    * 멤버십정책기본번호 
    */
    private String mshipPlcyBasNo;
    /**
    * 승급점수 
    */
    private Integer advncmtPointScore;
    /**
    * 총지정수 
    */
    private Integer totAppntCnt;
    /**
    * 일지정수 
    */
    private Integer dayAppntCnt;
    /**
    * 월지정수 
    */
    private Integer monthAppntCnt;
    
    
    private String comnCdNm;
    private String topComnCd2;
    private String comnCd2;
}
