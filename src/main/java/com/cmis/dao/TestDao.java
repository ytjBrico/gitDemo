package com.cmis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cmis.entity.User;


public interface TestDao {
	
	List<Map<String,Object>> testDao(String str);
	
	@Select("select actorno,actorname,nickname,state,telnum from s_user where rownum <= #{num} order by actorno")
	List<User> queryUser(@Param("num") int num);
	
	@Select("select actorno,actorname,nickname,state,telnum from s_user where rownum <= #{num} order by actorno")
	List<Map<?, ?>> queryUserMap(@Param("num") int num);
	
	@Select("select actorno,actorname,nickname,state,telnum from s_user where actorno = #{id}")
	User getUserById(@Param("id") String id);
	
	@Select("select * from s_dic s where s.opttype = 'REFU_REASON_WFL' ")
	Map<String, Object> getTpye();
	
}
