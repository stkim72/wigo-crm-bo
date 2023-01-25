package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusRecommendVo
 * @author   	 황재희
 * @date    	 2022. 4. 28.
 * @Version    	 1.0
 * @description	 추천이력 Vo
 * @Company  	 Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusRecommendVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	 * 추천인이력일련번호 
	 */
	 private String rcmdrHstSeq;
	 /**
	 * 통합고객번호 
	 */
	 private String itgCustNo;
	 /**
	 * 추천인고객번호 
	 */
	 private String rcmdrCustNo;
	 /**
	 * 추천임직원번호 
	 */
	 private String rcmdExecvdempNo;
	 /**
	 * 추천매장번호 
	 */
	 private String rcmdStorNo;
	 /**
	 * 추천유형코드 
	 */
	 private String rcmdTypeCd;
	 /**
	 * 추천인고객명 
	 */
	 private String custNm;
	 /**
	 * 추천인고객전화번호 
	 */
	 private String mphonNo;
	 /**
	 * 추천인고객등급코드 
	 */
	 private String mshipGradeCd;
	 /**
	 * 추천매장명 
	 */
	 private String rcmdStorNm;
	 /**
	 * 등록채널코드 
	 * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	 private String regChlCd;
}
