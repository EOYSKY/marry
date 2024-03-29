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

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class HttpRequestor {
  private String charset = "utf-8";
  private Integer connectTimeout = null;
  private Integer socketTimeout = null;
  private String proxyHost = null;
  private Integer proxyPort = null;

  /**
   * Do GET request
   *
   * @param url
   * @return
   * @throws Exception
   * @throws IOException
   */
  public String doGet(String url) throws Exception {

    URL localURL = new URL(url);

    URLConnection connection = openConnection(localURL);
    HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

    httpURLConnection.setRequestProperty("Accept-Charset", charset);
    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    InputStream inputStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader reader = null;
    StringBuffer resultBuffer = new StringBuffer();
    String tempLine = null;

    if (httpURLConnection.getResponseCode() >= 300) {
      throw new Exception(
          "HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
    }

    try {
      inputStream = httpURLConnection.getInputStream();
      inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
      reader = new BufferedReader(inputStreamReader);

      while ((tempLine = reader.readLine()) != null) {
        resultBuffer.append(tempLine);
      }

    } finally {

      if (reader != null) {
        reader.close();
      }

      if (inputStreamReader != null) {
        inputStreamReader.close();
      }

      if (inputStream != null) {
        inputStream.close();
      }
    }

    return resultBuffer.toString();
  }

  /**
   * Do POST request
   *
   * @param url
   * @param parameterMap
   * @return
   * @throws Exception
   */
  public String doPost(String url, Map parameterMap) throws Exception {

    /* Translate parameter map to parameter date string */
    StringBuffer parameterBuffer = new StringBuffer();
    if (parameterMap != null) {
      Iterator iterator = parameterMap.keySet().iterator();
      String key = null;
      String value = null;
      while (iterator.hasNext()) {
        key = (String) iterator.next();
        if (parameterMap.get(key) != null) {
          value = (String) parameterMap.get(key);
        } else {
          value = "";
        }

        parameterBuffer.append(key).append("=").append(value);
        if (iterator.hasNext()) {
          parameterBuffer.append("&");
        }
      }
    }

    System.out.println("POST parameter : " + parameterBuffer.toString());

    URL localURL = new URL(url);

    URLConnection connection = openConnection(localURL);
    HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

    httpURLConnection.setDoOutput(true);
    httpURLConnection.setRequestMethod("POST");
    httpURLConnection.setRequestProperty("Accept-Charset", charset);
    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    httpURLConnection.setRequestProperty(
        "Content-Length", String.valueOf(parameterBuffer.length()));

    OutputStream outputStream = null;
    OutputStreamWriter outputStreamWriter = null;
    InputStream inputStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader reader = null;
    StringBuffer resultBuffer = new StringBuffer();
    String tempLine = null;

    try {
      outputStream = httpURLConnection.getOutputStream();
      outputStreamWriter = new OutputStreamWriter(outputStream);

      outputStreamWriter.write(parameterBuffer.toString());
      outputStreamWriter.flush();

      if (httpURLConnection.getResponseCode() >= 300) {
        throw new Exception(
            "HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
      }

      inputStream = httpURLConnection.getInputStream();
      inputStreamReader = new InputStreamReader(inputStream);
      reader = new BufferedReader(inputStreamReader);

      while ((tempLine = reader.readLine()) != null) {
        resultBuffer.append(tempLine);
      }

    } finally {

      if (outputStreamWriter != null) {
        outputStreamWriter.close();
      }

      if (outputStream != null) {
        outputStream.close();
      }

      if (reader != null) {
        reader.close();
      }

      if (inputStreamReader != null) {
        inputStreamReader.close();
      }

      if (inputStream != null) {
        inputStream.close();
      }
    }

    return resultBuffer.toString();
  }

  private URLConnection openConnection(URL localURL) throws IOException {
    URLConnection connection;
    if (proxyHost != null && proxyPort != null) {
      Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
      connection = localURL.openConnection(proxy);
    } else {
      connection = localURL.openConnection();
    }
    return connection;
  }

  /**
   * Render request according setting
   *
   * @param connection URL 请求
   */
  private void renderRequest(URLConnection connection) {

    if (connectTimeout != null) {
      connection.setConnectTimeout(connectTimeout);
    }

    if (socketTimeout != null) {
      connection.setReadTimeout(socketTimeout);
    }
  }

  /*
   * Getter & Setter
   */
  public Integer getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Integer connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Integer getSocketTimeout() {
    return socketTimeout;
  }

  public void setSocketTimeout(Integer socketTimeout) {
    this.socketTimeout = socketTimeout;
  }

  public String getProxyHost() {
    return proxyHost;
  }

  public void setProxyHost(String proxyHost) {
    this.proxyHost = proxyHost;
  }

  public Integer getProxyPort() {
    return proxyPort;
  }

  public void setProxyPort(Integer proxyPort) {
    this.proxyPort = proxyPort;
  }

  public String getCharset() {
    return charset;
  }

  public void setCharset(String charset) {
    this.charset = charset;
  }
}
