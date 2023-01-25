package com.ceragem.crm.memship.dao;

import java.util.List;
import java.util.Map;

import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;
	
@CrmMapper
public interface CrmStorBasDao  extends ICrmDao {

	List<CrmStorBasVo>  selectTreeList(Map<String, Object> param);
	List<CrmStorBasVo> selectStoreList(Map<String, Object> param);
	List<CrmStorBasVo> selectGodList(Map<String, Object> param);

}
