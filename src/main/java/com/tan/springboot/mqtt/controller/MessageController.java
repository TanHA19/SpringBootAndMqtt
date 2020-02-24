package com.tan.springboot.mqtt.controller;

import com.tan.springboot.mqtt.service.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tan
 **/
@RestController
public class MessageController {
    @Autowired
    private MqttGateway mqttGateway;
    @RequestMapping("/send/{topic}/{message}")
    public String sendMsg(@PathVariable String topic, @PathVariable String message){
        /**
         * Quality of Service,服务质量
         * level 0：最多一次的传输
         * level 1：至少一次的传输，(鸡肋)
         * level 2： 只有一次的传输
         */
        mqttGateway.sendToMqtt("发送消息----您好1");
        mqttGateway.sendToMqtt(topic,"发送消息----您好2");
        mqttGateway.sendToMqtt(topic,2,"发送消息----您好3");
        return "SUCCESS";
    }
}
