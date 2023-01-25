package com.ceragem.crm.backcus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceragem.crm.backcus.dao.CrmUserInfoBaseDao;
import com.ceragem.crm.backcus.model.CrmAsDetailVo;
import com.ceragem.crm.backcus.model.CrmCollabiDetailVo;
import com.ceragem.crm.backcus.model.CrmUserInfoVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.RequiredArgsConstructor;

/**
 * @author Seo Dong Min(dm.seo@kt.com)
 *
 */
@Service
@RequiredArgsConstructor
public class CrmUserInfoService extends AbstractCrmService {
	private final CrmUserInfoBaseDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public <T> List<CrmUserInfoVo> getListMask(EzMap param) throws Exception {
		List<CrmUserInfoVo> list = dao.selectList(param);
		for (CrmUserInfoVo s : list) {
			s.setUserName(maskingName(s.getUserName()));
			s.setUserPhoneNumber(maskingPhoneNumber(s.getUserPhoneNumber()));
			if (s.getUserEmail() == null) {
				s.setUserEmail("");
			} else if (s.getUserEmail().trim().contains("@")) {
				s.setUserEmail(s.getUserEmail().replaceFirst(s.getUserEmail().substring(
						Integer.max(s.getUserEmail().indexOf("@") - 3, 0), s.getUserEmail().indexOf("@")), "***"));
			} else {
				s.setUserEmail("***");
			}
		}
		return list;
	}

	public <T> List<CrmAsDetailVo> asGetList(EzMap param) throws Exception {
		return dao.asSelectList(param);
	}

	public <T> List<CrmAsDetailVo> asGetListMask(EzMap param) throws Exception {
		List<CrmAsDetailVo> list = dao.asSelectList(param);
		for (CrmAsDetailVo s : list) {
			s.setCustomerName(maskingName(s.getCustomerName()));
			s.setAsPhone(maskingPhoneNumber(s.getAsPhone()));
			s.setAsMobile(maskingPhoneNumber(s.getAsMobile()));
		}
		return list;
	}

	public <T> List<CrmAsDetailVo> asCustGetListMask(EzMap param) throws Exception {
		List<CrmAsDetailVo> list = dao.asCustSelectList(param);
		for (CrmAsDetailVo s : list) {
			s.setCustomerName(maskingName(s.getCustomerName()));
			s.setAsPhone(maskingPhoneNumber(s.getAsPhone()));
			s.setAsMobile(maskingPhoneNumber(s.getAsMobile()));
		}
		return list;
	}

	public <T> List<CrmCollabiDetailVo> collabiGetList(EzMap param) throws Exception {
		return dao.collabiSelectList(param);
	}

	public <T> List<CrmCollabiDetailVo> collabiGetListMask(EzMap param) throws Exception {
		List<CrmCollabiDetailVo> list = dao.collabiSelectList(param);
		for (CrmCollabiDetailVo s : list) {
			s.setClientNm(maskingName(s.getClientNm()));
			s.setUserPhone(maskingPhoneNumber(s.getUserPhone()));
		}
		return list;
	}

	public <T> T collabiGet(Object param) throws Exception {
		return dao.collabiSelect(param);
	}

	public <T> T asGet(Object param) throws Exception {
		return dao.asSelect(param);
	}

	public String maskingName(String str) {
		if (str != null) {
			if (str.length() > 2) {
				return str.substring(0, 1) + "*" + str.substring(2);
			} else {
				return str.substring(0, 1) + "*";
			}
		} else {
			return "*";
		}
	}

	public String maskingPhoneNumber(String str) {
		if (str != null) {
			if (str.length() > 7) {
				return str.substring(0, 3) + "-****-" + str.substring(7);
			} else {
				return "***";
			}
		} else {
			return null;
		}
	}

	public List<CrmAsDetailVo> asCustGetList(EzMap param) {
		return dao.asCustSelectList(param);
	}
}
