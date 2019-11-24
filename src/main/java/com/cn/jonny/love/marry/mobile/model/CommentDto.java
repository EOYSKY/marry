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

/**
 * 功能简述 〈〉
 *
 * @author Jonny Chang
 * @version 2019/8/2
 * @since 1.0.0
 */
public class CommentDto {
  private String userOpenId;
  private String comment;
  private String createTime;
  private String nickName;
  private String province;
  private String avatarUrl;

  @Override
  public String toString() {
    return "CommentDto{"
        + "userOpenId='"
        + userOpenId
        + '\''
        + ", comment='"
        + comment
        + '\''
        + ", createTime='"
        + createTime
        + '\''
        + ", nickName='"
        + nickName
        + '\''
        + ", province='"
        + province
        + '\''
        + ", avatarUrl='"
        + avatarUrl
        + '\''
        + '}';
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getUserOpenId() {
    return userOpenId;
  }

  public void setUserOpenId(String userOpenId) {
    this.userOpenId = userOpenId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }
}
