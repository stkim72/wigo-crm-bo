package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustBosCntrtHstVo
 * @author    user
 * @date    2022. 5. 19.
 * @Version    1.0
 * @description    CRMBOS계약내역 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustBosCntrtTxnDtlVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	* 검색창 거래일 시작일 
	*/
	private String strtDt;
	/**
	* 검색창 거래일 종료일 
	*/
	private String endDt;
    /**
    * 계약번호 
    */
    private String cntrtNo;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * BOS고객번호 
    */
    private String bosCustNo;
    /**
    * 주문번호 
    */
    private String ordrNo;
    /**
    * 주문번호순서 
    */
    private Integer ordrNoQue;
    /**
    * 주문상태코드 
    */
    private String ordrStatusCd;
    /**
    * 제품번호 
    */
    private String godsNo;
    /**
    * 제품명 
    */
    private String godsNm;
    /**
    * 제품그룹코드 
    */
    private String godsGrpCd;
    /**
    * 제품유형코드 
    */
    private String godsTypeCd;
    /**
    * 제품상세유형코드 
    */
    private String godsDtlTypeCd;
    /**
    * 시리얼번호 
    */
    private String serialNo;
    /**
    * 판매유형코드 
    */
    private String salesTypeCd;
    /**
    * 판매구분코드 
    */
    private String salesDivCd;
    /**
    * 판매그룹코드 
    */
    private String salesGrpCd;
    /**
    * 계약상태코드 
    */
    private String cntrtStatusCd;
    /**
    * 계약상태상세코드 
    */
    private String cntrtStatusDtlCd;
    /**
    * 주문일자 
    */
    private String ordrDate;
    /**
    * 주문취소일자 
    */
    private String ordrCancelDate;
    /**
    * 계약취소여부 
    */
    private String cntrtCancelYn;
    /**
    * 계약취소일자 
    */
    private String cntrtCancelDate;
    /**
    * 계약취소사유내용 
    */
    private String cntrtCancelWhyCtnts;
    /**
    * 본부구분코드 
    */
    private String hqDivCd;
    /**
    * 판매조직코드 
    */
    private String salesOrgCd;
    /**
    * 판매조직명 
    */
    private String salesOrgNm;
    /**
    * 상위조직코드 
    */
    private String hRankOrgCd;
    /**
    * 상위조직명 
    */
    private String hRankOrgNm;
    /**
    * 판매사원번호 
    */
    private String salesEmpNo;
    /**
    * 판매사원명 
    */
    private String salesEmpNm;
    /**
    * 설치일자 
    */
    private String instllDate;
    /**
    * 확정설치일자 
    */
    private String confrmInstllDate;
    /**
    * 계약시작일자 
    */
    private String cntrtStaDate;
    /**
    * 계약종료예정일자 
    */
    private String cntrtEndExptDate;
    /**
    * 계약종료여부 
    */
    private String cntrtEndYn;
    /**
    * 계약종료일자 
    */
    private String cntrtEndDate;
    /**
    * 매출확정여부 
    */
    private String saleConfrmYn;
    /**
    * 매출확정일자 
    */
    private String saleConfrmDate;
    /**
    * 등록비용 
    */
    private Integer regExpns;
    /**
    * 설치비용 
    */
    private Integer instllExpns;
    /**
    * 해체비용 
    */
    private Integer disjtExpns;
    /**
    * 기본렌탈금액 
    */
    private Integer basRentAmt;
    /**
    * 렌탈금액 
    */
    private Integer rentAmt;
    /**
    * 기본판매금액 
    */
    private Integer basSalesAmt;
    /**
    * 판매금액 
    */
    private Integer salesAmt;
    /**
    * 결제금액 
    */
    private Integer payAmt;
    /**
    * 주문금액 
    */
    private Integer ordrAmt;
    /**
    * 주문부가세제외금액 
    */
    private Integer ordrVatExcptAmt;
    /**
    * 주문부가세금액 
    */
    private Integer ordrVatAmt;
    /**
    * 매출금액 
    */
    private Integer saleAmt;
    /**
    * 매출부가세제외금액 
    */
    private Integer saleVatExcptAmt;
    /**
    * 매출부가세금액 
    */
    private Integer saleVatAmt;
    /**
    * 매출번호 
    */
    private String saleNo;
    /**
    * 부가세코드 
    */
    private String vatCd;
    /**
    * 판매채널코드 
    */
    private String salesChlCd;
    /**
    * 반품유형코드 
    */
    private String rgoodTypeCd;
    /**
    * 반품확정여부 
    */
    private String rgoodConfrmYn;
    /**
    * 반품일자 
    */
    private String rgoodDate;
    /**
    * 렌탈구분코드 
    */
    private String rentDivCd;
    /**
    * 홈체험계약번호 
    */
    private String homeExprnCntrtNo;
    
    private String ordDe            ;
    private String saleSeCd         ;
    private String saleSeNm         ;
    private String ordChnNm         ;
    private String ordNo            ;
    private String ordNoSn          ;
    private String cntrNo           ;
    private String custNo           ;
    private String itemTyNm         ;
    private String itemCd           ;
    private String itemNm           ;
    private String cntrQy           ;
    private String prsntDtls        ;
    private String cntrStsNm        ;
    private String cntrStsDtlNm     ;
    private String setlStsNm        ;
    private String istStsNm         ;
    private String otbnStsNm        ;
    private String saleOrgz         ;
    private String saleOrgzNm       ;
    private String rcmdrNm          ;
    private String rcmdrMbrshId     ;
    private String rcmdrMbrshNm     ;
    private String cntrCnclDe       ;
    private String setlAmt          ;
    private String pamtOcrDe        ;
    private String istDueDe         ;
    private String istCustNm        ;
    private String istDcsDe         ;
    private String selngDcsDe       ;
    private String rtgdTyNm         ;
    private String rtgdDcsYn        ;
    private String exprnCntrNo      ;    
}
