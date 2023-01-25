package com.ceragem.crm.cusstatus.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//import com.ceragem.crm.cusstatus.dao.CrmCusStatusDao;
import com.ceragem.crm.cusstatus.dao.CrmStorNewJoinDao;
import com.ceragem.crm.cusstatus.model.CrmResponseVo;
//import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.RequiredArgsConstructor;

/**
 * @author Yongho Kim(yong_ho.kim@kt.com)
 *
 */
@Service
@RequiredArgsConstructor
public class CrmStorNewJoinService extends AbstractCrmService {
	private final CrmStorNewJoinDao dao;

	@Override
	public CrmStorNewJoinDao getDao() {
		return dao;
	}
	
	public List<String> barLabels(){	
		List<String> list = new ArrayList<String>();
		for(String s:dao.barLabels()) { 
		    list.add(s);
		}
		return list;
	}
	
	public List<Integer> newJoinMonData(){	
		List<Integer> list = new ArrayList<Integer>();
		for(int i:dao.newJoinMonData()) { 
		    list.add(i);	
		}
		return list;
	}
	
	public List<String> lineLabels(){	
		List<String> list = new ArrayList<String>();
		for(String s:dao.lineLabels()) { 
		    list.add(s);	
		}
		return list;
	}
	
	public List<Integer> newJoinYearData(){	
		List<Integer> list = new ArrayList<Integer>();
		for(int i:dao.newJoinYearData()) { 
		    list.add(i);	
		}
		return list;
	}
	
	
	public List<List<?>> editBarGraph(CrmResponseVo param) {
		String storNo = param.getStorNoGraph();
		String stndDt = param.getStndDt();
		List<List<?>> result = new ArrayList<List<?>>();
		result.add(dao.barLabels(storNo, stndDt));
		result.add(dao.newJoinMonData(storNo, stndDt));
		return result;
	}
	
	public List<List<?>> editLineGraph(CrmResponseVo param) {
		String storNo = param.getStorNoGraph();
		String stndDt = param.getStndDt();
		List<List<?>> result = new ArrayList<List<?>>();
		result.add(dao.lineLabels(storNo, stndDt));
		result.add(dao.newJoinYearData(storNo, stndDt));
		return result;
	}

	
}
