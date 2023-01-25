package com.ceragem.crm.memship.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.main.service.CrmCustBasService;
import com.ceragem.crm.mem.model.PartnerHomeVo;
import com.ceragem.crm.mem.service.PartnerHomeService;
import com.ceragem.crm.memship.model.CrmCardCustBasVo;
import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.memship.model.CrmGodsBasVo;
import com.ceragem.crm.memship.model.CrmMshipApplyChlRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyStorRelVo;
import com.ceragem.crm.memship.model.CrmMshipCardBasVo;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.memship.service.CrmCardPblsHstService;
import com.ceragem.crm.memship.service.CrmGodsBasService;
import com.ceragem.crm.memship.service.CrmMshipApplyChlRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyGodsRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyStorRelService;
import com.ceragem.crm.memship.service.CrmMshipCardBasService;
import com.ceragem.crm.memship.service.CrmStorBasService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;
import com.ceragem.crm.sys.service.CrmComnCdService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName    CrmMshipCardBasController
 * @author    user
 * @date    2022. 4. 28.
 * @Version    1.0
 * @description    CRM멤버십카드기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Controller
@RequestMapping(value = { "crmMshipCardBas", "{menuCd}/crmMshipCardBas" })
public class CrmMshipCardBasController{
	
	

	@Autowired
	CrmMshipCardBasService service;


	@Autowired
	CrmComnCdService codeService;
	

	@Autowired
	CrmGodsBasService serviceGodsBase;

	@Autowired
	CrmMshipApplyStorRelService serviceStoreRel;


	@Autowired
	CrmMshipApplyGodsRelService serviceGodsRel;


	@Autowired
	CrmMshipApplyChlRelService serviceChlRel;


	@Autowired
	CrmStorBasService serviceStroeBase;
	
	
	@Autowired
	CrmCardPblsHstService serviceCardHst;
	
	@Autowired
	CrmCustBasService serviceCustBase;
	
	@Autowired
	PartnerHomeService servicePartner;


	/**
	 * 
	 * @author user
	 * @date 2022. 4. 28. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM멤버십카드기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);

		param.put("codeCd", "MB020");
		List<CrmComnCdBaseVo> list = codeService.getComboCode(param);
		model.addAttribute("memknd", list);


		return Utilities.getProperty("tiles.crm") + "memship/crmMshipCardBasList";
	}
	


	/**
	 * 
	 * @author user
	 * @date 2022. 4. 28. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십카드기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipCardBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));


		return Utilities.getGridData(list,page);
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
	@GetMapping(value = { "getGodsBaseList" })
	public @ResponseBody Object getGodsBaseList(@RequestParam  Map<String, Object> param) throws Exception {
		List<CrmGodsBasVo> list = serviceGodsBase.getList(param);
		return list;
	}
	
	

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 28. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM멤버십카드기본 1건검색
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
	 * @date 2022. 4. 28. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십카드기본 저장
	 * */
	@PostMapping(value = {"save" })
	 public @ResponseBody Object save(@RequestBody CrmMshipCardBasVo vo) throws Exception {

		 if( "".equals( vo.getStat() ) || "".equals( vo.getMshipCardBasNo() ) ) {
			 vo.setStat("C");
		 }

		 return service.save(vo);
	 }

	 /**
	  * 
	  * @author user
	  * @date 2022. 4. 28. * @param list
	  * @return
	  * @throws Exception
	  * @description CRM멤버십카드기본 리스트 저장
	  *
	  */
	 @PostMapping(value = { "saveList" })
	 public @ResponseBody Object saveList(@RequestBody List<CrmMshipCardBasVo> list) throws Exception {
		 return service.saveList(list);
	 }
	 /**
	  * 
	  * @author user
	  * @date 2022. 4. 28.
	  * @param list
	  * @return
	  * @throws Exception
	  * @description CRM멤버십카드기본 리스트 삭제
	  *
	  */
	 @PostMapping(value = { "deleteList" })
	 public @ResponseBody Object deleteList(@RequestBody List<CrmMshipCardBasVo> list) throws Exception {
		 return service.deleteList(list);
	 }



	 /**
	  * 
	  * @author user
	  * @date 2022. 4. 28. * @param rparam
	  * @return
	  * @throws Exception
	  * @description CRM멤버십카드기본 카드발급 팝업
	  *
	  */
	 @GetMapping(value = { "crdCard" })
	 public String crdCard(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		 model.addAllAttributes(param);
		 return Utilities.getProperty("tiles.crm") + "memship/popCard";
	 }
	 

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param param
		 * @param model
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 적용매장 관리 팝업
		 *
		 */
		@RequestMapping(value = { "popStore" }, method = { RequestMethod.POST, RequestMethod.GET } )
		public String popStore(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
			
			model.addAllAttributes(param);
			
			// 전체 매장
			List<CrmStorBasVo> list = (List<CrmStorBasVo>) serviceStroeBase.getTreeList(param);
			
			
			log.debug("#################"+  param.get("mshipCardBasNo") );

			// 쿠폰이 적용된 매장
			List<CrmStorBasVo> storeList = (List<CrmStorBasVo>) serviceStroeBase.getStoreList(param);
			

			model.addAttribute("allStore", list);
			model.addAttribute("storeList", storeList);
			
			return Utilities.getProperty("tiles.crm") + "memship/popStore";
		}
		
		
		

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param param
		 * @param model
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 적용상품 관리 팝업
		 *
		 */
		@RequestMapping(value = { "popGods" }, method = { RequestMethod.POST, RequestMethod.GET } )
		public String popGods(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
			
			
			model.addAllAttributes(param);
			
			
			// 전체 상품
			List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.selectAllGodList(param);
			

			// 적용된 상품 매장
			List<CrmMshipApplyGodsRelVo> godsList = serviceGodsRel.selectGodList(param);
			

			model.addAttribute("allGods", list);
			model.addAttribute("godsList", godsList);
			
			
			return Utilities.getProperty("tiles.crm") + "memship/popGods";
		}




		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param param
		 * @param model
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 적용매장 관리 팝업
		 *
		 */
		@GetMapping(value = { "popChl" })
		public String popChl(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
			model.addAllAttributes(param);
			
			
			// 전체 채널
			param.put("codeCd", "CU100");
			List<CrmComnCdBaseVo> list = serviceChlRel.selectAllChlList(param);
			

			// 선택된 채널
			List<CrmMshipApplyChlRelVo> channelList = serviceChlRel.selectChlList(param);
			

			model.addAttribute("allChannel", list);
			model.addAttribute("channelList", channelList);
			
			
			return Utilities.getProperty("tiles.crm") + "memship/popChl";
		}



		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param list
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 점포 추가
		 *
		 */
		@PostMapping(value = { "saveStoreList" })
		public @ResponseBody Object saveStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list ) throws Exception {
			return serviceStoreRel.saveList(list);
		}
		

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param list
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 점포 삭제
		 *
		 */
		@PostMapping(value = { "delStoreList" })
		public @ResponseBody Object delStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list ) throws Exception {
			return serviceStoreRel.deleteList(list);
		}



		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param list
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 점포 추가
		 *
		 */
		@PostMapping(value = { "saveGodsList" })
		public @ResponseBody Object saveGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list ) throws Exception {
			return serviceGodsRel.saveList(list);
		}
		

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param list
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 점포 삭제
		 *
		 */
		@PostMapping(value = { "delGodsList" })
		public @ResponseBody Object delGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list ) throws Exception {
			return serviceGodsRel.deleteList(list);
		}

		
		

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param list
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 채널 추가
		 *
		 */
		@PostMapping(value = { "saveChlList" })
		public @ResponseBody Object saveChlList(@RequestBody List<CrmMshipApplyChlRelVo> list ) throws Exception {
			return serviceChlRel.saveList(list);
		}
		

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param list
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 채널 삭제
		 *
		 */
		@PostMapping(value = { "delChlList" })
		public @ResponseBody Object delChlList(@RequestBody List<CrmMshipApplyChlRelVo> list ) throws Exception {
			return serviceChlRel.deleteList(list);
		}

		
		/**
		 * 
		 * @author user
		 * @date 2022. 4. 21. * @param param
		 * @return
		 * @throws Exception
		 * @description CRM멤버십적용매장관계 목록검색
		 *
		 */
		@PostMapping(value = { "getListStoreRel" })
		public @ResponseBody Object getListStoreRel(@RequestBody EzMap param) throws Exception {
			EzPaginationInfo page = param.getPaginationInfo();
			List<CrmMshipApplyStorRelVo> list = serviceStoreRel.getList(param);
			page.setTotalRecordCount(serviceStoreRel.getListCount(param));
			return Utilities.getGridData(list,page);
		}


		/**
		 * 
		 * @author user
		 * @date 2022. 4. 21. * @param param
		 * @return
		 * @throws Exception
		 * @description CRM멤버십적용매장관계 목록검색
		 *
		 */
		@PostMapping(value = { "getStoreTree" })
		public @ResponseBody Object getStoreTree(@RequestBody EzMap param) throws Exception {
			Object list = serviceStroeBase.getTreeList(param);
			return list;
		}



		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param param
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 목록검색
		 *
		 */
		@PostMapping(value = { "getGodsRelList" })
		public @ResponseBody Object getGodsRelList(@RequestBody EzMap param) throws Exception {
			EzPaginationInfo page = param.getPaginationInfo();
			List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.getList(param);
			page.setTotalRecordCount(serviceGodsRel.getListCount(param));
			return Utilities.getGridData(list,page);
		}

		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param param
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 목록검색
		 *
		 */
		@PostMapping(value = { "getChlRelList" })
		public @ResponseBody Object getChlRelList(@RequestBody EzMap param) throws Exception {
			EzPaginationInfo page = param.getPaginationInfo();
			List<CrmMshipApplyChlRelVo> list = serviceChlRel.getList(param);
			page.setTotalRecordCount(serviceChlRel.getListCount(param));
			return Utilities.getGridData(list,page);
		}

		
		/**
		 * 
		 * @author user
		 * @date 2022. 5. 4. * @param param
		 * @return
		 * @throws Exception
		 * @description CRM카드발행이력 목록검색
		 *
		 */
		@PostMapping(value = { "getCardHstList" })
		public @ResponseBody Object getCardHstList(@RequestBody EzMap param) throws Exception {
		    EzPaginationInfo page = param.getPaginationInfo();
		    List<CrmCardPblsHstVo> list = serviceCardHst.getList(param);
		    page.setTotalRecordCount(serviceCardHst.getListCount(param));
		    return Utilities.getGridData(list,page);
		}
		
		
		
		/**
		 * 
		 * @author user
		 * @date 2022. 4. 28. * @param rparam
		 * @return
		 * @throws Exception
		 * @description CRM멤버십카드 회원 검색
		 *
		 */
		@PostMapping(value = { "getCustInfo" })
		public @ResponseBody Object getCustInfo(@RequestBody EzMap param) throws Exception {
			
			
			EzPaginationInfo page = param.getPaginationInfo();
		    List<CrmCardCustBasVo> list = serviceCardHst.getCustInfo(param);
		    page.setTotalRecordCount(serviceCardHst.getCustListCount(param));
		    return Utilities.getGridData(list,page);

			
		}
		
		
		/**
		 * 
		 * @author user
		 * @date 2022. 4. 28. * @param rparam
		 * @return
		 * @throws Exception
		 * @description CRM멤버십카드 발급 이력 검색
		 *
		 */
		@PostMapping(value = { "getCardInfo" })
		public @ResponseBody Object getCardInfo(@RequestBody CrmCardPblsHstVo vo) throws Exception {
			
		
				 CrmCardPblsHstVo cardPblsHstVo = serviceCardHst.get(vo);
//				if( cardPblsHstVo == null ) cardPblsHstVo = new CrmCardPblsHstVo();
		//		cardPblsHstVo.setItgCustNo( mshipCardBasVo.getItgCustNo() );
		//		cardPblsHstVo.setMshipGradeCd( mshipCardBasVo.getMshipGradeCd() );
				
			//	return cardPblsHstVo;
	//		}
			return cardPblsHstVo;
			
		}
		
		
		
		/**
		 * 
		 * @author 김은성
		 * @date 2022. 4. 7. * @param param
		 * @return
		 * @throws Exception
		 * @description CRM멤버십쿠폰기본 쿠폰 발급
		 *
		 */

		@PostMapping(value = { "pubCard" })
		public @ResponseBody Object pubCard(@RequestBody CrmCardPblsHstVo vo) throws Exception  {
			
			long cnt = service.pubCard(vo);
			vo.setCnt(cnt);			
			return vo;
			
		}
		
		

		/**
		 *
		 * @author      김은성
		 * @date        2022. 4. 21.
		 * @return
		 * @throws      Exception
		 * @description 제휴사 목록 검색
		 *
		 */
		@PostMapping(value = { "getPartnerList" })
		public @ResponseBody List<PartnerHomeVo> getPartnerList() throws Exception {
		    return  servicePartner.getList(null);
		}
		
		
		
	

}
