package gov.szmqs.pacsesc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gov.szmqs.pacsesc.pojo.dto.MgrPublicDTO;

/**
 * - 深信web 发布管理service
 * @author yangfei701
 * @date 2019年3月29日
 */
@Service
public interface EcsMgrPublicService {
	
	/**
	 * - 监管用户 新增文章
	 * @param mgrPublic  
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	void addArtBySupMgr(MgrPublicDTO mgrPublic);
	
	/**
	 * - 监管用户 编辑发布管理
	 * @param mgrPublic  
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	void updateArtBySupMgr(MgrPublicDTO mgrPublic);
	
	/**
	 * - 查询监管用户下的文章列表
	 * - 查询按钮共用此接口
	 * @param supMgrId
	 * @return  
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	List<MgrPublicDTO> queryMgrPublicList(MgrPublicDTO mgrPublic);
	
    
}
