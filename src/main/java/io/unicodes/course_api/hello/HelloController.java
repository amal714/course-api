package io.unicodes.course_api.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {


    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi All";
    }

    @RequestMapping
    public String empty(){
        return  "Empty anallo guysss";
    }


}
