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
import java.util.Calendar;
import java.util.Date;

public class Formats {

  public static String getNextDayByNum(String startDate, int month) {
    Calendar c = Calendar.getInstance(); // 获得一个日历的实例
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = sdf.parse(startDate); // 初始日期
      c.setTime(date); // 设置日历时间
      c.add(Calendar.MONTH, month); // 在日历的月份上增加6个月
      return sdf.format(c.getTime());
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }
}
