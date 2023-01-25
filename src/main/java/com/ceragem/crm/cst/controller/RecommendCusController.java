package com.ceragem.crm.cst.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.model.RecommendCusVo;
import com.ceragem.crm.cst.service.RecommendCusService;

/**
 * 
 * @ClassName    RecommendCusController
 * @author    황의겸
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM 추천고객기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "recommendCus", "{menuCd}/recommendCus" })
public class RecommendCusController{

@Autowired
RecommendCusService service;

/**
 * 
 * @author 황의겸
 * @date 2022. 5. 24. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description CRM 추천고객기본 목록페이지
 *
 */
@GetMapping(value = { "", "index" })
public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
    model.addAllAttributes(param);
    return Utilities.getProperty("tiles.crm") + "cst/CR110";
}

/**
 * 
 * @author 황의겸
 * @date 2022. 5. 24. * @param param
 * @return
 * @throws Exception
 * @description CRM 추천고객기본 목록검색
 *
 */
@PostMapping(value = { "getList" })
public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
    EzPaginationInfo page = param.getPaginationInfo();
    List<RecommendCusVo> list = service.getList(param);
    page.setTotalRecordCount(service.getListCount(param));
    return Utilities.getGridData(list,page);
}

/**
 * 
 * @author 황의겸
 * @date 2022. 5. 24. * @param rparam
 * @return
 * @throws Exception
 * @description CRM 추천고객기본 1건검색
 *
 */
@GetMapping(value = { "get" })
public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
    EzMap param = new EzMap(rparam);
    return service.get(param);
}

/**
 * 
 * @author      황의겸
 * @date        2022. 5. 24.
 * @return
 * @throws      Exception
 * @description 상세 팝업
 *                             
 */
@GetMapping(value = { "detail" })
public String detail(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	
	model.addAllAttributes(param);
	return Utilities.getProperty("tiles.crm.blank") + "cst/CR115";
}

/**
*
* @author      황의겸
* @date        2022. 5. 24.
* @return
* @throws      Exception
* @description 추천고객 상세목록
*
*/
@PostMapping(value = { "selectDetail" })
public @ResponseBody Object selectDetail(@RequestBody EzMap param) throws Exception {
   EzPaginationInfo page = param.getPaginationInfo();
   List<RecommendCusVo> list = service.selectDetail(param);
   page.setTotalRecordCount(service.selectDetailCount(param));
   return Utilities.getGridData(list,page);
}

/**
 * 
 * @author 황의겸
 * @date 2022. 5. 24. * @param vo
 * @return
 * @throws Exception
 * @description CRM 추천고객기본 저장
 * */@PostMapping(value = {"save" })
public @ResponseBody Object save(@RequestBody RecommendCusVo vo) throws Exception {
    return service.save(vo);
}

/**
 * 
 * @author 황의겸
 * @date 2022. 5. 24. * @param list
 * @return
 * @throws Exception
 * @description CRM 추천고객기본 리스트 저장
 *
 */
@PostMapping(value = { "saveList" })
public @ResponseBody Object saveList(@RequestBody List<RecommendCusVo> list) throws Exception {
    return service.saveList(list);
}
/**
 * 
 * @author 황의겸
 * @date 2022. 5. 24.
 * @param list
 * @return
 * @throws Exception
 * @description CRM 추천고객기본 리스트 삭제
 *
 */
@PostMapping(value = { "deleteList" })
public @ResponseBody Object deleteList(@RequestBody List<RecommendCusVo> list) throws Exception {
    return service.deleteList(list);
}
}
