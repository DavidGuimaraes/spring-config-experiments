package co.davidguimaraes.configdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration                      //Marks class as a Bean
@ConfigurationProperties("db")      //Looks for the prefix 'db' in application.properties
public class DbSettings {

    private String connection;      //If the class properties have the same name as the ones in application.properties, Spring injects the values in the class properties
    private String host;
    private int port;

    public DbSettings() { }

    public DbSettings(String connection, String host, int port) {
        this.connection = connection;
        this.host = host;
        this.port = port;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
