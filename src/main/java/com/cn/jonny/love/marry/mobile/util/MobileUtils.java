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
package com.cn.jonny.love.marry.mobile.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能简述 〈〉
 *
 * @author Jonny Chang
 * @version 2019/7/16
 * @since 1.0.0
 */
public class MobileUtils {

  public static String filter(String content) {
    byte[] conbyte = content.getBytes();
    for (int i = 0; i < conbyte.length; i++) {
      if ((conbyte[i] & 0xF8) == 0xF0) {
        for (int j = 0; j < 4; j++) {
          conbyte[i + j] = 0x30;
        }
        i += 3;
      }
    }
    content = new String(conbyte);
    return content.replaceAll("0000", "");
  }

  /** @描述 java生成流水号 14位时间戳 + 6位随机数 @作者 shaomy @时间:2017-1-12 上午10:10:41 @参数:@return @返回值：String */
  public static String getId() {
    String id = "";
    // 获取当前时间戳
    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
    String temp = sf.format(new Date());
    // 获取6位随机数
    int random = (int) ((Math.random() + 1) * 100000);
    id = temp + random;
    return id;
  }
}
