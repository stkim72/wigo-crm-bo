package com.ceragem.crm.bos.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BosSmallCdVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6824372224672580105L;
	String cmGrpCd;
	String cmGrpCdNm;
	String cmCd;
	String cmCdNm;
	String cmCdDesc;
	String useYn;
	int sortOrdr;
}
