package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @ClassName    CrmCampTypeBasVo
 * @author    user
 * @date    2022. 6. 14.
 * @Version    1.0
 * @description    캠페인유형기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampTypeBasVo extends BaseVo {
	
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 캠페인유형기본번호 
    */
    private String campTypeBasNo;
    /**
    * 캠페인유형명 
    */
    private String campTypeBasNm;
    /**
    * 캠페인구분코드 
    */
    private String campDivCd;
    private String campDivCdNm;
    /**
    * 캠페인유형코드 
    */
    private String campTypeCd;
    private String campTypeCdNm;
    /**
    * 사용여부 
    */
    private String useYn;
    private String useYnNm;
    /**
    * 캠페인형태코드 
    */
    private String campShapCd;
    private String campShapCdNm;
}
