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

package com.cn.jonny.love.marry.mobile.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.ant;

/**
 * Swagger 配置
 *
 * @author jonny
 * @version 2019/11/24
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiger {

  /**
   * REST Api
   *
   * @return {@link springfox.documentation.spring.web.plugins.Docket}
   */
  @Bean
  public Docket restApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("ShopApplication")
        .forCodeGeneration(false)
        // 最终调用的接口后会和paths拼接在一起
        .pathMapping("/")
        .select()
        .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error"))))
        .build()
        .apiInfo(apiApiInfo());
  }

  /**
   * apiApi信息
   *
   * @return {@link ApiInfo}
   */
  private ApiInfo apiApiInfo() {
    return new ApiInfoBuilder()
        .title("party") // 大标题
        .description(
            "Service Platform's REST API, all the applications could access the Object model data via JSON.") // 详细描述
        .version("1.0") // 版本
        .termsOfServiceUrl("NO terms of service")
        // .contact(new Contact("chenglong.tian", "", "chenglong.tian@percent.cn"))//作者
        .license("The Apache License, Version 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .build();
  }
}
