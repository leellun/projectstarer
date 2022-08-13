package com.newland.srb.oss.controller.api;


import com.newland.srb.oss.service.IFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin //跨域
@RestController
@RequestMapping("/api/oss/file")
public class FileController {

    @Resource
    private IFileService fileService;

    @PostMapping("/upload")
    public String upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("module") String module) {

        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String url = fileService.upload(inputStream, module, originalFilename);

            return url;
        } catch (IOException e) {
            return "";
        }
    }

    @DeleteMapping("/remove")
    public boolean remove(
            @RequestParam("url") String url) {
        fileService.removeFile(url);
        return true;
    }
}
