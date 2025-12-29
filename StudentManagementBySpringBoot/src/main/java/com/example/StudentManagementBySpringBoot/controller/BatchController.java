package com.example.StudentManagementBySpringBoot.controller;

import com.example.StudentManagementBySpringBoot.model.Batch;
import com.example.StudentManagementBySpringBoot.service.BatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    //Adding batches
    @PostMapping
    public ResponseEntity<String> addBatch(@Valid @RequestBody Batch batch) {
        batchService.addBatch(batch);
        return new ResponseEntity<>("Batch added successfully", HttpStatus.CREATED);
    }


    //getting all students
    @GetMapping
    public ResponseEntity<List<Batch>> getAllBatchesAPI() {
        List<Batch> batchList = batchService.getAllBatches() ;
        return new ResponseEntity<>(batchList, HttpStatus.FOUND);
    }

    //getting by id
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getBatchAPI(@PathVariable Long id) {
        //Student student = studentService.getStudentById(id);
        //return new ResponseEntity<>(student, HttpStatus.FOUND);
        return batchService.getBatchById(id)
                .map(batch -> ResponseEntity.ok(batch)).orElse(ResponseEntity.notFound().build());
    }


    //getting by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getStudentByEmail(@PathVariable String name) {

        return batchService.getBatchByName(name).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    //update by id
    @PutMapping("/{id}")

    public ResponseEntity<Batch> updateStudentAPI(@PathVariable Long id,
                                                    @Valid @RequestBody Batch batch) {
        Batch batch1 = batchService.updateStudentById(id,batch);
        return new ResponseEntity<>(batch1,HttpStatus.OK);
    }


    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBatchAPI(@PathVariable Long id) {

        batchService.deleteBatchById(id);
        return new ResponseEntity<>(id +" No. Student deleted successfully",HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllBatchesAPI() {
        batchService.deleteAllBatches();
        return new ResponseEntity<>("All students deleted successfully",HttpStatus.OK);
    }
}
