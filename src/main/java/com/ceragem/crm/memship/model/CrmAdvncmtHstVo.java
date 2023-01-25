package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmAdvncmtHstVo
 * @author    user
 * @date    2022. 5. 30.
 * @Version    1.0
 * @description    CRM승급이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmAdvncmtHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 승급이력일련번호 
    */
    private String advncmtHstSeq;
   
    
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 멤버십등급코드 
    */
    private String mshipGradeCd;
    /**
    * 매장번호 
    */
    private String storNo;
    private String storNoNm;
    private String custNm;
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
    * 발행구분코드 
    */
    private String pblsDivCd;
    private String pblsDivCdNm;
    /**
    * 발생승급점수 
    */
    private Integer occurAdvncmtScore;
    /**
    * 잔여포인트점수 
    */
    private Integer remainAdvncmtScore;
    /**
    * 유효기간시작년월일 
    */
    private String validPerdStaYmd;
    /**
    * 유효기간종료년월일 
    */
    private String validPerdEndYmd;
    /**
    * 발행일시 
    */
    private String pblsDt;
    /**
    * 소멸일시 
    */
    private String extncDt;
    /**
    * 내역 
    */
    private String txn;
    /**
    * 발행채널코드 
    */
    private String pblsChlCd;
    /**
    * 카드발행이력일련번호 
    */
    private String cardPblsHstSeq;
    /**
    * 사용유형코드 
    */
    private String useTypeCd;
    private String useTypeCdNm;
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
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
    /**
    * 적립여부 
    */
    private String accumYn;

    private String pblsStaDt;
    private String pblsEndDt;
    
	private long cnt;
	
	private Integer totalAdvnCmt;
}
