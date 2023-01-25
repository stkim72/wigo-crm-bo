package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.util.Utilities;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * 
 * @ClassName    PromotionListVo
 * @author    황재희
 * @date    2022. 5. 27.
 * @Version    1.0
 * @description    CRM멤버십프로모션기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class PromotionListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 멤버십프로모션기본번호 
    */
    private String mshipPromBasNo;
    /**
    * 프로모션시작년월일 
    */
    private String promStaYmd;
    /**
    * 프로모션유형코드 
    */
    private String promTypeCd;
    /**
    * 프로모션종료년월일 
    */
    private String promEndYmd;
    /**
    * 프로모션기본내용 
    */
    private String promBasCtnts;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
    /**
    * 광고노출여부 
    */
    private String advmShowYn;
    /**
    * 사용채널정책코드 
    */
    private String useChlPlcyCd;
    /**
    * FROM적용매출금액 
    */
    private Integer fromApplySaleAmt;
    /**
    * TO적용매출금액 
    */
    private Integer toApplySaleAmt;
    /**
    * FROM적용매출조건코드 
    */
    private String fromApplySaleCondCd;
    /**
    * TO적용매출조건코드 
    */
    private String toApplySaleCondCd;
    /**
    * FROM적용결제금액 
    */
    private Integer fromApplyPayAmt;
    /**
    * TO적용결제금액 
    */
    private Integer toApplyPayAmt;
    /**
    * FROM적용결제조건코드 
    */
    private String fromApplyPayCondCd;
    /**
    * TO적용결제조건코드 
    */
    private String toApplyPayCondCd;
    /**
    * 적용멤버십등급코드 
    */
    private String applyMshipGradeCd;
    /**
    * 중복사용여부 
    */
    private String dupUseYn;
    /**
    * 적용혜택코드 
    */
    private String applyBnfitCd;
    /**
    * 쿠폰적용구분코드1 
    */
    private String coupnApplyDivCd1;
    /**
    * 쿠폰적용구분코드2 
    */
    private String coupnApplyDivCd2;
    /**
    * 적용할인율 
    */
    private Integer applyDcRate;
    /**
    * 적용할인금액 
    */
    private Integer applyDcAmt;
    /**
    * 포인트적립율 
    */
    private Integer pointAccumRate;
    /**
    * 스탬프제공수 
    */
    private Integer stmpPrvCnt;
    /**
    * 제공쿠폰기본번호 
    */
    private String prvCoupnBasNo;
    /**
    * 상태코드 
    */
    private String statusCd;
    /**
    * 상태코드 
    */
    private String statusNm;
    /**
    * 프로모션기본명 
    */
    private String promBasNm;
    /**
    * 적용회원등급내용 
    */
    private Object applyMshpGradeCtnts;
    /**
    * 적용멤버십등급코드1 
    */
    private String applyMshipGradeCd1;
    /**
    * 제휴회사번호 
    */
    private String cprtCmpNo;
    /**
    * 적용포인트점수 
    */
    private Integer applyPointScore;
    

    
    private String searchPromTypeCd;
    private String searchStatusCd;
    private String searchPromBasNm;
    private String searchPromStaYmd;
    private String searchPromEndYmd;
    
    /**
    * 계약번호 
    */
    private String cntrNo;
    /**
    * 주문번호 
    */
    private String ordNo;
    /**
    * 주문상태코드 
    */
    private String ordStsCd;
    /**
    * 주문상태명 
    */
    private String ordStsCdnm;
    /**
    * 품목명 
    */
    private String itemNm;
    /**
    * 판매유형코드 
    */
    private String saleTyCd;
    /**
    * 판매유형명 
    */
    private String saleTyCdnm;
    /**
    * 판매구분코드 
    */
    private String saleSeCd;
    /**
    * 판매구분명 
    */
    private String saleSeCdnm;
    /**
    * 판매그룹코드 
    */
    private String saleGrpCd;
    /**
    * 판매그룹명 
    */
    private String saleGrpCdnm;
    /**
    * 계약상태코드 
    */
    private String cntrStsCd;
    /**
    * 계약상태명 
    */
    private String cntrStsCdnm;
    /**
    * 계약상태상세코드 
    */
    private String cntrStsDtlCd;
    /**
    * 계약상태상세명 
    */
    private String cntrStsDtlCdnm;
    /**
    * 주문일자 
    */
    private String ordDe;
    /**
    * 주문취소일자 
    */
    private String ordCnclDe;
    /**
    * 계약취소여부 
    */
    private String cntrCnclYn;
    /**
    * 계약취소일자 
    */
    private String cntrCnclDe;
    /**
    * 계약취소사유 
    */
    private String cntrCnclRsn;
    /**
    * 본부구분코드 
    */
    private String hqSeCd;
    /**
    * 판매조직 
    */
    private String saleOrgz;
    /**
    * 판매인 
    */
    private String seller;
    /**
    * 판매인명 
    */
    private String sellernm;
    /**
    * 설치일자 
    */
    private String istDe;
    /**
    * 설치확정일자 
    */
    private String istDcsDe;
    /**
    * 계약시작일자 
    */
    private String cntrStartDe;
    /**
    * 계약종료예정일자 
    */
    private String cntrEndDueDe;
    /**
    * 계약종료여부 
    */
    private String cntrEndYn;
    /**
    * 계약종료일자 
    */
    private String cntrEndDe;
    /**
    * 매출확정여부 
    */
    private String selngDcsYn;
    /**
    * 매출확정일자 
    */
    private String selngDcsDe;
    /**
    * 판매금액 
    */
    private Double salesAmt;
    /**
    * 결제금액 
    */
    private Double setlAmt;
    /**
    * 판매채널코드 
    */
    private String saleChnCd;
    /**
    * 판매채널명 
    */
    private String saleChnCdnm;
    /**
    * 반품유형코드 
    */
    private String rtgdTyCd;
    /**
    * 반품접수확정여부 
    */
    private String rtgdDcsYn;
    /**
    * 반품완료일자 
    */
    private String rtgdEndDe;
    /**
    * 렌탈구분코드 
    */
    private String rentSeCd;
    
    
    
    
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
     * 쿠폰발행이력일련번호 
     */
     private String coupnPblsHstSeq;
     /**
     * 쿠폰발행기본번호 
     */
     private String coupnPblsBasNo;
     /**
     * 쿠폰북이력일련번호 
     */
     private String coupnBookHstSeq;
     /**
     * 멤버십쿠폰기본번호 
     */
     private String mshipCoupnBasNo;
     /**
     * 쿠폰종류코드 
     */
     private String coupnKndCd;
     /**
     * 쿠폰종류명
     */
     private String coupnKndNm;
     /**
     * 쿠폰대상코드 
     */
     private String coupnTgtCd;
     /**
     * FROM발행기준일 
     */
     private String fromPblsStdDay;
     /**
     * TO발행기준일 
     */
     private String toPblsStdDay;
     /**
     * 사용기준일조건코드 
     */
     private String useStdDayCondCd;
     /**
     * FROM사용기준일 
     */
     private String fromUseStdDay;
     /**
     * TO사용기준일 
     */
     private String toUseStdDay;
     /**
     * 선물가능여부 
     */
     private String giftPossYn;
     /**
     * 쿠폰발급방법코드 
     */
     private String coupnIssueMethCd;
     /**
     * 발급제한수 
     */
     private Integer issueRstrtnCnt;
     /**
     * 최대발급수 
     */
     private Integer maxIssueCnt;
     /**
     * 최대사용수 
     */
     private Integer maxUseCnt;
     /**
     * 적용율 
     */
     private Integer applyRate;
     /**
     * 최소구매금액 
     */
     private Integer minBuyAmt;
     /**
     * 최대할인금액 
     */
     private Integer maxDcAmt;
     /**
     * 적용수 
     */
     private Integer applyCnt;
     /**
     * 증정제품코드 
     */
     private String prsnttnGodsCd;
     /**
     * 사용요일 
     */
     private String useDow;
     /**
     * FROM사용시간 
     */
     private String fromUseHour;
     /**
     * TO사용시간 
     */
     private String toUseHour;
     /**
     * 사용채널코드 
     */
     private String useChlCd;
     /**
     * 사용구분코드 
     */
     private String useDivCd;
     /**
     * 사용구분명 
     */
     private String useDivNm;
     /**
     * 사용여부 
     */
     private String useYn;
     /**
     * 쿠폰기본명 
     */
     private String coupnBasNm;
     /**
     * 쿠폰기본내용 
     */
     private String coupnBasCtnts;
     /**
     * 정산방법코드 
     */
     private String admtMethCd;
     /**
     * 정산금액 
     */
     private String admtAmt;
     /**
     * 쿠폰유형 
     */
     private String coupnTypeCd;
     /**
     * 쿠폰유형명
     */
     private String coupnTypeNm;
     /**
     * 쿠폰사용가능일 
     */
     private String coupnUsePossDay;
     /**
     * 쿠폰사용가능여부 
     */
     private String coupnUsePossYn;
     /**
     * 쿠폰사용가능일수 
     */
     private Integer coupnUsePossDayCnt;
     /**
     * 쿠폰분류코드 
     */
     private String coupnClassCd;
     /**
     * 회원1등급사용여부 
     */
     private String mshp1GradeUseYn;
     /**
     * 회원2등급사용여부 
     */
     private String mshp2GradeUseYn;
     /**
     * 회원3등급사용여부 
     */
     private String mshp3GradeUseYn;
     /**
     * 회원4등급사용여부 
     */
     private String mshp4GradeUseYn;
     /**
     * 회원5등급사용여부 
     */
     private String mshp5GradeUseYn;
     /**
     * 회원6등급사용여부 
     */
     private String mshp6GradeUseYn;
     /**
     * 채널1사용여부 
     */
     private String chl1UseYn;
     /**
     * 채널2사용여부 
     */
     private String chl2UseYn;
     /**
     * 채널3사용여부 
     */
     private String chl3UseYn;
     /**
     * 채널4사용여부 
     */
     private String chl4UseYn;
     /**
     * 채널5사용여부 
     */
     private String chl5UseYn;
     /**
     * 요일1사용여부 
     */
     private String dow1UseYn;
     /**
     * 요일2사용여부 
     */
     private String dow2UseYn;
     /**
     * 요일3사용여부 
     */
     private String dow3UseYn;
     /**
     * 요일4사용여부 
     */
     private String dow4UseYn;
     /**
     * 요일5사용여부 
     */
     private String dow5UseYn;
     /**
     * 요일6사용여부 
     */
     private String dow6UseYn;
     /**
     * 요일7사용여부 
     */
     private String dow7UseYn;
     /**
     * 회원등급코드 
     */
     private String mshpGradeCd;
     /**
     * 사용및적립일시
     */
     private String dt;
     /**
      * 회원형태
      */
     private Object mshipTypeCds;
     
     
     public String getApplyMshpGradeCtnts() {
     	return Utilities.convArryToStrs(this.applyMshpGradeCtnts, ",");
     }

     public List<String> getApplyMshpGradeCtntss() {
     	return Utilities.convStrsToArry(this.applyMshpGradeCtnts, ",");
     }
     
     public String getMshipTypeCds() {
 		return Utilities.convArryToStrs(this.mshipTypeCds, ",");
 	}

 	public List<String> getMshipTypeCdss() {
 		return Utilities.convStrsToArry(this.mshipTypeCds, ",");
 	}
}