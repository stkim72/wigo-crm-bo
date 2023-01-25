package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustPhnCnslHistVo
 * @author    user
 * @date    2022. 5. 6.
 * @Version    1.0
 * @description    CRM고객상담이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustPhnCnslHistVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
//검색조건 시작
	/**
	* 현재페이지번호 
	*/
	private String currentPageNo;
	/**
	* 페이지당로우수 
	*/
	private String recordCountPerPage;
	/**
	* 고객전화번호 
	*/
	private String custTelNo;
  /**
  * 통합고객번호 
  */
  private String itgCustNo;	
	/**
	* 검색시작일 
	*/
	private String startDt;
	/**
	* 검색종료일 
	*/
	private String endDt;
//검색조건 끝

    /**
    * 상담이력번호 
    */
    private String cnslHistNo;
    /**
    * ASP_고객사_키 
    */
    private String aspCustKey;
    /**
    * 조직ID 
    */
    private String orgzId;
    /**
    * 사용자ID 
    */
    private String userId;
    /**
    * 상담시작일자 
    */
    private String cnslBeginDt;
    /**
    * 상담시작시간 
    */
    private String cnslBeginTime;
    /**
    * 상담종료일자 
    */
    private String cnslEotDt;
    /**
    * 상담종료시간 
    */
    private String cnslEotTime;
    /**
    * 콜유형 
    */
    private String callTy;
    /**
    * 통화시각 
    */
    private Integer telTime;
    /**
    * 상담저장일시 
    */
    private String cnslSaveDttm;
    /**
    * 후처리시간 
    */
    private Integer afProcTime;

    /**
    * 계약자전화번호 
    */
    private String contTelNo;
    /**
    * AS접수번호 
    */
    private String asRecpNo;
    /**
    * 고객번호 
    */
    private String custNo;
    /**
    * 고객명 
    */
    private String custNm;
    /**
    * 녹취전송여부 
    */
    private String rdwtSendYn;
    /**
    * 녹취ID 
    */
    private String rdwtId;
    /**
    * 녹취파일명 
    */
    private String rdwtFileNm;
    /**
    * 녹취경로 
    */
    private String rdwtFilePath;
    /**
    * 발신자번호 
    */
    private String sendManNo;
    /**
    * 콜ID 
    */
    private String callId;
    /**
    * 접수번호 
    */
    private String icdtNo;
    /**
    * 칭찬콜여부 
    */
    private String cpmtCallYn;
    /**
    * 전화구분 
    */
    private String telTy;
    /**
    * 호전환여부 
    */
    private String trnsYn;
    /**
    * 호전환상담사ID 
    */
    private String trnsCsltId;
    /**
    * 캠페인ID 
    */
    private Integer camId;
    /**
    * 설문지ID 
    */
    private Integer questId;
    /**
    * IVR서비스번호 
    */
    private String ivrServNo;
    /**
    * 호전환번호 
    */
    private String trnsNo;
    /**
    * 삭제여부 
    */
    private String delYn;
    
    private String cnslBeginDate   ;

    private String channel         ;
    private String productNm       ;
    private String productCd       ;

    private String cnslTypCd       ;
    private String cnslTypCd2      ;
    private String cnslTypCd3      ;
    private String cnslTypNm       ;
    private String cnslTypNm2      ;
    private String cnslTypNm3      ;
    private String cmplYn          ;

    private String userNm          ;    
}
