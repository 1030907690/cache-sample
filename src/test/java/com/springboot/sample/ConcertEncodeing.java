package com.springboot.sample;

/**
 * zzq
 * 2021年4月20日14:33:52
 * 批量转换文件编码
 **/

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;

public class ConcertEncodeing {

    public static void main(String[] args) {
        convertCharset("D:\\work\\self\\Tinix", Charset.forName("GBK"), Charset.forName("UTF-8"), "c");
    }

    /**
     * 转换文件编码格式
     *
     * @param path        需要转换的文件或文件夹路径
     * @param fromCharset 原编码格式
     * @param toCharset   目标编码格式
     * @param extName   需要转换的文件扩展名,如需全部转换则传 null
     */
    private static void convertCharset(String path, Charset fromCharset, Charset toCharset, String extName) {
        if (StrUtil.isBlank(path)) {
            return;
        }
        File file = FileUtil.file(path);
        File[] listFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (StrUtil.isBlank(extName)) {
                    return true;
                }
                if (FileUtil.isDirectory(pathname) || FileUtil.extName(pathname).equals(extName)) {
                    return true;
                }
                return false;
            }
        });
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                String canonicalPath = FileUtil.getCanonicalPath(listFiles[i]);
                //每个文件夹分个线程处理,提高点儿效率
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        convertCharset(canonicalPath, fromCharset, toCharset, extName);
                    }
                }).start();
            } else {
                System.out.println(" 正在转换 " + listFiles[i]);
                FileUtil.convertCharset(listFiles[i], fromCharset, toCharset);
                Console.log("转换完成文件名:{}", listFiles[i].getName());
            }
        }
    }
}
