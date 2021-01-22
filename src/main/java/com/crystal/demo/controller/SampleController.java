package com.crystal.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//this restful websservices - Http Response body is granted, just return the Object and its data is automatically written
//in this encapsualtion as JSON orXML -- the counter part @Controller relied on the view used in Spring MVC
@RequestMapping("/api")
public class SampleController {
    @GetMapping("/printHello")
    public String printHelloWorld(){
        return "Hello World";
    }

    //json
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello json(){
        return new Hello("Greeting", "Hello Json");

    }
    private class Hello{
        private String title;
        private String value;

        public Hello(String title, String value) {
            this.title = title;
            this.value = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
