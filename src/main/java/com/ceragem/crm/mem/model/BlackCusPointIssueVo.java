package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    BlackCusPointIssueVo
 * @author    황재희
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    부정적립 포인트 관리 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class BlackCusPointIssueVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 포인트이력일련번호 
    */
    private String pointHstSeq;
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
    /**
    * 발생포인트점수 
    */
    private Integer occurPointScore;
    /**
    * 잔여포인트점수 
    */
    private Integer remainPointScore;
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
    * 이름 
    */
    private String custNm;
    /**
    * 생년월일 
    */
    private String birthday;
    /**
    * 성별 
    */
    private String gndrCd;
    /**
    * 휴대전화번호 
    */
    private String mphonNo;
    /**
    * 이메일 
    */
    private String emailAddr;
    /**
    * 전화번호 
    */
    private String corpTelNo;
    /**
    * 외국인 
    */
    private String fornYn;
    /**
    * 고객상태 
    */
    private String custStatusCd;
    /**
    * 고객유형 
    */
    private String custTypeCd;
    /**
    * 상태변경 
    */
    private String bllkRegDt;
    /**
    * 매장명
    */
    private String storNm;
    
    /**
    * 유효기간
    */
    private String validPerd;
    /**
    * 구분
    */
    private String useTypeNm;
    
}
