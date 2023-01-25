package com.ceragem.crm.memship.model;

import java.util.List;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipCoupnBasVo
 * @author user
 * @date 2022. 4. 19.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipCoupnBasVo extends BaseVo {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
	private String applyAmt;

	/**
	 * 적용율
	 */
	private String applyRate;
	/**
	 * 적용율
	 */
	private String applyPoint;
	/**
	 * 최소구매금액
	 */
	private String minBuyAmt;
	/**
	 * 최대할인율
	 */
	private String maxDcAmt;
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
	private String fromUseHour1;
	private String fromUseHour2;
	/**
	 * TO사용시간
	 */
	private String toUseHour;
	private String toUseHour1;
	private String toUseHour2;
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
	 * 쿠폰기본명
	 */
	private String coupnBasNm;
	/**
	 * 쿠폰기본내용
	 */
	private String coupnBasCtnts;
	/**
	 * 등록채널코드
	 */
	private String regChlCd;
	/**
	 * 정산방법코드
	 */
	private String admtMethCd;
	/**
	 * 정산금액
	 */
	private String admtAmt;
	/**
	 * 쿠폰리스트
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
	 * 쿠폰종류코드명
	 */
	private String coupnKndCdNm;

	/**
	 * 쿠폰대상코드명
	 */
	private String coupnTgtCdNm;

	/**
	 * 중복가능여부명
	 */
	private String dupUseYnNm;

	/**
	 * 사용가능 여부명
	 */
	private String useDivCdNm;

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
	 * 멤버십등급코드
	 */
	private String mshipGradeCd;

	/**
	 * 쿠폰분류코드명
	 */
	private String coupnApplyDivCd1Nm;

	/**
	 * 적용기준
	 */
	private String admtMethCdNm;

	/**
	 * 사용여부명
	 */
	private String useYnNm;

	/**
	 * 증정상품명
	 */
	private String godsNm;

	/**
	 * 쿠폰리스트명
	 */
	private String coupnTypeCdNm;

	/**
	 * 개별회원 코드
	 */
	private String custNo;

	/**
	 * 그룹회원 코드
	 */
	private String custGrpNo;

	/**
	 * 개별회원 코드
	 */
	// private List<String> custNoList;
	private String[] custNoList;

	/**
	 * 그룹회원 코드
	 */
	// private List<String> custGrpNoList;
	private String[] custGrpNoList;

	/**
	 * 매장 쿠폰 발행 매수
	 */
	private int pubCoupnCnt;

	/**
	 * 매점 코드
	 */
	private String storeNo;

	/**
	 * 제휴사 코드
	 */
	private String cprtCmpNo;
	private String cprtCmpNoNm;

	/**
	 * 매점 코드
	 */
//	private List<String> storeList;
	private String[] storeList;

	private String coupnClassCdNm;

	/**
	 * 적용회원등급내용
	 */
	private Object applyMshpGradeCtnts;
	/**
	 * 임직원
	 */
	private String mshipTypeCds;
	/**
	 * 멤버십쿠폰기본번호
	 */
	private String newMshipCoupnBasNo;
	/**
	 * 쿠폰비고
	 */
	private String coupnRmark;
	private String regrNm;

	public String getApplyMshpGradeCtnts() {
		return Utilities.convArryToStrs(this.applyMshpGradeCtnts, ",");
	}

	public List<String> getApplyMshpGradeCtntss() {
		return Utilities.convStrsToArry(this.applyMshpGradeCtnts, ",");
	}
	/**
	 * 등록자이름
	 */
    private String userNm;
//	private Object storeList;
//
//	public List<String> getStoreList() {
//		return Utilities.convStrsToArry(this.storeNo, ",");
//	}
}
