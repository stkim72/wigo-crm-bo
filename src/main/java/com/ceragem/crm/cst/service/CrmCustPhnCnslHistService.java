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
import com.ceragem.crm.cst.dao.CrmCustPhnCnslHistDao;
import com.ceragem.crm.cst.model.CrmCustPhnCnslHistVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustPhnCnslHistService
 * @author    user
 * @date    2022. 5. 6.
 * @Version    1.0
 * @description    CRM고객상담이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustPhnCnslHistService extends AbstractCrmService {
   @Autowired
   CrmCustPhnCnslHistDao dao;

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
	public List<CrmCustPhnCnslHistVo> getList(Object param) throws Exception {
		CrmApiPagingResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
				"GET", true, CrmCustPhnCnslHistVo.class);
		return result.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustPhnCnslHistVo get(Object param) throws Exception {
//		CrmCustPhnCnslHistVo vo = (CrmCustPhnCnslHistVo) param;
		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl + "/list/detail", param,
				"GET", true, CrmCustPhnCnslHistVo.class);
		return result.getPayload();
	}

	@Override
	public int update(Object param) throws Exception {
		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
				CrmCustPhnCnslHistVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}

	@Override
	public int insert(Object param) throws Exception {
		
		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
				CrmCustPhnCnslHistVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

//	@Override
//	public int delete(Object param) throws Exception {
//		CrmCustPhnCnslHistVo vo = (CrmCustPhnCnslHistVo) param;
//		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getCntplcSeq(), param,
//				"DELETE", false, CrmCustPhnCnslHistVo.class);
//		if (!result.isSuccess())
//			throw new EzAjaxException(result.getMessage());
//		return 1;
//	}
}
