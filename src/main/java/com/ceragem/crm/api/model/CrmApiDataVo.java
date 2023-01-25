package com.ceragem.crm.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Constants;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmApiDataVo {

	private String code;
	private String message;

	private String systemCd;

	private String timestamp;
	private Object payload;

	public CrmApiDataVo() {

	}

	public boolean isSuccess() {
		return Constants._API_CODE_OK.equals(code);
	}

	public boolean hasNoData() {
		return Constants._API_CODE_NO_DATA.equals(code);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getList() {
		if (payload == null)
			return null;
		if (payload instanceof List) {
			return (List<Map<String, Object>>) payload;
		} else if (payload instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) payload;
			if (map.containsKey("pagination"))
				return (List<Map<String, Object>>) map.get("list");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getObject() {
		if (payload == null)
			return null;
		if (payload instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) payload;
			if (!map.containsKey("pagination"))
				return map;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public EzPaginationInfo getPagination() {
		if (payload == null)
			return null;
		if (payload instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) payload;
			if (map.containsKey("pagination")) {
				return Utilities.mapToBean((Map<String,Object>) map.get("pagination"), EzPaginationInfo.class);
			}
		}
		return null;
	}

	public EzMap getGridData() {
		if (!isSuccess() && !hasNoData())
			throw new EzAjaxException(message);
		EzPaginationInfo pagination = getPagination();
		List<Map<String, Object>> list = getList();
		if (list == null)
			list = new ArrayList<Map<String, Object>>();
		return Utilities.getGridData(list, pagination);

	}
}
