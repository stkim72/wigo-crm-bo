package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusCardListVo
 * @author    황의겸
 * @date    2022. 4. 21.
 * @Version    1.0
 * @description    CRM카드발행이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusCardListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	 * 카드발행이력일련번호 
	 */
	 private String cardPblsHstSeq;
	 /**
	 * 통합고객번호 
	 */
	 private String itgCustNo;
	 /**
	 * 카드기본번호 
	 */
	 private String cardBasNo;
	 /**
	 * 카드유형코드 
	 */
	 private String cardTypeCd;
	 /**
	 * 카드유형코드 
	 */
	 private String cardTypeNm;
	 /**
	 * 카드구분코드 
	 */
	 private String cardDivCd;
	 /**
	 * 카드구분명 
	 */
	 private String cardDivNm;
	 /**
	 * 회원명 
	 */
	 private String mshpNm;
	 /**
	 * 이동전화번호 
	 */
	 private String mphonNo;
	 /**
	 * 멤버십등급코드 
	 */
	 private String mshipGradeCd;
	 /**
	 * FROM사용가능일시 
	 */
	 private String fromUsePossDt;
	 /**
	 * TO사용가능일시 
	 */
	 private String toUsePossDt;
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
	 * 인증번호 
	 */
	 private String certfNo;
	 /**
	 * 인증일시 
	 */
	 private String certfDt;
	 /**
	 * 사용여부 
	 */
	 private String useYn;
	 /**
	 * 등록채널
	 */
	 private String regChlNm;
	 /**
	 * 등록채널코드 
	 * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]
	 */
	 private String regChlCd;	 
}
