package com.ceragem.crm.cst.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.model.CrmCustBasListVo;
import com.ceragem.crm.main.service.CrmCustBasService;

/**
 * 
 * @ClassName    CrmCustBasListController
 * @author    user
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM고객기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "crmCustPerson", "{menuCd}/crmCustPerson" })
public class CrmCustBasListController{

@Autowired
CrmCustBasService service;

//eon
@Value("${spring.eon.send.url}")
String eonUrl;

@Value("${spring.eon.send.user}")
String eonUser;

//회원이력

/**
 * 
 * @author user
 * @date 2022. 4. 19. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description CRM고객기본 목록페이지
 *
 */
@GetMapping(value = { "", "index" })
public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	model.addAttribute("eonUrl",eonUrl);
    model.addAttribute("eonUser",eonUser);
	model.addAllAttributes(param);
    return Utilities.getProperty("tiles.crm") + "cst/CR002";
}

/**
 * 
 * @author user
 * @date 2022. 4. 19. * @param param
 * @return
 * @throws Exception
 * @description CRM고객기본 목록검색
 *
 */
@PostMapping(value = { "getList" })
public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	return service.getGridList(param);
}

/**
 * 
 * @author user
 * @date 2022. 4. 19. * @param rparam
 * @return
 * @throws Exception
 * @description CRM고객기본 1건검색
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
 * @date 2022. 4. 19. * @param vo
 * @return
 * @throws Exception
 * @description CRM고객기본 저장
 * */@PostMapping(value = {"save" })
public @ResponseBody Object save(@RequestBody CrmCustBasListVo vo) throws Exception {
    return service.save(vo);
}

/**
 * 
 * @author user
 * @date 2022. 4. 19. * @param list
 * @return
 * @throws Exception
 * @description CRM고객기본 리스트 저장
 *
 */
@PostMapping(value = { "saveList" })
public @ResponseBody Object saveList(@RequestBody List<CrmCustBasListVo> list) throws Exception {
    return service.saveList(list);
}
/**
 * 
 * @author user
 * @date 2022. 4. 19.
 * @param list
 * @return
 * @throws Exception
 * @description CRM고객기본 리스트 삭제
 *
 */
@PostMapping(value = { "deleteList" })
public @ResponseBody Object deleteList(@RequestBody List<CrmCustBasListVo> list) throws Exception {
    return service.deleteList(list);
}

/**
 * 
 * @author 안재홍
 * @date 2022. 4. 7. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description CRM연락처기본 목록페이지
 *
 */
//@GetMapping(value = { "sub/crmCustCntplcBas" })
//public String subCrmCustCntplcBasInit(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    //return Utilities.getProperty("tiles.crm") + "cst/CR009";
//    return "crm/cst/CR009";
//}

/**
 * 
 * @author 황의겸
 * @date 2022. 4. 26. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description CRM 회원이력기본 목록페이지 ( 쿠폰, 포인트, 스탬프, 카드, 발송)
 *
 */ 
//@GetMapping(value = { "sub/couponList" })
//public String couponList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    return Utilities.getProperty("tiles.crm") + "cst/CusCouponList";
//}
//@GetMapping(value = { "sub/pointList"})
//public String pointList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    return Utilities.getProperty("tiles.crm") + "cst/CusPointList";
//}
//@GetMapping(value = { "sub/stampList"})
//public String stampList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    return Utilities.getProperty("tiles.crm") + "cst/CusStampList";
//}
//@GetMapping(value = { "sub/cardList"})
//public String cardList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    return Utilities.getProperty("tiles.crm") + "cst/CusCardList";
//}
//@GetMapping(value = { "sub/sendList"})
//public String sendList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//    model.addAllAttributes(param);
//    return Utilities.getProperty("tiles.crm") + "cst/CusSendList";
//}

	
/**
 * 
 * @author 황의겸
 * @date 2022. 4. 26. * @param param
 * @param model
 * @return
 * @throws Exception
 * @description CRM 회원이력기본 목록검색 ( 쿠폰, 포인트, 스탬프, 카드, 발송)
 *
 */ 
//@PostMapping(value = { "getCouponList" })
//public @ResponseBody Object getCouponList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CusCouponListVo> list = couponService.getList(param);
//    page.setTotalRecordCount(couponService.getListCount(param));
//    return Utilities.getGridData(list,page);
//}
//@PostMapping(value = { "getPointList" })
//public @ResponseBody Object getPointList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CusPointListVo> list = pointService.getList(param);
//    page.setTotalRecordCount(pointService.getListCount(param));
//    return Utilities.getGridData(list,page);
//}
//@PostMapping(value = { "getStampList" })
//public @ResponseBody Object getStampList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CusStampListVo> list = stampService.getList(param);
//    page.setTotalRecordCount(stampService.getListCount(param));
//    return Utilities.getGridData(list,page);
//}
//@PostMapping(value = { "getCardList" })
//public @ResponseBody Object getCardList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CusCardListVo> list = cardService.getList(param);
//    page.setTotalRecordCount(cardService.getListCount(param));
//    return Utilities.getGridData(list,page);
//}
//@PostMapping(value = { "getSendList" })
//public @ResponseBody Object getSendList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CusSendListVo> list = sendService.getList(param);
//    page.setTotalRecordCount(sendService.getListCount(param));
//    return Utilities.getGridData(list,page);
//}

/**
 * 
 * @author user
 * @date 2022. 4. 13. * @param param
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 목록검색
 *
 */
//@PostMapping(value = { "sub/crmCustCntplcBas/getList" })
//public @ResponseBody Object subCrmCustCntplcBasGetList(@RequestBody EzMap param) throws Exception {
////    EzPaginationInfo page = param.getPaginationInfo();
////    List<CrmCustCntplcBasVo> list = service.getList(param);
////    page.setTotalRecordCount(service.getListCount(param));
////    return Utilities.getGridData(list,page);
//	return crmCustCntplcBasService.getGridList(param);
//}

/**
 * 
 * @author user
 * @date 2022. 4. 13. * @param rparam
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 1건검색
 *
 */
//@GetMapping(value = { "sub/crmCustCntplcBas/get" })
//public @ResponseBody Object subCrmCustCntplcBasGet(@RequestParam Map<String, Object> rparam) throws Exception {
//    EzMap param = new EzMap(rparam);
//    return crmCustCntplcBasService.get(param);
//}

/**
 * 
 * @author user
 * @date 2022. 4. 13. * @param rparam
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 등록모드 팝업호출
 *
 */
//@GetMapping(value = { "sub/crmCustCntplcBas/add" })
//public String subCrmCustCntplcBasAdd(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//
//	model.addAllAttributes(param);
//	
//	// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
//	CrmCustCntplcBasVo vo = new CrmCustCntplcBasVo();
//
//	vo.setCntplcSeq(Utilities.getAutoSeq("CNT"));
//	vo.setItgCustNo((String) param.get("itgCustNo"));
//	
//	model.addAttribute("vo", vo);
//	model.addAttribute("addMode", true);
//	
//	return Utilities.getProperty("tiles.crm.blank") + "cst/CR010";
//
//}

/**
 * 
 * @author user
 * @date 2022. 4. 13. * @param rparam
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 수정모드 팝업호출
 *
 */
//@GetMapping(value = { "sub/crmCustCntplcBas/mod" })
//public String subCrmCustCntplcBasMod(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//
//
//	model.addAllAttributes(param);
//
//	// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
//	Map<String, Object> vo = crmCustCntplcBasService.getData(param.get("cntplcSeq"));
//
//	model.addAttribute("vo", vo);
//	model.addAttribute("addMode", false);
//	
//	return Utilities.getProperty("tiles.crm.blank") + "cst/CR010";
//
//}

/**
 * 
 * @author user
 * @date 2022. 4. 13. * @param vo
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 저장
 * */
//@PostMapping(value = {"sub/crmCustCntplcBas/save" })
//public @ResponseBody Object subCrmCustCntplcBassave(@RequestBody CrmCustCntplcBasVo vo) throws Exception {
//	
//	String state = vo.getStat();
//	vo.setRegChlCd("CRM");
//	
//	if(state.equals("c")) {
//		return crmCustCntplcBasService.insert(vo);
//	}else {
//		return crmCustCntplcBasService.update(vo);
//	}
//
//}

 /**
  * 
  * @author user
  * @date 2022. 4. 13. * @param vo
  * @return
  * @throws Exception
  * @description CRM고객연락처기본 삭제
  * */
//@PostMapping(value = {"sub/crmCustCntplcBas/remove" })
//public @ResponseBody Object subCrmCustCntplcBasDelete(@RequestBody CrmCustCntplcBasVo vo) throws Exception {
//
//// 	String state = vo.getStat();
//	vo.setRegChlCd("CRM");
//
//	return crmCustCntplcBasService.delete(vo);
//
//}
  
/**
 * 
 * @author user
 * @date 2022. 4. 13. * @param list
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 리스트 저장
 *
 */
//@PostMapping(value = { "sub/crmCustCntplcBas/saveList" })
//public @ResponseBody Object subCrmCustCntplcBassaveList(@RequestBody List<CrmCustCntplcBasVo> list) throws Exception {
//    return crmCustCntplcBasService.saveList(list);
//}
/**
 * 
 * @author user
 * @date 2022. 4. 13.
 * @param list
 * @return
 * @throws Exception
 * @description CRM고객연락처기본 리스트 삭제
 *
 */
//@PostMapping(value = { "sub/crmCustCntplcBas/deleteList" })
//public @ResponseBody Object subCrmCustCntplcBasdeleteList(@RequestBody List<CrmCustCntplcBasVo> list) throws Exception {
//    return crmCustCntplcBasService.deleteList(list);
//}


}
