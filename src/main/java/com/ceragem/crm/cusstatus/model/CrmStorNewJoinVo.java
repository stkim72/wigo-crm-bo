package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmStorNewJoinVo{
	    /**
	    * <p>통합고객번호</p> 
	    */
	    private String itgCustNo;
	    
	    /**
	    * <p>회원명</p> 
	    */
	    private String custNm;
	  
	    /**
	     * <p>성별코드</p> 
	     */
	     private String gndrCd;
	    
	     /**
	      * <p>만 나이</p> 
	      */
	     private String age;
	     
	     /**
	      * <p>생년월일</p> 
	      */
	     private String birthdayDt;
	      
        /**
        * <p>매장명</p> 
        */
	     private String storNm;
	    
	    /**
	    * <p>매장번호</p> 
	    */
	    private String storNo;
	    
	    /**
	    * <p>매장상태코드</p> 
	    */
	    private String storStatusCd;
	  
	    /**
	    * <p>가입일자</p> 
	    */
	    private String regDt;
	    
}
