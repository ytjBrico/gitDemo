package gov.szmqs.pacsesc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import gov.szmqs.pacsesc.commons.exception.BizException;
import gov.szmqs.pacsesc.pojo.dto.MgrPublicDTO;
import gov.szmqs.pacsesc.service.EcsMgrPublicService;

/**
 * @author chenkun876
 */
@RestController
@RequestMapping("/mgrpub")
public class EcsMgrPublicController {

	private static final Logger logger = LoggerFactory.getLogger(EcsMgrPublicController.class);

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private EcsMgrPublicService ecsMgrPublicService;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String SUCCESS_CODE = "200";
	private static final String ERROR_CODE = "400";
	private static final String ERROR_MSG = "系统错误,请稍后重试!";
	
	/**
	 * - 深信web 新增发布文章
	 * 
	 * @author: yangfei701
	 * @date: 2019年4月1日
	 */
	@RequestMapping("/addart")
	public Map<String, Object> addMgrPublicArt() {
		logger.info("====> addMgrPublicArt 发布管理新增文章方法start...");
		Map<String, Object> reMap = new HashMap<String, Object>();
		
		try {
			MgrPublicDTO mgrPublicDTO = makeDTOData();
			
			ecsMgrPublicService.addArtBySupMgr(mgrPublicDTO);
			logger.info("====> addMgrPublicArt 发布管理新增文章方法end...");
			reMap.put("status", SUCCESS);
			reMap.put("msg", "新增成功!");
			reMap.put("code", SUCCESS_CODE);
		} catch (Exception e) {
			logger.error("====> addMgrPublicArt 发布管理新增文章方法异常...====> " + e.getMessage());
			if(e instanceof BizException) {
				reMap.put("msg", e.getMessage());
			} else {
				reMap.put("msg", ERROR_MSG);
			}
			reMap.put("status", ERROR);
			reMap.put("code", ERROR_CODE);
		}
		return reMap;
	}

	/**
	 * - 深信web 编辑文章 包括编辑,发布,下架等操作.
	 * @return  
	 * @author: yangfei701
	 * @date: 2019年4月1日
	 */
	@RequestMapping("/updart")
	public Map<String, Object> updateMgrPublicArt() {
		logger.info("====> updateMgrPublicArt 发布管理编辑文章方法start...");
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			MgrPublicDTO mgrPublicDTO = makeDTOData();
			ecsMgrPublicService.updateArtBySupMgr(mgrPublicDTO);
			if("N".equals(mgrPublicDTO.getArtStatusCode())) {
				reMap.put("msg", "编辑成功!");
			}
			if("P".equals(mgrPublicDTO.getArtStatusCode())) {
				reMap.put("msg", "发布成功!");
			}
			if("D".equals(mgrPublicDTO.getArtStatusCode())) {
				reMap.put("msg", "下架成功!");
			}
			reMap.put("status", SUCCESS);
			reMap.put("code", SUCCESS_CODE);
			logger.info("====> updateMgrPublicArt 发布管理编辑文章方法end...");
		} catch (Exception e) {
			logger.error("====> updateMgrPublicArt 发布管理编辑文章方法异常...====> " + e.getMessage());
			if(e instanceof BizException) {
				reMap.put("msg", e.getMessage());
			} else {
				reMap.put("msg", ERROR_MSG);
			}
			reMap.put("status", ERROR);
			reMap.put("code", ERROR_CODE);
		}
		
		return reMap;
	}
	
	/**
	 * - 深信web 发布管理文章 根据监管用户id 查询出文章列表
	 * @return  
	 * @author: yangfei701
	 * @date: 2019年4月1日
	 */
	@RequestMapping("/listart")
	public Map<String, Object> queryMgrPubList() {
		Map<String, Object> reMap = new HashMap<String, Object>();
		String customerId = StringUtils.trimToEmpty(request.getParameter("customerId"));
		if("".equals(customerId)) {
			reMap.put("msg", "参入监管用户id为空!");
			reMap.put("status", ERROR);
			reMap.put("code", ERROR_CODE);
			return reMap;
		}
		try {
			MgrPublicDTO mgrPublicDTO = makeDTOData();
			ecsMgrPublicService.queryMgrPublicList(mgrPublicDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	/**
	 * - 组装 DTO 参数
	 * @return  
	 * @author: yangfei701
	 * @date: 2019年4月1日
	 */
	private MgrPublicDTO makeDTOData() {
		MgrPublicDTO mgrPublicDTO = new MgrPublicDTO();
		mgrPublicDTO.setArtId(Integer.valueOf(request.getParameter("artId"))); // 文章Id
		mgrPublicDTO.setCustomerId(StringUtils.trimToEmpty(request.getParameter("customerId"))); // 新增文章用户id
		mgrPublicDTO.setCustomeName(StringUtils.trimToEmpty(request.getParameter("customerName"))); // 新增文章用户name
		mgrPublicDTO.setArtTopic(StringUtils.trimToEmpty(request.getParameter("artTopic"))); // 文章主题
		mgrPublicDTO.setArtTypeCode(StringUtils.trimToEmpty(request.getParameter("artTypeCode"))); // 文章类别
		mgrPublicDTO.setArtLabelCode(StringUtils.trimToEmpty(request.getParameter("artLabelCode"))); // 文章标签
		mgrPublicDTO.setBelongCityCode(StringUtils.trimToEmpty(request.getParameter("belongCityCode"))); // 文章所属主体
		mgrPublicDTO.setArtStatusCode(StringUtils.trimToEmpty(request.getParameter("artStatusCode"))); // 文章状态,此处只能为"N"
		mgrPublicDTO.setArtContent(StringUtils.trimToEmpty(request.getParameter("artContent"))); // 文章内容
		mgrPublicDTO.setQueryStrTime(StringUtils.trimToEmpty(request.getParameter("queryStrTime"))); // 查询的开始时间
		mgrPublicDTO.setQueryEndTime(StringUtils.trimToEmpty(request.getParameter("queryEndTime"))); // 查询的结束时间
		
		return mgrPublicDTO;
	}
	
}





