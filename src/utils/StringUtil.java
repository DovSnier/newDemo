/**
 * Filename:    StringUtil.java   
 * Copyright:   Copyright (c)2014  
 * Company:     Anhry
 *
 * Create at:   2014-10-23 下午2:40:23   
 * 
 * Description:  
 * 
 *  
 * 
 * Modification History:   
 * 
 *       Date        Author      Version     Description   
 * 
 * ----------------------------------------------------------------- 
 * 
 *     2014-10-23     lenovo      1.0.0      1.0.0 Version   
 * 
 */
package com.anhry.lfmanagerclient.utils;

/**
 * @author lenovo
 * @version 1.0.0
 * @since JDK 1.7
 */
public class StringUtil {

	/**
	 * <p>
	 * 判断一个对象是否为空 <br>
	 * 2014-10-23 下午2:41:59
	 * 
	 * @param obj
	 *            要被测试的对象
	 * @return true: 不为空 false: 为空
	 */
	public static boolean isEmpty(Object obj) {
		return obj != null ? true : false;
	}

	/**
	 * <p>
	 * 判断一个字符串是否为空 <br>
	 * 2014-10-23 下午2:46:18
	 * 
	 * @param element
	 *            要被测试的字符串
	 * @return true: 不为空 false: 为空
	 */
	public static boolean isEmpty(String element) {
		return element != null && !"".equals(element) ? true : false;
	}

}
