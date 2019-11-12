package com.ericaShy.java8.objects;

/**
 *   System.getProperties() 确定当前的系统属性, 几个主要的属性
 *
 *   java.class.path : java类路径
 *   java.library.path: 加载库时搜索的路径列表
 *   file.separator: 文件分隔符(Unix是/)
 *   path.separator: 路径分隔符(Unix是:)
 *   line.separator: 行分割符(Windows CR(回车 \r (13) ) LF(换行 \n (11)))
 *   user.dir: 用户当前的工作目录
 */
public class ShowProperties {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("path.separator"));
        String lineSeparator = System.getProperty("line.separator");
        System.out.println(lineSeparator.length() + "-------" + ((byte) (lineSeparator.charAt(0)) + "-----" + ((byte) (lineSeparator.charAt(1)))));
        System.out.println(System.getProperty("user.dir"));
        System.out.println("==========================");
        System.getProperties().list(System.out);

        System.out.println("============================");
        System.out.println("This is is a test\r\ndasdad");

    }

}
