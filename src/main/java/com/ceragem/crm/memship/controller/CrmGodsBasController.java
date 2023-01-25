package com.ceragem.crm.memship.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.ceragem.crm.common.util.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.memship.model.CrmGodsBasVo;
import com.ceragem.crm.memship.service.CrmGodsBasService;

/**
 * 
 * @ClassName    CrmGodsBasController
 * @author    user
 * @date    2022. 4. 18.
 * @Version    1.0
 * @description    CRM제품기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "crmGodsBas", "{menuCd}/crmGodsBas" })
public class CrmGodsBasController{

@Autowired
CrmGodsBasService service;

/**
 * 
 * @author user
 * @date 2022. 4. 18. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description CRM제품기본 목록페이지
 *
 */
@GetMapping(value = { "", "index" })
public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
    model.addAllAttributes(param);
    return Utilities.getProperty("tiles.crm") + "memship/crmGodsBasList";
}

/**
 * 
 * @author user
 * @date 2022. 4. 18. * @param param
 * @return
 * @throws Exception
 * @description CRM제품기본 목록검색
 *
 */
@PostMapping(value = { "getList" })
public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
    EzPaginationInfo page = param.getPaginationInfo();
    List<CrmGodsBasVo> list = service.getList(param);
    page.setTotalRecordCount(service.getListCount(param));
    return Utilities.getGridData(list,page);
}

/**
 * 
 * @author user
 * @date 2022. 4. 18. * @param rparam
 * @return
 * @throws Exception
 * @description CRM제품기본 1건검색
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
 * @date 2022. 4. 18. * @param vo
 * @return
 * @throws Exception
 * @description CRM제품기본 저장
 * */@PostMapping(value = {"save" })
public @ResponseBody Object save(@RequestBody CrmGodsBasVo vo) throws Exception {
    return service.save(vo);
}

/**
 * 
 * @author user
 * @date 2022. 4. 18. * @param list
 * @return
 * @throws Exception
 * @description CRM제품기본 리스트 저장
 *
 */
@PostMapping(value = { "saveList" })
public @ResponseBody Object saveList(@RequestBody List<CrmGodsBasVo> list) throws Exception {
    return service.saveList(list);
}
/**
 * 
 * @author user
 * @date 2022. 4. 18.
 * @param list
 * @return
 * @throws Exception
 * @description CRM제품기본 리스트 삭제
 *
 */
@PostMapping(value = { "deleteList" })
public @ResponseBody Object deleteList(@RequestBody List<CrmGodsBasVo> list) throws Exception {
    return service.deleteList(list);
}
}
