package com.ceragem.crm.api.model;

import java.util.List;

import com.ceragem.crm.common.util.Constants;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmApiResultListVo<T> /* extends ResponseEntity<T> */
{

	private String code;
	private String message;

	private String systemCd;

	private String timestamp;
	private List<T> payload;

	Class<T> clz;

	public CrmApiResultListVo() {
		
	}
	public boolean isSuccess() {
		return Constants._API_CODE_OK.equals(code);
	}
	public List<T> getList(){
		return payload;
	}
	
	public void getGridData() {
		Utilities.getGridData(getList(), null);
	}
}
