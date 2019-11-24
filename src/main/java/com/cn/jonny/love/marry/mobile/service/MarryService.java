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

import com.cn.jonny.love.marry.mobile.model.CommentDto;
import com.cn.jonny.love.marry.mobile.utils.R;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Jonny Chang
 * @version 2019/7/31
 * @since 1.0.0
 */
public interface MarryService {
  R getOpenId(String appid, String secret, String code, String grantType);

  R saveUser(String openId, String userInfo);

  R getHomeImg(String openId);

  R getDetailImage(String openId, String id);

  R getPraise();

  R getComment();

  R doComment(CommentDto commentDto);

  R doPraise(String openId);

  R getMapInfo();

  R checkAdmin(String openId);
}
