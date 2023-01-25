package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustInfoChngHstVo
 * @author    user
 * @date    2022. 5. 18.
 * @Version    1.0
 * @description    CRM고객정보변경이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustInfoChngHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;

	/**
	* 정보변경 시작일 
	*/
	private String strtDt7;
	/**
	* 정보변경 종료일 
	*/
	private String endDt7;
    /**
    * 고객정보변경이력일련번호 
    */
    private String custInfoChngHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 변경항목내용 
    */
    private String chngClusCtnts;
    /**
    * 변경사유내용 
    */
    private String chngWhyCtnts;
    /**
    * 보존기간 
    */
    private String keepPerd;
    /**
    * 변경전내용 
    */
    private String chngPreCtnts;
    /**
    * 변경내용 
    */
    private String chngCtnts;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
}
