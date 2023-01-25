package com.ceragem.crm.api.model;

import java.util.List;

import com.ceragem.crm.common.model.EzPaginationInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmApiPagingPayload<T> {
	private List<T> list;
	private EzPaginationInfo pagination;

}
