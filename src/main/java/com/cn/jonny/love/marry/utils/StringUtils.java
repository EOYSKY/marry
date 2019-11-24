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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class StringUtils {
  public static String getDataString(Date date, String format) {

    try {
      // yyyyMMddHHmmss
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      return formatter.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  public static String generateRefID() {
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    Properties prop = new Properties(System.getProperties());
    String userName = prop.getProperty("user.name");
    String refId = "ST_" + userName + "_" + sdf.format(now);
    return refId;
  }
}
