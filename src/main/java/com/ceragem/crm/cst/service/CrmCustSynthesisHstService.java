package com.ceragem.crm.cst.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.cst.dao.CrmCustSynthesisHstDao;
import com.ceragem.crm.cst.model.CrmCustSynthesisHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustSynthesisHstService
 * @author    user
 * @date    2022. 5. 25.
 * @Version    1.0
 * @description    CRM고객종합이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustSynthesisHstService extends AbstractCrmService {
   @Autowired
   CrmCustSynthesisHstDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}
	
	// 고객그룹 기본정보 관련
    @SuppressWarnings("unchecked")
    public <T> List<T> getGridList(Object param) throws Exception {
        
        List<CrmCustSynthesisHstVo> list = dao.selectList1(param);
        List<CrmCustSynthesisHstVo> list2 = dao.selectList2(param);
        List<CrmCustSynthesisHstVo> list3 = dao.selectList3(param);
        List<CrmCustSynthesisHstVo> list4 = dao.selectList4(param);
        List<CrmCustSynthesisHstVo> list5 = dao.selectList5(param);
        List<CrmCustSynthesisHstVo> list6 = dao.selectList6(param);
        List<CrmCustSynthesisHstVo> list7 = dao.selectList7(param);
        List<CrmCustSynthesisHstVo> list8 = dao.selectList8(param);
        
        int[] array = new int[8];
        
        array[0] = list.size();
        array[1] = list2.size();
        array[2] = list3.size();
        array[3] = list4.size();
        array[4] = list5.size();
        array[5] = list6.size();
        array[6] = list7.size();
        array[7] = list8.size();

        int maxNum = array[0];

        for (int j : array) {
            if (j > maxNum)
                maxNum = j;
        }
        
        List<EzMap> result = new ArrayList<EzMap>();
        
        for(int i=0; i<maxNum; i++)
        {
            EzMap resultMap = new EzMap();
            
            if(list.size() > i)
            {
                resultMap.put("itemNm", list.get(i).getItemNm());
                resultMap.put("istDcsDeBos", list.get(i).getIstDcsDeBos());
                resultMap.put("ordDe", list.get(i).getOrdDe());
            }
            else
            {
                resultMap.put("itemNm", "");
                resultMap.put("istDcsDeBos", "");
                resultMap.put("ordDe", "");
            }
            if(list2.size() > i)
            {
                resultMap.put("modelNm", list2.get(i).getModelNm());
                resultMap.put("endTime", list2.get(i).getEndTime());
                resultMap.put("iotCnt", list2.get(i).getIotCnt());
            }
            else
            {
                resultMap.put("modelNm", "");
                resultMap.put("endTime", "");
                resultMap.put("iotCnt", "");
            }
            if(list3.size() > i)
            {
                resultMap.put("crkCnt", list3.get(i).getCrkCnt());
                resultMap.put("regDt", list3.get(i).getRegDt());
            }
            else
            {
                resultMap.put("crkCnt", "");
                resultMap.put("regDt", "");
            }
            if(list4.size() > i)
            {
                resultMap.put("exprnDate", list4.get(i).getExprnDate());
                resultMap.put("excCnt", list4.get(i).getExcCnt());
            }
            else
            {
                resultMap.put("expDt", "");
                resultMap.put("excCnt", "");
            }
            if(list5.size() > i)
            {
                resultMap.put("istDcsDe", list5.get(i).getIstDcsDe());
                resultMap.put("hexcCnt", list5.get(i).getHexcCnt());
            }
            else
            {
                resultMap.put("istDcsDe", "");
                resultMap.put("hexcCnt", "");
            }
            if(list6.size() > i)
            {
                resultMap.put("rcmdCnt", list6.get(i).getRcmdCnt());
                resultMap.put("exprnCnt", list6.get(i).getExprnCnt());
                resultMap.put("hcExprnCnt", list6.get(i).getHcExprnCnt());
            }
            else
            {
                resultMap.put("rcmdCnt", "");
                resultMap.put("exprnCnt", "");
                resultMap.put("hcExprnCnt", "");
            }
            if(list7.size() > i)
            {
                resultMap.put("svcDate", list7.get(i).getSvcDate());
                resultMap.put("hccCnt", list7.get(i).getHccCnt());
            }
            else
            {
                resultMap.put("svcDate", "");
                resultMap.put("hccCnt", "");
            }
            if(list8.size() > i)
            {
                resultMap.put("crkPoint", list8.get(i).getCrkPoint());
                resultMap.put("deliverPoint", list8.get(i).getDeliverPoint());
                resultMap.put("callPoint", list8.get(i).getCallPoint());
                resultMap.put("gicPoint", list8.get(i).getGicPoint());
                resultMap.put("asPoint", list8.get(i).getAsPoint());
            }
            else
            {
            	resultMap.put("crkPoint", "");
                resultMap.put("deliverPoint", "");
                resultMap.put("callPoint", "");
                resultMap.put("gicPoint", "");
                resultMap.put("asPoint", "");
            }
            result.add(i, resultMap);
            

        }

        return (List<T>) result;
    }
    
    public <T> List<T> getCrmCustSynthesisHst2List(Object param) throws Exception {
		return dao.getCrmCustSynthesisHst2List(param);
	}
    
    public int getCrmCustSynthesisHst2ListCount(Object param) throws Exception {
		return dao.getCrmCustSynthesisHst2ListCount(param);
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
