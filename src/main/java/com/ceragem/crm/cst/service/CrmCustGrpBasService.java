package com.ceragem.crm.cst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.SessionUtil;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.dao.CrmCustGrpBasDao;
import com.ceragem.crm.cst.model.CrmCustGrpBasVo;
import com.ceragem.crm.cst.model.CrmCustGrpCnttHstCondVo;
import com.ceragem.crm.cst.model.CrmCustGrpDealHstCondVo;
import com.ceragem.crm.cst.model.CrmCustGrpMstrCondVo;
import com.ceragem.crm.cst.model.CrmCustGrpTargetCondVo;
import com.ceragem.crm.cst.model.CrmCustGrpTargetRelVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.model.CrmLoginUserVo;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CrmCustGrpBasService extends AbstractCrmService {
	@Autowired
	CrmCustGrpBasDao dao;

	@Value("${spring.nas.path}")
	String nasPath;

	@Resource(name = "crmSqlSessionFactory")
	SqlSessionFactory sFactory;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	// 고객그룹 기본정보 관련
	public <T> List<T> getGroupBasList(Object param) throws Exception {
		return dao.selectGroupBasList(param);
	}

	public int getGroupBasListCount(Object param) throws Exception {
		return dao.selectGroupBasListCount(param);
	}

	public CrmCustGrpBasVo getGroupBasInfo(Object param) throws Exception {
		return dao.selectGroupBasInfo(param);
	}

	public int insertGroupBasInfo(Object param) throws Exception {
		int resultVal = 0;
		String custGrpNo = "";

		CrmCustGrpBasVo custGrpVo = (CrmCustGrpBasVo) param;
		CrmCustGrpMstrCondVo custGrpMstrCondVo = new CrmCustGrpMstrCondVo();
		CrmCustGrpCnttHstCondVo custGrpCnttHstCondVo = new CrmCustGrpCnttHstCondVo();
		CrmCustGrpDealHstCondVo custGrpDealCondVo = new CrmCustGrpDealHstCondVo();

		// 생성한 일련번호를 검색조건 테이블에도 공유하기 위해
		custGrpNo = Utilities.getAutoSeq("GRP");
		custGrpVo.setCustGrpNo(custGrpNo);
		custGrpMstrCondVo.setCustGrpNo(custGrpNo);
		custGrpCnttHstCondVo.setCustGrpNo(custGrpNo);
		custGrpDealCondVo.setCustGrpNo(custGrpNo);

		resultVal += dao.insertGroupBasInfo(custGrpVo);
		resultVal += dao.insertMstrCondInfo(custGrpMstrCondVo);
		resultVal += dao.insertCnttHstCondInfo(custGrpCnttHstCondVo);
		resultVal += dao.insertDealHstCondInfo(custGrpDealCondVo);

		return resultVal;
	}

	public int updateGroupBasInfo(Object param) throws Exception {
		return dao.updateGroupBasInfo(param);
	}

	public int deleteGroupBasInfo(Object param) throws Exception {
		int resultVal = 0;

		resultVal += dao.deleteTargetRelAll(param); // 대상고객정보 삭제
		resultVal += dao.deleteMstrCondInfo(param); // 고객마스터조건 삭제
		resultVal += dao.deleteCnttHstCondInfo(param); // 접촉이력조건 삭제
		resultVal += dao.deleteDealGodsCondInfo(param); // 거래제품조건 삭제
		resultVal += dao.deleteDealHstCondInfo(param); // 거래이력조건 삭제
		resultVal += dao.deleteGroupBasInfo(param); // 고객그룹정보 삭제

		return resultVal;
	}

	public EzMap saveGroupBasInfoList(List<? extends BaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(setSaveGroupBasInfo(list.get(i)));
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap deleteGroupBasInfoList(List<? extends BaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(Utilities.getDeleteResult(deleteGroupBasInfo(list.get(i))));
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap setSaveGroupBasInfo(BaseVo vo) throws Exception {
		if ("C".equalsIgnoreCase(vo.getStat()))
			return Utilities.getInsertResult(insertGroupBasInfo(vo), vo);
		else if ("U".equalsIgnoreCase(vo.getStat()))
			return Utilities.getUpdateResult(updateGroupBasInfo(vo), vo);
		else if ("D".equalsIgnoreCase(vo.getStat()))
			return Utilities.getDeleteResult(deleteGroupBasInfo(vo));
		return Utilities.getUpdateResult(0, vo);
	}
	// 고객그룹 기본정보 관련

	// 고객마스터 조건정보 관련
	public CrmCustGrpMstrCondVo getMstrCondInfo(Object param) throws Exception {
		return dao.selectMstrCondInfo(param);
	}
	// 고객마스터 조건정보 관련

	// 접촉이력 조건정보 관련
	public CrmCustGrpCnttHstCondVo getCnttHstCondInfo(Object param) throws Exception {
		return dao.selectCnttHstCondInfo(param);
	}

	public int getExprnGodsSearchListCount(Object param) throws Exception {
		return dao.selectExprnGodsSearchListCount(param);
	}

	public <T> List<T> getExprnGodsSearchList(Object param) throws Exception {
		return dao.selectExprnGodsSearchList(param);
	}
	// 접촉이력 조건정보 관련

	// 거래이력 조건정보 관련
	public CrmCustGrpDealHstCondVo getDealHstCondInfo(Object param) throws Exception {
		CrmCustGrpDealHstCondVo vo = dao.selectDealHstCondInfo(param);
		if (vo != null) { // 거래이력 조회 후 데이터가 존재하면 거래이력 제품리스트를 추가조회하여 저장한다.
			vo.setGodsList(dao.selectDealGodsCondList(param));
		}

		return vo;
	}

	public int getDealGodsSearchListCount(Object param) throws Exception {
		return dao.selectDealGodsSearchListCount(param);
	}

	public <T> List<T> getDealGodsSearchList(Object param) throws Exception {
		return dao.selectDealGodsSearchList(param);
	}

	public EzMap insertDealGodsInfoList(Object param) throws Exception {
		return Utilities.getInsertResult(dao.insertDealGodsCondList(param));
	}

	public EzMap deleteDealGodsInfoList(Object param) throws Exception {
		return Utilities.getDeleteResult(dao.deleteDealGodsCondList(param));
	}
	// 거래이력 조건정보 관련

	// 대상 조건정보 관련
	public int updateTargetCondInfo(CrmCustGrpTargetCondVo vo) throws Exception {
		CrmCustGrpMstrCondVo custMasterVO = vo.getCustMasterCond();
		CrmCustGrpCnttHstCondVo cnttHstCondVO = vo.getCnttHstCond();
		CrmCustGrpDealHstCondVo dealHstCondVO = vo.getDealHstCond();

		int resultVal = 0;
		resultVal += dao.updateMstrCondInfo(custMasterVO);
		resultVal += dao.updateCnttHstCondInfo(cnttHstCondVO);
		resultVal += dao.updateDealHstCondInfo(dealHstCondVO);
		if (dealHstCondVO.getGodsList() != null && dealHstCondVO.getGodsList().size() > 0) {
			resultVal += dao.insertDealGodsCondList(dealHstCondVO);
		}

		return resultVal;
	}
	// 대상 조건정보 관련

	// 대상 고객추출 관련
	public <T> List<T> getTargetSearchList(Object param) throws Exception {
		List<T> list = dao.selectTargetSearchList(param);
		return list;
	}

	public int getTargetSearchPagingListCount(Object param) throws Exception {
		return dao.selectTargetSearchPagingListCount(param);
	}

	public <T> List<T> getTargetSearchPagingList(Object param) throws Exception {
		List<T> list = dao.selectTargetSearchPagingList(param);
		return list;
	}

	public CrmCustGrpBasVo getTargetQuery(Object param) throws Exception {
		String sQuery = Utilities.getSql("selectTargetSearchList", param);

		CrmCustGrpBasVo vo = new CrmCustGrpBasVo();
		vo.setCustGrpExtrSqlCtnts(sQuery);

		return vo;
	}
	
	public int getTargetWithQueryCount(Object param) throws Exception {
		return dao.selectTargetWithQueryCount(param);
	}

	public <T> List<T> getTargetWithQuery(Object param) throws Exception {
		List<T> list = dao.selectTargetWithQuery(param);

		return list;
	}

	public int saveTargetQuery(Object param) throws Exception {
		int resultVal = dao.saveTargetQuery(param);

		return resultVal;
	}
	// 대상 고객추출 관련

	// 대상 고객선정 관련
	public <T> List<T> getTargetRelList(Object param) throws Exception {
		List<T> list = dao.selectTargetRelList(param);
		return list;
	}

	public int getTargetRelListCount(Object param) throws Exception {
		return dao.selectTargetRelListCount(param);
	}
	
	public EzMap updateTargetSearchCustNo(Object param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		List<EzMap> targetDataList = dao.selectTargetCustNoEmptyList(param);
		
		for (int i = 0; i < targetDataList.size(); i++) {
			EzMap eachData = targetDataList.get(i);
			result.add(Utilities.getUpdateResult(dao.updateTargetCustNoEmpty(eachData), eachData));
		}
	
		return Utilities.getSaveResult(result);
	}

	public int updateTargetRelList(Object param) throws Exception {
		return dao.updateTargetRelList(param);
	}

	public int deleteTargetRelList(Object param) throws Exception {
		return dao.deleteTargetRelList(param);
	}

	// 엑셀 저장을 위해 보안이 필요한 정보를 암호화 합니다.
	@SuppressWarnings("unchecked")
	public EzMap saveTargetRelList1(EzMap param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		List<EzMap> targetDataList = (List<EzMap>) param.get("targetData");
		String sCustGrpNo = (String) param.get("custGrpNo");

		dao.deleteTargetRelAll(param); // 기존 데이터 삭제

		for (int i = 0; i < targetDataList.size(); i++) {
			Map<String, Object> eachData = targetDataList.get(i);
			String sOrgPhoneNo = Utilities.nullCheck(eachData.get("mphonNo"));
			String sMphonBkDgtNo = "";
			if (sOrgPhoneNo.length() > 4) {
				sMphonBkDgtNo = sOrgPhoneNo.substring(sOrgPhoneNo.length() - 4, sOrgPhoneNo.length());
			} // zodiack
			eachData.put("custGrpNo", sCustGrpNo);
			eachData.put("mphonBkDgtNo", sMphonBkDgtNo);

			result.add(Utilities.getInsertResult(insertTargetRelExcelInfo(eachData), eachData));
		}

		return Utilities.getSaveResult(result);
	}

	@SuppressWarnings("unchecked")
	public EzMap saveTargetRelList2(EzMap param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		List<EzMap> targetDataList = (List<EzMap>) param.get("targetData");
		String sCustGrpNo = (String) param.get("custGrpNo");

		dao.deleteTargetRelAll(param); // 기존 데이터 삭제

		for (int i = 0; i < targetDataList.size(); i++) {
			Map<String, Object> eachData = targetDataList.get(i);
			String sMaskingPhoneNo = Utilities.nullCheck(eachData.get("mphonNoMasking"));
			String sMphonBkDgtNo = "";
			if (sMaskingPhoneNo.length() > 4) {
				sMphonBkDgtNo = sMaskingPhoneNo.substring(sMaskingPhoneNo.length() - 4, sMaskingPhoneNo.length());
			} // zodiack
			eachData.put("custGrpNo", sCustGrpNo);
			eachData.put("mphonBkDgtNo", sMphonBkDgtNo);

			result.add(Utilities.getInsertResult(insertTargetRelInfo(eachData), eachData));
		}

		return Utilities.getSaveResult(result);
	}
	
	public EzMap saveTargetRelInpQuery(EzMap param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		
		CrmLoginUserVo user = SessionUtil.getLoginUser();
		param.put("regrId", user.getRegrId());
		param.put("amdrId", user.getRegrId());
		
		dao.deleteTargetRelAll(param); // 기존 데이터 삭제
		dao.saveTargetQuery(param);	//쿼리 저장
		
		result.add(Utilities.getInsertResult(dao.insertTargetRelInpQuery(param)));
		
		return Utilities.getSaveResult(result);
	}

	public EzMap saveTargetCondNRelInfo(CrmCustGrpTargetCondVo vo) throws Exception {
		CrmCustGrpMstrCondVo custMasterVO = vo.getCustMasterCond();
		CrmCustGrpCnttHstCondVo cnttHstCondVO = vo.getCnttHstCond();
		CrmCustGrpDealHstCondVo dealHstCondVO = vo.getDealHstCond();

		int resultVal = 0; // 조건저장
		resultVal += dao.updateMstrCondInfo(custMasterVO);
		resultVal += dao.updateCnttHstCondInfo(cnttHstCondVO);
		resultVal += dao.updateDealHstCondInfo(dealHstCondVO);
		if (dealHstCondVO.getGodsList() != null && dealHstCondVO.getGodsList().size() > 0) {
			resultVal += dao.insertDealGodsCondList(dealHstCondVO);
			log.debug(resultVal+"");
		}

		String sCustGrpNo = custMasterVO.getCustGrpNo();
		EzMap param = new EzMap();
		param.put("custGrpNo", sCustGrpNo);

		dao.deleteTargetRelAll(param); // 기존 데이터 삭제

		// 현재 저장한 조건으로 고객리스트 추출
		CrmCustGrpMstrCondVo nowCustMasterCondVO = dao.selectMstrCondInfo(param); // 고객마스터 조건
		CrmCustGrpCnttHstCondVo nowCnttHstCondVO = dao.selectCnttHstCondInfo(param); // 접촉이력 조건
		CrmCustGrpDealHstCondVo nowDealHstCondVO = dao.selectDealHstCondInfo(param); // 거래이력 조건
		nowDealHstCondVO.setGodsList(dao.selectDealGodsCondList(param)); // 거래이력의 구매제품 조건
		CrmCustGrpTargetCondVo totalCondVO = new CrmCustGrpTargetCondVo();
		totalCondVO.setCustMasterCond(nowCustMasterCondVO);
		totalCondVO.setCnttHstCond(nowCnttHstCondVO);
		totalCondVO.setDealHstCond(nowDealHstCondVO);

		List<EzMap> result = new ArrayList<EzMap>();
		List<CrmCustGrpTargetRelVo> targetDataList = dao.selectTargetSearchList(totalCondVO);

		if (targetDataList != null) {
			for (int i = 0; i < targetDataList.size(); i++) {
				CrmCustGrpTargetRelVo eachData = targetDataList.get(i);
				String sMaskingPhoneNo = Utilities.nullCheck(eachData.getMphonNoMasking());

				eachData.setCustGrpNo(sCustGrpNo);
				eachData.setMphonBkDgtNo(
						sMaskingPhoneNo.substring(sMaskingPhoneNo.length() - 4, sMaskingPhoneNo.length()));

				result.add(Utilities.getInsertResult(insertTargetRelInfo(eachData), eachData));
			}
		}

		return Utilities.getSaveResult(result);
	}

	public EzMap saveTargetCondNRelList(CrmCustGrpTargetCondVo vo) throws Exception {
		CrmCustGrpMstrCondVo custMasterVO = vo.getCustMasterCond();
		CrmCustGrpCnttHstCondVo cnttHstCondVO = vo.getCnttHstCond();
		CrmCustGrpDealHstCondVo dealHstCondVO = vo.getDealHstCond();

		int resultVal = 0; // 조건저장
		resultVal += dao.updateMstrCondInfo(custMasterVO);
		resultVal += dao.updateCnttHstCondInfo(cnttHstCondVO);
		resultVal += dao.updateDealHstCondInfo(dealHstCondVO);
		log.debug(resultVal+"");
		// 실시간으로 제품검색리스트가 저장되기 때문에 대상고객을 추출하는 시점에서는 저장할 필요가 없음
//		if (dealHstCondVO.getGodsList() != null && dealHstCondVO.getGodsList().size() > 0) {
//			resultVal += dao.insertDealGodsCondList(dealHstCondVO);
//		}

		String sCustGrpNo = custMasterVO.getCustGrpNo();
		EzMap param = new EzMap();
		param.put("custGrpNo", sCustGrpNo);

		dao.deleteTargetRelAll(param); // 기존 데이터 삭제

		List<EzMap> result = new ArrayList<EzMap>();
		CrmLoginUserVo user = SessionUtil.getLoginUser();
		custMasterVO.setRegrId(user.getRegrId());

		result.add(Utilities.getInsertResult(dao.insertTargetRelList(vo)));
		return Utilities.getSaveResult(result);
	}

	public int insertTargetRelExcelInfo(Object param) throws Exception {
		return dao.insertTargetRelExcelInfo(param);
	}

	public int insertTargetRelInfo(Object param) throws Exception {
		return dao.insertTargetRelInfo(param);
	}
	// 대상 고객선정 관련

	// 대상 고객검색 관련
	public <T> List<T> getTargetCustGradeList(Object param) throws Exception {
		return dao.selectTargetCustGradeList(param);
	}

	public int getTargetCustListCount(Object param) throws Exception {
		return dao.selectTargetCustListCount(param);
	}

	public <T> List<T> getTargetCustList(Object param) throws Exception {
		return dao.selectTargetCustList(param);
	}
	// 대상 고객검색 관련

	// 대상 고객발송 관련
	@SuppressWarnings("unchecked")
	public EzMap saveTargetSendGroupInfo(EzMap param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		List<EzMap> targetDataList = (List<EzMap>) param.get("targetData");
		String sSendGrpType = (String) param.get("sendGrpType");

		result.add(Utilities.getDeleteResult(deleteTargetSendGroup(param)));
		for (int i = 0; i < targetDataList.size(); i++) {
			Map<String, Object> eachData = targetDataList.get(i);
			eachData.put("sendGrpType", sSendGrpType);

			result.add(Utilities.getInsertResult(insertTargetSendGroup(eachData), eachData));
		}

		return Utilities.getSaveResult(result);
	}
	
	public EzMap saveTotalTargetSendGroupInfo(EzMap param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		result.add(Utilities.getDeleteResult(deleteTargetSendGroup(param)));
		result.add(Utilities.getInsertResult(dao.insertTotalTargetSendGroup(param)));

		return Utilities.getSaveResult(result);
	}
	
	@SuppressWarnings("unchecked")
	public EzMap saveTargetSendInfo(EzMap param) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		List<EzMap> targetDataList = (List<EzMap>) param.get("targetData");
		String sSendType = (String) param.get("sendType");
		String sCustGrpNo = (String) param.get("custGrpNo");
		String sClientId = (String) param.get("clientId");
		String sCampId = (String) param.get("campId");

		for (int i = 0; i < targetDataList.size(); i++) {
			Map<String, Object> eachData = targetDataList.get(i);
			eachData.put("custGrpNo", sCustGrpNo);
			eachData.put("memSeq", (i + 1));
			eachData.put("clientId", sClientId);
			eachData.put("campId", sCampId);

			if (sSendType.equals("003")) { // 이메일
				result.add(Utilities.getInsertResult(insertTargetByMail(eachData), eachData));
			} else { // 문자,알림톡
				result.add(Utilities.getInsertResult(insertTargetBySms(eachData), eachData));
			}
		}

		return Utilities.getSaveResult(result);
	}

	public EzMap saveTotalTargetSendInfo(EzMap param) throws Exception {
		String sSendType = (String) param.get("sendType");

		List<EzMap> result = new ArrayList<EzMap>();
		if (sSendType.equals("003")) { // 이메일
			result.add(Utilities.getInsertResult(dao.insertTotalTargetByMail(param)));
		} else {
			result.add(Utilities.getInsertResult(dao.insertTotalTargetBySms(param)));
		}

		return Utilities.getSaveResult(result);
	}
	
	public int deleteTargetSendGroup(Object param) throws Exception {
		return dao.deleteTargetSendGroup(param);
	}
	
	public int insertTargetSendGroup(Object param) throws Exception {
		return dao.insertTargetSendGroup(param);
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
	// 대상 고객발송 관련
}
