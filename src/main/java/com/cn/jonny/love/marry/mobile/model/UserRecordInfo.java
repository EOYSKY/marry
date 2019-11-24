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
package com.cn.jonny.love.marry.mobile.model;

import java.sql.Timestamp;

/**
 * 功能简述 〈〉
 *
 * @author Jonny Chang
 * @version 2019/8/1
 * @since 1.0.0
 */
public class UserRecordInfo {
  private Integer id;
  private String userOpenId;
  private Timestamp createTime;

  @Override
  public String toString() {
    return "UserRecordInfo{"
        + "id="
        + id
        + ", userOpenId='"
        + userOpenId
        + '\''
        + ", createTime="
        + createTime
        + '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserOpenId() {
    return userOpenId;
  }

  public void setUserOpenId(String userOpenId) {
    this.userOpenId = userOpenId;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
}
