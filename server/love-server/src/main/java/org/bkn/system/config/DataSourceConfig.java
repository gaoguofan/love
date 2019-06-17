package org.bkn.system.config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.bkn.web.interceptor.MapInterceptor;
import com.bkn.web.interceptor.PageInterceptor;

@Configuration  
@EnableTransactionManagement
/**
 * 
 * 实现properties属性值的注入方式有两种
 * {
 *      1. @PropertySource({"classpath:/properties/db.properties"}) 在属性上使用@Value
 *      2. PropertySourcesPlaceholderConfigurer 的实现,推荐此方法,原因有三(①使用该类,在xml中也可${}读取属性,②@Value也可使用,③可使用profile属性进行拓展)
 * }
* @author 高国藩
* @date 2017年3月11日 下午1:48:23
 */
/**
 * ComponentScan的属性 
　   basePackageClasses：对basepackages()指定扫描注释组件包类型安全的替代。
   excludeFilters：指定不适合组件扫描的类型。
   includeFilters：指定哪些类型有资格用于组件扫描。
   lazyInit：指定是否应注册扫描的beans为lazy初始化。
   nameGenerator：用于在Spring容器中的检测到的组件命名。
   resourcePattern：控制可用于组件检测的类文件。
   scopedProxy：指出代理是否应该对检测元件产生，在使用过程中会在代理风格时尚的范围是必要的。
   scopeResolver：用于解决检测到的组件的范围。
   useDefaultFilters：指示是否自动检测类的注释 @Component@Repository, @Service, or @Controller 应启用。
   value：basePackages()别名
 */
public class DataSourceConfig {
    
    private Logger logger = Logger.getLogger(DataSourceConfig.class);
    
    @Value(value="${jdbc.url}")
    private String jdbcUrl;
    @Value(value="${jdbc.username}")
    private String userName;
    @Value(value="${jdbc.password}")
    private String passWord;
    
    @Bean
    public com.alibaba.druid.filter.stat.StatFilter statFilter(){
        StatFilter statFilter = new com.alibaba.druid.filter.stat.StatFilter();
        statFilter.setLogSlowSql(true);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }
    
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            druidDataSource.setDriver(driver);
            druidDataSource.setUrl("jdbc:mysql://119.23.187.172:3306/love?useUnicode=true&characterEncoding=utf-8");
            druidDataSource.setUsername(userName);
            druidDataSource.setPassword(passWord);
            druidDataSource.setInitialSize(5);
            druidDataSource.setMinIdle(5);
            druidDataSource.setMaxActive(5);
            druidDataSource.setMaxWait(10000);
            druidDataSource.setDefaultReadOnly(false);
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
            druidDataSource.setMinEvictableIdleTimeMillis(300000);
            druidDataSource.setValidationQuery("SELECT 'x'");
            druidDataSource.setTestWhileIdle(true);
            druidDataSource.setTestOnBorrow(true);
            druidDataSource.setTestOnReturn(true);
            druidDataSource.setPoolPreparedStatements(false);
            druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
            druidDataSource.setTimeBetweenLogStatsMillis(300000);
            List<Filter> filters = new ArrayList<>();
            filters.add(statFilter());
            druidDataSource.setProxyFilters(filters);
        } catch (Exception e) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            e.printStackTrace(printWriter);
            logger.info("mysql startup failed of the \n" + new String(byteArrayOutputStream.toByteArray()));
        }
        return druidDataSource;
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(druidDataSource());
        return dataSourceTransactionManager;
    }
    
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        Interceptor[] plugins = new Interceptor[]{new PageInterceptor(), new MapInterceptor()};
        sqlSessionFactoryBean.setPlugins(plugins);
        Properties sqlSessionFactoryProperties = new Properties();
        sqlSessionFactoryProperties.setProperty("logImpl", "LOG4J");
        sqlSessionFactoryBean.setConfigurationProperties(sqlSessionFactoryProperties);
        ResourcePatternResolver resolver = (ResourcePatternResolver) new PathMatchingResourcePatternResolver(); 
        Resource[] resources = (Resource[]) resolver.getResources("classpath*:sqlMap/*.xml");  
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean;
    }
    
}
