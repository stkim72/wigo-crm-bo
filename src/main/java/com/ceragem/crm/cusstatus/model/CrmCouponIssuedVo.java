package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCouponIssuedVo{
	
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
    * <p>만 나이</p> 
    */
    private String age;   
    
    /**
    * <p>회원등급</p> 
    */
    private String mshipGradeCd;
    
    /**
    * <p>쿠폰기본명</p> 
    */
    private String coupnBasNm;

    /**
    * <p>쿠폰종류코드</p> 
    */
    private String coupnTypeCd;
    
    /**
    * <p>발행일자</p> 
    */
    private String issuedDt;
     
    /**
    * <p>만료일자</p> 
    */
    private String expiredDt;
      
    /**
    * <p>사용일자</p> 
    */
    private String usedDt;
       
    /**
    * <p>쿠폰발급방법</p> 
    */
    private String coupnIssueMethCd;
}
