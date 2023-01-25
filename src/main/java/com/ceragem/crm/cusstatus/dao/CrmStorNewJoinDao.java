package com.ceragem.crm.cusstatus.dao;


import java.util.List;

//import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmStorNewJoinDao extends ICrmDao{

	String[] barLabels();
	List<String> barLabels(String storNo, String stndDt);
	List<Integer> newJoinMonData();
	List<Integer> newJoinMonData(String storNo, String stndDt);
	
	String[] lineLabels();
	List<String> lineLabels(String storNo, String stndDt);
	List<Integer> newJoinYearData();
	List<Integer> newJoinYearData(String storNo, String stndDt);
	
	
}
