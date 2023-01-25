package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.bos.model.BosCrmServiceVo;
import com.ceragem.crm.bos.service.BosApiService;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.dao.CrmCustBosHcHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustBosHcHstService
 * @author    user
 * @date    2022. 5. 25.
 * @Version    1.0
 * @description    CRMBOS홈체험이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustBosHcHstService extends AbstractCrmService {
   @Autowired
   CrmCustBosHcHstDao dao;
	
	@Autowired
	BosApiService bosApiService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

//	public List<BosContractVo> getGridList(EzMap param) throws Exception {
	public EzMap getGridList(EzMap param) throws Exception {		
		// 파라미터 
		// 고객번호 , 조회시작일자 , 조회종룡일자

		List<BosCrmServiceVo> dataList = bosApiService.getCrmServiceList((String)param.get("itgCustNo") , "19000101" , "99991231");
//		List<BosCrmServiceVo> dataList = bosApiService.getCrmServiceList((String)param.get("itgCustNo") , "00000000" , "99999999");
		return Utilities.getGridData(dataList);	 
	}

//	public Map<String, Object> getData(Object param) throws Exception {
//		return apiService.getData(apiUrl + "/" + param, param, "GET", true);
//
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<CrmCustPhnCnslHistVo> getList(Object param) throws Exception {
//		CrmApiPagingResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
//				"GET", true, CrmCustPhnCnslHistVo.class);
//		return result.getList();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public CrmCustPhnCnslHistVo get(Object param) throws Exception {
//		CrmCustPhnCnslHistVo vo = (CrmCustPhnCnslHistVo) param;
//		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl + "/list/detail", param,
//				"GET", true, CrmCustPhnCnslHistVo.class);
//		return result.getPayload();
//	}
//
//	@Override
//	public int update(Object param) throws Exception {
//		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
//				CrmCustPhnCnslHistVo.class);
//
//		if (!result.isSuccess())
//			throw new EzAjaxException(result.getMessage());
//		return 1;
//
//	}
//
//	@Override
//	public int insert(Object param) throws Exception {
//		
//		CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
//				CrmCustPhnCnslHistVo.class);
//		if (!result.isSuccess())
//			throw new EzAjaxException(result.getMessage());
//		return 1;
//	}
}
