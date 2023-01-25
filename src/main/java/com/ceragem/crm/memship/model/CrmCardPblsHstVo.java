package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCardPblsHstVo
 * @author user
 * @date 2022. 5. 4.
 * @Version 1.0
 * @description CRM카드발행이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCardPblsHstVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 카드발행이력일련번호
	 */
	private String cardPblsHstSeq;

	/**
	 * 카드발행번호
	 */
	private String mshipCardBasNo;

	/**
	 * 통합고객번호
	 */
	private String itgCustNo;
	/**
	 * 카드기본번호
	 */
	private String cardBasNo;
	private String cardBasNm;

	/**
	 * 카드유형코드
	 */
	private String cardTypeCd;
	private String cardTypeCdNm;
	/**
	 * 카드구분코드
	 */
	private String cardDivCd;
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
	private String mshipGradeCdNm;
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
	private String statusCdNm;
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
	private String useYnNm;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	private String regChlCd;

	private String custNm;

	private String mshipLoginId;

	private String emailAddr;

	private String mponNo;

	private long cnt;
	
	private long remainPointScore;

	public String getCardBasNo() {
		return cardBasNo;
	}

	public void setCardBasNo(String cardBasNo) {
		this.cardBasNo = cardBasNo;
	}
	
	
	public String getToUsePossDt() {
		return toUsePossDt;
	}

	public void setToUsePossDt(String toUsePossDt) {
		this.toUsePossDt = toUsePossDt;
	}

}
