package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustSynthesisHstVo
 * @author    user
 * @date    2022. 5. 25.
 * @Version    1.0
 * @description    CRM고객종합이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustSynthesisHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;

	private String itgCustNo      ;
	private String itemNm         ;
	private String ordDe          ;
	private String istDcsDeBos    ;
	private String modelNm        ;
	private String iotCnt         ;
	private String endTime        ;
	private String crkCnt         ;
	private String regDt          ;
	private String excCnt         ;
	private String exprnDate      ;
//	private String excCnt  ;
	private String istDcsDe       ;
	private String hexcCnt        ;
	private String rcmdCnt        ;
	private String exprnCnt       ;
	private String hcExprnCnt       ;
	private String svcDate        ;
	private String hccCnt         ;
	//세라케어 만족도
	private String crkPoint       ;
	//배송만족도
	private String deliverPoint        ;
	//상담만족도
	private String callPoint        ;
	//직영점 만족도
	private String gicPoint        ;
	//AS만족도
	private String asPoint         ;
	
	//일시(고객여정)
	private String dt;
	//고객여정1
	private String col1;
	//고객여정2
	private String col2;
}
