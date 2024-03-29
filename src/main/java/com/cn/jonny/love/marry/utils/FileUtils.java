/*
 * Copyright  (c) 2018 - 2019. The EoySky of Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cn.jonny.love.marry.utils;

import java.io.*;

public class FileUtils {
  // 复制方法
  public static void copy(String src, String des) throws Exception {
    // 初始化文件复制
    File file1 = new File(src);
    // 把文件里面内容放进数组
    File[] fs = file1.listFiles();
    // 初始化文件粘贴
    File file2 = new File(des);
    // 判断是否有这个文件有不管没有创建
    if (!file2.exists()) {
      file2.mkdirs();
    }
    // 遍历文件及文件夹
    for (File f : fs) {
      if (f.isFile()) {
        // 文件
        fileCopy(f.getPath(), des + "/" + f.getName()); // 调用文件拷贝的方法
      } else if (f.isDirectory()) {
        // 文件夹
        copy(f.getPath(), des + "/" + f.getName()); // 继续调用复制方法      递归的地方,自己调用自己的方法,就可以复制文件夹的文件夹了
      }
    }
  }

  /** 文件复制的具体方法 */
  private static void fileCopy(String src, String des) throws Exception {
    // io流固定格式
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
    int i = -1; // 记录获取长度
    byte[] bt = new byte[2014]; // 缓冲区
    while ((i = bis.read(bt)) != -1) {
      bos.write(bt, 0, i);
    }
    bis.close();
    bos.close();
    // 关闭流
  }
}
