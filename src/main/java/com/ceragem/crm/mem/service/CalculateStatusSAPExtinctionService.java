package com.ceragem.crm.mem.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.mem.dao.CalculateStatusSAPExtinctionDao;
import com.ceragem.crm.mem.model.CalculateStatusSAPDayVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName CalculateStatusSAPExtinctionService
 * @author 안재홍
 * @date 2022. 6. 9.
 * @Version 1.0
 * @description 일별사용SAP(설치일기준) Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CalculateStatusSAPExtinctionService extends AbstractCrmService {
	@Autowired
	CalculateStatusSAPExtinctionDao dao;

	@Autowired
	CrmApiService apiService;

	@Value("${spring.api.url.sap}")
	String apiUrlSap;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@SuppressWarnings("unchecked")
	public int calculateStatusSAPExtinction(Object param) throws Exception {

		String url = apiUrlSap + "/sade";
		CrmApiResultVo<CalculateStatusSAPDayVo> result = apiService.getApiResultVo(url, param, "POST", false,
				CalculateStatusSAPDayVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.convertValue(param, Map.class);
		map.remove("items");

		String point = dao.selectExtncPoint(map);
		if ("".equals(point) || point == null) {
			point = "0";
		}
		map.put("extncPointScore", Integer.parseInt(point));

		if (dao.selectMonthPointCkExtinction(map) > 0) {
			return dao.updateMonthPointExtinction(map);
		} else {
			return dao.insertMonthPointExtinction(map);
		}
	}
}
