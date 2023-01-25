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
import com.ceragem.crm.cst.dao.CrmCustHshldBasDao;
import com.ceragem.crm.cst.model.CrmCustHshldBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustHshldBasService
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM고객가구기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustHshldBasService extends AbstractCrmService {
   @Autowired
   CrmCustHshldBasDao dao;
   
	@Autowired
	CrmApiService apiService;

	@Value("${spring.api.url.customer-bond}")
	String apiUrl;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public EzMap getGridList(Map<String,Object> param) throws Exception {
		return apiService.getGridData(apiUrl +"/list", param, "GET", true);

	}

	public Map<String, Object> getData(Map<String,Object> param) throws Exception {

		return apiService.getData(apiUrl + "/" + param.get("itgCustNo") , param , "GET", true );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustHshldBasVo> getList(Object param) throws Exception {
		CrmApiPagingResultVo<CrmCustHshldBasVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
				"GET", true, CrmCustHshldBasVo.class);
		return result.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustHshldBasVo get(Object param) throws Exception {
//		CrmCustHshldBasVo vo = (CrmCustHshldBasVo) param;
		CrmApiResultVo<CrmCustHshldBasVo> result = apiService.getApiResultVo(apiUrl + "/list/detail", param,
				"GET", true, CrmCustHshldBasVo.class);
		return result.getPayload();
	}

	@Override
	public int update(Object param) throws Exception {
		CrmApiResultVo<CrmCustHshldBasVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
				CrmCustHshldBasVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}

	@Override
	public int insert(Object param) throws Exception {
		
		CrmApiResultVo<CrmCustHshldBasVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
				CrmCustHshldBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

	@Override
	public int delete(Object param) throws Exception {
		CrmCustHshldBasVo vo = (CrmCustHshldBasVo) param;
//		CrmApiResultVo<CrmCustHshldBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getRepHshldNo() + "/" + vo.getItgCustNo(), param,
		CrmApiResultVo<CrmCustHshldBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getItgCustNo() , param,
				"DELETE", false, CrmCustHshldBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}
}
