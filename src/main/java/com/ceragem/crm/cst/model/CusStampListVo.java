package com.ceragem.crm.cst.model;

import java.util.List;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmStmpHstVo
 * @author    황의겸
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM스탬프이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusStampListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	* 스탬프이력일련번호 
	*/
	private String stmpHstSeq;
	/**
	* 사용일시or적립일시
	*/
	private String dt;
	/**
	* 멤버십스탬프기본번호 
	*/
	private String mshipStmpBasNo;
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
	* 매장명
	*/
	private String storNm;	
	/**
	* 적립일시 
	*/
	private String accumDt;
	/**
	* 사용일시 
	*/
	private String useDt;
	/**
	* 스탬프기본명 
	*/
	private String stmpBasNm;
	/**
	* FROM사용가능일시 
	*/
	private String fromUsePossDt;
	/**
	* TO사용가능일시 
	*/
	private String toUsePossDt;
	/**
	* 구매제품번호 
	*/
	private String buyGodsNo;
	/**
	* 스탬프적립수량 
	*/
	private Integer stmpAccumQnty;
	/**
	* 발급횟수 
	*/
	private Integer issueCnt;
	/**
	* 주문수량 
	*/
	private Integer ordrQnty;
	/**
	* 주문금액 
	*/
	private Integer ordrAmt;
	/**
	* 결제금액 
	*/
	private Integer payAmt;
	/**
	* 결제채널코드 
	*/
	private String payChlCd;
	/**
	* 발행스탬프번호 
	*/
	private String pblsStmpNo;
	/**
	* 상태코드 
	*/
	private String statusCd;
	/**
	* 쿠폰번호 
	*/
	private String coupnNo;
	/**
	* 포인트점수 
	*/
	private Integer pointScore;
	/**
	* 전표번호 
	*/
	private String chitNo;
	/**
	* 정산방법코드 
	*/
	private String admtMethCd;
	/**
	* 사용유형코드 
	*/
	private String useTypeCd;
	/**
	* 등록채널코드 
	* 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	*/
	private String regChlCd;
	/**
	* 매장채널코드
	*/
	private String storChlCd;
    /**
     * 스탬프 유형코드
     */
    private String stmpTypeCd;
    /**
     * 스탬프 이벤트코드
     */
    private String stmpEventCd;
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
     * 적립채널내역
     */
    private String accumChlTxn;
    /**
     * 혜택코드
     */
    private String bnfitCd;
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
     * 적용회원등급내용
     */
    private Object applyMshpGradeCtnts;
    /**
     * 회원유형
     */
    private String mshipTypeCds;
    /**
     * 채널명
     */
    private String chlNm;
    /**
     * 발급상태
     */
    private String accumStatus;
    

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
}
