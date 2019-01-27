## 新建 spring boot 项目

1. 在[官网](https://start.spring.io/)进行配置,在导入idea

2. 在pom文件中注释掉`spring-boot-starter-tomcat`

3. 新建Hello类

4. 启动项目,浏览器访问`http://localhost:8080/hello` 得到`hello spring boot`

## 配置静态资源访问

Spring Boot默认提供静态资源目录位置需置于classpath下，目录名需符合如下规则

```
/static

/public

/resources

/META-INF/resources
```

## Spring Boot之HTML模版引擎Thymeleaf

1. 在pom.xml添加thymeleaf依赖

2. 配置 `application.properties`

## Spring Boot配置文件`application.properties`

1. 主要用来配置数据库连接、日志相关配置等

2. 自定义属性与加载

3. 多环境配置

```
application-{profile}.properties
spring.profiles.active=profile
```