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

/** 注册用户表实体 TUnit entity. @author MyEclipse Persistence Tools */
public class UserInfo implements java.io.Serializable {

  private String avatarUrl;
  private String city;
  private String nickName;
  private String province;
  private int gender;
  private String language;
  private String country;

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
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

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "UserInfo{"
        + "avatarUrl='"
        + avatarUrl
        + '\''
        + ", city='"
        + city
        + '\''
        + ", nickName='"
        + nickName
        + '\''
        + ", province='"
        + province
        + '\''
        + ", gender="
        + gender
        + ", language='"
        + language
        + '\''
        + ", country='"
        + country
        + '\''
        + '}';
  }
}
