package com.lr.cloudadmin.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月15日
 */
@Component
@ConfigurationProperties(prefix = "audience")
public class Audience {
    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
}
