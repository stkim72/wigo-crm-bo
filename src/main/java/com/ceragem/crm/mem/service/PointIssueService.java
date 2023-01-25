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
import com.ceragem.crm.mem.dao.PointIssueDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.mem.model.PointIssueVo;

/**
 * 
 * @ClassName   PointIssueService
 * @author      황재희
 * @date        2022. 4. 18.
 * @Version     1.0
 * @description 포인트 발행 목록 Service
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PointIssueService extends AbstractCrmService {
   @Autowired
   PointIssueDao dao;
   
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
	   PointIssueVo vo = Utilities.beanToBean(param,PointIssueVo.class);
	 
	   // CRM 포인트 적립
	   // 22.09.22 김은성 추가
	   String url = apiUrl + "/deposit/CRM/"+vo.getChitNo();
	   
	   // 포인트 수기 차감일 경우는 CRM 포인트 사용 API 로 처리
	   if( "940".equals( vo.getPblsDivCd() ) ) {
		   url = apiUrl + "/withdrawal/CRM/"+vo.getChitNo();
		   vo.setOccurPointScore( ""+ Math.abs( Integer.valueOf( vo.getOccurPointScore() ) ) );
	   }

	   CrmApiResultVo<PointIssueVo> result = apiService.getApiResultVo(url, param, "POST", false, PointIssueVo.class);
	   if (!result.isSuccess())
		   throw new EzAjaxException(result.getMessage());
	   
	   return 1;
   }
   
   public PointIssueVo selectUserInfo(Object param)  throws Exception{
		return dao.selectUserInfo(param);
	}
   
   public EzMap savePointScoreList(List<? extends BaseVo> list) throws Exception {
	   List<EzMap> result = new ArrayList<EzMap>();
	   for (int i = 0; i < list.size(); i++) {
		   result.add(savePointScore(list.get(i)));
	   }
	   return Utilities.getSaveResult(result);
   }
   
   public PointIssueVo getUsePointForBos(Object param)  throws Exception{
		return dao.getUsePointForBos(param);
  }
   
   public PointIssueVo getOccurPointForBos(Object param)  throws Exception{
		return dao.getOccurPointForBos(param);
   }
}