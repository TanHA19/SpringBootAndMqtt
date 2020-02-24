package com.tan.springboot.mqtt.config;

/**
 * @Author tan
 **/

public class MqttOutboundProperties {
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private String clientId;
}