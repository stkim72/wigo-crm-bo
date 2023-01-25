package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipApplyGodsRelVo
 * @author user
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CRM멤버십적용제품관계 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyGodsRelVo extends BaseVo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 적용혜택코드
	 */
	private String applyBnfitCd;
	/**
	 * 적용구분코드
	 */
	private String applyDivCd;
	/**
	 * 멤버십카드기본번호
	 */
	private String mshipCardBasNo;
	/**
	 * 멤버십쿠폰기본번호
	 */
	private String mshipCoupnBasNo;
	/**
	 * 멤버십프로모션기본번호
	 */
	private String mshipPromBasNo;
	/**
	 * 멤버십정책기본번호
	 */
	private String mshipPlcyBasNo;
	/**
	 * 제품번호
	 */
	private String godsNo;
	/**
	 * 제품구분
	 */
	private String godsTypeCd;
	/**
	 * 할인율
	 */
	private Integer dcRate;
	/**
	 * 채널코드
	 */
	private String regChlCd;

	/**
	 * 제품관계기본번호
	 */
	private String godsRelBasNo;

	/**
	 * 상품명
	 */
	private String godsNm;

	/**
	 * 상품군명
	 */
	private String godsTypeCdNm;

	/**
	 * 지역코드
	 */
	private String distrctCd;

	/**
	 * 지역명
	 */
	private String distrctCdNm;

	/**
	 * 스탬프 번호
	 */
	private String mshipStmpBasNo;

	/**
	 * 상품분류 [앞3자리가 상품분류1, 6자리가 상품분류2, 10자리가 상품분류3]
	 */
	private String godsClassCd;

	/**
	 * 최소 주문금액
	 */
	private Integer minBuyAmt;

	/**
	 * 스탬프 수량
	 */
	private Integer itemAccumCnt;

	/**
	 * 스탬프 수량
	 */
	private String stat;

}
