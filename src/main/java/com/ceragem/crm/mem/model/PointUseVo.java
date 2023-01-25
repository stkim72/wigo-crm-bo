package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    PointUseVo
 * @author    황의겸
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    포인트사용현황 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class PointUseVo extends BaseVo {
    /**
    *
    */
	private static final long serialVersionUID = 1L;
	/**
	* 사용및적립일시 
	*/
	private String dt;
    /**
    * 사용및적립일시 
    */
    private String calDt;    
	/**
    * 사용및적립일시(월) 
    */
    private String searchMonth;
	
	/**
	* 통합고객번호 
	*/
	private String itgCustNo;
	/**
	* 통합고객명
	*/
	private String custNm;	 
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
	* 발생포인트점수 
	*/
	private Integer pointScore;
	/**
    * 가맹점부담포인트점수 
	*/
	private Integer storPointScore;
	/**
	* 잔여포인트점수 
	*/
	private Integer remainPointScore;
	/**
	* 소멸일시 
	*/
	private String extncDt;  
	/**
	* 매장번호 
	*/
	private String storNo; 
	/**
	* 매장명
	*/
	private String storNm;
	/**
    * 매장구분코드
	*/
	private String storDivCd; 
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
     * 제품/상품구분
     */
     private String itemPrCdNm;	    
	 
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
     /**
     * 소멸포인트
     */
     private int expirePoint;
     
}

