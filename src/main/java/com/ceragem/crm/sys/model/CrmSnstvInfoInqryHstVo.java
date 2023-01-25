package com.ceragem.crm.sys.model;

import com.ceragem.crm.main.model.CrmCustBasVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmSnstvInfoInqryHstVo
 * @author 김성태
 * @date 2022. 4. 19.
 * @Version 1.0
 * @description CRM민감정보조회이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmSnstvInfoInqryHstVo extends CrmCustBasVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 정보조회이력일련번호
	 */
	private String infoInqryHstSeq;

	/**
	 * 개인정보취급자번호
	 */
	private String indiInfoHandlPrsnNo;
	/**
	 * 접속자IP주소
	 */
	private String connPrsnIpAddr;
	/**
	 * 수행업무코드
	 */
	private String pfmWorkCd;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	private String regChlCd;

	private Integer inqryCnt;

	private String dnldTxn;
}
