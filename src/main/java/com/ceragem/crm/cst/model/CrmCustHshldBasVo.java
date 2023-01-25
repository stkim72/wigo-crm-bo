package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustHshldBasVo
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM고객가구기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustHshldBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;

	/**
	* 수정 or 등록 상태 값 : c or u 
	*/	
	private String stat;
    /**
    * 대표가구번호 
    */
    private String repHshldNo;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 회원명 
    */
    private String custNm;    
    /**
    * 사용유형코드 
    */
    private String useTypeCd;
    /**
    * 가족관계코드 
    */
    private String famlyRelCd;
    
    
    /**
    * 삭제여부 
    */
    private String delYn;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
    
    /**
    * 채널명 
    */
    private String regChlCdNm;
    /**
    * 이동전화번호 
    */
    private String mphonNo;
    /**
    * 이동전화번호 암호화 값 
    */
    private String mphonNoEncVal;    
    
    private String postStaDt;
    
    private String postEndDt;    
}
