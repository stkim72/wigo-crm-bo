package com.ceragem.crm.sys.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.ceragem.crm.common.util.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.sys.model.BatchInfoBasVo;
import com.ceragem.crm.sys.model.CrmApiExecHstVo;
import com.ceragem.crm.sys.service.BatchInfoBasService;

/**
 * 
 * @ClassName BatchInfoBasController
 * @author 김성태
 * @date 2022. 5. 25.
 * @Version 1.0
 * @description 배치정보기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "batch", "{menuCd}/batch" })
public class BatchInfoBasController {

	@Autowired
	BatchInfoBasService service;

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 25. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 배치정보기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "sys/batchList";
	}

	@GetMapping(value = { "detail/{batchCd}" })
	public String detail(CrmApiExecHstVo vo, @PathVariable("batchCd") String batchCd,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAttribute("batchCd", batchCd);
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "sys/batchHistPop";
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 25. * @param param
	 * @return
	 * @throws Exception
	 * @description 배치정보기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<BatchInfoBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 25. * @param rparam
	 * @return
	 * @throws Exception
	 * @description 배치정보기본 1건검색
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
	 * @date 2022. 5. 25. * @param vo
	 * @return
	 * @throws Exception
	 * @description 배치정보기본 저장
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody BatchInfoBasVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 25. * @param list
	 * @return
	 * @throws Exception
	 * @description 배치정보기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<BatchInfoBasVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 25.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 배치정보기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<BatchInfoBasVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 8. 19.
	 * @param batchCd
	 * @return
	 * @throws Exception
	 * @description 배치실행
	 *
	 */
	@GetMapping(value = { "execute/{batchCd}" })
	public @ResponseBody Object execute(@PathVariable("batchCd") String batchCd) throws Exception {
		service.execute(batchCd);
		return true;
	}

}
