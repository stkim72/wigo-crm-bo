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
import com.ceragem.crm.cst.dao.CrmCustAsSubmitHistDao;
import com.ceragem.crm.cst.model.CrmCustAsSubmitHistVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustAsSubmitHistService
 * @author    user
 * @date    2022. 5. 12.
 * @Version    1.0
 * @description    CRM고객AS접수이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustAsSubmitHistService extends AbstractCrmService {
   @Autowired
   CrmCustAsSubmitHistDao dao; 

	@Autowired
	CrmApiService apiService;

	@Value("${spring.api.url.as-hist}")
	String apiUrl;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public EzMap getGridList(Map<String,Object> param) throws Exception {
		return apiService.getGridData(apiUrl +"/list", param, "GET", true);

	}

	public Map<String, Object> getData(Map<String,Object> param) throws Exception {

		return apiService.getData(apiUrl + "/" + param.get("itgCustNo") + "/" + param.get("hstSeq") , param , "GET", true );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustAsSubmitHistVo> getList(Object param) throws Exception {
		CrmApiPagingResultVo<CrmCustAsSubmitHistVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
				"GET", true, CrmCustAsSubmitHistVo.class);
		return result.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustAsSubmitHistVo get(Object param) throws Exception {
		CrmCustAsSubmitHistVo vo = (CrmCustAsSubmitHistVo) param;
		
		//AS상세 단건 조회
		CrmApiResultVo<CrmCustAsSubmitHistVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getItgCustNo() + "/" + vo.getHstSeq(), param,
				"GET", true, CrmCustAsSubmitHistVo.class);

		//AS상세 총건수 조회
		CrmApiResultVo<CrmCustAsSubmitHistVo> count = apiService.getApiResultVo(apiUrl + "/count/" + vo.getItgCustNo() , param,
				"GET", true, CrmCustAsSubmitHistVo.class);
		
		result.getPayload().setTotalCnt(count.getPayload().getTotalCnt());
		result.getPayload().setCancelCnt(count.getPayload().getCancelCnt());		
		return result.getPayload();
	}

	@Override
	public int update(Object param) throws Exception {
		CrmApiResultVo<CrmCustAsSubmitHistVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
				CrmCustAsSubmitHistVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}

	@Override
	public int insert(Object param) throws Exception {
		
		CrmApiResultVo<CrmCustAsSubmitHistVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
				CrmCustAsSubmitHistVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

//	@Override
//	public int delete(Object param) throws Exception {
//		CrmCustAsSubmitHistVo vo = (CrmCustAsSubmitHistVo) param;
////		CrmApiResultVo<CrmCustAsSubmitHistVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getRepHshldNo() + "/" + vo.getItgCustNo(), param,
//		CrmApiResultVo<CrmCustAsSubmitHistVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getItgCustNo() , param,
//				"DELETE", false, CrmCustAsSubmitHistVo.class);
//		if (!result.isSuccess())
//			throw new EzAjaxException(result.getMessage());
//		return 1;
//	}
}
