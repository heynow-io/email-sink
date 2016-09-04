package io.heynow.sink.email.service;

import java.net.URI;

/**
 * Created by Ciffer on 04.09.2016.
 */
public class SmtpEmailServiceProperties {
    private URI host;
    private int port;
    private String username;
    private String password;

    public URI getHost() {
        return host;
    }

    public void setHost(URI host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
