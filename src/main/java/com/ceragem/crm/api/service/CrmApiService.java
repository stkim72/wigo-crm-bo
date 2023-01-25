package com.ceragem.crm.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.model.CrmApiDataVo;
import com.ceragem.crm.api.model.CrmApiPagingPayload;
import com.ceragem.crm.api.model.CrmApiPagingResultVo;
import com.ceragem.crm.api.model.CrmApiResultListVo;
import com.ceragem.crm.api.model.CrmApiResultVo;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.BaseUtilities;
import com.ceragem.crm.common.util.Utilities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName CrmApiService
 * @author 김성태
 * @date 2022. 4. 14.
 * @Version 1.0
 * @description
 * 
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Service
public class CrmApiService {

	String enc = "UTF-8";
	@Value("${spring.api.base-url}")
	String baseUrl;
//	@Value("${spring.api.token}")
	String token;
	@Value("${spring.api.url.token-url}")
	String tokenUrl;
	String tokenYmd;
//	@Value("${spring.api.url.customer}")
//	String crmUrlCustomer;
//	@Value("${spring.api.url.customer-contact}")
//	String crmCustomerContact;
//	@Value("${spring.api.url.customer-bond}")
//	String crmCustomerBond;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

//	@PostConstruct
	@Scheduled(cron = "0 1 0 * * *")
	public String getToken() throws Exception {
		if (Utilities.isNotEmpty(token) && Utilities.getDateString().equals(tokenYmd))
			return token;
		CrmApiDataVo vo = getApiData(tokenUrl, null, "GET", false, null);
		Map<String, Object> payload = vo.getObject();
		String tk = (String) payload.get("token");
		token = tk;
		tokenYmd = Utilities.getDateString();
		return token;
	}

	public EzMap getGridData(String uri, Object param) throws Exception {

		return getGridData(uri, param, "GET", true);
	};

	public EzMap getGridData(String uri, Object param, String method, boolean form) throws Exception {
		setPagination(param);
		CrmApiDataVo vo = getApiData(uri, param, method, form);

		return vo.getGridData();
	};

	@SuppressWarnings("unchecked")
	private void setPagination(Object param) {
		if (param == null)
			return;
		if (!(param instanceof Map))
			return;

		Map<String, Object> searchObj = (Map<String, Object>) param;
		if (searchObj.containsKey("page")) {
			searchObj.put("currentPageNo", searchObj.get("page"));
		}
		if (searchObj.containsKey("perPage")) {
			searchObj.put("recordCountPerPage", searchObj.get("perPage"));
		}

	}

	public Map<String, Object> getData(String uri, Object param) throws Exception {
		return getData(uri, param, "GET", true);

	};

	public Map<String, Object> getData(String uri, Object param, String method, boolean form) throws Exception {
		CrmApiDataVo vo = getApiData(uri, param, method, form);

		return vo.getObject();
	};

	public <T> CrmApiPagingResultVo<T> getApiPagingResultVo(String uri, Object param, String method, boolean form,
			Class<T> clz) throws Exception {
		CrmApiDataVo vo = getApiData(uri, param, method, form);

		CrmApiPagingResultVo<T> result = toCrmApiPagingResultVo(vo, clz);
		return result;
	};

	public <T> CrmApiResultListVo<T> getApiResultListVo(String uri, Object param, String method, boolean form,
			Class<T> clz) throws Exception {
		CrmApiDataVo vo = getApiData(uri, param, method, form);
		return toCrmApiResultList(vo, clz);
	};

	public <T> CrmApiResultVo<T> getApiResultVo(String uri, Object param, String method, boolean form, Class<T> clz)
			throws Exception {
		CrmApiDataVo vo = getApiData(uri, param, method, form);
		return toCrmApiResultVo(vo, clz);
	};

	public CrmApiDataVo getApiData(String uri, Object param, String method, boolean form) throws Exception {
		return getApiData(uri, param, method, form, getToken());
	}

	public CrmApiDataVo getApiData(String uri, Object param, String method, boolean form, String token)
			throws Exception {
		String strJson = getStr(uri, param, method, form, token);
		if(Utilities.isEmpty(strJson)) {
			log.error(baseUrl + uri + " 접속에러");
			throw new EzAjaxException( baseUrl + uri + " 접속에러");
		}
		CrmApiDataVo result = objectMapper.readValue(strJson, CrmApiDataVo.class);
		return result;
	}

	private String getStr(String uri, Object param, String methodName, boolean form, String token) throws Exception {
		StringBuffer serverUrl = new StringBuffer();
//		serverUrl.append( uri );
		String method = methodName;
		String enc = "UTF-8";
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		if (BaseUtilities.isEmpty(method))
			method = "GET";

		String strParam = form ? getFormStr(param, "GET".equalsIgnoreCase(method)) : getJsonStr(param);

		try {
			if (uri.startsWith("/"))
				serverUrl.append(baseUrl);
			serverUrl.append(uri);

			if ("GET".equalsIgnoreCase(method)) {
				if (Utilities.isNotEmpty(strParam)) {
					if (uri.indexOf("?") > -1)
						serverUrl.append("&");
					else
						serverUrl.append("?");
					serverUrl.append(strParam);

				}
				strParam = "";
			}

			URL url = new URL(serverUrl.toString());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn == null)
				return null;
			conn.setDoOutput(true);
			conn.setConnectTimeout(2000);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Authorization", "Bearer " + token);
			if (form) {
				if ("GET".equalsIgnoreCase(method)) {
					if (Utilities.isNotEmpty(strParam)) {
						conn.setRequestProperty("Content-Type", "text/plain;charset=" + enc);
					}

				} else {
					conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);

				}
			} else {
				conn.setRequestProperty("Content-Type", "application/json;charset=" + enc);

			}
			if (Utilities.isNotEmpty(strParam)) {
				osw = new OutputStreamWriter(conn.getOutputStream(), enc);
				osw.write(strParam);
				osw.flush();
			}

			int responseCode = conn.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_OK)
				return null;

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), enc));

			char[] buffer = new char[1024];
			StringBuffer sb = new StringBuffer();
			do {
				int nRead = br.read(buffer);
				if (nRead <= 0)
					break;

				sb.append(buffer, 0, nRead);
			} while (true);
			return sb.toString();
		} catch (Exception ex) {

			return null;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}
			try {
				if (osw != null)
					osw.close();
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}

		}
	}

	private String getJsonStr(Object param) throws Exception {
		if (param == null)
			return null;
		if (param instanceof String)
			return (String) param;
		return objectMapper.writeValueAsString(param);
	}

	private String getFormStr(Object param, boolean encoding) throws Exception {
		if (param == null)
			return null;
		if (param instanceof String)
			return (String) param;
		TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
		};
		Map<String, Object> map = objectMapper.convertValue(param, typeRef);
		StringBuffer ret = new StringBuffer();
		for (String key : map.keySet()) {
			String value = Utilities.nullCheck(map.get(key));
			if (encoding)
				value = URLEncoder.encode(value, "utf-8");
			if (Utilities.isEmpty(value))
				continue;
			if (ret.length() > 0)
				ret.append("&");

			ret.append(key);
			ret.append("=");
			ret.append(value);
		}

		return ret.toString();
	}

	@SuppressWarnings("unchecked")
	private <T> CrmApiPagingResultVo<T> toCrmApiPagingResultVo(CrmApiDataVo vo, Class<T> clz) {
		CrmApiPagingResultVo<T> result = new CrmApiPagingResultVo<T>();
		result.setCode(vo.getCode());
		result.setMessage(vo.getMessage());
		result.setSystemCd(vo.getSystemCd());
		result.setTimestamp(vo.getTimestamp());
		Map<String, Object> payload = (Map<String, Object>) vo.getPayload();
		if (payload == null)
			return result;
		CrmApiPagingPayload<T> data = new CrmApiPagingPayload<>();

		EzPaginationInfo pagination = objectMapper.convertValue(payload.get("pagination"), EzPaginationInfo.class);
		data.setPagination(pagination);
		List<T> list = objectMapper.convertValue(payload.get("list"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, clz));
		data.setList(list);
		result.setPayload(data);
		return result;
	}

	private <T> CrmApiResultListVo<T> toCrmApiResultList(CrmApiDataVo vo, Class<T> clz) {
		CrmApiResultListVo<T> result = new CrmApiResultListVo<T>();
		result.setCode(vo.getCode());
		result.setMessage(vo.getMessage());
		result.setSystemCd(vo.getSystemCd());
		result.setTimestamp(vo.getTimestamp());
		if (vo.getPayload() == null)
			return result;
		List<T> list = objectMapper.convertValue(vo.getPayload(),
				TypeFactory.defaultInstance().constructCollectionType(List.class, clz));
		result.setPayload(list);
		return result;
	}

	private <T> CrmApiResultVo<T> toCrmApiResultVo(CrmApiDataVo vo, Class<T> clz) {
		CrmApiResultVo<T> result = new CrmApiResultVo<T>();
		result.setCode(vo.getCode());
		result.setMessage(vo.getMessage());
		result.setSystemCd(vo.getSystemCd());
		result.setTimestamp(vo.getTimestamp());
		if (vo.getPayload() == null)
			return result;
		T payload = objectMapper.convertValue(vo.getPayload(), clz);
		result.setPayload(payload);
		return result;
	}
}
