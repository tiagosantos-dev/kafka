package com.ts.visitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ts.visitor.model.Localization;

import java.io.Serializable;

@RequestMapping("/location")
@RestController
public class LatitudeController {


    @Autowired
    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    @PostMapping
    public ResponseEntity<?> setLocation(@RequestBody Localization localization){
        jsonKafkaTemplate.send("topic-one", localization);

        return ResponseEntity.ok().build();
    }

}
