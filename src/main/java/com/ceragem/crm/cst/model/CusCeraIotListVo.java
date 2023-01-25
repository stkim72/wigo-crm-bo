package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustIotHstVo
 * @author    황의겸
 * @date    2022. 5. 10.
 * @Version    1.0
 * @description    CRM고객IOT이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusCeraIotListVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 아이디 
    */
    private String id;
    /**
    * 장비사용이력시퀀스 
    */
    private Integer historySeq;
    /**
    * 장비시리얼번호 
    */
    private String machineSerialNo;
    /**
    * 종료시간 
    */
    private String endTime;
    /**
    * 고객일련번호 
    */
    private Integer userNo;
    /**
    * 사용시간(초) 
    */
    private Integer duration;
	/**
	* 사용시간(시분초) 
	*/
	private String durationTime;
    /**
    * 실사용시간(초) 
    */
    private Integer originalDuration;
    /**
    * 장비모델 
    */
    private String model;
    /**
    * MODE1 
    */
    private String mode1;
    /**
    * MODE1 명
    */
    private String mode1Nm;
    /**
    * 사용이력등록날짜 
    */
    private String historyRegDt;
    /**
    * 모델 
    */
    private String modelNm;
    /**
    * 등록고객일련번호 
    */
    private Integer machineUserNo;
    /**
    * 전원상태 
    */
    private Integer power;
    /**
    * 전원상태변경요청 
    */
    private Integer requestPower;
    /**
    * 요청고객일련번호 
    */
    private Integer requestUserNo;
    /**
    * 요청날짜 
    */
    private String requestDate;
    /**
    * CL 
    */
    private String cl;
    /**
    * 등록일시 
    */
    private String regDt2;
    /**
    * 모드 
    */
    private String modeCd;
    /**
    * 모델 
    */
    private String deviceCd;    
}
