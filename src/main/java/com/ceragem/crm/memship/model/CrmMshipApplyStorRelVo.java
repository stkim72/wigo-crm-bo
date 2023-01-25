package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipApplyStorRelVo
 * @author user
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM멤버십적용매장관계 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyStorRelVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 적용혜택코드
	 */
	private String applyBnfitCd;
	/**
	 * 정책기본번호
	 */
	private String mshipPlcyBasNo;
	/**
	 * 카드기본번호
	 */
	private String mshipCardBasNo;
	/**
	 * 쿠폰기본번호
	 */
	private String mshipCoupnBasNo;
	/**
	 * 프로모션기본번호
	 */
	private String mshipPromBasNo;
	/**
	 * 스탬프기본번호
	 */
	private String mshipStmpBasNo;
	/**
	 * 적용구분코드
	 */
	private String applyDivCd;
	/**
	 * 매장번호
	 */
	private String storNo;
	/**
	 * 채널코드
	 */
	private String regChlCd;

	/**
	 * 매장명
	 */
	private String storNm;

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
	 * 지역번호
	 */
	private String distrctNo;

	/**
	 * 지역코드
	 */
	private String distrctCd;

	/**
	 * 지역명
	 */
	private String distrctCdNm;

	/**
	 * 매장 고유 번호
	 */
	private String storRelBasNo;

}
