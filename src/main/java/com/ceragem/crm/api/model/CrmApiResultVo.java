package com.ceragem.crm.api.model;

import com.ceragem.crm.common.util.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmApiResultVo<T> /* extends ResponseEntity<T> */
{

	private String code;
	private String message;

	private String systemCd;

	private String timestamp;
	private T payload;

	
	Class<T> clz;

	public CrmApiResultVo() {
		
	}
	public boolean isSuccess() {
		return Constants._API_CODE_OK.equals(code);
	}
	
}
