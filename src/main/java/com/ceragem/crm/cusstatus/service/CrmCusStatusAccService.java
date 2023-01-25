package com.ceragem.crm.cusstatus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceragem.crm.cusstatus.dao.CrmCusStatusAccDao;
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
public class CrmCusStatusAccService extends AbstractCrmService {
	private final CrmCusStatusAccDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<String> barLabels() {
		List<String> list = new ArrayList<String>();
		for (String s : dao.barLabels()) {
			list.add(s);
		}
		return list;
	}

	public List<Integer> normalData() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : dao.normalData()) {
			list.add(i);
		}
		return list;
	}

	public List<Integer> dormarcyData() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : dao.dormarcyData()) {
			list.add(i);
		}
		return list;
	}

	public List<String> lineLabels() {
		List<String> list = new ArrayList<String>();
		for (String s : dao.lineLabels()) {
			list.add(s);
		}
		return list;
	}

	public List<Integer> lineNormal() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : dao.lineNormal()) {
			list.add(i);
		}
		return list;
	}

	public List<Integer> lineDormarcy() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : dao.lineDormarcy()) {
			list.add(i);
		}
		return list;
	}

	public List<List<?>> editBarGraph(CrmResponseVo param) {
//		String storNo = param.getStorNoGraph();
		String regChlCd = param.getRegChlCd();
		String stndDt = param.getStndDt();
		List<List<?>> result = new ArrayList<List<?>>();
		result.add(dao.barLabels(regChlCd, stndDt));
		result.add(dao.normalData(regChlCd, stndDt));
		result.add(dao.dormarcyData(regChlCd, stndDt));
		return result;
	}

	public List<List<?>> editLineGraph(CrmResponseVo param) {
//		String storNo = param.getStorNoGraph();
		String regChlCd = param.getRegChlCd();
		String stndDt = param.getStndDt();
		List<List<?>> result = new ArrayList<List<?>>();
		result.add(dao.lineLabels(regChlCd, stndDt));
		result.add(dao.lineNormal(regChlCd, stndDt));
		result.add(dao.lineDormarcy(regChlCd, stndDt));
		return result;
	}
}
