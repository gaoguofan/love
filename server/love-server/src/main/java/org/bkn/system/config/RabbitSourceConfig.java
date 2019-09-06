//package org.bkn.system.config;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//
///*@Configuration*/
///**
// * 特点：
//    1.在目标方法之前执行
//    2.后置通知 AfterReturningAdvice
//    3.环绕通知 MethodInterceptor
//    4.异常通知 ThrowsAdvice 定义异常通知，需要实现接口ThrowAdvice接口 。该接口的主要作用是，在目标方法抛出异常后，根据异常的不同做出相应的处理。
//              当该接口处理完异常后，会简单地将异常再次抛出给目标方法。
//    =====顾问Advisor
//    5.通知Advice是Spring提供的一种切面(Aspect)。但其功能过于简单，只能
//             将切面织入到目标类的所有目标方法中，无法完成将切面织入到指定目标方法中。
//             顾问Advisor是Spring提供的另一种切面。其可以完成更为复杂的切面织入功能。PointcutAdvisor是顾问的一种，可以指定具体的切入点。顾问将通知进行了包装，
//             会根据不同的通知类型，在不同的时间点，将切面织入到不同的切入点。
//    PointcutAdvisor接口有两个较为常用的实现类：
//    *：NameMatchMethodPointcutAdvisor 名称匹配方法切入点顾问
//    *:RegexpMethodPointcutAdvisor 正则表达式匹配方法切入点顾问
//    <property name="pattern" value=".*do.*"></property> 表示方法全名（包名，接口名，方法名）
//              运算符 名称 意义
//        . 点号 表示任意单个字符
//        + 加号 表示前一个字符出现一次或者多次
//        * 星号 表示前一个字符出现0次或者多次
//        =====默认Advisor自动代理生成器
//        DefaultAdvisorAutoProxyCreator
//        =====BeanName自动代理生成器
//        BeanNameAutoProxyCreator
//        =====AspectJ对AOP的实现
//            对于AOP这种编程思想，很多框架都进行了实现。Spring就是其中之一，可以完成面向切面编程。然而，AspectJ也实现了AOP的功能，且实现方式更为简捷，
//            使用更加方便，而且还支持注解式开发。所以，Spring又将AspectJ对于AOP的实现也引入到了自己的框架中。
//            在Spring中使用AOP开发时，一般使用AspectJ的实现方式。
//* @author 李志伟
//* @date 2017年3月12日 上午1:08:58
// */
//public class RabbitSourceConfig {
//    
//    @Value(value="${rabbitmq.host}")
//    private String rabbitHost;
//    @Value(value="${rabbitmq.port}")
//    private Integer rabbitPort;
//    @Value(value="${rabbitmq.username}")
//    private String rabbitUserName;
//    @Value(value="${rabbitmq.password}")
//    private String rabbitPassword;
//
//    @Bean
//    public org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(rabbitHost);
//        connectionFactory.setPort(rabbitPort);
//        connectionFactory.setUsername(rabbitUserName);
//        connectionFactory.setPassword(rabbitPassword);
//        return connectionFactory;
//    }
//    
//    @Bean
//    public RabbitAdmin rabbitAdmin(){
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
//        return rabbitAdmin;
//    }
//    
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
//        return rabbitTemplate;
//    }
//}
