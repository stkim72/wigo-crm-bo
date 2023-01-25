package com.ceragem.crm.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPropertyServiceImpl;
import com.ceragem.crm.sys.model.CrmLoginUserVo;
import com.ceragem.crm.sys.model.CrmMenuBaseVo;
import com.ceragem.crm.sys.service.CrmCommonService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * <pre>
 * com.ceragem.crm.common.util - Utilities.java
 * </pre>
 *
 * @ClassName : Utilities
 * @Description : 유틸리티
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Component
public class Utilities extends BaseUtilities {
	private static final BarcodeFormat _BARCODE_FORMAT_COUPON = BarcodeFormat.CODE_128;
	private static CrmCommonService commonService;
	private static EzPropertyServiceImpl propertiesService;
	private static SqlSessionFactory sessionFactory;
	@Autowired
	CrmCommonService commService;
	@Resource(name = "propertiesService")
	EzPropertyServiceImpl ezProperties;

	@Resource(name = "crmSqlSessionFactory")
	SqlSessionFactory sFactory;

	@PostConstruct
	public void init() throws Exception {
		super.init();
		commonService = this.commService;
		propertiesService = this.ezProperties;
		sessionFactory = this.sFactory;
	}

	public static String getProperty(String name) {
		return propertiesService.getString(name, "");
	}

	public static int getPropertyInt(String name) {
		return propertiesService.getInt(name, 0);
	}

	public static long getPropertyLong(String name) {
		return propertiesService.getLong(name, 0);
	}

	public static double getPropertyDouble(String name) {
		return propertiesService.getDouble(name, 0);
	}

	public static double getPropertyFloat(String name) {
		return propertiesService.getFloat(name, 0);
	}

	public static boolean getPropertyBoolean(String name) {
		return propertiesService.getBoolean(name, false);
	}

	public static CrmLoginUserVo getLoginUser() {
		HttpSession session = getSession();
		if (session == null)
			return null;
		return (CrmLoginUserVo) session.getAttribute(Constants._LOGIN_SESSION_NAME);
	}

	public static String getLoginUserCd() {
		CrmLoginUserVo loginUser = getLoginUser();
		if (loginUser == null)
			return null;
		return loginUser.getUserCd();

	}

	public static String getLoginUserId() {
		// return "2020000001";
		CrmLoginUserVo loginUser = getLoginUser();
		if (loginUser == null)
			return null;
		return loginUser.getLoginId();

	}

	public static boolean isLogin() {

		return Utilities.isNotEmpty(getLoginUserCd());
	}

	public static String getAutoSeq(String prefix) throws Exception {
		EzMap param = new EzMap();
		param.setString("prefix", prefix);
		return getAutoSeq(param);
	}

//	public static String getAutoSeq(String prefix, String suffix) throws Exception {
//		EzMap param = new EzMap();
//		param.setString("prefix", prefix);
//		param.setString("suffix", suffix);
//		return getAutoSeq(param);
//	}

	public static String getAutoSeq(Map<String, Object> param) throws Exception {
		return commonService.getAutoSeq(param);
	}

	public static String getFileCd() throws Exception {
		EzMap param = new EzMap();
		param.setString("prefix", "FL");
		return getAutoSeq(param);
	}

	public static CrmMenuBaseVo getCurrentMenu() {
		HttpServletRequest request = getRequest();
		if (request == null)
			return null;

		return (CrmMenuBaseVo) request.getAttribute("currentMenu");
	}

	public static String getCurrentMenuCd() {
		CrmMenuBaseVo menu = getCurrentMenu();
		if (menu == null)
			return null;
		return menu.getMenuCd();
	}

	public static BufferedImage createBarcodeImage(String text, int width, int height) {
		if (Utilities.isEmpty(text) || width <= 0 || height <= 0)
			return null;
		try {

			ByteArrayInputStream bis = new ByteArrayInputStream(createBarcodeByte(text, width, height));
			return ImageIO.read(bis);
		} catch (Exception e) {
			return null;
		}
	}

	public static byte[] createBarcodeByte(String text, int width, int height) {
		if (Utilities.isEmpty(text) || width <= 0 || height <= 0)
			return null;
		try {
			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			Writer writer = new Code128Writer();
			BitMatrix bitMatrix = writer.encode(text, _BARCODE_FORMAT_COUPON, width, height);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);

			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	public static String getSql(String mapId, Object param) {
		try {
			Configuration configuration = sessionFactory.getConfiguration();
			MappedStatement ms = configuration.getMappedStatement(mapId);
			BoundSql boundSql = ms.getBoundSql(param);
			String sql = getSql(boundSql, param);
			return sql;
		} catch (Exception ex) {
			return null;
		}
	}

	public static String getSql(BoundSql boundSql, Object parameter) {
		try {

			StringBuilder sql = new StringBuilder(boundSql.getSql());

			if (parameter != null) {
				List<Object> valueList = new ArrayList<Object>();
				for (ParameterMapping parameterMapping : boundSql.getParameterMappings()) {
					String property = parameterMapping.getProperty();
					Object value = null;
					if (boundSql.hasAdditionalParameter(property)) {
						value = boundSql.getAdditionalParameter(property);
						valueList.add(value);
					} else if (parameter != null) {
						value = PropertyUtils.getProperty(parameter, property);
						valueList.add(value);
					}
				}

				for (Object value : valueList) {
					int start = sql.indexOf("?");
					int end = start + 1;
					if (value == null) {
						sql.replace(start, end, "NULL");
					} else if (value instanceof String) {
						sql.replace(start, end, "'" + value.toString() + "'");
					} else {
						sql.replace(start, end, value.toString());
					}
				}
			}
			return sql.toString();
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * @Author 주재민
	 * @date 2022.06.01
	 * @param input
	 * @param div
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String convArryToStrs(Object input, String div) {
		//ArrayList를 구분자를 포함한 문자열리스트로 변환
		StringBuffer sRtnVal = new StringBuffer();

		if (input != null && div != null) {
			if (input instanceof String) {
				sRtnVal.append((String) input);
				return sRtnVal.toString();
			} else {
				ArrayList<String> list = (ArrayList<String>) input;
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						sRtnVal.append(div);
						sRtnVal.append(list.get(i));
					}
					return sRtnVal.toString().substring(div.length(), sRtnVal.length());
				}
			}
		}

		return sRtnVal.toString();
	}

	/**
	 * @Author 주재민
	 * @date 2022.06.01
	 * @param input
	 * @param div
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> convStrsToArry(Object input, String div) {
		//구분자를 포함한 문자열리스트를 ArrayList로 변환
		List<String> lRtnVal = null;

		if (input != null) {
			String sInput = input.toString();
			String[] strArry = sInput.split(div);
			lRtnVal = new ArrayList<String>(Arrays.asList(strArry));
		}

		if (input != null && div != null) {
			if (input instanceof String) {
				lRtnVal = new ArrayList<String>();
				lRtnVal.add((String) input);
			} else {
				lRtnVal = (ArrayList<String>) input;
			}
		}

		return lRtnVal;
	}

	/**
	 * @Author 주재민
	 * @date 2022.06.01
	 * @param map
	 * @param obj
	 * @return
	 */
	public static Object convertMapToObj(Map<String, Object> map, Object obj) {
		//Map을 VO로 변환
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		Iterator<String> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			keyAttribute = itr.next();
			methodString = setMethodString + keyAttribute.substring(0, 1).toUpperCase() + keyAttribute.substring(1);
			Method[] methods = obj.getClass().getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				if (methodString.equals(methods[i].getName())) {
					try {
						methods[i].invoke(obj, map.get(keyAttribute));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return obj;
	}
	
	/**
	 * @Author 주재민
	 * @date 2022.06.01
	 * @param list
	 * @param pageMap
	 * @return
	 */
	public static EzMap getVoGridData(List<? extends Object> list, EzMap pageMap) {
		//VO에 toast grid 페이징기능 추가한버전
		if (pageMap == null)
			return getGridData(list);
		EzMap ezMap = new EzMap();
		EzMap data = new EzMap();
		ezMap.put("result", true);
		ezMap.put("data", data);
		data.put("contents", list);
		data.put("pagination", pageMap);

		return ezMap;
	}
}
