package com.korolkov.shop.controller.auth;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class TestController {
   TestRepo testRepo;
   TestRepo2 testRepo2;

    @PostMapping(path = "/1" , consumes = { MediaType.MULTIPART_FORM_DATA_VALUE } , produces =MediaType.APPLICATION_JSON_VALUE)
    public void saveTest1(@RequestParam("file") MultipartFile file) {
        Test1 test1 = new Test1();
        try {
            test1.setData(file.getBytes());
            testRepo.saveAndFlush(test1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping(path = "/2" , consumes = { MediaType.MULTIPART_FORM_DATA_VALUE } , produces =MediaType.APPLICATION_JSON_VALUE)
    public void saveTest2(@RequestParam("file") MultipartFile file) {
        Test2 test2 = new Test2();
        try {
            test2.setData(file.getBytes());
            testRepo2.saveAndFlush(test2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
