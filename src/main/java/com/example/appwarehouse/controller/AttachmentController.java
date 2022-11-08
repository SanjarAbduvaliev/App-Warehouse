package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Attachment;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @PostMapping
    public Result upload(MultipartHttpServletRequest request) throws IOException {
       Result result= attachmentService.uploadFile(request);
       return result;

    }
    @GetMapping
    public List<Attachment> geAll(){
        return attachmentService.getAll();
    }
    @GetMapping("/{id}")
    public Attachment getId(@PathVariable Integer id){
        return attachmentService.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(MultipartHttpServletRequest request, @PathVariable Integer id) throws IOException {
        return attachmentService.editPhoto(request, id);

    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return attachmentService.deletePhoto(id);
    }
}
