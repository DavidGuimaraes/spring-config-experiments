package co.davidguimaraes.configdemo.resources;

import co.davidguimaraes.configdemo.config.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/rest")
public class MainResource {

    @Value("${app.name: My App Uiuiui}")
    private String appName;

    @Value("${test}")
    private String test;

    @Value("Some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> messages;

    @Value("#{${dbvalues}}")
    private Map<String, String> dbvalues;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/hello")
    public String getGreeting(){
        StringBuilder strings = new StringBuilder();

        strings.append("<p>" + this.appName);
        strings.append("<p>" + this.test);
        strings.append("<p>" + this.staticMessage);
        strings.append("<p>" + this.messages);
        strings.append("<p>" + this.dbvalues);
        strings.append("<p>" + this.dbSettings.getConnection());
        strings.append("<p>" + this.dbSettings.getHost());
        strings.append("<p>" + this.dbSettings.getPort());

        return strings.toString();
    }
}
