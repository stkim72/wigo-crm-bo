package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    PartnerHomeVo
 * @author    김성태
 * @date    2022. 4. 7.
 * @Version    1.0
 * @description    CRM고객기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class PartnerHomeVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
	/**
	 * 제휴구분(조회조건) 
	 */
	private String searchCprtDivCd;
	/**
     * 제휴사상태(조회조건) 
     */
    private String searchCprtStatusCd;
    /**
     * 제휴사명(조회조건)
     */
    private String searchCprtCmpNm;
    /**
    * 제휴사코드 
    */
    private String cprtCmpNo;
    /**
     * 제휴사명 
     */
    private String cprtCmpNm;
    /**
     * 제휴구분 
     */
    private String cprtDivCd;
    /**
     * 제휴사상태 
     */
    private String cprtStatusCd;
    /**
     * 등록일자 
     */
    private String cprtCmpRegYmd;
    /**
     * 전화번호 
     */
    private String telNo;
    /**
     * 우편번호 
     */
    private String zipCd;
    /**
     * 주소1내용 
     */
    private String addr1Ctnts;
    /**
     * 주소2내용 
     */
    private String addr2Ctnts;
    /**
     * 사업자등록번호 
     */
    private String bizNo;
    /**
     * 제휴회사유형코드 
     */
    private String cprtCmpTypeCd;
    /**
     * 제휴회사메모내용 
     */
    private String cprtCmpMemoCtnts;
    /**
     * 제휴회사담당임직원번호 
     */
    private String cprtCmpChrgExecvdempNo;
    /**
     * 임직원명 
     */
    private String execvdempNm;
    /**
     * 임직원명 
     */
    private String deptNm;
    /**
     * 임직원명 
     */
    private String rspofNm;
    /**
     * 생년월일 
     */
    private String birthday;
    /**
     * 담당자전화번호 
     */
    private String picTelNo;
    /**
     * 성별코드 
     */
    private String gndrCd;
    /**
     * 이메일주소 
     */
    private String emailAddr;
    /**
     * 제휴회사식별번호 
     */
    private String cprtCmpDifyNo;
    /**
     * 통합고객번호 
     */
    private String itgCustNo;
    /**
     * 이동전화번호 
     */
    private String mphonNo;
    /**
     * 암호화값 
     */
    private String mphonNoEncVal;
    /**
     * 뒤자리번호 
     */
    private String mphonBkDgtNo;
    /**
     * 제휴회사카드번호 
     */
    private String cprtCmpCardNo;
    /**
    * 등록채널코드 
    */
    private String regChlCd;
    /**
     * 제휴회사식별번호
     */
    private String cprtCmpIdfyNo;
    
    private String custNm;
    private String empNo;
}
