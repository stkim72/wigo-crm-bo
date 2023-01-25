package com.ceragem.crm.cusstatus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceragem.crm.cusstatus.dao.CrmCouponUsedDao;
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
public class CrmCouponUsedService extends AbstractCrmService {
	private final CrmCouponUsedDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}
	
	public List<String> barLabels(){	
		List<String> list = new ArrayList<String>();
		for(String s:dao.barLabels()) { 
		    list.add(s);	
		}
		return list;
	}
	
	public List<Integer> barData(){	
		List<Integer> list = new ArrayList<Integer>();
		for(int i:dao.barData()) { 
		    list.add(i);	
		}
		return list;
	}
	
	public List<List<?>> editBarGraph(CrmResponseVo param) {
		String storNoGraph = param.getStorNoGraph();
		String custNmGraph = param.getCustNmGraph();
		String stndDateYGraph = param.getStndDateYGraph();
		String stndDateMGraph = param.getStndDateMGraph();
		String coupnTypeCdGraph = param.getCoupnTypeCdGraph();
		
		List<List<?>> result = new ArrayList<List<?>>();
		result.add(dao.barLabels(storNoGraph, custNmGraph, stndDateYGraph, stndDateMGraph, coupnTypeCdGraph));
		result.add(dao.barData(storNoGraph, custNmGraph, stndDateYGraph, stndDateMGraph, coupnTypeCdGraph));
		return result;
	}
}
