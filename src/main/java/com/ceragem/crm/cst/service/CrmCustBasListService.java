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
import com.ceragem.crm.cst.dao.CrmCustBasListDao;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustBasListService
 * @author    user
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustBasListService extends AbstractCrmService {
   @Autowired
   CrmCustBasListDao dao;

	@Autowired
	CrmApiService apiService;
	
	@Value("${spring.api.url.customer}")
	String apiUrl;
	
	@Override
	public ICrmDao getDao() {
		return dao;
	}
	
	// 좌측 그리드 목록 
	public EzMap getGridList(Object param) throws Exception {
		return apiService.getGridData(apiUrl + "/list", param, "GET", true);

	}
	
	// 고객 단건조회
	public Map<String, Object> getData(Object param) throws Exception {
		return apiService.getData(apiUrl + "/" + param, param, "GET", true);

	}
	
	// 
	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustBasVo> getList(Object param) throws Exception {
		CrmApiPagingResultVo<CrmCustBasVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
				"GET", true, CrmCustBasVo.class);
		return result.getList();
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public CrmCustBasVo get(Object param) throws Exception {
//		CrmCustBasVo vo = (CrmCustBasVo) param;
//		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getCntplcSeq(), param,
//				"GET", true, CrmCustBasVo.class);
//		return result.getPayload();
//	}

	@Override
	public int update(Object param) throws Exception {
		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
				CrmCustBasVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}
}
