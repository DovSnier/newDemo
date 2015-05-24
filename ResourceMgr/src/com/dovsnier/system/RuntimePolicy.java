/**
 * 
 */
package com.dovsnier.system;

import com.dovsnier.resource.AbstractResourceManager;
import com.dovsnier.resource.ResourceManager;
import com.dovsnier.utils.JudgeUtils;

/**
 * <pre>
 * RuntimePolicy
 * </pre>
 * 
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class RuntimePolicy {
	// public static final String path = "C:\\Temp\\test";
	public static final String path = "M:\\MediaCache";

	/**
	 * the current runtime uname mode <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 */
	public static final void runUnameMode() {
		managerOperaion(path, "", "uname");
	}

	/**
	 * the current runtime rename mode <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 */
	public static final void runRnameMode() {
		managerOperaion(path, ".asc", "rename");
	}

	/**
	 * <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param path
	 * @param sufix
	 *            TODO
	 */
	protected static void managerOperaion(String path, String sufix, String type) {
		AbstractResourceManager arm = new ResourceManager();
		AbstractResourceManager.suffix = sufix;
		arm.init(path);
		if (JudgeUtils.isNotEmpty(type)) {
			if (type.equalsIgnoreCase("rename")) {
				arm.rename(path, "");
			} else if (type.equalsIgnoreCase("uname")) {
				arm.uname(path, "");
			} else {
				throw new IllegalArgumentException("the current type parameter is not standar parameter.");
			}
		} else {
			throw new NullPointerException("the current type is null, maybe is fatal.");
		}
		arm.exit();
	}
}
