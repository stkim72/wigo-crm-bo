package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmRcvRfslHstVo
 * @author    user
 * @date    2022. 4. 29.
 * @Version    1.0
 * @description    CRM수신거부이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmRcvRfslHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 수신거부이력일련번호 
    */
    private String rcvRfslHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 수신거부유형코드 
    */
    private String rcvRfslTypeCd;
    /**
    * 수신거부사유내용 
    */
    private String rcvRfslWhyCtnts;
    /**
    * 수신거부여부 
    */
    private String rcvRfslYn;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
}
