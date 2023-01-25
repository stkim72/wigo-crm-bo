package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusCampaignListVo
 * @author    황의겸
 * @date    2022. 4. 27.
 * @Version    1.0
 * @description    CRM프로모션이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusCampaignListVo extends BaseVo {
    /**
    *
    */
	private static final long serialVersionUID = 1L;
	/**
	* 프로모션시작년월일 
	*/
	private String promStaYmd;
	/**
	* 통합고객번호 
	*/
	private String itgCustNo;
	/**
	* 프로모션유형코드 
	*/
	private String promTypeCd;
	/**
	* 주문금액 
	*/
	private String ordAmt;
	/**
	* 제공쿠폰기본번호 
	*/
	private String prvCoupnBasNo;
	/**
	* 제공쿠폰기본명 
	*/
	private String couponNm;
	/**
	* 적용포인트점수 
	*/
	private String applyPointScore;
	/**
	* 프로모션코드 
	*/
	private String mshipPromBasNo;
	

}
