/**
 * 
 */
package com.dovsnier.resource;

/**
 * <pre>
 * AbstractResourceManager
 * </pre>
 * 
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public abstract class AbstractResourceManager {
	public String TAG = this.getClass().getCanonicalName().substring(this.getClass().getCanonicalName().lastIndexOf(".") + 1);
	/** the rename suffix name */
	public static String suffix = ".asc";
	/** the rename prefix name */
	public static String preffix = "_back";
	/** the current system operation log */
	public static String SYSTEM_OPERATION_LOG = "operation";
	/** the success value */
	protected static final long SUCCESS = 0L;
	/** the default value */
	protected static final long DEFAULT = -1L;

	/**
	 * the initialize resource manager environment <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param path
	 *            the current resource absolute path
	 * @return
	 * 
	 */
	public long init(String path) {
		return DEFAULT;
	}

	/**
	 * the directory or file rename operation <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param path
	 * @param newName
	 */
	public abstract void rename(String path, String newName);

	/**
	 * the remove the file with the last suffix <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param path
	 * @param newName
	 */
	public abstract void uname(String path, String newName);

	/**
	 * the directory or file copy operation <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param oldPath
	 * @param newPath
	 */
	public abstract void copy(String oldPath, String newPath);

	/**
	 * the directory or file move operation <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param oldPath
	 * @param newPath
	 */
	public abstract void move(String oldPath, String newPath);

	/**
	 * the exit environment <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @return
	 */
	public long exit() {
		return DEFAULT;
	};
}
