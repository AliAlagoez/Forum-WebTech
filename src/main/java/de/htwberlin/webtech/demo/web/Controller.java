package de.htwberlin.webtech.demo.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public ModelAndView showHelloWorld() {
        return new ModelAndView ("helloworld");
    }
}
