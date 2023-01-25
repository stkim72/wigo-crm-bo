package com.ceragem.crm.cst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName    CrmCustCntplcBasController
 * @author    안재홍
 * @date    2022. 4. 7.
 * @Version    1.0
 * @description    CRM연락처기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "crmCustBas", "{menuCd}/crmCustBas"})
public class CrmCustCntplcBasController{

//@Autowired
//CrmCustCntplcBasService service;
//
///**
// * 
// * @author 안재홍
// * @date 2022. 4. 7. * @param param
// * @param model
// * @return
// * @throws Exception
// * @description CRM연락처기본 목록페이지
// *
// */
//@GetMapping(value = { "", "index" })
//public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    //return Utilities.getProperty("tiles.crm") + "cst/CR009";
//    return "crm/cst/CR009";
//}
//
///**
// * 
// * @author user
// * @date 2022. 4. 13. * @param param
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 목록검색
// *
// */
//@PostMapping(value = { "getList" })
//public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
////    EzPaginationInfo page = param.getPaginationInfo();
////    List<CrmCustCntplcBasVo> list = service.getList(param);
////    page.setTotalRecordCount(service.getListCount(param));
////    return Utilities.getGridData(list,page);
//	return service.getGridList(param);
//}
//
///**
// * 
// * @author user
// * @date 2022. 4. 13. * @param rparam
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 1건검색
// *
// */
//@GetMapping(value = { "get" })
//public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
//    EzMap param = new EzMap(rparam);
//    return service.get(param);
//}
//
///**
// * 
// * @author user
// * @date 2022. 4. 13. * @param rparam
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 등록모드 팝업호출
// *
// */
//@GetMapping(value = { "add" })
//public String add(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//
//	model.addAllAttributes(param);
//	
//	// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
//	CrmCustCntplcBasVo vo = new CrmCustCntplcBasVo();
//	vo.setCntplcSeq(Utilities.getAutoSeq("CNT"));
//	model.addAttribute("vo", vo);
//	model.addAttribute("addMode", true);
//	
//	return Utilities.getProperty("tiles.crm.blank") + "cst/CR010";
//
//}
//
///**
// * 
// * @author user
// * @date 2022. 4. 13. * @param rparam
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 수정모드 팝업호출
// *
// */
//@GetMapping(value = { "mod" })
//public String mod(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//
//
//	model.addAllAttributes(param);
//
//	// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
//	Map<String, Object> vo = service.getData(param.get("cntplcSeq"));
//
//	model.addAttribute("vo", vo);
//	model.addAttribute("addMode", false);
//	
//	return Utilities.getProperty("tiles.crm.blank") + "cst/CR010";
//
//}
//
///**
// * 
// * @author user
// * @date 2022. 4. 13. * @param vo
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 저장
// * */@PostMapping(value = {"save" })
//public @ResponseBody Object save(@RequestBody CrmCustCntplcBasVo vo) throws Exception {
//    return service.insert(vo);
//}
//
///**
// * 
// * @author user
// * @date 2022. 4. 13. * @param list
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 리스트 저장
// *
// */
//@PostMapping(value = { "saveList" })
//public @ResponseBody Object saveList(@RequestBody List<CrmCustCntplcBasVo> list) throws Exception {
//    return service.saveList(list);
//}
///**
// * 
// * @author user
// * @date 2022. 4. 13.
// * @param list
// * @return
// * @throws Exception
// * @description CRM고객연락처기본 리스트 삭제
// *
// */
//@PostMapping(value = { "deleteList" })
//public @ResponseBody Object deleteList(@RequestBody List<CrmCustCntplcBasVo> list) throws Exception {
//    return service.deleteList(list);
//}
}
