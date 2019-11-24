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

package com.cn.jonny.love.marry.mobile.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 前台跨域访问配置
 *
 * @author Jonny Chang
 * @version : 2018/10/29
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "response.header")
@Service
public class AccessFilter implements Filter {
  private String allowOrigin;
  private String allowCredentials;
  private String allowMethods;
  private String maxAge;
  private String allowHeaders;
  private String characterEncoding;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    servletRequest.setCharacterEncoding(characterEncoding);
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    // res.setHeader("Access-Control-Allow-Origin", allowOrigin);
    // 响应标头指定 指定可以访问资源的URI路径
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Credentials", allowCredentials);
    // 响应标头指定响应访问所述资源到时允许的一种或多种方法
    res.setHeader("Access-Control-Allow-Methods", allowMethods);
    // 设置 缓存可以生存的最大秒数
    res.setHeader("Access-Control-Max-Age", maxAge);
    // 设置  受支持请求标头
    res.setHeader("Access-Control-Allow-Headers", allowHeaders);
    res.setCharacterEncoding(characterEncoding);
    filterChain.doFilter(servletRequest, res);
  }

  @Override
  public void destroy() {}
}
