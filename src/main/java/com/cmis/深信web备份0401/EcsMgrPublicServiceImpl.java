package gov.szmqs.pacsesc.service.impl;

import static gov.szmqs.pacsesc.commons.utils.dto.DTOUtils.checkDTOSomeFieldValueNull;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.pingan.ff.standard.core.exception.BizException;

import gov.szmqs.pacsesc.dao.mapper.EcsMgrPublicMapper;
import gov.szmqs.pacsesc.pojo.dto.MgrPublicDTO;
import gov.szmqs.pacsesc.service.EcsMgrPublicService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EcsMgrPublicServiceImpl implements EcsMgrPublicService{
	
	@Resource
	EcsMgrPublicMapper ecsMgrPublicMapper;
	
	private static final String ERROR_MSG = "传入参数存在空值或非法.!! ";

	@Override
	public void addArtBySupMgr(MgrPublicDTO mgrPublic) {
		log.info("====> addArtBySupMgr 新增发布管理方法start... ");
		String[] fields = new String[]{"customerId","artTopicCode","artTypeCode","artLabelCode","belongCityCode","artStatusCode","artContent"};
		if(checkDTOSomeFieldValueNull(mgrPublic, fields)) {
			log.error("====> addArtBySupMgr 方法传入参数存在空值或非法.!! ");
			throw new BizException(ERROR_MSG);
		}
		if(!"N".equals(mgrPublic.getArtStatusCode())) {
			log.error("====> addArtBySupMgr 新增文章时,传入状态值错误! ");
			throw new BizException("新增文章时,传入状态值错误! ");
		}
		if(StringUtils.isEmpty(mgrPublic.getCustomeName())) {
			mgrPublic.setCustomeName(ecsMgrPublicMapper.queryCustomerNameByCustomerId(mgrPublic.getCustomerId()));
		}
		ecsMgrPublicMapper.addPublic(mgrPublic);
		log.info("====> addArtBySupMgr 新增发布管理方法end... ");
	}

	@Override
	public void updateArtBySupMgr(MgrPublicDTO mgrPublic) {
		log.info("====> updateArtBySupMgr 编辑发布管理方法start... ");
		if(StringUtils.isEmpty(String.valueOf(mgrPublic.getArtId()))) {
			log.error("====> updateArtBySupMgr 方法传入参数存在空值或非法.!!  ");
			throw new BizException(ERROR_MSG);
		}
		ecsMgrPublicMapper.updatePublic(mgrPublic);
		log.info("====> addArtBySupMgr 编辑发布管理方法end... ");
	}

	@Override
	public List<MgrPublicDTO> queryMgrPublicList(MgrPublicDTO mgrPublic) {
		log.info("====> queryMgrPublicList 查询发布管理列表方法start... ");
		if(StringUtils.isEmpty(mgrPublic.getCustomerId())) {
			log.error("====> queryMgrPublicList 方法传入参数存在空值或非法.!! ");
			throw new BizException(ERROR_MSG);
		}
		List<MgrPublicDTO> mgrPublicList = ecsMgrPublicMapper.queryPubListByCusId(mgrPublic);
		log.info("====> addArtBySupMgr 查询发布管理列表方法end... ");
		return mgrPublicList;
	}

	
	
	
	
	
	
}



