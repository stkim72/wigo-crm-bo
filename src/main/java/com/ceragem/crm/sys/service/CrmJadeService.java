package com.ceragem.crm.sys.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.util.BaseUtilities;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.sys.model.CrmJadeOrgVo;
import com.ceragem.crm.sys.model.CrmLoginUserVo;

@Service
public class CrmJadeService {
	@Value("${spring.jade.token-url}")
	String tokenUrl;
	@Value("${spring.jade.rest-url}")
	String restUrl;
	@Value("${spring.jade.ceragem}")
	String ceragemCd;
	@Value("${spring.jade.ceragem-cns}")
	String ceragemCdnCd;

	@Value("${spring.jade.p1-param}")
	String p1Param;

	@Value("${spring.jade.org-param}")
	String orgParam;
	@Value("${spring.jade.hr-param}")
	String hrParam;

	String token = null;
//	private String tokenDt = null;

	@SuppressWarnings("unchecked")
	private String getToken() throws Exception {
//		if(Utilities.isEmpty(token) || Utilities.isEmpty(tokenDt) || !Utilities.getDateString().equals(tokenDt)) {
		String jsonStr = Utilities.wget(tokenUrl, null, null, true, "POST", null);
		if(Utilities.isEmpty(jsonStr))
			throw new EzAjaxException("인사정보 토큰 획득에 실패했습니다.");
		Map<String, Object> map = Utilities.parseJson(jsonStr, Map.class);
		if(Utilities.isEmpty(map))
			throw new EzAjaxException("인사정보 토큰 획득에 실패했습니다.");
		token = (String) map.get("Token");
		if(Utilities.isEmpty(token))
			throw new EzAjaxException("인사정보 토큰 획득에 실패했습니다.");
//			tokenDt = Utilities.getDateString();
//		}
		return token;
	}

	@SuppressWarnings("unchecked")
	public List<CrmJadeOrgVo> getCeragemOrgList() throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();

		parameter.put("p1", URLEncoder.encode(p1Param, "UTF-8"));
		parameter.put("p2", URLEncoder.encode(orgParam, "UTF-8"));
		parameter.put("p3", URLEncoder.encode(getToken(), "UTF-8"));

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("C_CD", ceragemCd);
		param.put("YMD", Utilities.getDateString());
		parameter.put("PARAM", param);
		String jsonStr = Utilities.getJsonString(parameter);
		String p = "jsonData=" + jsonStr;
//		Map<String, Object> result = Utilities.wgetJson(restUrl + "?" + p, Map.class);
		String json = Utilities.wget(restUrl+"?"+p,null,null);
		Map<String, Object> result = Utilities.parseJson(json, Map.class);
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("Data");

//		String json = Utilities.wget(restUrl+"?"+p,null,null);
//		CrmJadeResultVo<CrmJadeHrVo> result = Utilities.parseJson(json, CrmJadeResultVo.class);
//		List<CrmJadeHrVo> list = result.Etc;

		return mapToBean(list, CrmJadeOrgVo.class);
	}

	public List<CrmLoginUserVo> getCeragemHrList() throws Exception {
		return getHrList(false);
	}

	public List<CrmLoginUserVo> getCeragemCnsHrList() throws Exception {
		return getHrList(true);
	}

	@SuppressWarnings("unchecked")
	private List<CrmLoginUserVo> getHrList(boolean cns) throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();

		parameter.put("p1", URLEncoder.encode(p1Param, "UTF-8"));
		parameter.put("p2", URLEncoder.encode(hrParam, "UTF-8"));
		parameter.put("p3", URLEncoder.encode(getToken(), "UTF-8"));

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("C_CD", ceragemCd);
		param.put("YMD", Utilities.getDateString());
		param.put("CP_CD", cns ? ceragemCdnCd : ceragemCd);
		parameter.put("PARAM", param);

		String jsonStr = Utilities.getJsonString(parameter);
		String p = "jsonData=" + jsonStr;
//		Map<String, Object> result = Utilities.wgetJson(restUrl + "?" + p, Map.class);
		String json = Utilities.wget(restUrl+"?"+p,null,null);
		Map<String, Object> result = Utilities.parseJson(json, Map.class);
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("Data");

//		String jsonStr = Utilities.getJsonString(parameter);
//		String json = Utilities.wget(restUrl,jsonStr,null,true);

//		CrmJadeResultVo<CrmJadeHrVo> result = Utilities.parseJson(json, CrmJadeResultVo.class);
//		List<CrmJadeHrVo> list = result.Etc;

		return mapToBean(list, CrmLoginUserVo.class);
	}

	private <T> List<T> mapToBean(List<Map<String, Object>> list, Class<T> clz) {

		try {
			List<T> ret = new ArrayList<T>();
			for (int i = 0; i < list.size(); i++) {
				Map<String,Object> map = Utilities.convert2CamelCase(list.get(i));
				ret.add(BaseUtilities.mapToBean(map, clz));
			}
			return ret;
		} catch (Exception ex) {
			return null;
		}
	}
}
