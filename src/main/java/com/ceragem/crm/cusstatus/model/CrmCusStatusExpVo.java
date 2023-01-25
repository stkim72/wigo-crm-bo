package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCusStatusExpVo{
	
	/**
    * <p>통합고객번호</p> 
    */
    private String itgCustNo;
    
    /**
     * <p>회원명</p> 
     */
     private String custNm;
    
    /**
     * <p>성별</p> 
     */
    private String gndrCd;
   
     /**
      * <p>연령대</p> 
      */
    private String ageCd;
    
    /**
     * <p>경험여부</p> 
     */
   private String exprnExprcCd;
   
    /**
     * <p>체험일자</p> 
     */
    private String exprnDate;
    
    /**
     * <p>체험요일</p> 
     */
    private String expDay;
   
}
