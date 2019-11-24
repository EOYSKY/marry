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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

public class MessageUtil {
  private static XStream xstream =
      new XStream(
          new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
              return new PrettyPrintWriter(out) {
                // 对所有xml节点都增加CDATA标记
                boolean cdata = true;

                @Override
                public void startNode(String name, Class clazz) {
                  super.startNode(name, clazz);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                  if (cdata) {
                    writer.write("<![CDATA[");
                    writer.write(text);
                    writer.write("]]>");
                  } else {
                    writer.write(text);
                  }
                }
              };
            }
          });

  public static HashMap parseXML(HttpServletRequest request) throws Exception {
    HashMap map = new HashMap();
    // 通过IO获得Document
    SAXReader reader = new SAXReader();
    Document doc = reader.read(request.getInputStream());
    // 得到xml的根节点
    Element root = doc.getRootElement();
    recursiveParseXML(root, map);
    return map;
  }

  private static void recursiveParseXML(Element root, HashMap map) {
    // 得到根节点的子节点列表
    List<Element> elementList = root.elements();
    // 判断有没有子元素列表
    if (elementList.size() == 0) {
      map.put(root.getName(), root.getTextTrim());
    } else {
      // 遍历
      for (Element e : elementList) {
        recursiveParseXML(e, map);
      }
    }
  }
}
