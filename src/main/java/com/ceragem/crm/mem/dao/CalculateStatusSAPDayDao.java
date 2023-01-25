package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CalculateStatusSAPDayDao extends ICrmDao {

    int insertMonthPoint(Object param);
    int updateMonthPoint(Object param);
    int selectMonthPointCk(Object param);
}
