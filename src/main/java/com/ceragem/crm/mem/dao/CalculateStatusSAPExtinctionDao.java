package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CalculateStatusSAPExtinctionDao extends ICrmDao {

    int insertMonthPointExtinction(Object param);
    int updateMonthPointExtinction(Object param);
    int selectMonthPointCkExtinction(Object param);
    
    String selectExtncPoint(Object param);
}
