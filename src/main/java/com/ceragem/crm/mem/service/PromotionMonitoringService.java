package com.ceragem.crm.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.dao.PromotionMonitoringDao;
import com.ceragem.crm.mem.model.PromotionListVo;
import com.ceragem.crm.mem.model.PromotionMonitoringVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmMshipPromBasService
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description CRM멤버십프로모션기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PromotionMonitoringService extends AbstractCrmService {
	@Autowired
	PromotionMonitoringDao dao;

	@Autowired
	PromotionListService serviceList;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public <T> List<T> getIndirectUserList(Object param) throws Exception {
		return dao.getIndirectUserList(param);
	}

	public int getIndirectUserListCount(Object param) throws Exception {
		return dao.getIndirectUserListCount(param);
	}

	public EzMap savePromotionStatus(BaseVo vo) throws Exception {
		return Utilities.getUpdateResult(updatePromotionStatus(vo), vo);
	}

	public int updatePromotionStatus(Object param) throws Exception {
		return dao.updatePromotionStatus(param);
	}

	public List<PromotionMonitoringVo> getListAddCount(EzMap param) throws Exception {

		List<PromotionMonitoringVo> list = getList(param);

		if (Utilities.isEmpty(list) || list == null) {
			return null;
		}

		for (int i = 0; i < list.size(); i++) {
			EzMap map = new EzMap(list.get(i));
			list.get(i).setIndirectReactionBos(getBosOrderListCountMonitor(map));
			list.get(i).setIndirectReactionPos(getPosOrderListCountMonitor(map));
		}

		return list;
	}

	public List<PromotionListVo> getBosOrderListMonitor(EzMap param) throws Exception {

		EzMap promInfo = serviceList.getPromInfo(param);

		if (Utilities.isEmpty(promInfo) || promInfo == null) {
			return null;
		}
		// statusCd , 002 >> 진행중
		// if (!promInfo.getString("statusCd").equals("002")) {
		// return null;
		// }

		if (Utilities.isEmpty(param.get("cntrStaDt"))) {
			param.put("promStaYmd", promInfo.getString("promStaYmd"));
		} else {
			param.put("promStaYmd", param.getString("cntrStaDt"));
		}

		if (Utilities.isEmpty(param.get("cntrEndDt"))) {
			param.put("promEndYmd", promInfo.getString("promEndYmd"));
		} else {
			param.put("promEndYmd", param.getString("cntrEndDt"));
		}

		param.put("fromApplySaleCondCd", promInfo.getString("fromApplySaleCondCd"));
		param.put("toApplySaleCondCd", promInfo.getString("toApplySaleCondCd"));

		param.put("fromApplySaleAmt", promInfo.getString("fromApplySaleAmt"));
		param.put("toApplySaleAmt", promInfo.getString("toApplySaleAmt"));

		List<EzMap> ordList = serviceList.getOrderList(param);
		String bosOrdNo = "";
		StringBuffer bf = new StringBuffer();
		for (EzMap ezMap : ordList) {
			if (!Utilities.isEmpty(ezMap.get("bosOrdNos"))) {
				bf.append(ezMap.getString("bosOrdNos"));
				bf.append(",");
//				bosOrdNo += ezMap.getString("bosOrdNos") + ",";
			}
		}
		bosOrdNo = bf.toString();
		String[] bosOrdNos = bosOrdNo.split(",");
		param.put("bosOrdNos", bosOrdNos);

		if (!Utilities.isEmpty(promInfo.getString("applyMshpGradeCtnts"))) {
			String[] gradeCd = promInfo.getString("applyMshpGradeCtnts").split(",");
			param.put("gradeCd", gradeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("mshipTypeCds"))) {
			String[] typeCd = promInfo.getString("mshipTypeCds").split(",");
			param.put("typeCd", typeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("cprtCmpNo"))) {
			String cmpNo = promInfo.getString("cprtCmpNo");
			param.put("cmpNo", cmpNo);
		}

		return serviceList.getBosOrderList(param);
	}

	public int getBosOrderListCountMonitor(EzMap param) throws Exception {

		EzMap promInfo = serviceList.getPromInfo(param);

		List<EzMap> ordList = serviceList.getOrderList(param);
		if (ordList.size() == 0) {
			return 0;
		}
		StringBuffer bf = new StringBuffer();
		String bosOrdNo = "";
		for (EzMap ezMap : ordList) {
			if (!Utilities.isEmpty(ezMap.get("bosOrdNos"))) {
				bf.append(ezMap.getString("bosOrdNos"));
				bf.append(",");
//				bosOrdNo += ezMap.getString("bosOrdNos") + ",";
			}
		}
		
		
		bosOrdNo = bf.toString();
		
		String[] bosOrdNos = bosOrdNo.split(",");
		param.put("bosOrdNos", bosOrdNos);

		if (Utilities.isEmpty(param.get("cntrStaDt"))) {
			param.put("promStaYmd", promInfo.getString("promStaYmd"));
		} else {
			param.put("promStaYmd", param.getString("cntrStaDt"));
		}

		if (Utilities.isEmpty(param.get("cntrEndDt"))) {
			param.put("promEndYmd", promInfo.getString("promEndYmd"));
		} else {
			param.put("promEndYmd", param.getString("cntrEndDt"));
		}

		param.put("fromApplySaleCondCd", promInfo.getString("fromApplySaleCondCd"));
		param.put("toApplySaleCondCd", promInfo.getString("toApplySaleCondCd"));

		param.put("fromApplySaleAmt", promInfo.getString("fromApplySaleAmt"));
		param.put("toApplySaleAmt", promInfo.getString("toApplySaleAmt"));

		if (!Utilities.isEmpty(promInfo.getString("applyMshpGradeCtnts"))) {
			String[] gradeCd = promInfo.getString("applyMshpGradeCtnts").split(",");
			param.put("gradeCd", gradeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("mshipTypeCds"))) {
			String[] typeCd = promInfo.getString("mshipTypeCds").split(",");
			param.put("typeCd", typeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("cprtCmpNo"))) {
			String cmpNo = promInfo.getString("cprtCmpNo");
			param.put("cmpNo", cmpNo);
		}

		return serviceList.getBosOrderListCount(param);
	}

	public List<PromotionListVo> getPosOrderListMonitor(EzMap param) {

		EzMap promInfo = serviceList.getPromInfo(param);

		if (Utilities.isEmpty(promInfo) || promInfo == null) {
			return null;
		}
		// statusCd , 002 >> 진행중
		// if (!promInfo.getString("statusCd").equals("002")) {
		// return null;
		// }

		if (Utilities.isEmpty(param.get("cntrStaDt"))) {
			param.put("promStaYmd", promInfo.getString("promStaYmd"));
		} else {
			param.put("promStaYmd", param.getString("cntrStaDt"));
		}

		if (Utilities.isEmpty(param.get("cntrEndDt"))) {
			param.put("promEndYmd", promInfo.getString("promEndYmd"));
		} else {
			param.put("promEndYmd", param.getString("cntrEndDt"));
		}

		param.put("fromApplySaleCondCd", promInfo.getString("fromApplySaleCondCd"));
		param.put("toApplySaleCondCd", promInfo.getString("toApplySaleCondCd"));

		param.put("fromApplySaleAmt", promInfo.getString("fromApplySaleAmt"));
		param.put("toApplySaleAmt", promInfo.getString("toApplySaleAmt"));

		List<EzMap> ordList = serviceList.getOrderList(param);

		StringBuffer bf = new StringBuffer();
		String posOrdNo = "";
		for (EzMap ezMap : ordList) {
			if (!Utilities.isEmpty(ezMap.get("posOrdNos"))) {
				bf.append(ezMap.getString("posOrdNos"));
				bf.append(",");
//				posOrdNo += ezMap.getString("posOrdNos") + ",";
			}
		}

		posOrdNo = bf.toString();

		String[] posOrdNos = posOrdNo.split(",");
		param.put("posOrdNos", posOrdNos);

		if (!Utilities.isEmpty(promInfo.getString("applyMshpGradeCtnts"))) {
			String[] gradeCd = promInfo.getString("applyMshpGradeCtnts").split(",");
			param.put("gradeCd", gradeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("mshipTypeCds"))) {
			String[] typeCd = promInfo.getString("mshipTypeCds").split(",");
			param.put("typeCd", typeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("cprtCmpNo"))) {
			String cmpNo = promInfo.getString("cprtCmpNo");
			param.put("cmpNo", cmpNo);
		}

		return serviceList.getPosOrderList(param);
	}

	public int getPosOrderListCountMonitor(EzMap param) {

		EzMap promInfo = serviceList.getPromInfo(param);

		if (Utilities.isEmpty(promInfo) || promInfo == null) {
			return 0;
		}

		List<EzMap> ordList = serviceList.getOrderList(param);
		if (ordList.size() == 0) {
			return 0;
		}
		StringBuffer bf = new StringBuffer();
		String posOrdNo = "";
		for (EzMap ezMap : ordList) {
			if (!Utilities.isEmpty(ezMap.get("posOrdNos"))) {
				bf.append(ezMap.getString("posOrdNos"));
				bf.append(",");
//				posOrdNo += ezMap.getString("posOrdNos") + ",";
			}
		}

		posOrdNo = bf.toString();

		String[] posOrdNos = posOrdNo.split(",");
		param.put("posOrdNos", posOrdNos);

		if (Utilities.isEmpty(param.get("cntrStaDt"))) {
			param.put("promStaYmd", promInfo.getString("promStaYmd"));
		} else {
			param.put("promStaYmd", param.getString("cntrStaDt"));
		}

		if (Utilities.isEmpty(param.get("cntrEndDt"))) {
			param.put("promEndYmd", promInfo.getString("promEndYmd"));
		} else {
			param.put("promEndYmd", param.getString("cntrEndDt"));
		}

		param.put("fromApplySaleCondCd", promInfo.getString("fromApplySaleCondCd"));
		param.put("toApplySaleCondCd", promInfo.getString("toApplySaleCondCd"));

		param.put("fromApplySaleAmt", promInfo.getString("fromApplySaleAmt"));
		param.put("toApplySaleAmt", promInfo.getString("toApplySaleAmt"));

		if (!Utilities.isEmpty(promInfo.getString("applyMshpGradeCtnts"))) {
			String[] gradeCd = promInfo.getString("applyMshpGradeCtnts").split(",");
			param.put("gradeCd", gradeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("mshipTypeCds"))) {
			String[] typeCd = promInfo.getString("mshipTypeCds").split(",");
			param.put("typeCd", typeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("cprtCmpNo"))) {
			String cmpNo = promInfo.getString("cprtCmpNo");
			param.put("cmpNo", cmpNo);
		}

		return serviceList.getPosOrderListCount(param);
	}
}