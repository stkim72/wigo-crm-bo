package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipApplyChlRelVo
 * @author user
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM멤버십적용채널관계 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyChlRelVo extends BaseVo {
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
	 * 쿠폰기본번호
	 */
	private String mshipCoupnBasNo;
	/**
	 * 카드기본번호
	 */
	private String mshipCardBasNo;
	/**
	 * 스탬프번호
	 */
	private String mshipStmpBasNo;
	/**
	 * 프로모션기본번호
	 */
	private String mshipPromBasNo;
	/**
	 * 적용구분코드
	 */
	private String applyDivCd;
	/**
	 * 채널코드
	 */
	private String applyChlCd;
	/**
	 * 채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	private String regChlCd;

	/**
	 * 채널코드명
	 */
	private String applyChlCdNm;

	/**
	 * 채널고유번호
	 */
	private String chlRelBasNo;
}
