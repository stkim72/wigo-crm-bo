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
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.model.CusCouponListVo;
import com.ceragem.crm.cst.service.CusCardListService;
import com.ceragem.crm.cst.service.CusCouponListService;
import com.ceragem.crm.cst.service.CusPointListService;
import com.ceragem.crm.cst.service.CusSendListService;
import com.ceragem.crm.cst.service.CusStampListService;


/**
 * 
 * @ClassName    CusCeraCkListController
 * @author    김성태
 * @date    2022. 4. 7.
 * @Version    1.0
 * @description    CRM캠페인기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "cusCouponList", "{menuCd}/cusCouponList" })
public class CusCouponListController{

	@Autowired
	CusCouponListService service;
	@Autowired
	CusPointListService pointService;
	@Autowired
	CusStampListService stampService;
	@Autowired
	CusCardListService cardService;
	@Autowired
	CusSendListService sendService;
	
	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "cst/CusCouponList";
	}
	/*
	 * @GetMapping(value = { "CusPointList"}) public String
	 * CusPointList(@RequestParam Map<String, Object> param, ModelMap model) throws
	 * Exception { model.addAllAttributes(param); return
	 * Utilities.getProperty("tiles.crm") + "cst/CusPointList"; }
	 * 
	 * @GetMapping(value = { "CusStampList"}) public String
	 * CusStampList(@RequestParam Map<String, Object> param, ModelMap model) throws
	 * Exception { model.addAllAttributes(param); return
	 * Utilities.getProperty("tiles.crm") + "cst/CusStampList"; }
	 * 
	 * @GetMapping(value = { "CusCardList"}) public String CusCardList(@RequestParam
	 * Map<String, Object> param, ModelMap model) throws Exception {
	 * model.addAllAttributes(param); return Utilities.getProperty("tiles.crm") +
	 * "cst/CusCardList"; }
	 * 
	 * @GetMapping(value = { "CusSendList"}) public String CusSendList(@RequestParam
	 * Map<String, Object> param, ModelMap model) throws Exception {
	 * model.addAllAttributes(param); return Utilities.getProperty("tiles.crm") +
	 * "cst/CusSendList"; }
	 */
	
	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 목록검색
	 *
	 */
	/*
	 * @PostMapping(value = { "getList" }) public @ResponseBody Object
	 * getList(@RequestBody EzMap param) throws Exception { EzPaginationInfo page =
	 * param.getPaginationInfo(); List<CusCouponListVo> list =
	 * service.getList(param);
	 * page.setTotalRecordCount(service.getListCount(param)); return
	 * Utilities.getGridData(list,page); }
	 */
	/*
	 * @PostMapping(value = { "getPointList" }) public @ResponseBody Object
	 * getPointList(@RequestBody EzMap param) throws Exception { EzPaginationInfo
	 * page = param.getPaginationInfo(); List<CusPointListVo> list =
	 * pointService.getList(param);
	 * page.setTotalRecordCount(pointService.getListCount(param)); return
	 * Utilities.getGridData(list,page); }
	 * 
	 * @PostMapping(value = { "getStampList" }) public @ResponseBody Object
	 * getStampList(@RequestBody EzMap param) throws Exception { EzPaginationInfo
	 * page = param.getPaginationInfo(); List<CusStampListVo> list =
	 * stampService.getList(param);
	 * page.setTotalRecordCount(stampService.getListCount(param)); return
	 * Utilities.getGridData(list,page); }
	 * 
	 * @PostMapping(value = { "getCardList" }) public @ResponseBody Object
	 * getCardList(@RequestBody EzMap param) throws Exception { EzPaginationInfo
	 * page = param.getPaginationInfo(); List<CusCardListVo> list =
	 * cardService.getList(param);
	 * page.setTotalRecordCount(cardService.getListCount(param)); return
	 * Utilities.getGridData(list,page); }
	 * 
	 * @PostMapping(value = { "getSendList" }) public @ResponseBody Object
	 * getSendList(@RequestBody EzMap param) throws Exception { EzPaginationInfo
	 * page = param.getPaginationInfo(); List<CusSendListVo> list =
	 * sendService.getList(param);
	 * page.setTotalRecordCount(sendService.getListCount(param)); return
	 * Utilities.getGridData(list,page); }
	 */
	
	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 7. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 1건검색
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
	    EzMap param = new EzMap(rparam);
	    return service.get(param);
	}
	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 7. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 저장
	 * */@PostMapping(value = {"save" })
	public @ResponseBody Object save(@RequestBody CusCouponListVo vo) throws Exception {
	    return service.save(vo);
	}
	
	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CusCouponListVo> list) throws Exception {
	    return service.saveList(list);
	}
	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 7.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<CusCouponListVo> list) throws Exception {
	    return service.deleteList(list);
	}
}
