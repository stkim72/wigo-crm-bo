package com.ceragem.crm.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiPagingResultVo;
import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.model.CrmCustGradeChngHstVo;
import com.ceragem.crm.cst.service.CrmCustGradeChngHstService;
import com.ceragem.crm.main.dao.CrmCustBasDao;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.memship.model.AdvnCmtVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmCustBasService
 * @author user
 * @date 2022. 4. 19.
 * @Version 1.0
 * @description CRM고객기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustBasService extends AbstractCrmService {
	@Autowired
	CrmCustBasDao dao;

	@Autowired
	CrmApiService apiService;
	
	@Autowired
	CrmCustGradeChngHstService  custGradeChngHstService;

	@Value("${spring.api.url.customer}")
	String apiUrl;
	@Value("${spring.api.url.customer-memship}")
	String apiUrlMemship;	

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	// 좌측 그리드 목록
	public EzMap getGridList(Object param) throws Exception {
		Map<String, Object>  so = Utilities.beanToMap(param);
		so.put("indiInfoHandlPrsnNo", Utilities.getLoginUserCd());
		so.put("connPrsnIpAddr", Utilities.getPeerIp());
		EzMap test = apiService.getGridData(apiUrl + "/list", so, "GET", true);
		return test;

	}

	// 고객 단건조회
	public Map<String, Object> getData(Object param) throws Exception {

		return apiService.getData(apiUrl + "/" + param, param, "GET", true);

	}

	//
	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustBasVo> getList(Object param) throws Exception {
		Map<String, Object>  so = Utilities.beanToMap(param);
		so.put("indiInfoHandlPrsnNo", Utilities.getLoginUserCd());
		so.put("connPrsnIpAddr", Utilities.getPeerIp());
		CrmApiPagingResultVo<CrmCustBasVo> result = apiService.getApiPagingResultVo(apiUrl + "/list", so, "GET",
				true, CrmCustBasVo.class);
		return result.getList();
	}

	//	@SuppressWarnings("unchecked")
	//	@Override
	//	public CrmCustBasVo get(Object param) throws Exception {
	//		CrmCustBasVo vo = (CrmCustBasVo) param;
	//		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getCntplcSeq(), param,
	//				"GET", true, CrmCustBasVo.class);
	//		return result.getPayload();
	//	}

	@Override
	public int update(Object param) throws Exception {
		Map<String, Object>  so = Utilities.beanToMap(param);
		so.put("indiInfoHandlPrsnNo", Utilities.getLoginUserCd());
		so.put("connPrsnIpAddr", Utilities.getPeerIp());
		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(apiUrl, so, "PUT", false,
				CrmCustBasVo.class);

		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;

	}

	public List<EzMap> getMemberShipScoreList(Object param) throws Exception {
		return dao.selectMemberShipScoreList(param);
	}

	//	@Override
	//	public int insert(Object param) throws Exception {
	//		
	//		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(apiUrl, param, "POST", false,
	//				CrmCustBasVo.class);
	//		if (!result.isSuccess())
	//			throw new EzAjaxException(result.getMessage());
	//		return 1;
	//	}

	//	@Override
	//	public int delete(Object param) throws Exception {
	//		CrmCustBasVo vo = (CrmCustBasVo) param;
	//		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(apiUrl + "/" + vo.getCntplcSeq(), param,
	//				"DELETE", false, CrmCustBasVo.class);
	//		if (!result.isSuccess())
	//			throw new EzAjaxException(result.getMessage());
	//		return 1;
	//	}

	public int saveRepCntplc(Object param) throws Exception {
		dao.saveRepCntplcToN(param);
		return dao.saveRepCntplcToY(param);
	}

	public EzMap saveMemshipDormancy(BaseVo vo) throws Exception {
		return Utilities.getUpdateResult(memshipDormancy(vo), vo);
	}

	public EzMap saveMemshipCancelDormancy(BaseVo vo) throws Exception {
		return Utilities.getUpdateResult(memshipCancelDormancy(vo), vo);
	}

	public int memshipDormancy(Object param)  throws Exception {
		CrmCustBasVo vo = Utilities.beanToBean(param,CrmCustBasVo.class);
		String url = apiUrlMemship + "/dormancy/" + vo.getItgCustNo();
		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(url, param, "POST", false, CrmCustBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

	public int memshipCancelDormancy(Object param)  throws Exception {
		CrmCustBasVo vo = Utilities.beanToBean(param,CrmCustBasVo.class);
		String url = apiUrlMemship + "/dormancy-cancel/" + vo.getItgCustNo();
		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(url, param, "POST", false, CrmCustBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

	public EzMap deleteMemShip(BaseVo vo) throws Exception {
		return Utilities.getUpdateResult(deleMemShip(vo), vo);
	}

	public int deleMemShip(Object param)  throws Exception {
		CrmCustBasVo vo = Utilities.beanToBean(param,CrmCustBasVo.class);
		String url = apiUrlMemship + "/" + vo.getItgCustNo();
		CrmApiResultVo<CrmCustBasVo> result = apiService.getApiResultVo(url, param, "DELETE", false, CrmCustBasVo.class);
		if (!result.isSuccess())
			throw new EzAjaxException(result.getMessage());
		return 1;
	}

	// 통합고객검색 개인 고객발송 관련
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
			
			sEmailYn = "Y";
			sSmsYn = "Y";
			
			// 동의여부 관계없이 무조건 발송하라고 협의함(강전무님,김기종님) 2022-09-07
			/*
			if(sEmailYn == null)
			{
				sEmailYn = "N";
			}
			if(sSmsYn == null)
			{
				sSmsYn = "N";
			}
			*/
			
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

	public int updateAdvn(CrmCustBasVo vo) throws Exception {
		
		//CrmCustBasVo crmCustBasVo = (CrmCustBasVo) dao.select(vo);
		
		
		CrmCustBasVo crmCustBasVo = dao.selectAdvn(vo);
		int updCnt = 0;
		int insCnt = 0;
		
		if( crmCustBasVo != null ) {

			String preMshipGradeCd = crmCustBasVo.getMshipGradeCd();
			
			updCnt = dao.updateAdvn(crmCustBasVo);
			insCnt = 0;
			if( updCnt > 0) {
				
				CrmCustGradeChngHstVo custGradeChngHstVo = new CrmCustGradeChngHstVo();
				custGradeChngHstVo.setItgCustNo( crmCustBasVo.getItgCustNo() );
				custGradeChngHstVo.setApplyStdStaYmd(null);
				custGradeChngHstVo.setApplyStdEndYmd(null);
				custGradeChngHstVo.setMshpGradeCd( crmCustBasVo.getMshipExptGradeCd() );
				custGradeChngHstVo.setChngPreMshpGradeCd( preMshipGradeCd );
				custGradeChngHstVo.setMshpGradeTypeCd( crmCustBasVo.getMshipTypeCd() );
				custGradeChngHstVo.setRegChlCd("CRM"); 
	
				insCnt = custGradeChngHstService.insert(custGradeChngHstVo); // 실제 승급변동 히스토리
				insCnt = custGradeChngHstService.insertDay(custGradeChngHstVo); // 일배치 히스토리
				
				
				// 개별 승급 포인트 지급
				AdvnCmtVo advnCmtVo = new AdvnCmtVo();
				advnCmtVo.setItgCustNo( crmCustBasVo.getItgCustNo() );
				advnCmtVo.setMshipExptGradeCd( crmCustBasVo.getMshipExptGradeCd() );
				advnCmtVo.setNowMshipGradeCd(preMshipGradeCd);
			
				dao.pubAdvnPoint( advnCmtVo );
				
			}
			
		}else {
			
			return 999;
		}
		
		
		return updCnt + insCnt;
	}
}
