package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmResponseVo {
	/**
	 * <p>
	 * 매장번호
	 * </p>
	 */
	private String storNoGraph;
	/**
	 * <p>
	 * 고객명
	 * </p>
	 */
	private String custNmGraph;
	/**
	 * <p>
	 * 기준연도
	 * </p>
	 */
	private String stndDateYGraph;
	/**
	 * <p>
	 * 기준연월
	 * </p>
	 */
	private String stndDateMGraph;
	/**
	 * <p>
	 * 매장명
	 * </p>
	 */
	private String storNmGraph;
	/**
	 * <p>
	 * 기준일
	 * </p>
	 */
	private String stndDt;
	/**
	 * <p>
	 * 쿠폰타입
	 * </p>
	 */
	private String coupnTypeCdGraph;
	/**
	 * <p>
	 * 시작날짜
	 * </p>
	 */
	private String strtDt;
	/**
	 * <p>
	 * 종료날짜
	 * </p>
	 */
	private String endDt;
	/**
	 * <p>
	 * 고객가입채널
	 * </p>
	 */
	private String regChlCd;

}
