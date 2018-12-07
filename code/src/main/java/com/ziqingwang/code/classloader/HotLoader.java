package com.ziqingwang.code.classloader;

/**
 * 热部署的原理
 * 利用同一个class文件不同的类加载器在内存创建出两个不同的class对象，切换实现
 * 在加载类时：
 * 1. 同一个类，不能被重复加载（{@link ClassLoader#findLoadedClass(java.lang.String)} 会检测该类是否被加载过 -- 从缓存查找）
 * 2. 同一个类加载器，同一个.class文件加载的Class对象，在同一个命名空间
 *
 * 为了绕过1，直接调用findClass()方法，绕过缓存检查
 * 为了绕过2，使用不同的类加载器，加载同一个类名的不同Class实例
 *
 * @author: Ziven
 * @date: 2018/12/07
 **/
public class HotLoader {

	public static void main(String[] args) throws Exception {
		FileClassLoader fileClassLoader1 = new FileClassLoader();
		FileClassLoader fileClassLoader2 = new FileClassLoader();
		fileClassLoader2.setHot(true);

		String clazz = "com.ziqingwang.code.classloader.DemoClass.class";
		Object obj = fileClassLoader1.findClass(clazz).newInstance();
		System.out.println("对象："+obj.toString());
		System.out.println(" ------------- 热加载 ----------------  ");
		obj = fileClassLoader2.findClass(clazz).newInstance();
		System.out.println("对象："+obj.toString());
	}

}
