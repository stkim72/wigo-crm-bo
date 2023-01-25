package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CusCeraCkListVo
 * @author    황의겸
 * @date    2022. 5. 2.
 * @Version    1.0
 * @description    CRM고객세라체크이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusCeraCkListVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
    * 고객번호 
    */
    private String userId;
    /**
    * 뇌파측정번호 
    */
    private String neuroMeasureNo;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 측정시작일 
    */
    private String startTime;
    /**
    * 두뇌스트레스 
    */
    private String cstressCd;
    /**
    * 멘탈헬스스코어점수 
    */
    private Double cbrainScore;
    /**
    * 집중도 
    */
    private String concentrationCd;
    /**
    * 접중도점수 
    */
    private Double concentration;
    /**
    * 두뇌활동정도 
    */
    private String mentalCd;
    /**
    * 두뇌활동정도수치 
    */
    private Double mental;
    /**
    * 좌우뇌불균형 
    */
    private String balanceCd;
    /**
    * 좌뇌비율 
    */
    private Double leftBalanceRatio;
    /**
    * 우뇌비율 
    */
    private Double rightBalanceRatio;
    /**
    * 피로도 
    */
    private String bodyFatigueCd;
    /**
    * 피도로점수 
    */
    private Double bodyFatigue;
    /**
    * 신경계건강도 
    */
    private String nerveHealthCd;
    /**
    * 신경계건강도점수 
    */
    private Double nerveHealth;
    /**
    * 활력도 
    */
    private String bodyEnergyCd;
    /**
    * 혈압(수축기) 
    */
    private String bpSysCd;
    /**
    * 혈압(이완기) 
    */
    private String bpDiaCd;
    /**
    * 혈압(수축기)수치 
    */
    private Double bpSys;
    /**
    * 혈압(이완기)수치 
    */
    private Double bpDia;
    /**
    * 맥압 
    */
    private String bpPowerCd;
    /**
    * 맥압수치 
    */
    private Double bpPower;
    /**
    * 혈당 
    */
    private String blCd;
    /**
    * 혈당수치 
    */
    private Double blVl;
    /**
    * 체지방률 
    */
    private String fatCd;
    /**
    * 근육량 
    */
    private String muscleCd;
    /**
    * 체지방률수치 
    */
    private Double fat;
    /**
    * 근육량수치 
    */
    private Double muscle;
    /**
    * BMI 
    */
    private String bmiCd;
    /**
    * BMI수치 
    */
    private Double bmi;
    /**
    * 키 
    */
    private Double height;
    /**
    * 몸무게 
    */
    private Double weight;
    /**
    * 복부둘레 
    */
    private String abdRoundCd;
    /**
    * 복부둘레수치 
    */
    private Double abdRound;
}
