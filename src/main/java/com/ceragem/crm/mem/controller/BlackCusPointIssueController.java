package com.ceragem.crm.mem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.model.BlackCusPointIssueVo;
import com.ceragem.crm.mem.service.BlackCusPointIssueService;

/**
 * 
 * @ClassName    BlackCusPointIssueController
 * @author    황재희
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    부정적립 포인트 관리 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
//@Slf4j
@Controller
@RequestMapping(value = { "blackCusPointIssue", "{menuCd}/blackCusPointIssue" })
public class BlackCusPointIssueController{

@Autowired
BlackCusPointIssueService service;

/**
 * 
 * @author 황재희
 * @date 2022. 5. 17. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description 부정적립 포인트 관리 목록페이지
 *
 */
@GetMapping(value = { "", "index" })
public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
    model.addAllAttributes(param);
    return Utilities.getProperty("tiles.crm") + "mem/MB022";
}

/**
 * 
 * @author 황재희
 * @date 2022. 5. 17. * @param param
 * @return
 * @throws Exception
 * @description 부정적립 포인트 관리 목록검색
 *
 */
@PostMapping(value = { "getList" })
public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
    EzPaginationInfo page = param.getPaginationInfo();
    List<BlackCusPointIssueVo> list = service.getList(param);
    page.setTotalRecordCount(service.getListCount(param));
    return Utilities.getGridData(list,page);
}

/**
 * 
 * @author 황재희
 * @date 2022. 5. 17. * @param rparam
 * @return
 * @throws Exception
 * @description 부정적립 포인트 관리 1건검색
 *
 */
@GetMapping(value = { "get" })
public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
    EzMap param = new EzMap(rparam);
    return service.get(param);
}
/**
 * 
 * @author 황재희
 * @date 2022. 5. 17. * @param vo
 * @return
 * @throws Exception
 * @description 부정적립 포인트 관리 저장
 * */@PostMapping(value = {"save" })
public @ResponseBody Object save(@RequestBody BlackCusPointIssueVo vo) throws Exception {
    return service.save(vo);
}

/**
 * 
 * @author 황재희
 * @date 2022. 5. 17. * @param list
 * @return
 * @throws Exception
 * @description 부정적립 포인트 관리 리스트 저장
 *
 */
@PostMapping(value = { "saveList" })
public @ResponseBody Object saveList(@RequestBody List<BlackCusPointIssueVo> list) throws Exception {
    return service.saveList(list);
}
/**
 * 
 * @author 황재희
 * @date 2022. 5. 17.
 * @param list
 * @return
 * @throws Exception
 * @description 부정적립 포인트 관리 리스트 삭제
 *
 */
@PostMapping(value = { "deleteList" })
public @ResponseBody Object deleteList(@RequestBody List<BlackCusPointIssueVo> list) throws Exception {
    return service.deleteList(list);
}

/**
 * 
 * @author      황재희
 * @date        2022. 5. 18.
 * @return
 * @throws      Exception
 * @description 부정적립 포인트 상세 팝업(그리드 더블 클릭)
 *                             
 */
@GetMapping(value = { "detail/{pointHstSeq}" })
public String detail(BlackCusPointIssueVo vo, @PathVariable("pointHstSeq") String pointHstSeq, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	vo.setPointHstSeq(pointHstSeq);
	model.addAttribute("BlackCusPointIssue", service.get(vo));
	model.addAllAttributes(param);
	return Utilities.getProperty("tiles.crm") + "mem/MB023";
}

/**
 * 
 * @author      황재희
 * @date        2022. 5. 6.
 * @param 		vo
 * @return
 * @throws      Exception
 * @description 포인트발생내역, 잔여포인트 저장
 *
 */
@PostMapping(value = { "savePointScoreList" })
public @ResponseBody Object savePointScoreList(@RequestBody List<BlackCusPointIssueVo> list) throws Exception {
    return service.savePointScoreList(list);
}
}
