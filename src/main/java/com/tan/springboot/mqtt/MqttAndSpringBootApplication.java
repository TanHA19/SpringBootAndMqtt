package com.tan.springboot.mqtt;

import com.tan.springboot.mqtt.config.MqttProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author tan
 **/
@SpringBootApplication
@EnableConfigurationProperties(MqttProperties.class)
public class MqttAndSpringBootApplication {
    public static void main(String[] args) {

        SpringApplication.run(MqttAndSpringBootApplication.class,args);
    }
}
