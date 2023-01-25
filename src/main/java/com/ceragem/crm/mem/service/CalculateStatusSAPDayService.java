package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.mem.dao.CalculateStatusSAPDayDao;
import com.ceragem.crm.mem.model.CalculateStatusSAPDayVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CalculateStatusSAPDayService
 * @author 안재홍
 * @date 2022. 6. 9.
 * @Version 1.0
 * @description 일별사용SAP(설치일기준) Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CalculateStatusSAPDayService extends AbstractCrmService {
    @Autowired
    CalculateStatusSAPDayDao dao;

    @Autowired
    CrmApiService apiService;

    @Value("${spring.api.url.sap}")
    String apiUrlSap;

    @Override
    public ICrmDao getDao() {
        return dao;
    }

    public int calculateStatusSAPDay(Object param) throws Exception {
        String url = apiUrlSap + "/use";
        CrmApiResultVo<CalculateStatusSAPDayVo> result = apiService.getApiResultVo(url, param, "POST", false,
                CalculateStatusSAPDayVo.class);
        if (!result.isSuccess())
            throw new EzAjaxException(result.getMessage());

        if (dao.selectMonthPointCk(param) > 0) 
        {
            return dao.updateMonthPoint(param);
        }
        else
        {
            return  dao.insertMonthPoint(param);
        }
    }

}
