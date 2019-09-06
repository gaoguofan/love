//package com.bkn.system.service;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * 消息队列服务类
//* @author 张进军
//* @date Aug 24, 2015 3:51:04 PM 
//*/
///*@Service*/
//public class RabbitService {
//
//    /** rabbit队列模版方法 */
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    /**
//     * 直播模式发送
//    * @author 李志伟
//    * @date 2017年3月10日 下午3:48:44
//    * @param routingKey
//    * @param object
//     */
//    public void rediredMsgRadio(String routingKey, Object object) {
//        rabbitTemplate.convertAndSend(routingKey, object);
//    }
//}
