package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")   //    url연결 localhost:8080/hello => get으로연결
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";  //    hello.html연결 => templates안에 hello찾기
    }
}
