package com.lyy.base.testIO;

import java.io.File;

class FileDemo {
    public static void main(String[] args) {
        //文件创建、删除文件、获取文件描述符
        File file0 = new File("D:\\file.txt");//双\\是转义
//        try {
//            file0.createNewFile();//创建一个文件
//            //路径分隔符，win是; linux是:
//            //路径名称分隔符，win是\ linux是/
//            System.out.println(File.pathSeparator);// ;
//            System.out.println(File.separator);// \
//
//            //删除文件
//            if (file0.exists()) {
//                file0.delete();
//            } else {
//                System.out.println("文件不存在");
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

        //对文件夹操作
//        String fileName = "D:" + File.separator + "filepackage";
//        File file1 = new File(fileName);
//        file1.mkdir();

        //列出所有文件
        File file2 = new File("D:\\Store\\surfshark");
//        String[] str = file2.list();
//        for (int i = 0; i < str.length; i++) {
//            System.out.println(str[i]);
//        }

        //使用file.listFiles();列出所有文件，包括隐藏文件
        //使用file.isDirectory();判断指定路径是否是目录
//        System.out.println(file0.isDirectory());
//        System.out.println(file2.isDirectory());

        System.out.println(file2);//D:\Store\surfshark
        System.out.println(file2.getName());//surfshark
        System.out.println(file2.getParent());//D:\Store
        String str = file2.getPath();
        System.out.println(str);//D:\Store\surfshark
        System.out.println(file2.isFile());//false 是否是一个标准文件
    }
}
