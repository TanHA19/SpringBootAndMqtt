package com.tan.springboot.mqtt.config;

/**
 * @Author tan
 **/
public class MqttInboundProperties {
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private String clientId;

}
