package com.aop.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/11/2
 * @Modified By
 */
@RestController

public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        System.out.println("Hello" + name);
        return "Hello" + name;
    }
}
