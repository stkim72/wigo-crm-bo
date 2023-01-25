package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusKnownpersonListVo
 * @author    황의겸
 * @date    2022. 4. 28.
 * @Version    1.0
 * @description    CRM지인이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusKnownpersonListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 지인이력일련번호 
    */
    private String acqieHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 지인통합고객번호 
    */
    private String acqieItgCustNo;
    /**
    * 지인명
    */
    private String acqieItgCustNm;
    /**
    * 지인휴대전화번호 
    */
    private String mphonNo;
    /**
    * 계약번호 
    */
    private String cntrtNo;
    /**
    * 사용유형 
    */
    private String useTypeNm;
    /**
    * 사용유형코드 
    */
    private String useTypeCd;
    /**
    * 지인관계코드 
    */
    private String acqieRelNm;
    /**
    * 지인관계코드 
    */
    private String acqieRelCd;
    /**
    * 등록채널
    */
    private String regChlNm;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
}
