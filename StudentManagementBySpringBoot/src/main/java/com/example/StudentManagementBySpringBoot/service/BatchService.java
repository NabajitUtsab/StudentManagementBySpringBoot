package com.example.StudentManagementBySpringBoot.service;

import com.example.StudentManagementBySpringBoot.model.Batch;
import com.example.StudentManagementBySpringBoot.model.Student;
import com.example.StudentManagementBySpringBoot.repository.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    @Autowired
    private BatchRepo batchRepo;

    //adding
    public Batch addBatch(Batch batch) {
        return batchRepo.save(batch);
    }

    //getting All Batches
    public List<Batch> getAllBatches() {
        return batchRepo.findAll();
    }

    //getting Batch ById
    public Optional<Object> getBatchById(Long id) {
        return batchRepo.findById(id);
    }

    //getting batch by name
    public Optional<Object> getBatchByName(String name) {
        return batchRepo.findByName(name);
    }

    //updatinh bach by id
    public Batch updateStudentById(Long id, Batch batch) {

        try {
            for (Batch b : batchRepo.findAll()) {
                if (b.getId().equals(id)) {

                    b.setId(batch.getId());
                    b.setName(batch.getName());
                    b.setStartDate(batch.getStartDate());
                    b.setEndDate(batch.getEndDate());

                    return batchRepo.save(b);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //deleting by id
    public void deleteBatchById(Long id) {
        batchRepo.removeById(id);
    }

    //deleting all batches
    public void deleteAllBatches() {
        batchRepo.deleteAll();
    }
}
