package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpBasVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String custGrpNo;
	
	private String custGrpTypeCd;
	
	private String custGrpNm;
	
	private String custGrpCtnts;
	
	private String custGrpExtrSqlCtnts;
	
	private String ottpYn;
	
	private String useYn;
	
	private String useStaDay;
	
	private String useEndDay;
	
	private Integer custCnt;
	
	private String regrInfo;
}
