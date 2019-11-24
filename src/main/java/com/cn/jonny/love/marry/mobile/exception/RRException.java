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

package com.cn.jonny.love.marry.mobile.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常
 *
 * @author Jonny Chang
 *     <p>create: 2019-01-02 13:49
 * @version: 1.0
 */
public class RRException extends RuntimeException {
  private String msg;
  private HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

  public RRException(String msg) {
    super(msg);
    this.msg = msg;
  }

  public RRException(String msg, Throwable e) {
    super(msg, e);
    this.msg = msg;
  }

  public RRException(String msg, HttpStatus statusCode) {
    super(msg);
    this.msg = msg;
    this.statusCode = statusCode;
  }

  public RRException(String msg, HttpStatus statusCode, Throwable e) {
    super(msg, e);
    this.msg = msg;
    this.statusCode = statusCode;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }
}
