package com.ziqingwang.code.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 当class文件不在ClassPath路径下，默认系统类加载器无法找到该class文件，
 * 在这种情况下我们需要实现一个自定义的ClassLoader来加载特定路径下的class文件生成class对象。
 *
 * @author: Ziven
 * @date: 2018/12/07
 **/
public class FileClassLoader extends ClassLoader {
	private boolean hot = false;
	private String dir = "D:\\MyData\\wangzq1\\Desktop\\";
	private String dirHot = dir+"hot\\";
	/**
	 * 编写获取类的字节码并创建class对象的逻辑
	 *
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] classBytes = new byte[0];
		String path = hot?dirHot+name:dir+name;
		// 读取class文件字节码
		try {
			InputStream in = new FileInputStream(path);
			byte[] buffer = new byte[2048];
			int size = 0;
			while ((size = in.read(buffer)) != -1) {
				out.write(buffer, 0, size);
			}
			classBytes = out.toByteArray();
		} catch (Exception e) {
			// ignore
		}
		if(classBytes.length == 0){
			throw new ClassNotFoundException();
		}
		// 二进制字节码 -- class
		return defineClass(name.replace("DemoClass.class","DemoClass"),classBytes,0,classBytes.length);
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	public static void main(String[] args) throws Exception{
		FileClassLoader classLoader = new FileClassLoader();
		Class clazz = classLoader.loadClass("com.ziqingwang.code.classloader.DemoClass.class");
		System.out.printf(clazz.toGenericString());
	}



}
