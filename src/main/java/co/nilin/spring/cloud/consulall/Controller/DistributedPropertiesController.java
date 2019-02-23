package co.nilin.spring.cloud.consulall.Controller;


import co.nilin.spring.cloud.consulall.utils.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class DistributedPropertiesController {

    @Value("${my.prop}")
    String value;

    @Autowired
    private MyProperties properties;

    @GetMapping("/getConfigFromValue")
    public String getConfigFromValue(){
        return value;
    }

    @GetMapping("getConfigFromProperty")
    public String getConfigFromProperty(){
        return properties.getProp();
    }

}
