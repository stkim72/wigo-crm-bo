package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCusStatusAccVo {
	/**
	 * <p>
	 * 통합고객번호
	 * </p>
	 */
	private String itgCustNo;
	/**
	 * <p>
	 * 고객번호
	 * </p>
	 */
	private String custNm;
	/**
	 * <p>
	 * 휴면/정상 여부
	 * </p>
	 */
	private String custStatusCd;
	/**
	 * <p>
	 * 휴면/정상 여부
	 * </p>
	 */
	private String regDt;
	/**
	 * <p>
	 * 매장번호
	 * </p>
	 */
	private String storNo;
	/**
	 * <p>
	 * 매장명
	 * </p>
	 */
	private String storNm;
	/**
	 * <p>
	 * 매장상태코드
	 * </p>
	 */
	private String storStatusCd;
	/**
	 * <p>
	 * 멤버십등급코드
	 * </p>
	 */
	private String mshipGradeCd;
	/**
	 * <p>
	 * 성별코드
	 * </p>
	 */
	private String gndrCd;
	/**
	 * <p>
	 * 생년월일
	 * </p>
	 */
	private String birthdayDt;
	/**
	 * <p>
	 * 가입채널
	 * </p>
	 */
	private String regChlCd;
}
