package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CalculateStatusSAPDayVo
 * @author    안재홍
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    일별사용SAP(설치일기준) Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CalculateStatusSAPDayVo extends BaseVo {
    /**
    *
    */
	private static final long serialVersionUID = 1L; 

//============================================= SAP전달데이터(사용) 
	/**
	 * 사용일시 : 거래일시 
	 */
	 private String useYmd;

	/**
	 * 설치완료일 
	 */
	 private String istDcsDe;	 
	
	/**
	 * 매장번호 : 거래처코드 
	 */
	 private String storNo;

	/**
	 * 매장명 : 거래처명 
	 */
	 private String storNm;

	/**
	 * 계약번호
	 */
	 private String dealNo;
	 
	/**
	 * 통합고객번호 
	 */
	 private String itgCustNo;
	/**
	 * 할인구분
	 */
	 private String disGubun;

	/**
	 * 할인구분명
	 */
	 private String disGubunNm;	 
	 

	/**
	 * 사용포인트
	 */
	 private String disAmt;	 
 
	 
//=============================================	 

//=============================================	SAP전달데이터(가맹점 포인트 보전)
	/**
	 * 할인구분명
	 */
	 private String rate;		
	 
	/**
	 * 사용구분
	 */
	 private String useGubun;
	 
	/**
	 * 사용구분명
	 */
	 private String useGubunNm;		 
	/**
	 * 사용포인트/쿠폰사용부담금
	 */
	 private String disAmtRate;	 
	 
	 
	 /**
	 * 사용일시 
	 */
	 private String useDt;
	 /**
	 * 등록채널코드 
	 * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	 private String regChlCd;
	 
     /* new */
	 
	 /**
	 * 거래일시 
	 */
	 private String dt;	 
     /**
     * 설치완료일 
     */
     private String calDt;
     /**
     * 통합고객명 
     */
     private String custNm;   
     /**
     * 사용유형 
     */
     private String useTypeCd;
     /**
     * 발생포인트점수/할인구분 
     */
     private String pointScore;
     /**
     * 가맹점부담(발생포인트점수/할인구분) 
     */
     private String storPointScore;
     /**
     * 매장채널
     */
     private String storChlCd;
     /**
     * 매장구분 
     */
     private String storDivCd;
     /**
     * 전표번호 
     */
     private String chitNo;
     /**
     * 할인구분 
     */
     private String saleGb;
     /**
     * 할인구분명 
     */
     private String saleGbNm;
     //
      /**
      * 사용및적립일시(월) 
      */
      private String searchMonth;
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
       * 포인트이력일련번호 
       */
       private String pointHstSeq;
       /**
       * 멤버십등급코드 
       */
       private String mshipGradeCd;
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
       * 월별포인트합계 조회조건 연도
       */
       private String searchYear;
       /**
       * 월별포인트합계 기간
       */
       private String periodMonth;
       /**
       * 월별포인트합계 사용 포인트
       */
       private String usePoint;
       /**
       * 월별포인트합계 발생 포인트
       */
       private String pblsPoint;
       /**
       * 월별포인트합계 소멸 포인트
       */
       private String extncPoint;
       /**
       * 월별포인트합계 잔여 포인트
       */
       private String remainPoint;
       /**
       * 월별포인트합계 사용구분코드 사용
       */
       private String useCd;
       /**
       * 월별포인트합계 사용구분코드 발급
       */
       private String pblsCd;
       /**
       * 월별포인트합계 사용구분코드 소멸
       */
       private String extncCd;
       /**
       * 포인트구분
       */
       private String pointCd;
       /**
       * 포인트구분명
       */
       private String pointCdNm;
       /**
       * 제/상품구분
       */
       private String saveGb;
        
       /**
       * 통합고객번호 (SAP)
       */
       private String custNoWrms;
       /**
       * 거래일시 (SAP)
       */
       private String zrtDt;   
       /**
       * 설치완료일 (SAP)
       */
       private String suReqDt;
       /**
       * 전표번호 (SAP)
       */
       private String bstkd;       
       /**
       * 거래처코드 (SAP)
       */
       private String kunnr; 
       /**
       * 거래처명 (SAP)
       */
       private String kunnrNm; 
       /**
       * 고객 그룹 (SAP)
       */
       private String kdgrp;
       /**
       * 고객 그룹
       */
       private String kdgrpCd; 
       /**
       * 포인트 (SAP)
       */
       private String pntPay;
       /**
       * 청구 포인트 (SAP)
       */
       private String pntPay2;       
       /**
       * 포인트 (SAP)
       */
       private String pntPaySave;
       /**
       * 청구 포인트 (SAP)
       */
       private String pntPayUse;       
       /**
       * 포인트 구분명 (적립:01 , 소멸:02) (SAP)
       */
       private String pntGb;
       /**
       * 포인트 구분 (적립:01 , 소멸:02) (SAP)
       */
       private String pntGbNm;       
       /**
       * items (SAP)
       */
       private String items;
       
       /**
       * 년월코드
       */
       private String yyyymmCd;
       /**
       * 발생포인트점수
       */
       private String occurPointScore;
       /**
       * 사용포인트점수
       */
       private String usePointScore;
       /**
       * 소멸포인트점수
       */
       private String extncPointScore;
       /**
       * 잔액포인트점수
       */
       private String blcPointScore;               
}

