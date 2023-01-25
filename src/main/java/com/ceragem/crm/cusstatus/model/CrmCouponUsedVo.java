package com.ceragem.crm.cusstatus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCouponUsedVo{
	/**
    * <p>쿠폰발행이력일련번호</p> 
    */
    private String coupnPblsHstSeq;
    /**
	* <p>고객명</p> 
	*/
	private String custNm;
	/**
    * <p>매장번호</p> 
    */
    private String storNo; 
    /**
    * <p>쿠폰명</p> 
    */
    private String coupnBasNm;
    /**
    * <p>쿠폰종류코드</p> 
    */
    private String coupnTypeCd;
    /**
	* <p>사용일자</p> 
	*/
	private String useDt;
	/**
	* <p>성별</p> 
	*/
	private String gndrCd;
	/**
	* <p>나이</p> 
	*/
	private String birthdayDt;
	/**
	* <p>회원등급</p> 
	*/
	private String mshipGradeCd;
	/**
	* <p>쿠폰 사용전 금액</p> 
	*/
	private String ordrAmt;
	/**
	* <p>쿠폰금액</p> 
	*/
	private String saleAmt;
	/**
	* <p>최종결제금액</p> 
	*/
	private String payAmt;
	/**
	* <p>사용매장명</p> 
	*/
	private String storNm;
	/**
	* <p>쿠폰발행번호</p> 
	*/
	private String coupnPblsBasNo;
	/**
	* <p>통합회원번호</p> 
	*/
	private String itgCustNo;
}
