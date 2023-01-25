package com.ceragem.crm.mem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.dao.BlackCusPointIssueDao;
import com.ceragem.crm.mem.model.BlackCusPointIssueVo;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    BlackCusPointIssueService
 * @author    황재희
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    부정적립 포인트 관리 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class BlackCusPointIssueService extends AbstractCrmService {
   @Autowired
   BlackCusPointIssueDao dao;
   
   @Autowired
   CrmApiService apiService;

   @Value("${spring.api.url.point}")
   String apiUrl;
   
   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public EzMap savePointScore(BaseVo vo) throws Exception {
	   return Utilities.getUpdateResult(updatePointScore(vo), vo);
   }
   
   public int updatePointScore(Object param)  throws Exception {
	   BlackCusPointIssueVo vo = Utilities.beanToBean(param,BlackCusPointIssueVo.class);
	   String url = apiUrl + "/deposit/CRM/"+vo.getChitNo();
	   CrmApiResultVo<BlackCusPointIssueVo> result = apiService.getApiResultVo(url, param, "POST", false, BlackCusPointIssueVo.class);
	   if (!result.isSuccess())
		   throw new EzAjaxException(result.getMessage());
	   return 1;
   }
   
   public EzMap savePointScoreList(List<? extends BaseVo> list) throws Exception {
	   List<EzMap> result = new ArrayList<EzMap>();
	   for (int i = 0; i < list.size(); i++) {
		   result.add(savePointScore(list.get(i)));
	   }
	   return Utilities.getSaveResult(result);
   }
}
