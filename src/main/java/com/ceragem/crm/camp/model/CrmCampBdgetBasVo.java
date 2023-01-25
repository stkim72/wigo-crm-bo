package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampBdgetBasVo
 * @author    user
 * @date    2022. 6. 12.
 * @Version    1.0
 * @description    캠페인발송예산관리 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampBdgetBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 예산기본번호 
    */
    private String bdgetBasNo;
    /**
    * 적용년도 
    */
    private String applyYear;
    /**
    * 부서코드 
    */
    private String orgId;
    private String orgIdNm;
    /**
    * 예산수 
    */
    private Integer bdgetCnt;
    /**
    * 상태코드 
    */
    private String statusCd;
    private String statusCdNm;
}
