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

import com.cn.jonny.love.marry.mobile.model.ImgDetailEntity;
import com.cn.jonny.love.marry.mobile.service.ImgService;
import com.cn.jonny.love.marry.mobile.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能简述 〈〉
 *
 * @author Jonny Chang
 * @version 2019/8/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/image")
public class ImageController {

  @Autowired ImgService imgService;

  @ApiOperation(value = "上传图片", notes = "")
  @RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
  public R imgUpload(
      MultipartFile file,
      @RequestParam(value = "flag", required = false) Integer flag,
      @RequestParam(value = "bannerCode", required = false) String bannerCode) {
    return imgService.imgUpload(file, flag, bannerCode);
  }

  @ApiOperation(value = "上传图片", notes = "")
  @RequestMapping(value = "/updateDesc", method = RequestMethod.POST)
  public R updateDesc(@RequestBody ImgDetailEntity imgDetailEntity) {
    return imgService.updateDesc(imgDetailEntity);
  }
}
