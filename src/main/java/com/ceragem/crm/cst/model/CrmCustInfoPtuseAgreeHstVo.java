package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustInfoPtuseAgreeHstVo
 * @author    user
 * @date    2022. 4. 29.
 * @Version    1.0
 * @description    CRM고객정보활용동의이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustInfoPtuseAgreeHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;

	/**
	* 검색창 동의기간 시작일 
	*/
	private String strtDt;
	/**
	* 검색창 동의기간 종료일 
	*/
	private String endDt;
    /**
    * 정보활용동의이력일련번호 
    */
    private String infoPtuseAgreeHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 동의유형코드 
    */
    private String agreeTypeCd;
    /**
    * 약관번호 
    */
    private String stpltNo;
    /**
    * 동의여부 
    */
    private String agreeYn;
    /**
    * 수신거부유형코드 
    */
    private String rcvRfslTypeCd;
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
