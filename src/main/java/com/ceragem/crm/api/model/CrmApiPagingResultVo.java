package com.ceragem.crm.api.model;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Constants;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmApiPagingResultVo<T> {

	private String code;
	private String message;

	private String systemCd;

	private String timestamp;
	private CrmApiPagingPayload<T> payload;

	public CrmApiPagingResultVo() {

	}
	public boolean isSuccess() {
		return Constants._API_CODE_OK.equals(code);
	}

	public List<T> getList() {
		if (payload == null)
			return null;
		return payload.getList();
	}

	public EzPaginationInfo getPagination() {
		if (payload == null)
			return null;
		return payload.getPagination();
	}

	public EzMap getGridData() {
		if (payload == null)
			return null;
		if (getList() == null)
			return null;
		return Utilities.getGridData(payload.getList(), payload.getPagination());
	}
}
