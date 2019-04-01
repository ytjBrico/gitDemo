

drop table if exists `ecs_mgr_public`;
CREATE TABLE `ecs_mgr_public` (
	`art_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`CUSTOMER_ID` varchar(50) not null COMMENT '用户ID(外键)',
	`CUSTOMER_name`	varchar(50)	COMMENT '用户姓名(可冗余字段)',
	`art_topic`	varchar(200) not null COMMENT '文章主题',
	`art_type`	char(1)	not null COMMENT '文章类别(0:法规政策、1:行业动态)',
	`art_label`	char(1) not null COMMENT '文章标签(0:市场监督、1:综合管理)',
	`belong_city` char(1) not null COMMENT '所属主体(0:国家,1:广东省,2:深圳市)',
	`art_status` char(1) not null COMMENT '文章状态(N: 新增, P: 发布, D: 下架)',
	`art_content` text not null COMMENT '文章内容',
	`CREATED_BY` varchar(60) not null COMMENT '创建人',
	`DATE_CREATED` datetime not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`UPDATED_BY` varchar(60) not null COMMENT '更新人',
	`DATE_UPDATED` datetime not null DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='深信web发布管理主表' ENGINE=InnoDB;










