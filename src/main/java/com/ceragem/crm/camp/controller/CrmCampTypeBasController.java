package com.ceragem.crm.camp.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;
import com.ceragem.crm.sys.service.CrmComnCdService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.camp.model.CrmCampTypeBasVo;
import com.ceragem.crm.camp.service.CrmCampTypeBasService;

/**
 * 
 * @ClassName    CrmCampTypeBasController
 * @author    user
 * @date    2022. 6. 14.
 * @Version    1.0
 * @description    캠페인유형기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "crmCampTypeBas", "{menuCd}/crmCampTypeBas" })
public class CrmCampTypeBasController{

@Autowired
CrmCampTypeBasService service;


@Autowired
CrmComnCdService codeService;



/**
 * 
 * @author user
 * @date 2022. 6. 14. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description 캠페인유형기본 목록페이지
 *
 */
@GetMapping(value = { "", "index" })
public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
    model.addAllAttributes(param);
    

	param.put("topComnCd", "CM010");
	param.put("prntsComnCd", "CM010");
	List<CrmComnCdBaseVo> list = codeService.getList(param);
	model.addAttribute("typeList", list);
	
	
    return Utilities.getProperty("tiles.crm") + "camp/crmCampTypeBasList";
}

/**
 * 
 * @author user
 * @date 2022. 6. 14. * @param param
 * @return
 * @throws Exception
 * @description 캠페인유형기본 목록검색
 *
 */
@PostMapping(value = { "getList" })
public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
    EzPaginationInfo page = param.getPaginationInfo();
    List<CrmCampTypeBasVo> list = service.getList(param);
    page.setTotalRecordCount(service.getListCount(param));
    return Utilities.getGridData(list,page);
}

/**
 * 
 * @author user
 * @date 2022. 6. 14. * @param rparam
 * @return
 * @throws Exception
 * @description 캠페인유형기본 1건검색
 *
 */
@GetMapping(value = { "get" })
public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
    EzMap param = new EzMap(rparam);
    return service.get(param);
}
/**
 * 
 * @author user
 * @date 2022. 6. 14. * @param vo
 * @return
 * @throws Exception
 * @description 캠페인유형기본 저장
 * */@PostMapping(value = {"save" })
public @ResponseBody Object save(@RequestBody CrmCampTypeBasVo vo) throws Exception {
    return service.save(vo);
}

/**
 * 
 * @author user
 * @date 2022. 6. 14. * @param list
 * @return
 * @throws Exception
 * @description 캠페인유형기본 리스트 저장
 *
 */
@PostMapping(value = { "saveList" })
public @ResponseBody Object saveList(@RequestBody List<CrmCampTypeBasVo> list) throws Exception {
    return service.saveList(list);
}
/**
 * 
 * @author user
 * @date 2022. 6. 14.
 * @param list
 * @return
 * @throws Exception
 * @description 캠페인유형기본 리스트 삭제
 *
 */
@PostMapping(value = { "deleteList" })
public @ResponseBody Object deleteList(@RequestBody List<CrmCampTypeBasVo> list) throws Exception {
    return service.deleteList(list);
}
}
