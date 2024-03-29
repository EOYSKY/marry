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

package com.cn.jonny.love.marry.mobile.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;

/**
 * 打印SQL执行时间
 *
 * @author Jonny Chang
 * @version 2017-12-19 21:11:57
 */
@Intercepts({
  @Signature(
      type = Executor.class,
      method = "query",
      args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
  @Signature(
      type = Executor.class,
      method = "update",
      args = {MappedStatement.class, Object.class})
})
public class SqlPrintInterceptor implements Interceptor {

  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
    Object parameterObject = null;
    if (invocation.getArgs().length > 1) {
      parameterObject = invocation.getArgs()[1];
    }

    long start = System.currentTimeMillis();

    Object result = invocation.proceed();

    String statementId = mappedStatement.getId();
    BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
    Configuration configuration = mappedStatement.getConfiguration();
    String sql = getSql(boundSql, parameterObject, configuration);

    long end = System.currentTimeMillis();
    long timing = end - start;
    if (logger.isInfoEnabled()) {
      logger.info("执行sql耗时:{} ms -id:{} -sql:{}", timing, statementId, sql);
    }

    return result;
  }

  @Override
  public Object plugin(Object target) {
    if (target instanceof Executor) {
      return Plugin.wrap(target, this);
    }
    return target;
  }

  @Override
  public void setProperties(Properties properties) {}

  private String getSql(BoundSql boundSql, Object parameterObject, Configuration configuration) {
    String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
    List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
    TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
    if (parameterMappings != null) {
      for (int i = 0; i < parameterMappings.size(); i++) {
        ParameterMapping parameterMapping = parameterMappings.get(i);
        if (parameterMapping.getMode() != ParameterMode.OUT) {
          Object value;
          String propertyName = parameterMapping.getProperty();
          if (boundSql.hasAdditionalParameter(propertyName)) {
            value = boundSql.getAdditionalParameter(propertyName);
          } else if (parameterObject == null) {
            value = null;
          } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
            value = parameterObject;
          } else {
            MetaObject metaObject = configuration.newMetaObject(parameterObject);
            value = metaObject.getValue(propertyName);
          }
          sql = replacePlaceholder(sql, value);
        }
      }
    }
    return sql;
  }

  private String replacePlaceholder(String sql, Object propertyValue) {
    String result;
    if (propertyValue != null) {
      if (propertyValue instanceof String) {
        result = "'" + propertyValue + "'";
      } else if (propertyValue instanceof Date) {
        result = "'" + DATE_FORMAT.format(propertyValue) + "'";
      } else {
        result = propertyValue.toString();
      }
    } else {
      result = "null";
    }
    return sql.replaceFirst("\\?", Matcher.quoteReplacement(result));
  }
}
