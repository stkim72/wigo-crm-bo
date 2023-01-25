package com.ceragem.crm.cusstatus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.cusstatus.dao.CrmCusStatusDao;
import com.ceragem.crm.cusstatus.model.CrmResponseVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.RequiredArgsConstructor;

/**
 * @author Seo Dong Min(dm.seo@kt.com)
 *
 */
@Service
@RequiredArgsConstructor
public class CrmCusStatusService extends AbstractCrmService {
	private final CrmCusStatusDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<Integer> getGradePie() {
		return dao.getGradePie();
	}

	public List<Integer> getGradePie(CrmResponseVo param) {
		String strtDt = param.getStrtDt();
		String endDt = param.getEndDt();
		return dao.getGradePie(strtDt, endDt);
	}

	public List<Integer> getGradeBar() {
		return dao.getGradeBar();
	}

	public List<Integer> getGradeBar(CrmResponseVo param) {
		String strtDt = param.getStrtDt();
		String endDt = param.getEndDt();
		return dao.getGradeBar(strtDt, endDt);
	}

	public List<String> monthRegCntM(EzMap param) {
		List<String> list = new ArrayList<String>();
		for (String s : dao.monthRegCntM(param)) {
			list.add(s);
		}
		return list;
	}

	public List<List<Integer>> monthRegCnt(EzMap param) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<String> idx = Arrays.asList("001", "002", "003", "004", "005", "006");

		for (String code : idx) {
			List<Integer> list = new ArrayList<Integer>();
			param.put("code", code);
			for (int s : dao.monthRegCnt(param)) {
				list.add(s);
			}
			result.add(list);
		}
		return result;
	}

	public EzMap getGraphData(EzMap param) {
		EzMap ret = new EzMap();
		ret.put("gender", dao.selectGndrInfo(param));
		ret.put("age", dao.selectAgeInfo(param));
		return ret;
	}

	public List<String> gradeLevel() {
		return dao.gradeLevel();
	}
}
