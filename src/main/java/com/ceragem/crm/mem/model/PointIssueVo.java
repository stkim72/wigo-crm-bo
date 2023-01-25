package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName	PointIssueVo
 * @author      황재희
 * @date        2022. 4. 18.
 * @Version     1.0
 * @description 포인트 발행 목록 Vo
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class PointIssueVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	 * 포인트이력일련번호 
	 */
	private String pointHstSeq;
    /**
    *  통합고객번호 
    */
    private String itgCustNo;
    /**
     * 멤버십등급코드 
     */
    private String mshipGradeCd;
    /**
     * 멤버십등급명
     */
    private String mshipGradeNm;
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
    private String ordrAmt;
    /**
     * 적용금액 
     */
    private String applyAmt;
    /**
     * 결제금액 
     */
    private String payAmt;
    /**
     * 발행구분코드 
     */
    private String pblsDivCd;
    /**
     * 발생포인트점수 
     */
    private String occurPointScore;
    /**
     * 유효기간
     */
    private String validPerd;
    /**
     * 유효기간시작년월일
     */
    private String validPerdStaYmd;
    /**
     * 유효기간종료년월일
     */
    private String validPerdEndYmd;
    /**
     * 발생일시 
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
     * 발생채널코드 
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
     * 사용유형코드 
     */
    private String useTypeNm;
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
    *  등록채널코드 
    */
    private String regChlCd;
    /**
     * 고객명
     */
    private String custNm;
    /**
     * 고객전화번호
     */
    private String mphonNo;
    /**
     * 매장명
     */
    private String storNm;
    /**
     * 잔여포인트
     */
    private String remainPointScore;
    /**
     * 잔여 승급점수
     */
    private String mshipAdvnCmtScore;
    /**
     * 발생 승급점수
     */
    private String occurAdvncmtScore;
    /**
     * 발생 승급점수
     */
    private String regrId;
    
    /**
     * 유효기간
     */
    private Integer applyPointValidPerd;


}