package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.mem.dao.CalculateStatusSAPSynthesisDao;
import com.ceragem.crm.mem.model.CalculateStatusSAPDayVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CalculateStatusSAPSynthesisService
 * @author    안재홍
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    일별사용SAP(설치일기준) Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CalculateStatusSAPSynthesisService extends AbstractCrmService {
   @Autowired
   CalculateStatusSAPSynthesisDao dao;

   @Autowired
   CrmApiService apiService;
   
   @Value("${spring.api.url.sap}")
   String apiUrlSap;
   
   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public int calculateStatusSAPSynthesisn(Object param)  throws Exception {
       String url = apiUrlSap + "/pr";
       CrmApiResultVo<CalculateStatusSAPDayVo> result = apiService.getApiResultVo(url, param, "POST", false, CalculateStatusSAPDayVo.class);
       if (!result.isSuccess())
           throw new EzAjaxException(result.getMessage());
       return 1;
   }
}
