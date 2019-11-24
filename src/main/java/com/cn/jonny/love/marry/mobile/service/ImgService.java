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
package com.cn.jonny.love.marry.mobile.service;

import com.cn.jonny.love.marry.mobile.model.ImgDetailEntity;
import com.cn.jonny.love.marry.mobile.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Jonny Chang
 * @version 2019/8/13
 * @since 1.0.0
 */
public interface ImgService {
  R imgUpload(MultipartFile file, Integer flag, String bannerCode);

  R updateDesc(ImgDetailEntity imgDetailEntity);
}
