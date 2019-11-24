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

package com.cn.jonny.love.marry.mobile.utils;

import com.alibaba.druid.util.StringUtils;

/**
 * @author Jonny Chang
 *     <p>create: 2019-01-03 11:54
 * @version: 1.0
 */
public class TimeUtil {
  /**
   * @param time 2018-12-30 22:33:88
   * @return 2018-12-30 或者 time
   */
  public static String getTime(String time) {
    if (!StringUtils.isEmpty(time)) {
      String[] times = time.split(" ");
      if (2 == times.length) {
        time = times[0];
      }
    }
    return time;
  }
}
