package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampDspBasVo
 * @author    user
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    캠페인발송기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampDspBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 발생채널 기본번호 
    */
    private String campDspBasNo;
    /**
    * 발송채널명 
    */
    private String campDspChlNm;
    /**
    * 발송금액 
    */
    private String campDspAmt;
}
