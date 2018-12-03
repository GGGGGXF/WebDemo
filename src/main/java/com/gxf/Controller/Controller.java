package com.gxf.Controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Controller {
    @RequestMapping("/index")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    public String index() {
        return "Hello World!";
    }
}
