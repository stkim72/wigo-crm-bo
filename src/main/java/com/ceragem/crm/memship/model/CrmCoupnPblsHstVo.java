package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCoupnPblsHstVo
 * @author user
 * @date 2022. 5. 9.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCoupnPblsHstVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 쿠폰발행이력일련번호
	 */
	private String coupnPblsHstSeq;
	/**
	 * 매장번호
	 */
	private String storNo;
	/**
	 * 매장명
	 */
	private String storNm;
	/**
	 * 사용매장
	 */
	private String useStorNo;
	/**
	 * 사용매장 명
	 */
	private String useStorNm;
	/**
	 * 캠페인번호
	 */
	private String campNo;
	/**
	 * 프로모션번호
	 */
	private String promNo;
	/**
	 * 통합고객번호
	 */
	private String itgCustNo;
	/**
	 * 멤버십쿠폰기본번호
	 */
	private String mshipCoupnBasNo;
	/**
	 * 쿠폰종류코드
	 */
	private String coupnKndCd;
	/**
	 * 쿠폰대상코드
	 */
	private String coupnTgtCd;
	/**
	 * 쿠폰적용구분코드1
	 */
	private String coupnApplyDivCd1;
	/**
	 * 쿠폰적용구분코드2
	 */
	private String coupnApplyDivCd2;
	/**
	 * FROM발행기준일
	 */
	private String fromPblsStdDay;
	/**
	 * TO발행기준일
	 */
	private String toPblsStdDay;
	/**
	 * 사용기준일조건코드
	 */
	private String useStdDayCondCd;
	/**
	 * FROM사용기준일
	 */
	private String fromUseStdDay;
	/**
	 * TO사용기준일
	 */
	private String toUseStdDay;
	/**
	 * 선물가능여부
	 */
	private String giftPossYn;
	/**
	 * 쿠폰발급방법코드
	 */
	private String coupnIssueMethCd;
	/**
	 * 발급제한수
	 */
	private Integer issueRstrtnCnt;
	/**
	 * 최대발급수
	 */
	private Integer maxIssueCnt;
	/**
	 * 최대사용수
	 */
	private Integer maxUseCnt;
	/**
	 * 적용금액
	 */
	private Integer applyAmt;
	/**
	 * 적용율
	 */
	private Integer applyRate;
	/**
	 * 최소구매금액
	 */
	private Integer minBuyAmt;
	/**
	 * 최대할인율
	 */
	private Integer maxDcAmt;

	/**
	 * 적용수
	 */
	private Integer applyCnt;
	/**
	 * 증정제품코드
	 */
	private String prsnttnGodsCd;
	/**
	 * 사용요일
	 */
	private String useDow;
	/**
	 * FROM사용시간
	 */
	private String fromUseHour;
	/**
	 * TO사용시간
	 */
	private String toUseHour;
	/**
	 * 사용채널코드
	 */
	private String useChlCd;
	/**
	 * 중복사용여부
	 */
	private String dupUseYn;
	/**
	 * 사용구분코드
	 */
	private String useDivCd;
	/**
	 * 사용여부
	 */
	private String useYn;
	/**
	 * 사용날짜
	 */
	private String useDt;
	/**
	 * 쿠폰기본명
	 */
	private String coupnBasNm;
	/**
	 * 쿠폰기본내용
	 */
	private String coupnBasCtnts;
	/**
	 * 정산방법코드
	 */
	private String admtMethCd;
	/**
	 * 정산금액
	 */
	private String admtAmt;
	/**
	 * 쿠폰유형
	 */
	private String coupnTypeCd;
	/**
	 * 쿠폰사용가능일
	 */
	private String coupnUsePossDay;
	/**
	 * 쿠폰사용가능여부
	 */
	private String coupnUsePossYn;
	/**
	 * 쿠폰사용가능일수
	 */
	private Integer coupnUsePossDayCnt;
	/**
	 * 쿠폰분류코드
	 */
	private String coupnClassCd;

	/**
	 * 요일1사용여부
	 */
	private String dow1UseYn;
	/**
	 * 요일2사용여부
	 */
	private String dow2UseYn;
	/**
	 * 요일3사용여부
	 */
	private String dow3UseYn;
	/**
	 * 요일4사용여부
	 */
	private String dow4UseYn;
	/**
	 * 요일5사용여부
	 */
	private String dow5UseYn;
	/**
	 * 요일6사용여부
	 */
	private String dow6UseYn;
	/**
	 * 요일7사용여부
	 */
	private String dow7UseYn;
	/**
	 * 회원등급코드
	 */
	private String mshpGradeCd;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	private String regChlCd;

	private String mphonNo; // 전화번호

	private String custNm; // 고객명

	private String coupnTypeCdNm; // 쿠폰리스트명

	private String coupnPblsBasNo; // 쿠폰발급번호
}
