package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusSendListVo
 * @author    황의겸
 * @date    2022. 4. 22.
 * @Version    1.0
 * @description    CRM발송이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusSendListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	 * 발송이력일련번호 
	 */
	 private String dspHstSeq;
	 /**
	 * 통합고객번호 
	 */
	 private String itgCustNo;
	 /**
	 * 발송콘텐츠유형코드 
	 */
	 private String dspCtntTypeCd;
	 /**
	 * 발송콘텐츠유형 
	 */
	 private String dspCtntTypeNm;
	 /**
	 * 이동전화번호 
	 */
	 private String mphonNo;
	 /**
	 * 이메일주소 
	 */
	 private String emailAddr;
	 /**
	 * 발송일시 
	 */
	 private String dspDt;
	 /**
	 * 발송상태코드 
	 */
	 private String dspStatusCd;
	 /**
	 * 발송상태
	 */
	 private String dspStatusNm;
	 /**
	 * 템플릿내역 
	 */
	 private String tmpltTxn;
	 /**
	 * 발송사유내역 
	 */
	 private String dspWhyTxn;
	 /**
	 * 발송채널코드 
	 */
	 private String dspChlCd;
	 /**
	 * 발송채널 
	 */
	 private String dspChlNm;
	 /**
	 * 프로모션번호 
	 */
	 private String promNo;
	 /**
	 * 캠페인번호 
	 */
	 private String campNo;
	 /**
	 * 매장번호 
	 */
	 private String storNo;
	 /**
	 * 등록채널코드 
	 * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	 private String regChlCd;
	 /**
	 * 등록채널 
	 */
	 private String regChlNm;
	 
	 /**
	 * 발송상태(조회조건)
	 */
	 private String sendType;
	 /**
	 * 성공여부(조회조건)
	 */
	 private String sendResult;
	 /**
	 * 발송상태(그리드)
	 */
	 private String sndType;
	 /**
	 * 성공여부(그리드)
	 */
	 private String sndResult;
	 /**
	 * 발송일시(그리드)
	 */
	 private String sndDate;
	 /**
	 * 발송메시지(그리드)
	 */
	 private String sndMsg;
}
