package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CouponUseVo
 * @author    황의겸
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    쿠폰사용현황 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CouponUseVo extends BaseVo {
    /**
    *
    */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 사용일시
	 */
	private String useDt;
    /**
    * 사용및적립일시 
    */
    private String calDt;	
	/**
	* 등록일시
	*/
	private String regDt;
	/**
	* 사용일시/등록일시
	*/
	private String dt;
	/**
    * 사용및적립일시(월) 
    */
    private String searchMonth;
	/**
	* 통합고객번호
	*/
	private String itgCustNo;
    /**
    * 통합고객명
    */
    private String custNm;	
	/**
	* 사용구분코드
	*/
	private String useDivCd;
	/**
	* 사용구분명
	*/
	private String useDivNm;	
	/**
	* 쿠폰유형코드 
	*/
	private String coupnTypeCd;
	/**
	* 쿠폰유형명 
	*/
	private String coupnTypeNm;
	/**
	* 쿠폰종류코드 
	*/
	private String coupnKndCd;
	/**
	* 쿠폰종류명 
	*/
	private String coupnKndNm;
	/**
	* 적용금액 
	*/
	private String applyAmt;	
	/**
    * 가맹점부담포인트점수 
	*/
	private Integer storPointScore;
	/**
	* 쿠폰기본명
	*/
	private String coupnBasNm;
	/**
	* 멤버십쿠폰기본번호
	*/
	private String mshipCoupnBasNo;
	/**
	* 쿠폰발행기본번호
	*/
	private String coupnPblsBasNo;
	/**
	 * 쿠폰기본내용(구매제품코드)
	 */
	private String buyGodsCd;
	/**
	 * 발행사유내용
	 */
	private String pblsWhyCtnts;	
	/**
	* 매장번호
	*/
	private String storNo;
	/**
    * 매장구분코드
	*/
	private String storDivCd; 
	/**
	*  매장명
	*/
	private String storNm;
	/**
	* 등록채널코드
	*/
	private String regChlCd;
	/**
	* 등록채널코드
	*/
	private String regChlNm;
	/**
	* 매장채널코드
	*/
	private String storChlCd;
    /**
    * 전표번호 
    */
    private String chitNo;
    /**
    * 할인금액
    */
    private String saleAmt; 
    /**
    * 결제금액
    */
    private Integer payAmt;    
    
}
