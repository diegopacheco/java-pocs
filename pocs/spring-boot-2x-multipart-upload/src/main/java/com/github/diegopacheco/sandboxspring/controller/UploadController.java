package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class UploadController {

    @Value("${file.upload-dir}")
    private String fileDirectory;

    @PostMapping("/up")
    public ResponseEntity<Object> uploadFile(@RequestParam("File") MultipartFile file) throws IOException {
        File convertFile = new File(fileDirectory + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<Object>("The File Uploaded Successfully.", HttpStatus.OK);
    }

}
