package co.davidguimaraes.configdemo.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MainResource {

    @Value("${app.name}")
    private String appName;

    @Value("${test}")
    private String test;

    @GetMapping("/hello")
    public String getGreeting(){
        return "Welcome to " + this.appName + "!\n" + this.test;
    }
}
