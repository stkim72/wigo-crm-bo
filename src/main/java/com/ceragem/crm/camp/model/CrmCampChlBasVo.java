package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampChlBasVo
 * @author    user
 * @date    2022. 6. 11.
 * @Version    1.0
 * @description    캠페인발송채널기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampChlBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 캠페인발송채널기본번호 
    */
    private String campChlBasNo;
    /**
    * 발송채널유형코드 
    */
    private String chlTypeCd;
    private String chlTypeCdNm;
    /**
    * 발송채널ID 
    */
    private String chlId;
    /**
    * 발송채널명 
    */
    private String chlNm;
    /**
    * 프로토콜 
    */
    private String chlProtCd;
    /**
    * 담당자명 
    */
    private String picNm;
    /**
    * 담당자휴대폰번호 
    */
    private String picMphonNo;
    /**
    * 접속정보 
    */
    private String connInfo;
    /**
    * API호출정보 
    */
    private String apiCallInfo;
    /**
    * 최종성공일자 
    */
    private String lastSuccDate;
    /**
    * 최종에러일자 
    */
    private String lastErrDate;
    /**
    * USE_YN 
    */
    private String useYn;
    private String useYnNm;
}
