package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustBosHcHstVo
 * @author    user
 * @date    2022. 5. 25.
 * @Version    1.0
 * @description    CRMBOS홈체험이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustBosHcHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 계약번호 
    */
    private String cntrtNo;
    /**
    * 방문회차수 
    */
    private Integer visitTmsCnt;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 처리방법코드 
    */
    private String trtMethCd;
    /**
    * 처리방법명 
    */
    private String trtMethNm;
    /**
    * 서비스개월수 
    */
    private Integer svcMonsCnt;
    /**
    * 서비스일자 
    */
    private String svcDate;
    /**
    * 예정년월 
    */
    private String exptYyyymm;
    /**
    * 예정일자 
    */
    private String exptDate;
    /**
    * 정기점검유형코드 
    */
    private String rgitvInspTypeCd;
    /**
    * 정기점검유형명 
    */
    private String rgitvInspTypeNm;
    /**
    * 기간유형코드 
    */
    private String perdTypeCd;
    /**
    * 기간유형명 
    */
    private String perdTypeNm;
    /**
    * 점검처리여부 
    */
    private String inspTrtYn;
    /**
    * 정기점검접수번호 
    */
    private String rgitvInspSubmitNo;
    /**
    * BOS고객번호 
    */
    private String bosCustNo;
    /**
    * 처리조직코드 
    */
    private String trtOrgCd;
    /**
    * 처리일자 
    */
    private String trtDate;
    /**
    * 처리시간 
    */
    private String trtHour;
    /**
    * 처리기사사원번호 
    */
    private String trtEngnrEmpNo;
    /**
    * 차회예정일자 
    */
    private String nxtmExptDate;
}
