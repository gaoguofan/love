package org.bkn.system.config;

import java.net.MalformedURLException;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages = {"com"},
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, 
    value = org.springframework.stereotype.Controller.class)})
/**
 * MapperScannerConfigurer 实现了JDk动态代理,代理方式为接口代理,其中Java中的动态代理实现有两种方式,如下
 *  1.使用jdk自带的动态代理需要了解InvocationHandler接口和Proxy类，他们都是在java.lang.reflect包下。
        InvocationHandler介绍：InvocationHandler是代理实例的调用处理程序实现的接口。
                   每个代理实例都具有一个关联的InvocationHandler。对代理实例调用方法时，这个方法会调用InvocationHandler的invoke方法。
        Proxy介绍：Proxy 提供静态方法用于创建动态代理类和实例。
        public class TestDynamicProxy {
        @Test
        public void testJDK() {
            TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
            UserService userService = new UserServiceImpl();
            transactionInterceptor.setTarget(userService);
            UserService userServiceProxy =
                    (UserService) Proxy.newProxyInstance(
                            userService.getClass().getClassLoader(),
                            userService.getClass().getInterfaces(),
                            transactionInterceptor);
            userServiceProxy.addUser();
        }
    }
    2.CGLIB是一个功能强大的，高性能、高质量的代码生成库，用于在运行期扩展Java类和实现Java接口。
                它与JDK的动态代理的之间最大的区别就是：
       JDK动态代理是针对接口的，而cglib是针对类来实现代理的，cglib的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。

            架构问题:综合在javaconfig的条件下,如果将MapperScannerConfigurer配置于dateSrouceConfig.class中将导致@Value返回Null,配置失败
            解决办法有两种,第一将MapperScannerConfigurer配置于父容器中,第二种在dateSrouceConfig中使用@MapperScan(basePackages={"com.bkn.browser.mybatis",...})
* @author 高国藩
* @date 2017年3月11日 下午11:51:53
 */
@Import({RedisSourceConfig.class, DataSourceConfig.class})
public class RootConfig {
    
    @Bean
    @Profile(value="dev")
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerDev() throws MalformedURLException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Resource[] locations;
        locations = new Resource[]{
                    new UrlResource("http://file.sumernetwork.com/fanmi/dev/config/jdbc.properties")
                , new UrlResource("http://qiniu.jobwisdom.cn/properties/dev/redis.properties")};
        propertySourcesPlaceholderConfigurer.setLocations(locations);
        return propertySourcesPlaceholderConfigurer;
    }
    
    @Bean
    @Profile(value="pro")
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerPro() throws MalformedURLException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Resource[] locations;
        locations = new Resource[]{
                    new UrlResource("http://qiniu.jobwisdom.cn/properties/bkn/jdbc.properties")
                , new UrlResource("http://qiniu.jobwisdom.cn/properties/bkn/redis.properties")};
        propertySourcesPlaceholderConfigurer.setLocations(locations);
        return propertySourcesPlaceholderConfigurer;
    }
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.bkn.browser.mybatis");
        return mapperScannerConfigurer;
    }
}
