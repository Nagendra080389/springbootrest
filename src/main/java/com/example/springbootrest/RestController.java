package com.example.springbootrest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/consumeFiles", method = RequestMethod.POST)
    public String consumeRest(@RequestParam("filename") MultipartFile filename) throws IOException {

        System.out.println(filename.getName());
        System.out.println(filename.getOriginalFilename());
        System.out.println(filename.getSize());

        return "";

    }
}
