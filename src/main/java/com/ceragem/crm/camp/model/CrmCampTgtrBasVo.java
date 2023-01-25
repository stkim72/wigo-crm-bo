package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampTgtrBasVo
 * @author    user
 * @date    2022. 7. 24.
 * @Version    1.0
 * @description    CRM캠페인대상자기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampTgtrBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 캠페인대상그룹기본번호 
    */
    private String campTgtGrpBasNo;
    /**
    * 캠페인기본번호 
    */
    private String campBasNo;
    /**
    * 고객명 
    */
    private String custNm;
    /**
    * 이동전화번호 
    */
    private String mphonNo;
    /**
    * 이메일주소 
    */
    private String emailAddr;
    /**
    * 발송채널코드 
    */
    private String dspChlCd;
    /**
    * 발송년월일시분초 
    */
    private String dspYmdhms;
    /**
    * 직접반응코드 
    */
    private String drRspnCd;
    /**
    * 직접반응수집년월일시분초 
    */
    private String drRspnCollctYmdhms;
    /**
    * 간접반응코드 
    */
    private String indirRspnCd;
    /**
    * 간접반응수집년월일시분초 
    */
    private String indirRspnCollctYmdhms;
    /**
    * 사용채널코드 
    */
    private String useChlCd;
    /**
    * 전표번호 
    */
    private String chitNo;
    /**
    * 구매제품번호 
    */
    private String buyGodsNo;
    /**
    * 결제금액 
    */
    private Integer payAmt;
    /**
    * 적용금액 
    */
    private Integer applyAmt;
    /**
    * 주문금액 
    */
    private Integer ordrAmt;
    /**
    * 발행구분코드 
    */
    private String pblsDivCd;
    /**
    * 발생포인트점수 
    */
    private Integer occurPointScore;
    /**
    * 유효기간 
    */
    private String validPerd;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
    */
    private String regChlCd;
    
    private String campBasNm;//CAMP_BAS_NM;
    private String custGrpNm;// CUST_GRP_NM
    

    private String campTmsNm;
    private String campShapCdNm;
    
    private String applyPoint;
    private String applyCoupnBasNoNm;
    
    
}
