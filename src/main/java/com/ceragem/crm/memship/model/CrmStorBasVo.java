package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmStorBasVo
 * @author user
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM매장기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmStorBasVo extends BaseVo {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 매장번호
	 */
	private String storNo;
	/**
	 * 매장명
	 */
	private String storNm;
	/**
	 * 등록채널코드
	 */
	private String regChlCd;
	/**
	 * 전화번호
	 */
	private String telNo;
	/**
	 * FROM사용시간
	 */
	private String fromUseHour;
	/**
	 * TO사용시간
	 */
	private String toUseHour;
	/**
	 * 우편번호
	 */
	private String zipCd;
	/**
	 * 주소1내용
	 */
	private String addr1Ctnts;
	/**
	 * 주소2내용
	 */
	private String addr2Ctnts;
	/**
	 * 메모
	 */
	private String memo;
	/**
	 * 위도
	 */
	private String lati;
	/**
	 * 경도
	 */
	private String longi;
	/**
	 * 브랜드코드
	 */
	private String brandCd;
	/**
	 * 채널코드
	 */
	private String chlCd;
	/**
	 * 운영코드
	 */
	private String operCd;
	/**
	 * 매장인증번호
	 */
	private String certfNo;
	/**
	 * POS매장번호
	 */
	private String posStorNo;
	/**
	 * 상태코드
	 */
	private String statusCd;

	/**
	 * 지역코드
	 */
	private String distrctCd;

	/**
	 * 지역명
	 */
	private String distrctCdNm;

	/**
	 * 지역명
	 */
	private String comnCdNm;

	/**
	 * 쿠폰 고유번호
	 */
	private String mshipCoupnBasNo;

	/**
	 * 카드 고유번호
	 */
	private String mshipCardBasNo;

	/**
	 * 프로모션 고유번호
	 */
	private String mshipPromBasNo;

	/**
	 * 정책 고유번호
	 */
	private String mshipPlcyBasNo;

	/**
	 * 매장명
	 */
	private String storNm2;

	/**
	 * 지역코드
	 */
	private String distrctCd2;

	/* 매장 고유번호 */
	private String storRelBasNo;

}
