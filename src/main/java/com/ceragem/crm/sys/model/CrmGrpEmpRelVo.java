package com.ceragem.crm.sys.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmGrpEmpRelVo extends CrmJadeHrVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * <p>그룹코드</p> 
    */
    private String grpCd;
    private String grpNm;
}
