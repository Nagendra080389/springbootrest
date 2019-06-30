package com.example.springbootrest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/consumeFiles", method = RequestMethod.POST)
    public String consumeRest(HttpServletResponse response, HttpServletRequest request) throws IOException {

        System.out.println(request);
        System.out.println(response);
        return "";

    }
}
