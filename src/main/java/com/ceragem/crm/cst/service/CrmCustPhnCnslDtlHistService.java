package com.ceragem.crm.cst.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiPagingResultVo;
import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.cst.dao.CrmCustPhnCnslDtlHistDao;
import com.ceragem.crm.cst.model.CrmCustPhnCnslDtlHistVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustPhnCnslDtlHistService
 * @author    user
 * @date    2022. 5. 13.
 * @Version    1.0
 * @description    CRM고객상담상세이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustPhnCnslDtlHistService extends AbstractCrmService {
   @Autowired
   CrmCustPhnCnslDtlHistDao dao;

	@Autowired
	CrmApiService apiService;

	@Value("${spring.api.url.ctc-hist}")
	String apiUrl;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public EzMap getGridList(Object param) throws Exception {
		return apiService.getGridData(apiUrl +"/list", param, "GET", true);

	}

	public Map<String, Object> getData(Object param) throws Exception {
		return apiService.getData(apiUrl + "/" + param, param, "GET", true);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustPhnCnslDtlHistVo> getList(Object param) throws Exception {
		CrmApiPagingResultVo<CrmCustPhnCnslDtlHistVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
				"GET", true, CrmCustPhnCnslDtlHistVo.class);
		return result.getList();
	}

//	@SuppressWarnings("unchecked")
	public CrmCustPhnCnslDtlHistVo get(String param) throws Exception {
//		CrmCustPhnCnslDtlHistVo vo = (CrmCustPhnCnslDtlHistVo) param;
		CrmApiResultVo<CrmCustPhnCnslDtlHistVo> result = apiService.getApiResultVo(apiUrl + "/" + param , param,
				"GET", true, CrmCustPhnCnslDtlHistVo.class);
		return result.getPayload();
	}

	@Override
	public int update(Object param) throws Exception {
		CrmApiResultVo<CrmCustPhnCnslDtlHistVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
				CrmCustPhnCnslDtlHistVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}

	@Override
	public int insert(Object param) throws Exception {
		
		CrmApiResultVo<CrmCustPhnCnslDtlHistVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
				CrmCustPhnCnslDtlHistVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}
}
