/**
 * Filename:    ActionState.java   
 * Copyright:   Copyright (c)2014  
 * Company:     CEICT
 *
 * Create at:   2014-6-18 下午2:35:34   
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
 *     2014-6-18     ceict      1.0.0      1.0.0 Version   
 * 
 */
package com.ceict.utils;

import android.util.Log;

/**
 * <pre>
 * <b>
 * action state is used for output debug information
 * </b>
 * </pre>
 * 
 * 
 * @author ceict
 * @version 1.0.0
 * @since JDK 1.6.0
 */
public class ActionState {
	/**
	 * <p>
	 * debug tag
	 */
	private static boolean isDebug = true;

	/**
	 * <p>
	 * this method is used for debug <br>
	 * 2014-6-18
	 * 
	 * @param object
	 *            Object Instance
	 * @param methodName
	 *            Method Name
	 * @param msg
	 *            Message
	 */
	public static void d(Object object, String methodName, String msg) {
		if (isDebug) {
			System.out.println();
			System.out.println();
			System.out.println("==>==>==>==>==>==>==>=*TestLog*=>==>==>==>==>==>==>==>");
			Log.d("###" + object.getClass().getName() + "=>" + methodName + "###\n", "---" + msg + "---\n");
			System.out.println("<==<==<==<==<==<==<==<==<==<==<==<==<==<==<==");
			System.out.println();
		}
	}

	/**
	 * <p>
	 * this method is used for debug <br>
	 * 2014-6-18
	 * 
	 * @param object
	 *            Object Instance
	 * @param methodName
	 *            Method Name
	 * @param msg
	 *            Message
	 * @param e
	 *            Exception Object Instance
	 */
	public static void d(Object object, String methodName, String msg, Exception e) {
		if (isDebug) {
			System.out.println();
			System.out.println("==>==>==>==>==>==>==>=*TestLog*=>==>==>==>==>==>==>==>");
			Log.d("###" + object.getClass().getName() + "=>" + methodName + "###\n", "---" + msg + "---\n", e);
			System.out.println("<==<==<==<==<==<==<==<==<==<==<==<==<==<==<==");
			System.out.println();
		}
	}

}
