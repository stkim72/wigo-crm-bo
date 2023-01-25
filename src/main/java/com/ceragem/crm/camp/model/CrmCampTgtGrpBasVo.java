package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampTgtGrpBasVo
 * @author    user
 * @date    2022. 7. 24.
 * @Version    1.0
 * @description    CRM캠페인대상그룹기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampTgtGrpBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 캠페인대상그룹기본번호 
    */
    private String campTgtGrpBasNo;
    /**
    * 캠페인기본번호 
    */
    private String campBasNo;
    /**
    * 고객그룹번호 
    */
    private String custGrpNo;
    /**
    * 대상추출예정년월일 
    */
    private String tgtExtrExptYmd;
    /**
    * 대상추출년월일시분초 
    */
    private String tgtExtrYmdhms;
    /**
    * 대상추출쿼리내용 
    */
    private String tgtExtrSqlCtnts;
    /**
    * 대상고객수 
    */
    private Integer tgtCustCnt;
    /**
    * 발송채널코드 
    */
    private String dspChlCd;
    /**
    * 예상발송비용 
    */
    private Integer forecDspExpns;
    /**
    * 예상혜택비용 
    */
    private Integer forecBnfitExpns;
    /**
    * 적용혜택코드 
    */
    private String applyBnfitCd;
    /**
    * 전송콘텐츠번호 
    */
    private String trmCtntNo;
    /**
    * 전송콘텐츠내용 
    */
    private String trmCtntCtnts;
    /**
    * 쿠폰기본번호 
    */
    private String coupnBasNo;
    /**
    * 쿠폰유형코드 
    */
    private String coupnTypeCd;
    /**
    * 쿠폰종류코드 
    */
    private String coupnKndCd;
    /**
    * 쿠폰적용구분코드1 
    */
    private String coupnApplyDivCd1;
    /**
    * 쿠폰적용구분코드2 
    */
    private String coupnApplyDivCd2;
    /**
    * 발송여부 
    */
    private String dspYn;
    /**
    * 발송년월일시분초 
    */
    private String dspYmdhms;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
    */
    private String regChlCd;
    

}
