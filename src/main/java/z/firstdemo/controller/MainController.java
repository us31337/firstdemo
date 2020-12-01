package z.firstdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import z.firstdemo.service.EmailService;
import z.firstdemo.view.EmailRequestView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private EmailService emailService;

    @PostMapping(path = "/")
    public ResponseEntity getPostEmailRequest(@Valid @RequestBody EmailRequestView emailRequestView) {
        emailService.saveIfNotExist(emailRequestView);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity dublicateExceptionHandler() {
        Map<String, String> map = Collections.singletonMap("duplicate", "true");
        return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
    }
}
