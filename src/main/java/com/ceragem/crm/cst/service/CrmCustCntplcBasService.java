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
import com.ceragem.crm.cst.dao.CrmCustCntplcBasDao;
import com.ceragem.crm.cst.model.CrmCustCntplcBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmCustCntplcBasService
 * @author 안재홍
 * @date 2022. 4. 7.
 * @Version 1.0
 * @description CRM연락처기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustCntplcBasService extends AbstractCrmService {
	@Autowired
	CrmCustCntplcBasDao dao;
	@Autowired
	CrmApiService apiService;

	@Value("${spring.api.url.customer-contact}")
	String apiUrl;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public EzMap getGridList(Object param) throws Exception {
		return apiService.getGridData(apiUrl + "/list", param, "GET", true);

	}

	public Map<String, Object> getData(Object param) throws Exception {
		return apiService.getData(apiUrl + "/" + param, param, "GET", true);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustCntplcBasVo> getList(Object param) throws Exception {
		CrmApiPagingResultVo<CrmCustCntplcBasVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
				"GET", true, CrmCustCntplcBasVo.class);
		return result.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustCntplcBasVo get(Object param) throws Exception {
		CrmCustCntplcBasVo vo = (CrmCustCntplcBasVo) param;
		CrmApiResultVo<CrmCustCntplcBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getCntplcSeq(), param,
				"GET", true, CrmCustCntplcBasVo.class);
		return result.getPayload();
	}

	@Override
	public int update(Object param) throws Exception {
		CrmApiResultVo<CrmCustCntplcBasVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
				CrmCustCntplcBasVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}

	@Override
	public int insert(Object param) throws Exception {
		
		CrmApiResultVo<CrmCustCntplcBasVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
				CrmCustCntplcBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

	@Override
	public int delete(Object param) throws Exception {
		CrmCustCntplcBasVo vo = (CrmCustCntplcBasVo) param;
		CrmApiResultVo<CrmCustCntplcBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getCntplcSeq(), param,
				"DELETE", false, CrmCustCntplcBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}
}
