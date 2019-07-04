package com.example.springbootrest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @CrossOrigin(origins = {"https://nagesingh-dev-ed--c.visualforce.com", "chrome-extension://aejoelaoggembcahagimdiliamlcdmfm","https://hcscace--acedev--c.cs90.visual.force.com"})
    @RequestMapping(value = "/consumeFiles", method = RequestMethod.POST)
    public List<FileAttachmentMerged> consumeRest(@RequestParam(value = "metadata", required = true)String jsonData ,
                                                  @RequestParam(value = "filename", required = true)MultipartFile filename) throws IOException {
        //create a temp file
        File temp = File.createTempFile("temp-file-name", ".tmp");

        System.out.println("Temp file : " + temp.getAbsolutePath());
        System.out.println("jsonData : " + jsonData);

        //Get tempropary file path
        String absolutePath = temp.getAbsolutePath();
        List<FileAttachmentMerged> fileAttachmentMergeds = new ArrayList<>();
        File file = new File( absolutePath + filename.getOriginalFilename());
        filename.transferTo(file);
        FileAttachmentMerged fileAttachmentMerged = new FileAttachmentMerged();
        fileAttachmentMerged.setStrName(filename.getName());
        fileAttachmentMerged.setStrContentType("Type");
        fileAttachmentMerged.setStrUploadedBy("Nagendra Singh");
        fileAttachmentMerged.setStrUploadedDate(new Date().toString());
        fileAttachmentMergeds.add(fileAttachmentMerged);


        return fileAttachmentMergeds;

    }
}
