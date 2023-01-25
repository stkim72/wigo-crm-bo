package com.ceragem.crm.cst.dao;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCustSynthesisHstDao extends ICrmDao {

	//보스 구매
	<T> List<T> selectList1(Object param);
	//IOT 
	<T> List<T> selectList2(Object param);	
	//세라체크 
	<T> List<T> selectList3(Object param);
	//체험
	<T> List<T> selectList4(Object param);
	//홈체험
	<T> List<T> selectList5(Object param);
	//구매추천 
	<T> List<T> selectList6(Object param);	
	//HC 
	<T> List<T> selectList7(Object param);
	//배송
	<T> List<T> selectList8(Object param);
	
	<T> List<T> getCrmCustSynthesisHst2List(Object param);
	int getCrmCustSynthesisHst2ListCount(Object param);
}
