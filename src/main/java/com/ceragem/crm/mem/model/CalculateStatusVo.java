package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CalculateStatusVo
 * @author    안재홍
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    정산현황 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CalculateStatusVo extends BaseVo {
    /**
    *
    */
	private static final long serialVersionUID = 1L; 

//============================================= 정산현황 
	/**
	 * 사용및적립일시 
	 */
	 private Object rcmdStorNo;
	
	/**
	 * 사용및적립일시 
	 */
	 private String mdt;

	/**
	 * 매장번호 
	 */
	 private String storNo;	 
	/**
	 * 매장명
	 */
	 private String storNm; 	 
	/**
	 * 포인트사용현황 
	 */
	 private String usePointScore;
	/**
	 * 포인트적립현황 
	 */
	 private String accumulatePointScore;
	/**
	 * 사용쿠폰현황 
	 */
	 private String useCoupnCnt;	 
	/**
	 * 미사용쿠폰현황 
	 */
	 private String accumulateCoupnCnt;		 
//=============================================	 
	/**
	 * 사용및적립일시 
	 */
	 private String dt;
	/**
	 * 통합고객번호 
	 */
	 private String itgCustNo;
	/**
	 * 발행구분 
	 */
	 private String pblsDivNm;
	/**
	 * 발행구분코드 
	 */
	 private String pblsDivCd;
	 /**
	 * 사용유형 
	 */
	 private String useTypeNm;
	 /**
	 * 사용유형코드 
	 */
	 private String useTypeCd;
	/**
	 * 내역 
	 */
	 private String txn;
	/**
	  * 잔여포인트점수 
	  */
	  private Integer remainPointScore;
	/**
	 * 소멸일시 
	 */
	 private String extncDt; 


	/**
	 * 발행채널 
	 */
	 private String chlNm;
	/**
	 * 발행채널코드 
	 */
	 private String chlCd;
	/**
	 * 매장채널코드
	 */
	 private String storChlCd;
		
	/* hidden */
	 
	/**
	 * 포인트이력일련번호 
	 */
	 private String pointHstSeq;
	 /**
	 * 멤버십등급코드 
	 */
	 private String mshipGradeCd;
	 /**
	 * 전표번호 
	 */
	 private String chitNo;
	 /**
	 * 구매제품번호 
	 */
	 private String buyGodsNo;
	 /**
	 * 주문금액 
	 */
	 private Integer ordrAmt;
	 /**
	 * 적용금액 
	 */
	 private Integer applyAmt;
	 /**
	 * 결제금액 
	 */
	 private Integer payAmt;
	 /**
	 * 발행일시 
	 */
	 private String pblsDt;
	 /**
	  * 유효기간 
	  */
	 private String validPerd; 
	 /**
	 * 카드발행이력일련번호 
	 */
	 private String cardPblsHstSeq;
	 /**
	 * 거래번호 
	 */
	 private String dealNo;
	 /**
	 * 프로모션번호 
	 */
	 private String promNo;
	 /**
	 * 캠페인번호 
	 */
	 private String campNo;
	 /**
	 * 쿠폰번호 
	 */
	 private String coupnNo;
	 /**
	 * 사용일시 
	 */
	 private String useDt;
	 /**
	 * 등록채널코드 
	 * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	 private String regChlCd;
}

