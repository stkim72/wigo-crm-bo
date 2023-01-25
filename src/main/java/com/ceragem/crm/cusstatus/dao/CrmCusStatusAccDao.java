package com.ceragem.crm.cusstatus.dao;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCusStatusAccDao extends ICrmDao {
	String[] barLabels();

	List<String> barLabels(String regChlCd, String stndDt);

	List<Integer> normalData();

	List<Integer> normalData(String regChlCd, String stndDt);

	List<Integer> dormarcyData();

	List<Integer> dormarcyData(String regChlCd, String stndDt);

	String[] lineLabels();

	List<String> lineLabels(String regChlCd, String stndDt);

	List<Integer> lineNormal();

	List<Integer> lineNormal(String regChlCd, String stndDt);

	List<Integer> lineDormarcy();

	List<Integer> lineDormarcy(String regChlCd, String stndDt);
}