package com.ceragem.crm.cst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.dao.BlackCusDao;
import com.ceragem.crm.cst.model.BlackCusVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCampBasService
 * @author    김성태
 * @date    2022. 4. 7.
 * @Version    1.0
 * @description    CRM캠페인기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class BlackCusService extends AbstractCrmService {
   @Autowired
   BlackCusDao dao;
   @Autowired
   CrmApiService apiService;

	@Value("${spring.api.url.customer-black}")
	String apiUrl;
   
   
   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public <T> List<T> getBlackHistoryList(Object param)  throws Exception{
		return dao.getBlackHistoryList(param);
	}
   public int getBlackHistoryCount(Object param) throws Exception {
		return dao.getBlackHistoryCount(param);
	}
   
   public EzMap saveBlackList(List<? extends BaseVo> list) throws Exception {
	   List<EzMap> result = new ArrayList<EzMap>();
	   for (int i = 0; i < list.size(); i++) {
		   result.add(saveBlack(list.get(i)));
	   }
	   return Utilities.getSaveResult(result);
   }
   
   public EzMap saveBlack(BaseVo vo) throws Exception {
	   return Utilities.getUpdateResult(updateblack(vo), vo);
   }
   
   public int updateblack(Object param)  throws Exception {
	   CrmApiResultVo<BlackCusVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false, BlackCusVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
   }
   
   public EzMap deleteBlackList(List<? extends BaseVo> list) throws Exception {
	   List<EzMap> result = new ArrayList<EzMap>();
	   for (int i = 0; i < list.size(); i++) {
		   result.add(deleteBlack(list.get(i)));
	   }
	   return Utilities.getSaveResult(result);
   }
   
   public EzMap deleteBlack(BaseVo vo) throws Exception {
	   return Utilities.getUpdateResult(delBlack(vo), vo);
   }
   
   public int delBlack(Object param)  throws Exception {
	   BlackCusVo vo = Utilities.beanToBean(param,BlackCusVo.class);
	   String url = apiUrl + "/" + vo.getBllkCustHstSeq();
	   CrmApiResultVo<BlackCusVo> result = apiService.getApiResultVo(url, param, "DELETE", false, BlackCusVo.class);
	   if (!result.isSuccess())
		   throw new EzAjaxException(result.getMessage());
	   return 1;
   }
   
   // 블랙 고객발송 관련
   @SuppressWarnings("unchecked")
public EzMap saveTargetSendInfo(EzMap param) throws Exception {
       List<EzMap> result = new ArrayList<EzMap>();
       List<EzMap> targetDataList = (List<EzMap>) param.get("targetData");
       String sSendType = (String) param.get("sendType");
       /* String sCustGrpNo = (String) param.get("custGrpNo"); */
       String sClientId = (String) param.get("clientId");
       String sCampId = (String) param.get("campId");
       String sEmailYn = "";
       String sSmsYn = "";

       for (int i = 0; i < targetDataList.size(); i++) {
           Map<String, Object> eachData = targetDataList.get(i);
           
           sEmailYn = (String) eachData.get("emailRcvAgreeYn"); // 이메일 동의여부
           sSmsYn = (String) eachData.get("smsRcvAgreeYn"); // sms동의 여부
           
           if(sEmailYn == null)
           {
               sEmailYn = "N";
           }
           if(sSmsYn == null)
           {
               sSmsYn = "N";
           }

           /* eachData.put("custGrpNo", sCustGrpNo); */
           eachData.put("memSeq", (i+1));
           eachData.put("clientId", sClientId);
           eachData.put("campId", sCampId);

           /*
           if(sSendType.equals("003")){    //이메일
               result.add(Utilities.getInsertResult(insertTargetByMail(eachData), eachData));
           }else{  //문자,알림톡
               result.add(Utilities.getInsertResult(insertTargetBySms(eachData), eachData));
           }
           */
           if(sSendType.equals("003")){    //이메일
               if(sEmailYn != null && sEmailYn.equals("Y"))
               {
                   result.add(Utilities.getInsertResult(insertTargetByMail(eachData), eachData));
               }
           }else{  //문자,알림톡
               if(sSmsYn.equals("Y"))
               {
                   result.add(Utilities.getInsertResult(insertTargetBySms(eachData), eachData));
               }
           }
       }

       return Utilities.getSaveResult(result);
   }
   
   public int insertTargetBySms(Object param) throws Exception {
       return dao.insertTargetBySms(param);
   }
   
   public int insertTargetByMail(Object param) throws Exception {
       return dao.insertTargetByMail(param);
   }
   
   public int getTargetCustSendListCount(Object param) throws Exception {
       return dao.selectTargetCustSendListCount(param);
   }

   public <T> List<T> getTargetCustSendList(Object param) throws Exception {
       return dao.selectTargetCustSendList(param);
   }
   // 블랙 고객발송 관련
}
