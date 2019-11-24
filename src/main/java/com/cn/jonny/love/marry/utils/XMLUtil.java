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

package com.cn.jonny.love.marry.utils;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMLUtil {
  /**
   * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
   *
   * @param strxml
   * @return
   * @throws JDOMException
   * @throws IOException
   */
  public static Map doXMLParse(String strxml) throws JDOMException, IOException {
    strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
    if (null == strxml || "".equals(strxml)) {
      return null;
    }
    Map m = new HashMap();
    InputStream in = new ByteArrayInputStream(strxml.getBytes(StandardCharsets.UTF_8));
    SAXBuilder builder = new SAXBuilder();
    Document doc = builder.build(in);
    Element root = doc.getRootElement();
    List list = root.getChildren();
    Iterator it = list.iterator();
    while (it.hasNext()) {
      Element e = (Element) it.next();
      String k = e.getName();
      String v = "";
      List children = e.getChildren();
      if (children.isEmpty()) {
        v = e.getTextNormalize();
      } else {
        v = XMLUtil.getChildrenText(children);
      }
      m.put(k, v);
    } // 关闭流
    in.close();
    return m;
  }

  /**
   * 获取子结点的xml
   *
   * @param children
   * @return String
   */
  public static String getChildrenText(List children) {
    StringBuffer sb = new StringBuffer();
    if (!children.isEmpty()) {
      Iterator it = children.iterator();
      while (it.hasNext()) {
        Element e = (Element) it.next();
        String name = e.getName();
        String value = e.getTextNormalize();
        List list = e.getChildren();
        sb.append("<" + name + ">");
        if (!list.isEmpty()) {
          sb.append(XMLUtil.getChildrenText(list));
        }
        sb.append(value);
        sb.append("</" + name + ">");
      }
    }
    return sb.toString();
  }
}
