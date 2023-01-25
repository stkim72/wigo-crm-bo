package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CusStampListDao extends ICrmDao {
    
    <T> List<T> searchStmpList(Object param);
    
    int searchStmpListCount(Object param);
    
}
