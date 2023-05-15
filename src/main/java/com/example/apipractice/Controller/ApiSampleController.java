package com.example.apipractice.Controller;

import com.example.apipractice.Form.ApiSampleForm;
import com.example.apipractice.Model.ApiSampleModel;
import com.example.apipractice.Service.ApiSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-sample")
public class ApiSampleController {

    @Autowired
    ApiSampleService apiSampleService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiSampleModel> searchTopicById(@PathVariable Integer id){
        ApiSampleModel model=  apiSampleService.findById(id);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/createTopic")
    public ResponseEntity<ApiSampleModel> createTopic(@RequestBody ApiSampleForm form) {
        ApiSampleModel model = apiSampleService.addTopic(form.getTitle(),form.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSampleModel> editTopic(@PathVariable Integer id, @RequestBody ApiSampleForm form) {
        ApiSampleModel model = apiSampleService.updateTopic(id,form.getTitle(),
                form.getContent());
        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Integer id) {
        ApiSampleModel model = apiSampleService.deleteTopic(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}