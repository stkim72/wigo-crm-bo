package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    LoyalCusVo
 * @author    황의겸
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM 충성고객기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class LoyalCusVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 고객명 
    */
    private String custNm;
    /**
    * 성별코드 
    */
    private String gndrCd;
    /**
    * 생년월일 
    */
    private String birthday;
    /**
    * 이동전화번호 
    */
    private String mphonNo;
    /**
    * 이메일주소 
    */
    private String emailAddr;
    /**
    * 고객상태코드 
    */
    private String custStatusCd;
    /**
    * 고객유형코드 
    */
    private String custTypeCd;
    /**
    * 고객구분코드 
    */
    private String custDivCd;
    /**
    * 추천매장번호 
    */
    private String rcmdStorNo;
    /**
    * 추천매장
    */
    private String rcmdStorNm;
    /**
    * 멤버십등급코드 
    */
    private String mshipGradeCd;
    /**
    * 총 구매건수 
    */
    private String bosCntrtCnt;
    /**
    * 총 구매추천건수 
    */
    private String rcmdCnt;   
    ////////////구매이력관려/////////////
    private String regChlCd;
    /**
    * 판매유형코드 
    */
    private String salesDivCd;
    /**
    * 판매유형명 
    */
    private String salesDivNm;
    /**
    * 계약건수 
    */
    private int cnt;
    /**
    * 매장명 
    */
    private String storNm;
    /* */
    /**
    * 계약번호 
    */
    private String cntrtNo;
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
    /////////////구매추천이력관련//////////////
    /**
    * 추천인이력일련번호 
    */
    private String rcmdrHstSeq;
    /**
    * 추천유형코드 
    */
    private String rcmdTypeCd;
    /**
    * 추천인고객번호 
    */
    private String rcmdrCustNo;
    /**
    * 추천인고객 
    */
    private String rcmdrCustNm;
    /**
    * 계약번호 
    */
    private String cntrNo;
    /**
    * 고객번호 
    */
    private String custNo;
    /**
    * 고객유형코드 
    */
    private String custTyCd;
    /**
    * 고객유형명 
    */
    private String custTyCdnm;
    /**
    * 고객유형상세코드 
    */
    private String custTyDtlCd;
    /**
    * 고객유형상세명 
    */
    private String custTyDtlCdnm;
    /**
    * 주문번호 
    */
    private String ordNo;
    /**
    * 주문번호순번 
    */
    private Integer ordNoSn;
    /**
    * 주문일자 
    */
    private String ordDe;
    /**
    * 주문상태코드 
    */
    private String ordStsCd;
    /**
    * 주문상태명 
    */
    private String ordStsCdnm;
    /**
    * 주문채널코드 
    */
    private String ordChnCd;
    /**
    * 주문구분코드 
    */
    private String ordSeCd;
    /**
    * 주문구분명 
    */
    private String ordSeCdnm;
    /**
    * 주문취소일자 
    */
    private String ordCnclDe;
    /**
    * 품목코드 
    */
    private String itemCd;
    /**
    * 품목명 
    */
    private String itemNm;
    /**
    * 품목그룹코드 
    */
    private String itemGrpCd;
    /**
    * 품목그룹명 
    */
    private String itemGrpCdnm;
    /**
    * 품목유형코드 
    */
    private String itemTyCd;
    /**
    * 품목유형명 
    */
    private String itemTyCdnm;
    /**
    * 품목유형상세코드 
    */
    private String itemTyDtlCd;
    /**
    * 품목유형상세명 
    */
    private String itemTyDtlCdnm;
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
    * 계약상태상세사유 
    */
    private String cntrStsDtlRsn;
    /**
    * 결제상태코드 
    */
    private String setlStsCd;
    /**
    * 결제상태명 
    */
    private String setlStsCdnm;
    /**
    * 설치상태코드 
    */
    private String istStsCd;
    /**
    * 설치상태명 
    */
    private String istStsCdnm;
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
    * 판매인 
    */
    private String seller;
    /**
    * 판매인명 
    */
    private String sellernm;
    /**
    * 판매조직 
    */
    private String saleOrgz;
    /**
    * 설치예정조직 
    */
    private String istDueOrgz;
    /**
    * 설치예정기사 
    */
    private String istDueEngr;
    /**
    * 설치조직 
    */
    private String istOrgz;
    /**
    * 설치기사 
    */
    private String istEngr;
    /**
    * 설비번호 
    */
    private String eqpNo;
    /**
    * 창고코드 
    */
    private String wrhCd;
    /**
    * 창고명 
    */
    private String wrhNm;
    /**
    * 컨택순번 
    */
    private Integer cntcSn;
    /**
    * 고객컨택상태 
    */
    private String custCntcSts;
    /**
    * 고객컨택일자 
    */
    private String custCntcDe;
    /**
    * 설치요청일자 
    */
    private String istReqDe;
    /**
    * 설치일자 
    */
    private String istDe;
    /**
    * 설치확정여부 
    */
    private String istDcsYn;
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
    * 신용조회여부 
    */
    private String cdtSelYn;
    /**
    * 가격정책번호 
    */
    private String prcPlcNo;
    /**
    * 약정기간코드 
    */
    private String agrPdCd;
    /**
    * 약정기간명 
    */
    private String agrPdCdnm;
    /**
    * 계약기간값 
    */
    private Integer cntrPdVal;
    /**
    * 서비스기간코드 
    */
    private String svcPdCd;
    /**
    * 점검주기 
    */
    private String svcCycle;
    /**
    * 선납여부 
    */
    private String prepayYn;
    /**
    * 선납금액 
    */
    private Double prepayAmt;
    /**
    * 선납주기 
    */
    private String prepayCycle;
    /**
    * 선납할인율 
    */
    private Integer prepayDcrt;
    /**
    * 등록비 
    */
    private Double regfee;
    /**
    * 설치비 
    */
    private Double istct;
    /**
    * 해체비 
    */
    private Double dfee;
    /**
    * 기본렌탈금액 
    */
    private Double bassRentAmt;
    /**
    * 기본판매금액 
    */
    private Double bassSaleAmt;
    /**
    * 결제금액 
    */
    private Double setlAmt;
    /**
    * 주문금액 
    */
    private Double ordAmt;
    /**
    * 주문부가세제외금액 
    */
    private Double ordVatExclAmt;
    /**
    * 주문부가세금액 
    */
    private Double ordVatAmt;
    /**
    * 매출금액 
    */
    private Double selngAmt;
    /**
    * 매출부가세제외금액 
    */
    private Double selngVatExclAmt;
    /**
    * 매출부가세금액 
    */
    private Double selngVatAmt;
    /**
    * 매출번호 
    */
    private String selngNo;
    /**
    * 판매채널코드 
    */
    private String saleChnCd;
    /**
    * 판매채널명 
    */
    private String saleChnCdnm;
    /**
    * 프로모션여부 
    */
    private String prmtYn;
    /**
    * 프로모션정책번호 
    */
    private String prmtPlcNo;
    /**
    * 프로모션번호 
    */
    private String prmtNo;
    /**
    * 패키지여부 
    */
    private String pkgYn;
    /**
    * 패키지정책번호 
    */
    private String pkgPlcNo;
    /**
    * 패키지번호 
    */
    private String pkgNo;
    /**
    * 단체여부 
    */
    private String grpYn;
    /**
    * 단체코드 
    */
    private String grpCd;
    /**
    * 단체번호 
    */
    private String grpNo;
    /**
    * 계약서파일번호 
    */
    private String ctrtcFileNo;
    /**
    * 서명파일번호 
    */
    private String signFileNo;
    /**
    * 서비스여부 
    */
    private String svcYn;
    /**
    * 기존계약번호 
    */
    private String existCntrNo;
    /**
    * 반품유형코드 
    */
    private String rtgdTyCd;
    /**
    * 반품요청일자 
    */
    private String rtgdReqDe;
    /**
    * 반품접수확정여부 
    */
    private String rtgdDcsYn;
    /**
    * 반품완료일자 
    */
    private String rtgdEndDe;
    /**
    * 약관정책번호 
    */
    private String spltPlcNo;
    /**
    * 설치예정일자 
    */
    private String istDueDe;
    /**
    * 추가증빙파일번호1 
    */
    private String addPrufFileNo1;
    /**
    * 추가증빙파일번호2 
    */
    private String addPrufFileNo2;
    /**
    * 신용등급코드 
    */
    private String cdtGradCd;
    /**
    * 등록자ID 
    */
    private String regUsrId;
    /**
    * 수정자ID 
    */
    private String updUsrId;
    /**
    * 수정일시 
    */
    private String updDt;
    /**
    * 설치-우편번호 
    */
    private String postNo;
    /**
    * 설치-기본주소 
    */
    private String bassAddr;
    /**
    * 설치-상세주소 
    */
    private String dtlAddr;
    /**
    * 설치-모바일번호 
    */
    private String mobNo;
    /**
    * 설치-전화번호 
    */
    private String telNo;
    /**
    * 설치-특이사항 
    */
    private String partclrMatter;
    /**
    * 설치-설치고객명 
    */
    private String istCustNm;
    /**
    * 정기결제-카드번호 
    */
    private String cardNo;
    /**
    * 정기결제-카드사코드 
    */
    private String cdcmpCd;
    /**
    * 정기결제-소유주명 
    */
    private String ownerNm;
    /**
    * 정기결제-방법코드 
    */
    private String fsetlMthCd;
    /**
    * 정기결제-방법명 
    */
    private String fsetlMthCdnm;
    /**
    * 정기결제일자코드 
    */
    private String fsetlDeCd;
    /**
    * 계좌신청동의파일번호 
    */
    private String acctAfileNo;
    /**
    * 출고상태코드 
    */
    private String otbnStsCd;
    /**
    * 출고상태명 
    */
    private String otbnStsCdnm;
    /**
    * 비고 
    */
    private String rm;
    /**
    * 기본멤버십금액 
    */
    private Double bassMbrshAmt;
    /**
    * 멤버십금액 
    */
    private Double mbrshAmt;
    /**
    * 일시불무상종료예정일 
    */
    private String lmpsFreeEndDueDe;
    /**
    * 패키지해지여부 
    */
    private String pkgTrmnYn;
    /**
    * 배송유형코드 
    */
    private String dlvTyCd;
    /**
    * 배송유형명 
    */
    private String dlvTyCdnm;
    /**
    * 배송유형상세코드 
    */
    private String dlvTyDtlCd;
    /**
    * 배송유형상세명 
    */
    private String dlvTyDtlCdnm;
    /**
    * 약정기간값 
    */
    private Integer agrPdVal;
    /**
    * 계약기간구분코드 
    */
    private String cntrPdSeCd;
    /**
    * 계약기간구분명 
    */
    private String cntrPdSeCdnm;
    /**
    * 계약이후처리방법코드 
    */
    private String cntrEndAfterProcMthCd;
    /**
    * 계약종료이후처리방법 
    */
    private String cntrEndAfterProcMthCdnm;
    /**
    * 중고구분코드 
    */
    private String uatcSeCd;
    /**
    * 중고구분명 
    */
    private String uatcSeCdnm;
    /**
    * 중고등급코드 
    */
    private String uatcGradCd;
    /**
    * 중고등급명 
    */
    private String uatcGradCdnm;
    /**
    * 스케줄생성여부 
    */
    private String shdeCreYn;
    /**
    * 렌탈구분코드 
    */
    private String rentSeCd;
    /**
    * 렌탈구분명 
    */
    private String rentSeCdnm;
    /**
    * 홈체험청구할인기간코드 
    */
    private String exprnDmdDcPdCd;
    /**
    * 홈체험청구할인기간명 
    */
    private String exprnDmdDcPdCdnm;
    /**
    * 홈체험계약번호 
    */
    private String exprnCntrNo;
    /**
    * 추천인 
    */
    private String rcmdr;
    /**
    * 추천인명 
    */
    private String rcmdrnm;
    /**
    * 추천인조직코드 
    */
    private String orgzCd;
    /**
    * 추천인조직명 
    */
    private String orgzNm;
    /**
    * 본인영업구분코드 
    */
    private String selfBsnSeCd;
    /**
    * 본인영업구분명 
    */
    private String selfBsnSeCdnm;
    /**
    * 사은품내역 
    */
    private String prsntDtls;
    /**
    * 무상판매유형 
    */
    private String freeSaleTy;
    /**
    * 무상판매유형명 
    */
    private String freeSaleTynm;
    /**
    * 관리번호 
    */
    private String mngNo;
    /**
    * 컨택상태명 
    */
    private String cntcStsCdnm;
    /**
    * 기본판매요금 
    */
    private Double bassSaleFee;
    /**
    * 가격정책명 
    */
    private String prcPlcNm;
    /**
    * 계약수량 
    */
    private Double cntrQy;
    /**
    * 할인율 
    */
    private String dcrt;
    /**
    * 할인금액 
    */
    private Double dcAmt;
    /**
    * 이지렌탈계약번호 
    */
    private String erCntrNo;
    /**
    * 대표번호여부 
    */
    private String rprsntvCntrYn;
    /**
    * 주문유형코드 
    */
    private String orTyCd;
    /**
    * 주문유형 
    */
    private String orTyCdnm;
    /**
    * 사은품여부 
    */
    private String prsntYn;
    /**
    * 원계약번호(사은품) 
    */
    private String prsntCntrNo;
    /**
    * 건기식주문번호 
    */
    private String ceramOrdNo;
    /**
    * 선세금계산서발급여부 
    */
    private String ptaxbilYn;
    /**
    * 선세금계산서기준일자 
    */
    private String ptaxbilDe;
    /**
    * 선세금계산서담당자 
    */
    private String ptaxbilChrgrSn;
    /**
    * 담당자이메일 
    */
    private String chrgrEmail;
    /**
    * 담당자연락처 
    */
    private String chrgrCttpc;
    /**
    * 담당자부서명 
    */
    private String chrgrDeptNm;
    /**
    * 추천고객멤버십아이디 
    */
    private String rcmdrMbrshId;
    /**
    * 추천고객멤버십이름 
    */
    private String rcmdrMbrshNm;
    /**
    * 인수서파일번호 
    */
    private String cfileNo;
    /**
    * 조견표번호 
    */
    private String insSerNo;
    /**
    * 채권분류코드 
    */
    private String bondCd;
    /**
    * 채권분류명 
    */
    private String bondCdnm;
    /**
    * 매출합계금액 
    */
    private String saleAggrAmt;
    /**
    * 매출합계금액 FROM
    */
    private String fromSaleAggrAmt;
    /**
    * 매출합계금액 TO
    */
    private String toSaleAggrAmt;        
}
