package com.ceragem.crm.memship.model;

import java.util.List;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipCoupnBasVo
 * @author Lee Kwang
 * @date 2022. 5. 19.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipStmpBasVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 스탬프발행기본번호
	 */
	private String mshipStmpBasNo;
	/**
	 * 스탬프기본명
	 */
	private String stmpBasNm;
	/**
	 * 스탬프 유형코드
	 */
	private String stmpTypeCd;
	/**
	 * 스탬프 유형코드 명
	 */
	private String stmpTypeCdNm;
	/**
	 * 스탬프 이벤트코드
	 */
	private String stmpEventCd;
	/**
	 * FROM스탬프 발행기간
	 */
	private String fromUsePossDt;
	/**
	 * TO스탬프 발행기간
	 */
	private String toUsePossDt;
	/**
	 * 유효기간 여부
	 */
	private String validYn;
	/**
	 * 유효기간
	 */
	private String validPerd;
	/**
	 * 스탬프최대여부
	 */
	private String stmpMaxYn;
	/**
	 * 스탬프 최대수
	 */
	private Integer stmpMaxCnt;
	/**
	 * 스탬프 수량
	 */
	private Integer stmpQnty;
	/**
	 * 사용여부
	 */
	private String useYn;
	/**
	 * 멤버십등급코드
	 */
	private String mshipGradeCd;
	/**
	 * 회원등급코드
	 */
	private String mshpGradeCd;
	/**
	 * 제휴회사번호
	 */
	private String cprtCmpNo;
	/**
	 * 조건금액 여부
	 */
	private String condYn;
	/**
	 * 조건금액
	 */
	private Integer condAmt;
	/**
	 * 적립수량
	 */
	private Integer condCnt;
	/**
	 * 쿠폰할인 시 적립여부
	 */
	private String coupnAccumDcYn;
	/**
	 * 적립수 X 1회 최대적립
	 */
	private Integer accumCnt;
	/**
	 * 주문금액여부 X 주문금액 여부
	 */
	private String ordrYn;
	/**
	 * 주문금액 제한 X 주문금액
	 */
	private Integer ordrAmt;
	/**
	 * 적립채널내역
	 */
	private String accumChlTxn;
	/**
	 * 혜택코드
	 */
	private String bnfitCd;
	/**
	 * 포인트점수
	 */
	private Integer pointScore;
	/**
	 * 쿠폰번호
	 */
	private String coupnNo;
	/**
	 * 쿠폰이름
	 */
	private String coupnNm;
	/**
	 * 수정자ID
	 */
	private String amdrId;
	/**
	 * 등록자ID
	 */
	private String regrId;
	/**
	 * 채널코드
	 */
	private String regChlCd;
	/**
	 * 채널코드배열
	 */
	private Object accumChl;
	/**
	 * 혜택
	 */
	private String accumType;
	/**
	 * 완판수량
	 */
	private String stmpAccumCnt;
	/**
	 * 현재수량
	 */
	private String stmpAccumQnty;
	/**
	 * 적용회원등급내용
	 */
	private Object applyMshpGradeCtnts;
	/**
	 * 회원유형
	 */
	private Object mshipTypeCds;
	/**
	 * 등록자이름
	 */
	private String regrNm;

	public String getApplyMshpGradeCtnts() {
		return Utilities.convArryToStrs(this.applyMshpGradeCtnts, ",");
	}

	public List<String> getApplyMshpGradeCtntss() {
		return Utilities.convStrsToArry(this.applyMshpGradeCtnts, ",");
	}

	public String getAccumChl() {
		return Utilities.convArryToStrs(this.accumChl, ",");
	}

	public List<String> getAccumChls() {
		return Utilities.convStrsToArry(this.accumChl, ",");
	}

	public String getMshipTypeCds() {
		return Utilities.convArryToStrs(this.mshipTypeCds, ",");
	}

	public List<String> getMshipTypeCdss() {
		return Utilities.convStrsToArry(this.mshipTypeCds, ",");
	}

}
