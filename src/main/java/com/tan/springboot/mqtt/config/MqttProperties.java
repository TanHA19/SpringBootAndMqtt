package com.tan.springboot.mqtt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author tan
 **/
@Component
@ConfigurationProperties(prefix = "spring.mqtt")
public class MqttProperties {
    private MqttInboundProperties inbound;
    private MqttOutboundProperties outbound;
    public MqttInboundProperties getInbound() {
        return inbound;
    }
    public void setInbound(MqttInboundProperties inbound) {
        this.inbound = inbound;
    }
    public MqttOutboundProperties getOutbound() {
        return outbound;
    }
    public void setOutbound(MqttOutboundProperties outbound) {
        this.outbound = outbound;
    }

    private  char[] password;

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String topics;
    private String url;
    private String username;
}
