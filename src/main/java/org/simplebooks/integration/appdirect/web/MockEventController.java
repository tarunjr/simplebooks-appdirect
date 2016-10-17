package org.simplebooks.integration.appdirect.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

@RestController
public class MockEventController {
    @Value("${test.data.create.mock.json}")
    private String createMockFile;
    @Value("${test.data.change.mock.json}")
    private String changeMockFile;
    @Value("${test.data.cancel.mock.json}")
    private String cancelMockFile;
    @Value("${test.data.notice.mock.json}")
    private String noticeMockFile;

    @RequestMapping("/test/subscription/create/event")
    public String create(){
        return readFile(createMockFile);
    }
    @RequestMapping("/test/subscription/change/event")
    public String change(){
        return readFile(changeMockFile);
    }
    @RequestMapping("/test/subscription/cancel/event")
    public String cancel(){
        return readFile(cancelMockFile);
    }
    @RequestMapping("/test/subscription/notice/event")
    public String notice(){
        return readFile(noticeMockFile);
    }

    private String readFile(String filename) {
      String result = "";
      try {
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        result = new String(data, "UTF-8");
      } catch ( IOException iox) {
      }
      return result;
    }
  }
