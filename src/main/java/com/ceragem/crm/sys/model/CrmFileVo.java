package com.ceragem.crm.sys.model;

import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmFileVo extends CrmFileBaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileCtgryCd;

	public String getFileSizeText() {
		return Utilities.getSizeString(getFileSize()) + "B";
	};
}
