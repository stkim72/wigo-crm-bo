package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipApplyCoupnRelVo
 * @author    user
 * @date    2022. 5. 12.
 * @Version    1.0
 * @description    undefined Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyCoupnRelVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 등급쿠폰기본번호 
    */
    private String gradeCoupnBasNo;
    /**
    * 멤버십정책기본번호 
    */
    private String mshipPlcyBasNo;
    /**
    * 쿠폰리스트코드 
    */
    private String coupnTypeCd;
    /**
    * 멤버십쿠폰기본번호 
    */
    private String mshipCoupnBasNo;
    /**
    * 제공수량 
    */
    private Integer prvQnty;
    /**
    * 주기코드 
    */
    private String cycleCd;
    private String cycleCdNm;
    
    /**
	 * 쿠폰종류코드 
	 */
	private String coupnKndCd;
	
	/**
	 * FROM발행기준일 
	 */
	private String fromPblsStdDay;
	/**
	 * TO발행기준일 
	 */
	private String toPblsStdDay;
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
	
	private String coupnKndCdNm;
	private String coupnTypeCdNm;
}
