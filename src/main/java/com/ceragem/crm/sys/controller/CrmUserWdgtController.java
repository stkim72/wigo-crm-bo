package com.ceragem.crm.sys.controller;

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
import com.ceragem.crm.sys.model.CrmUserWdgtVo;
import com.ceragem.crm.sys.service.CrmUserWdgtService;

@Controller
@RequestMapping(value = { "crmUserWdgt", "{menuCd}/crmUserWdgt" })
public class CrmUserWdgtController{

@Autowired
CrmUserWdgtService service;

@GetMapping(value = { "", "index" })
public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
    model.addAllAttributes(param);
    return Utilities.getProperty("tiles.crm") + "sys/crmUserWdgtList";
}

@PostMapping(value = { "getList" })
public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
    EzPaginationInfo page = param.getPaginationInfo();
    param.setString("userCd", Utilities.getLoginUserCd());
    List<EzMap> list = service.getList(param);
    page.setTotalRecordCount(service.getListCount(param));
    return Utilities.getGridData(list,page);
}

@GetMapping(value = { "get" })
public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
    EzMap param = new EzMap(rparam);
    return service.get(param);
}
@PostMapping(value = {"save" })
public @ResponseBody Object save(@RequestBody CrmUserWdgtVo vo) throws Exception {
    return service.save(vo);
}

@PostMapping(value = { "saveList" })
public @ResponseBody Object saveList(@RequestBody List<CrmUserWdgtVo> list) throws Exception {
    return service.saveList(list);
}
@PostMapping(value = { "deleteList" })
public @ResponseBody Object deleteList(@RequestBody List<CrmUserWdgtVo> list) throws Exception {
    return service.deleteList(list);
}
}
