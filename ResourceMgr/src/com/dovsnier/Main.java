/**
 * 
 */
package com.dovsnier;

import com.dovsnier.resource.AbstractResourceManager;
import com.dovsnier.resource.ResourceManager;
import com.dovsnier.system.RuntimePolicy;

/**
 * <pre>
 * Main
 * </pre>
 * 
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class Main {
	/**
	 * <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param args
	 */
	public static void main(String[] args) {
		RuntimePolicy.runRnameMode();
		// RuntimePolicy.runUnameMode();
	}

	/**
	 * <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 */
	public static void testManagerField() {
		AbstractResourceManager arm = new ResourceManager();
		System.out.println(arm.TAG);
	}
}
