package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.bos.model.BosContractVo;
import com.ceragem.crm.bos.service.BosApiService;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.dao.CrmCustBosCntrtHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustBosCntrtTxnService
 * @author    user
 * @date    2022. 5. 12.
 * @Version    1.0
 * @description    CRMBOS계약내역 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustBosCntrtTxnHCService extends AbstractCrmService {
	   @Autowired
	   CrmCustBosCntrtHstDao dao;
		
		@Autowired
		BosApiService bosApiService;

		@Override
		public ICrmDao getDao() {
			return dao;
		}

		public EzMap getGridList(EzMap param) throws Exception {		
			List<BosContractVo> dataList = bosApiService.getContractList((String)param.get("itgCustNo") , null , null, "1202");
			return Utilities.getGridData(dataList);	 
		}

//		public Map<String, Object> getData(Object param) throws Exception {
//			return apiService.getData(apiUrl + "/" + param, param, "GET", true);
	//
//		}
	//
//		@SuppressWarnings("unchecked")
//		@Override
//		public List<CrmCustPhnCnslHistVo> getList(Object param) throws Exception {
//			CrmApiPagingResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", param,
//					"GET", true, CrmCustPhnCnslHistVo.class);
//			return result.getList();
//		}
	//
//		@SuppressWarnings("unchecked")
//		@Override
//		public CrmCustPhnCnslHistVo get(Object param) throws Exception {
//			CrmCustPhnCnslHistVo vo = (CrmCustPhnCnslHistVo) param;
//			CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl + "/list/detail", param,
//					"GET", true, CrmCustPhnCnslHistVo.class);
//			return result.getPayload();
//		}
	//
//		@Override
//		public int update(Object param) throws Exception {
//			CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl, param, "PUT", false,
//					CrmCustPhnCnslHistVo.class);
	//
//			if (!result.isSuccess())
//				throw new EzAjaxException(result.getMessage());
//			return 1;
	//
//		}
	//
//		@Override
//		public int insert(Object param) throws Exception {
//			
//			CrmApiResultVo<CrmCustPhnCnslHistVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
//					CrmCustPhnCnslHistVo.class);
//			if (!result.isSuccess())
//				throw new EzAjaxException(result.getMessage());
//			return 1;
//		}
}
