package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCusStatusVo{
	/**
    * <p>통합고객번호</p> 
    */
    private String itgCustNo;
    /**
    * <p>통합고객번호</p> 
    */
    private String custNm;
    /**
    * <p>멤버십등급코드</p> 
    */
    private String mshipGradeCd;
    /**
    * <p>성별코드</p> 
    */
    private String gndrCd;
    /**
    * <p>생년월일</p> 
    */
    private String birthdayDt;
    /**
    * <p>생년월일</p> 
    */
    private String regDt;
     
}
