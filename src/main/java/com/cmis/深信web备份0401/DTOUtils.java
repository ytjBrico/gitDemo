package gov.szmqs.pacsesc.commons.utils.dto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.szmqs.pacsesc.commons.exception.BizException;
import gov.szmqs.pacsesc.commons.utils.string.StringUtil;
import gov.szmqs.pacsesc.pojo.dto.MgrPublicDTO;

/**
 * - DTO 工具类
 * 
 * @author yangfei701
 * @date 2019年3月29日
 */
public final class DTOUtils {

	private static Logger log = LoggerFactory.getLogger(StringUtil.class);

	/**
	 * - 校验DTO 中是否有字段的指为 null || ""
	 * 
	 * @param dto
	 * @param fields
	 * @return
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	public static boolean checkDTOFieldValueNull(Object dto, Field[] fields) {
		boolean result = true;
		if (dto == null) return result;

		Class<?> cls = dto.getClass();
//		Field[] fields = cls.getDeclaredFields();
		Method[] methods = cls.getDeclaredMethods();

		String fieldGetName = "";
		Method fieldGetMet = null;
		Object fieldVal = null;
		for (Field field : fields) {
			try {
				fieldGetName = parGetName(field.getName());
				if (!checkGetMet(methods, fieldGetName)) {
					throw new BizException();
				}
				fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});
				fieldVal = fieldGetMet.invoke(dto, new Object[] {});
				if (null == fieldVal || "".equals(fieldVal)) {
					result = true;
					break;
				} else {
					result = false;
				}

			} catch (Exception e) {
				if (e instanceof BizException) {
					throw new BizException("DTO 不存在 { " + field + " } 字段的get 方法");
				} else {
					continue;
				}
			}
		}
		return result;
	}

	/**
	 * - 检查DTO 里 指定的字段值是否为null 或者 ""
	 * 
	 * @param dto
	 * @param fileds 需要校验的 字段集
	 * @return
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	public static boolean checkDTOSomeFieldValueNull(Object dto, String[] fields) {
		if (dto == null || fields == null || fields.length == 0) return true;
		
		int len = fields.length;
		Class<?> cls = dto.getClass();
		Field[] nFields = new Field[len];
		for (int i = 0; i < len; i++) {
			try {
				nFields[i] = cls.getDeclaredField(fields[i]);
			} catch (Exception e) {
				continue;
			}
		}

		return checkDTOFieldValueNull(dto, nFields);
	}

	/**
	 * - 检查 DTO 全部字段 是否有字段值为 null || ""
	 * 
	 * @param dto
	 * @return
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	public static boolean checkDTOALLFieldValueNull(Object dto) {
		if (dto == null)
			return true;
		Class<?> cls = dto.getClass();
		Field[] fields = cls.getDeclaredFields();
		return checkDTOFieldValueNull(dto, fields);
	}

	/**
	 * - 得到字段的get方法
	 * 
	 * @param fieldName
	 * @return
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	public static String parGetName(String fieldName) {
		if (null == fieldName || "".equals(fieldName))
			return null;
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

	}

	/*
	 * public static void main(String[] args) { MgrPublicDTO mgrPublicDTO = new
	 * MgrPublicDTO(1, "ds", "aaa", "tsd", "0", "0", "0", "N", "snglkgnsg", "c",
	 * "2019", "cc", "2019", "2019", "2019");
	 * //System.out.println(checkDTOALLFieldValueNull(mgrPublicDTO));
	 * 
	 * String[] h = {"artId","customerId","artTopic"};
	 * 
	 * 
	 * System.out.println(checkDTOSomeFieldValueNull(mgrPublicDTO, h)); }
	 */

	/**
	 * - 判断字段的get方式是否存在
	 * 
	 * @param methods
	 * @param fieldGetMet
	 * @return
	 * @author: yangfei701
	 * @date: 2019年3月29日
	 */
	public static boolean checkGetMet(Method[] methods, String fieldGetMet) {
		// 1.8 API
		// return Arrays.stream(methods).anyMatch((method) -> 
		//        	method.getName().equals(fieldGetMet));
		boolean result = false;
		for (Method method : methods) {
			if (method.getName().equals(fieldGetMet)) {
				result = true;
				return result;
			}
		}
		return result;
	}

}
