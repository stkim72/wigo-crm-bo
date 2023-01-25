package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipApplyPointRelVo
 * @author    user
 * @date    2022. 5. 15.
 * @Version    1.0
 * @description    맴버십기본정책-이벤트쿠폰정책 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyPointRelVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 등급쿠폰기본번호 
    */
    private String eventPointBasNo;
    /**
    * 이벤트공통코드 
    */
    private String eventComnCd;
    /**
    * 멤버십정책기본번호 
    */
    private String mshipPlcyBasNo;
    /**
    * 적립포인트점수 
    */
    private Integer accumPointScore;
    /**
    * 총지정수 
    */
    private Integer totAppntCnt;
    /**
    * 일지정수 
    */
    private Integer dayAppntCnt;
    /**
    * 월지정수 
    */
    private Integer monthAppntCnt;
    
    /**
    * 유효기간 
    */
    private String validPerd;
    
    
    /**
    * 선물가능여부 
    */
    private String giftPossYn;
    
    private String comnCdNm;
    private String topComnCd2;
    private String comnCd2;
}
