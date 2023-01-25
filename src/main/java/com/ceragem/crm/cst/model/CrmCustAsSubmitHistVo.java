package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustAsSubmitHistVo
 * @author    user
 * @date    2022. 5. 12.
 * @Version    1.0
 * @description    CRM고객AS접수이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustAsSubmitHistVo extends BaseVo {
    /** 
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * AS접수번호 
    */
    private String asSubmitNo;
    /**
    * AS이력일련번호
    */
    private String hstSeq;
    
    private String submitDate;
    
    private String godsExplnNm;
    
    
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * BOS고객번호 
    */
    private String bosCustNo;
    /**
    * 고객명 
    */
    private String custNm;
    /**
    * 등급코드 
    */
    private String gradeCd;
    /**
    * 등급명 
    */
    private String gradeNm;
    /**
    * 접수채널코드 
    */
    private String submitChlCd;
    /**
    * 접수채널명 
    */
    private String submitChlNm;
    /**
    * 이동전화번호 
    */
    private String mphonNo;
    /**
    * 집전화번호 
    */
    private String homeTelNo;
    /**
    * 직장전화번호 
    */
    private String wkplcTelNo;
    /**
    * SMS대상구분코드 
    */
    private String smsTgtDivCd;
    /**
    * 우편번호 
    */
    private String zipCd;
    /**
    * 주소1내용 
    */
    private String addr1Ctnts;
    /**
    * 주소2내용 
    */
    private String addr2Ctnts;
    /**
    * 계약번호 
    */
    private String cntrtNo;
    /**
    * 제품일련번호 
    */
    private String godsSrialNo;
    /**
    * 계약구분코드 
    */
    private String cntrtDivCd;
    /**
    * 계약구분명 
    */
    private String cntrtDivNm;
    /**
    * 카테고리코드 
    */
    private String ctgrCd;
    /**
    * 카테고리명 
    */
    private String ctgrNm;
    /**
    * 모델코드 
    */
    private String modelCd;
    /**
    * 모델명 
    */
    private String modelNm;
    /**
    * 판매설치일자 
    */
    private String salesInstllDate;
    /**
    * 제품교환일자 
    */
    private String godsExchngDate;
    /**
    * 유지보수개월코드 
    */
    private String mtcMonsCd;
    /**
    * 계약만료일 
    */
    private String cntrtExpDay;
    /**
    * 상담일 
    */
    private String cnslgDay;
    /**
    * 상담년월일시분초 
    */
    private String cnslgYmdhms;
    /**
    * 상담사사원ID 
    */
    private String csagEmpId;
    /**
    * 상담자사원명 
    */
    private String cnslgPrsnEmpNm;
    /**
    * AS처리구분코드 
    */
    private String asTrtDivCd;
    /**
    * 증상접수전화번호 
    */
    private String symtmSubmitTelNo;
    /**
    * 증상파일ID 
    */
    private String symtmFileId;
    /**
    * SMS비고 
    */
    private String smsRmark;
    /**
    * 접수비고 
    */
    private String submitRmark;
    /**
    * 방문예정일 
    */
    private String visitExptDay;
    /**
    * 방문예정시간 
    */
    private String visitExptHour;
    /**
    * 처리완료일시 
    */
    private String trtCmptDt;
    /**
    * 처리담당자사원ID 
    */
    private String trtPicEmpId;
    /**
    * 처리담당자명 
    */
    private String trtPicNm;
    /**
    * 송장번호 
    */
    private String invcNo;
    /**
    * 택배회사코드 
    */
    private String homdlvCmpCd;
    /**
    * 해피콜전화번호 
    */
    private String hcallTelNo;
    /**
    * 처리비고 
    */
    private String trtRmark;
    /**
    * 처리첨부파일ID 
    */
    private String trtAttchFileId;
    /**
    * 출장비금액 
    */
    private Integer tvexpnsAmt;
    /**
    * 총금액 
    */
    private Integer totAmt;
    /**
    * 할인금액 
    */
    private Integer dcAmt;
    /**
    * 결제금액 
    */
    private Integer payAmt;
    /**
    * 할인내용 
    */
    private String dcCtnts;
    /**
    * AS상태코드 
    */
    private String asStatusCd;
    /**
    * 보증만료일 
    */
    private String grntExpDay;
    /**
    * 불량증상코드 
    */
    private String badSymtmCd;
    /**
    * 불량증상명 
    */
    private String badSymtmNm;
    /**
    * 조치부품코드 
    */
    private String actnPartsCd;
    /**
    * 조치부품명 
    */
    private String actnPartsNm;
    
    private String regChlCd     ;

    private String actnCtnts    ;
    
//=================================================== 상담상세항목
    private String regrId           ; 
    private String regDt            ;
    private String amdrId           ;
    private String amdDt            ;

    private String asStatusCdNm     ;

    private String asTrtDivCdNm     ;

    private String trtPicMphonNo    ;

    private String totalCnt     ;

    private String cancelCnt    ;

}
