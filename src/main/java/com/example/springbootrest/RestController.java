package com.example.springbootrest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @CrossOrigin(origins = {"https://nagesingh-dev-ed--c.visualforce.com", "chrome-extension://aejoelaoggembcahagimdiliamlcdmfm"})
    @RequestMapping(value = "/consumeFiles", method = RequestMethod.POST)
    public String consumeRest(@RequestParam("filename")MultipartFile filename[]) throws IOException {	    public String consumeRest(@RequestParam("filename")MultipartFile filename[]) throws IOException {
        //create a temp file	
         File temp = File.createTempFile("temp-file-name", ".tmp");	
ObjectMapper mapper = new ObjectMapper();	
        System.out.println("Temp file : " + temp.getAbsolutePath());	


         //Get tempropary file path	        return "";
        String absolutePath = temp.getAbsolutePath();	
        List<FileAttachmentMerged> fileAttachmentMergeds = new ArrayList<>();	
        for (MultipartFile uploadedFile : filename) {	
            File file = new File( absolutePath + uploadedFile.getOriginalFilename());	
            uploadedFile.transferTo(file);	
            FileAttachmentMerged fileAttachmentMerged = new FileAttachmentMerged();	
            fileAttachmentMerged.setStrName(uploadedFile.getName());	
            fileAttachmentMerged.setStrContentType("Type");	
            fileAttachmentMerged.setStrUploadedBy("Nagendra Singh");	
            fileAttachmentMerged.setStrUploadedDate(new Date().toString());	
            fileAttachmentMergeds.add(fileAttachmentMerged);	
        }	
String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fileAttachmentMergeds);	

         return jsonInString2;	


     }
}
