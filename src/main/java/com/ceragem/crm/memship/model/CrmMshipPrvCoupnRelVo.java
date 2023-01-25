package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipPrvCoupnRelVo
 * @author    user
 * @date    2022. 4. 20.
 * @Version    1.0
 * @description    CRM멤버십제공쿠폰관계 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipPrvCoupnRelVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 멤버십정책기본번호 
    */
    private String mshipPlcyBasNo;
    /**
    * 멤버십프로모션기본번호 
    */
    private String mshipPromBasNo;
    /**
    * 쿠폰기본번호 
    */
    private String coupnBasNo;
    /**
    * 등록채널코드 
    */
    private String regChlCd;
    /**
    * 쿠폰기본번호 
    */
    private String mshipCoupnBasNo;

    
    
    
    /**
	 * 쿠폰기본명 
	 */
	private String coupnBasNm;
	
	/**
	 * 쿠폰사용가능일 
	 */
	private String coupnUsePossDay;
	/**
	 * 쿠폰사용가능여부 
	 */
	private String coupnUsePossYn;
	/**
	 * 쿠폰사용가능일수 
	 */
	private Integer coupnUsePossDayCnt;

	/**
	 * 쿠폰종류코드명
	 */
	private String coupnKndCdNm;
	
	
	/**
	 * 쿠폰적용구분코드1 
	 */
	private String coupnApplyDivCd1;
	
	/**
	 * 적용금액 
	 */
	private Integer applyAmt;
	/**
	 * 적용율 
	 */
	private Integer applyRate;
	
	/**
	 * 적용수 
	 */
	private Integer applyCnt;
	
	/**
	 * 사용구분코드 
	 */
	private String useDivCd;
	/**
	 * 사용여부 
	 */
	private String useYn;
	/**
	 * 사용기준일조건코드 
	 */
	private String useStdDayCondCd;

	/**
	 * FROM사용기준일 
	 */
	private String fromUseStdDay;
	/**
	 * TO사용기준일 
	 */
	private String toUseStdDay;
	
	/**
	 * 상품명 
	 */
	private String godsNm;


}
