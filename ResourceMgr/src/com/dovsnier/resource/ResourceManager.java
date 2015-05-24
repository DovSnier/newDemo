/**
 * 
 */
package com.dovsnier.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import com.dovsnier.utils.JudgeUtils;

/**
 * <pre>
 * ResourceManager
 * </pre>
 * 
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class ResourceManager extends AbstractResourceManager {
	private File file;
	private String currentPath;
	private String rootPath;
	private FileWriter fileWriter;

	/*
	 * @see com.dovsnier.resource.AbstractResourceManager#rename(java.lang.String, java.lang.String)
	 */
	@Override
	public void rename(String path, String newName) {
		// currentPath = path + newName;
		file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) { // the directory
				if (file.canRead()) {
					// File fileBack = new File(currentPath);
					// if (!fileBack.exists()) {
					// fileBack.mkdirs();
					// } else {
					// System.err.println("the current directory(" + currentPath + ") is already exist.");
					// exit();
					// }
					File[] listFiles = file.listFiles();
					for (File item : listFiles) {
						if (item.canRead()) {
							if (item.isDirectory()) {
								// rename(item.getParent() + File.separator, item.getName() + preffix);
								rename(item.getAbsolutePath() + File.separator, "");
							} else {
								// item.renameTo(new File(fileBack, item.getName() + suffix));
								if (!item.getName().startsWith(SYSTEM_OPERATION_LOG)) {
									item.renameTo(new File(path, item.getName() + suffix));
									printMsg(" the current operation " + item.getName() + " -> " + item.getName() + suffix + " is success. ");
								}
							}
						} else {
							String warn = "ResourceManager.rename()" + ": the current " + item.getAbsolutePath() + " file or dirctory is not read permission.";
							System.out.println(warn);
							printMsg(warn);
							exit();
						}
					}
				} else {
					String warn = "ResourceManager.rename()" + ": the current " + file.getAbsolutePath() + " file or dirctory is not read permission.";
					System.out.println(warn);
					printMsg(warn);
					exit();
				}
			} else { // the file
				String renamePath = path.substring(0, path.lastIndexOf("\\")) + preffix;
				File renameFile = new File(renamePath);
				if (!renameFile.exists()) {
					renameFile.mkdirs();
				}
				if (!newName.startsWith(SYSTEM_OPERATION_LOG)) {
					file.renameTo(new File(renameFile, newName));
					printMsg(" the current operation " + file.getName() + " -> " + file.getName() + suffix + " is success. ");
				}
			}
		} else {
			System.err.println("the current " + file.getAbsolutePath() + "is not exist.");
			printMsg(" the current operation " + "the current " + file.getAbsolutePath() + "is not exist.");
		}
	}

	/*
	 * @see com.dovsnier.resource.AbstractResourceManager#uname(java.lang.String, java.lang.String)
	 */
	@Override
	public void uname(String path, String newName) {
		file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) { // the directory
				if (file.canRead()) {
					File[] listFiles = file.listFiles();
					for (File item : listFiles) {
						if (item.canRead()) {
							if (item.isDirectory()) {
								uname(item.getAbsolutePath() + File.separator, "");
							} else {
								if (!item.getName().startsWith(SYSTEM_OPERATION_LOG)) {
									int lastIndex = item.getName().lastIndexOf(".");
									if (lastIndex > 0) {
										String name = item.getName().substring(0, lastIndex);
										item.renameTo(new File(path, (name + suffix).trim()));
										printMsg(" the current operation " + item.getName() + " -> " + (name + suffix).trim() + " is success. ");
									} else {
										printMsg(" the current file(" + item.getName() + ") that your not required uname");
									}
								}
							}
						} else {
							String warn = "ResourceManager.rename()" + ": the current " + item.getAbsolutePath() + " file or dirctory is not read permission.";
							System.out.println(warn);
							printMsg(warn);
							exit();
						}
					}
				} else {
					String warn = "ResourceManager.rename()" + ": the current " + file.getAbsolutePath() + " file or dirctory is not read permission.";
					System.out.println(warn);
					printMsg(warn);
					exit();
				}
			} else { // the file
				String renamePath = path.substring(0, path.lastIndexOf("\\")) + preffix;
				File renameFile = new File(renamePath);
				if (!renameFile.exists()) {
					renameFile.mkdirs();
				}
				String name = path.substring(path.lastIndexOf("\\"));
				if (!name.startsWith(SYSTEM_OPERATION_LOG)) {
					file.renameTo(new File(renameFile, (name + suffix).trim()));
					printMsg(file.getName() + " -> " + (name + suffix).trim() + " is success. ");
				}
			}
		} else {
			System.err.println("the current " + file.getAbsolutePath() + "is not exist.");
			printMsg("the current " + file.getAbsolutePath() + "is not exist.");
		}
	}

	/*
	 * @see com.dovsnier.resource.AbstractResourceManager#init(java.lang.String)
	 */
	@Override
	public long init(String path) {
		if (JudgeUtils.isNotEmpty(path)) {
			this.rootPath = path;
			File logFile = new File(rootPath, SYSTEM_OPERATION_LOG + ".log");
			try {
				if (!logFile.exists()) {
					logFile.createNewFile();
				} else {
					// logFile.delete();
				}
				fileWriter = new FileWriter(logFile, true);
				fileWriter.write("\r\n ======================= \r\n");
				fileWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
				try {
					fileWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			return SUCCESS;
		}
		return super.init(path);
	}

	/*
	 * @see com.dovsnier.resource.AbstractResourceManager#exit()
	 */
	@Override
	public long exit() {
		if (JudgeUtils.isNotEmpty(fileWriter)) {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
		return super.exit();
	}

	/**
	 * the print current operation information <br>
	 * 2015年5月24日
	 * 
	 * @version 0.0.1
	 * @param item
	 */
	public void printMsg(String item) {
		String date = getCurrentTime();
		String msg = date + item + "\r\n";
		if (JudgeUtils.isNotEmpty(rootPath)) {
			try {
				fileWriter.append(msg);
				fileWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
				try {
					fileWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			System.out.println(msg);
		}
	}

	private String getCurrentTime() {
		String pattern = "[yyyy-MM-dd HH:mm:ss]";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(System.currentTimeMillis());
		return date;
	}

	/*
	 * @see com.dovsnier.resource.AbstractResourceManager#copy(java.lang.String, java.lang.String)
	 */
	@Override
	public void copy(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @see com.dovsnier.resource.AbstractResourceManager#move(java.lang.String, java.lang.String)
	 */
	@Override
	public void move(String oldPath, String newPath) {
		// File (or directory) to be moved
		File file = new File(oldPath);
		// Destination directory
		File dir = new File(newPath);
		// Move file to new directory
		boolean success = file.renameTo(new File(dir, file.getName()));
	}

	public static boolean Move(File srcFile, String destPath) {
		// Destination directory
		File dir = new File(destPath);
		// Move file to new directory
		boolean success = srcFile.renameTo(new File(dir, srcFile.getName()));
		return success;
	}

	public static void Copy(File oldfile, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			// File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldfile);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
