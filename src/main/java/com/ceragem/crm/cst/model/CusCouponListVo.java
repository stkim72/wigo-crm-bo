package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CusCouponListVo
 * @author 황의겸
 * @date 2022. 4. 13.
 * @Version 1.0
 * @description CRM쿠폰이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusCouponListVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	
    /**
     * 쿠폰발행기본번호
     */
    private String coupnPblsBasNo;	
	/**
	 * 사용일시
	 */
	private String useDt;
	/**
	 * 등록일시
	 */
	private String regDt;
	/**
	 * 사용일시/등록일시
	 */
	private String dt;
	/**
	 * 통합고객번호
	 */
	private String itgCustNo;
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
	 * 쿠폰기본명
	 */
	private String coupnBasNm;
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
     * 사용매장번호
     */
    private String useStorNo;
	/**
	 * 매장명
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
	 * 사용상태
	 */
	private String useYn;
	/**
	 * 유효기간 시작
	 */
	private String condFromDt;
	/**
	 * 유효기간 완료
	 */
	private String condToDt;
	/**
	 *  쿠폰 발급자
	 */
	private String regrId;

}
