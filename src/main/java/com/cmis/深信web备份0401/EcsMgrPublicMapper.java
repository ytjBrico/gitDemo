package gov.szmqs.pacsesc.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import gov.szmqs.pacsesc.pojo.dto.MgrPublicDTO;

/**
 * - web 发布管理 Mapper
 * @author yangfei701
 * @date 2019年3月28日
 */
public interface EcsMgrPublicMapper {
	
	/**
	 * - 根据监管用户ID 查询发布管理菜单
	 * - 查询按钮共用此接口
	 * @param CusId 用户Id.
	 * @return  
	 * @author: yangfei701
	 * @date: 2019年3月28日
	 */
	public List<MgrPublicDTO> queryPubListByCusId(MgrPublicDTO mgrPublic);
	
	/**
	 * - 新增
	 * @param mgrPublic  
	 * @author: yangfei701
	 * @date: 2019年3月28日
	 */
	public void addPublic(MgrPublicDTO mgrPublic);
	
	/**
	 * - 编辑,包括修改内容,发布,下架
	 * @param mgrPublic  
	 * @author: yangfei701
	 * @date: 2019年3月28日
	 */
	public void updatePublic(MgrPublicDTO mgrPublic);
	
	@Select("select eu.customer_name from ecs_user eu where eu.customer_id = #{customerId}")
	public String queryCustomerNameByCustomerId(String customerId);
	
	
}
