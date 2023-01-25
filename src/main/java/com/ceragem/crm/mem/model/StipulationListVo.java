package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName	StipulationListVo
 * @author      황재희
 * @date        2022. 4. 8.
 * @Version     1.0
 * @description 약관 목록 Vo
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class StipulationListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 약관번호 
    */
    private String stpltNo;
    /**
    * 약관명 
    */
    private String stpltNm;
    /**
    * 유형코드 
    */
    private String stpltTypeCd;
    /**
    * 약관내용 
    */
    private String stpltCtnts;
    /**
    * 약관시작일 
    */
    private String stpltStaYmd;
    /**
    * 약관종료일 
    */
    private String stpltEndYmd;
    /**
    * 사용여부 
    */
    private String useYn;
    /**
    * 등록채널코드 
    */
    private String regChlCd;
    
    private String info;
}