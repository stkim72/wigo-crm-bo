package com.ceragem.crm.camp.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCampTempltBasVo
 * @author    user
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    캠페인템플릿기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCampTempltBasVo extends BaseVo {
	

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 캠페인템블릿기본번호 
	 */
	private String campTempltBasNo;
	/**
	 * 템플릿유형코드 
	 */
	private String tmpltTypeCd;
	private String tmpltTypeCdNm;
	/**
	 * 템플릿명 
	 */
	private String tmpltNm;
	/**
	 * 템플릿내용 
	 */
	private String tmpltCtnts;
	/**
	 * 사용여부 
	 */
	private String useYn;
	private String useYnNm;

	/**
	 * 바코드타입 
	 */
	private String barcodeType;
	/**
	 * 바코드생성폭 
	 */
	private String barcodeWidth;
	/**
	 * 바코드생성높이 
	 */
	private String barcodeHeight;
	/**
	 * 바코드삽입위치 X 좌표 
	 */
	private String barcodePosX;
	/**
	 * 바코드삽입위치 Y 좌표 
	 */
	private String barcodePosY;
	/**
	 * 바코드를 생성할 값 
	 */
	private String barcodeValue;


	private String barcodeOrgImg;

	private String barcodeImg;
	
	private String z023Group;
	


}
