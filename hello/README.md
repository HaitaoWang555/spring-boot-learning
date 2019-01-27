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

## 创建定时任务

1. 在Spring Boot的主类中加入`@EnableScheduling`注解，启用定时任务的配置

2. `@Scheduled`详解

```
@Scheduled(fixedRate= 5000)：上一次开始执行时间点之后5秒再执行
@Scheduled(fixedDelay= 5000)：上一次执行完毕时间点之后5秒再执行
@Scheduled(initialDelay=1000,fixedRate=5000)：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
@Scheduled(cron="*/5     * * * * *")：通过cron表达式定义规则
```

## 异步调用

1. `@Async`注解能将原来的同步函数变为异步函数

2. `@Async`注解能够生效，还需要在SpringBoot的主程序中配置`@EnableAsync`

3. `@Async`所修饰的函数不要定义为static类型，这样异步调用不会生效

4. 使用`Future<T>`来返回异步调用的结果

