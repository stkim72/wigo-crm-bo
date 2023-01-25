package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipCardBasVo
 * @author user
 * @date 2022. 4. 28.
 * @Version 1.0
 * @description CRM멤버십카드기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipCardBasVo extends BaseVo {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 멤버십카드기본번호
	 */
	private String mshipCardBasNo;
	/**
	 * 카드유형코드
	 */
	private String cardTypeCd;
	/**
	 * 멤버십등급적용내용
	 */
	private String mshipGradeApplyCtnts;
	/**
	 * 카드사용기간
	 */
	private String cardUsePerd;
	/**
	 * 카드유효기간
	 */
	private String cardValidPerd;
	/**
	 * 발급수
	 */
	private Integer issueCnt;
	/**
	 * 실제 카드 발급수
	 */
	private String realIssueCnt;
	
	/**
	 * 포인트적립율
	 */
	private Integer pointAccumRate;
	/**
	 * 가입포인트점수
	 */
	private Integer sbscPointScore;
	/**
	 * 가입포인트적용기준코드
	 */
	private String sbscPointApplyStdCd;
	/**
	 * 승급포인트점수
	 */
	private Integer advncmtPointScore;
	/**
	 * 승급포인트적용기준코드
	 */
	private String advncmtPointApplyStdCd;
	/**
	 * 음료할인율
	 */
	private Integer drnkDcRate;
	/**
	 * 일음료제공수
	 */
	private Integer dayDrnkPrvCnt;
	/**
	 * 음료제공수
	 */
	private Integer drnkPrvCnt;
	/**
	 * 자사몰무료배송여부
	 */
	private String mycomMallFreeDlvYn;
	/**
	 * 음료무료적용스탬프수
	 */
	private Integer drnkFreeApplyStmpCnt;
	/**
	 * 무료서비스연장개월수
	 */
	private Integer freeSvcExtnsnMonsCnt;
	/**
	 * 세라케어쿠폰제공개월수
	 */
	private Integer ceracCoupnPrvMonsCnt;
	/**
	 * 세라체크쿠폰제공개월수
	 */
	private Integer crckCoupnPrvMonsCnt;
	/**
	 * 제품제한여부
	 */
	private String godsRstrtnYn;
	/**
	 * 상태코드
	 */
	private String statusCd;
	/**
	 * 카드기본명
	 */
	private String cardBasNm;
	/**
	 * 카드기본내용
	 */
	private String cardBasCtnts;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	private String regChlCd;
	/**
	 * 사용기간코드
	 */
	private String usePerdCd;
	/**
	 * 유효기간코드
	 */
	private String validPerdCd;
	/**
	 * 발급수코드
	 */
	private String issueCntCd;
	
	

	/*
	 * 카드 유형 명
	 */
	private String cardTypeCdNm;
	/*
	 * 카드 유형 명
	 */
	private String statusCdNm;

	/*
	 * 등록 시작일
	 */
	private String strRegDt;

	/*
	 * 등록 종료일
	 */
	private String endRegDt;

	private String cardBasNo;

	private String custNm;

	private String mshpGradeCd;

	private String cprtCmpNo;

}
