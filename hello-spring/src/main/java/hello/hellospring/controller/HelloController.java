package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")   //    url연결 localhost:8080/hello => get으로연결
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";  //    hello.html연결 => templates안에 hello찾기
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name", required = false) String name, Model model){  // 외부에서 입력값 받기 => url예시: http://localhost:8080/hello-mvc?name=spring!
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  //HTTP통신 프로토콜의 BODY에 문자 내용을 직접 반환하겠다 => html 불필요
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;  //hello kim 이렇게 그대로 클라이언트로 이동  => url 예시: http://localhost:8080/hello-string?name=spring!
    }

    @GetMapping("hello-api")
    @ResponseBody
    // => http://localhost:8080/hello-api?name=spring 객체를 반환하면 객체가 JSON으로 변환됨
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
