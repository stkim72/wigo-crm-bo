package com.ceragem.crm.memship.dao;

import java.util.List;
import java.util.Map;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.model.CrmMshipStmpBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmMshipStmpBasDao extends ICrmDao {

	String getMaxStmpNo();

	int insertChlCode(EzMap prm);

	List<EzMap> getStmpHisList(EzMap param);

	int getStmpHisListCount(EzMap param);

	int deleteStmpHis(CrmMshipStmpBasVo list);

	int deleteStmpStor(CrmMshipStmpBasVo list);

	int deleteStmpGods(CrmMshipStmpBasVo list);

	int deleteStmpChl(CrmMshipStmpBasVo list);

	int copyStmpMaster(CrmMshipStmpBasVo vo);

	int copyStmpStore(EzMap parm);

	int copyStmpGods(EzMap parm);

	int copyStmpChl(EzMap parm);

	EzMap checkIssueHis(EzMap parm);

	CrmMshipStmpBasVo getStmpBasInfo(Map<String, Object> param);

	List<CrmMshipStmpBasVo> searchStmpList(EzMap param);

	List<EzMap> getComnList(EzMap param);

	List<EzMap> getListPop(EzMap param);

	List<EzMap> getListPopForCust(EzMap param);

	int getListPopForCustCount(EzMap param);

	int getStmpTotalHist(EzMap hisPrm);

	String getStmpHisSeq(EzMap inHisPrm);

	EzMap getStmpMaxSeq(String hstSeq);

	int insertStmpHis(EzMap inHisPrm);

	EzMap getStmpBasInfoForPopup(Map<String, Object> param);

	int getTargetSearchForStmpCount(EzMap param);

	List<EzMap> getTargetSearchListForStmp(EzMap param);

	int checkChitNo(EzMap chitPrm);

	int updateStmpInfo(CrmMshipStmpBasVo vo);

	int searchStmpListCount(EzMap param);

}
