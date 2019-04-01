package gov.szmqs.pacsesc.pojo.dto;

import gov.szmqs.pacsesc.commons.pojo.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * - 发布管理DTO
 * @author yangfei701
 * @date 2019年3月28日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MgrPublicDTO{
	
	private Integer artId;		     // 文章ID
	private String customerId;	     // 监管用户ID
	private String customeName;	     // 用户姓名
	private String artTopic;	     // 文章主题
	private String artTypeCode;	     // 文章类别code码(0,1,all)
	private String artTypeValue;	 // 文章类别(0:法规政策、1:行业动态, all: 全部)
	private String artLabelCode;     // 文章标签code码(0,1)
	private String artLabelValue;	 // 文章标签(0:市场监督、1:综合管理)
	private String belongCityCode;	 // 所属主体code码(0,1,2)
	private String belongCityValue;	 // 所属主体(0:国家,1:广东省,2:深圳市)
	private String artStatusCode;	 // 文章状态code码(N, P, D, all)
	private String artStatusValue;	 // 文章状态(N: 新增, P: 发布, D: 下架, all: 全部)
	private String artContent;	     // 文章内容
	
	private String queryStrTime;	 // 查询的开始时间
	private String queryEndTime;	 // 查询的结束时间
	
	
	

}





