package com.tan.springboot.mqtt.configuration;

import com.tan.springboot.mqtt.config.MqttProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * 收到订阅
 */
@Configuration
public class MqttInboundConfiguration {
    @Autowired
    private MqttProperties mqttProperties;
    @Autowired
    private MqttPahoClientFactory mqttPahoClientFactory;
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }



    @Bean
    public MessageProducer inbound() {
        String inboundTopics = mqttProperties.getTopics();
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqttProperties.getInbound().getClientId(),mqttPahoClientFactory,
                        inboundTopics);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("接受到消息--"+(String) message.getPayload());
            }

        };
    }
}
