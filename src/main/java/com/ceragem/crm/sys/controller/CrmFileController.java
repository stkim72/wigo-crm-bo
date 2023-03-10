package com.ceragem.crm.sys.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.sys.model.CrmFileVo;
import com.ceragem.crm.sys.service.CrmFileService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * com.ceragem.crm.common.controller - FileController.java
 * </pre>
 *
 * @ClassName : FileController
 * @Description : 파일 컨트롤러
 * @author : 김성태
 * @date : 2021. 1. 8.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Controller
@RequestMapping(value = { "file", "{menuCd}/file" })
public class CrmFileController {
	@Autowired
	CrmFileService service;

	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "sys/fileList";
	}

	@GetMapping(value = { "add", "mod", "fileInfo" })
	public String add(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		String fileCd = (String) param.get("fileCd");
		EzMap ezMap = new EzMap();
		if (Utilities.isEmpty(fileCd))
			ezMap.setString("fileCd", Utilities.getFileCd());
		else
			ezMap.setString("fileCd", fileCd);
		model.addAttribute("fileInfo", ezMap);
		model.addAttribute("fileCd", fileCd);
		if ("view".equals(param.get("mode")))
			return Utilities.getProperty("tiles.crm.blank") + "sys/fileViewPopup";
		else
			return Utilities.getProperty("tiles.crm.blank") + "sys/filePopup";
	}

	@PostMapping(value = { "uploadFile" })
	public @ResponseBody Object uploadFile(@RequestParam("uploadFile") MultipartFile uploadfile, CrmFileVo param)
			throws Exception {
		return service.uploadFile(uploadfile, param);
	}

	@PostMapping(value = { "downloadFile" })
	public @ResponseBody void downloadFile(@RequestBody CrmFileVo fileInfo) throws Exception {
		service.downloadFile(fileInfo);
	}

	@PostMapping(value = { "getFileInfo" })
	public @ResponseBody Object getFileInfo(@RequestBody CrmFileVo fileInfo) throws Exception {
		return service.get(fileInfo);
	}

	@GetMapping(value = { "download" })
	public @ResponseBody void download(CrmFileVo fileInfo) throws Exception {
		service.downloadFile(fileInfo);
	}

	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "addFileInfo" })
	public @ResponseBody Object addFileInfo(@RequestBody CrmFileVo param) throws Exception {
		param.setStat("c");
		return service.save(param);
	}

	@PostMapping(value = { "editFileInfo" })
	public @ResponseBody Object editFileInfo(@RequestBody CrmFileVo param) throws Exception {
		param.setStat("u");
		return service.save(param);
	}

	@PostMapping(value = { "removeFileList" })
	public @ResponseBody Object removeFileInfoList(@RequestBody List<CrmFileVo> param) throws Exception {
		return service.deleteList(param);
	}

	@PostMapping(value = { "removeFileInfo" })
	public @ResponseBody Object removeFileInfo(@RequestBody CrmFileVo param) throws Exception {
		return service.delete(param);
	}

	@PostMapping(value = { "saveFileInfo" })
	public @ResponseBody Object saveFileInfo(@RequestBody CrmFileVo param) throws Exception {
		return service.save(param);
	}

	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody List<CrmFileVo> param) throws Exception {
		return service.saveList(param);
	}

	@GetMapping(value = { "downloadFromUrl" })
	public @ResponseBody void downloadFromUrl(@RequestParam("url") String url, HttpServletResponse response)
			throws Exception {
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new URL(url).openStream());
			String contentsType = "application/octet-stream";
			response.setContentType(contentsType);
			response.setHeader("Content-Disposition",
					"attachment;filename=\"" + URLEncoder.encode(Utilities.getFileName(url), "UTF-8") + "\";");
			Utilities.DownloadStream(response.getOutputStream(), in);
		} catch (Exception ex) {
			throw new HTTPException(404);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
		}
	}

	@GetMapping(value = { "barcode" })
	public @ResponseBody void barcode(@RequestParam("text") String text, HttpServletResponse response)
			throws Exception {
		ByteArrayInputStream in = null;
		try {
			in = new ByteArrayInputStream(service.createCoupon("BBS22032913072800330", 1, text, 90, 965, 815, 147, 0));
//			in = new ByteArrayInputStream(Utilities.createBarcodeByte(text,1000, 150));
			String contentsType = "image/png";
			response.setContentType(contentsType);
			response.setHeader("Content-Disposition",
					"filename=\"" + URLEncoder.encode(text + ".png", "UTF-8") + "\";");
			Utilities.DownloadStream(response.getOutputStream(), in);
		} catch (Exception ex) {
			throw new HTTPException(404);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
		}
	}
}
