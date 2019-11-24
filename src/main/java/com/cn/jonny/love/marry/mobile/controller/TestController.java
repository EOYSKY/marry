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
package com.cn.jonny.love.marry.mobile.controller;

import com.cn.jonny.love.marry.mobile.utils.ParamUtils;
import com.cn.jonny.love.marry.mobile.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 功能简述 〈swagger文档接口测试〉
 *
 * @author Jonny Chang
 * @version 2019/1/14
 * @since 1.0.0
 */
@RestController
public class TestController {

  @ApiOperation("名称和数量")
  @RequestMapping(
      value = "getSixthDataTotal",
      method = {RequestMethod.POST, RequestMethod.GET})
  @ApiImplicitParams({
    @ApiImplicitParam(
        paramType = "query",
        dataType = "Integer",
        name = "type",
        value = "1生产扶贫；2搬迁式扶贫；3生态扶贫；4教育扶贫；5扶贫人数（地图）；6扶贫项目数"),
    @ApiImplicitParam(paramType = "body", dataType = "Map", name = "params", value = "post请求接参对象"),
    @ApiImplicitParam(paramType = "query", dataType = "String", name = "city", value = "区域（城市）"),
    @ApiImplicitParam(
        paramType = "query",
        dataType = "String",
        name = "orderField",
        value = "排序字段 "),
    @ApiImplicitParam(
        paramType = "query",
        dataType = "String",
        name = "orderType",
        value = " 降序(desc)还是升序(asc)")
  })
  public R getSixthDataTotal(
      @RequestParam(value = "type", required = false) Integer type,
      @RequestBody(required = false) Map<String, Object> params,
      @RequestParam(value = "city", required = false) String city,
      @RequestParam(value = "orderField", required = false) String orderField,
      @RequestParam(value = "orderType", required = false) String orderType) {
    if (params != null) {
      //      以map接收post请求参数再赋给相应的变量
      if (type == null) {
        type = ParamUtils.getType(type, params);
      }
      if (params.get("city") != null && city == null) {
        city = params.get("city").toString();
      }
      if (params.get("orderField") != null && orderField == null) {
        orderField = params.get("orderField").toString();
      }
      if (params.get("orderType") != null && orderType == null) {
        orderType = params.get("orderType").toString();
      }
    }
    return new R().ok("success");
  }
}
