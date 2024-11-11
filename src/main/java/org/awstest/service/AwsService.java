package org.awstest.service;

import org.awstest.entity.Aws;
import org.awstest.repository.AwsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwsService {

    private final AwsRepository awsRepository;

    @Autowired
    public AwsService(AwsRepository awsRepository) {
        this.awsRepository = awsRepository;
    }

    // Create
    public Aws createAws(Aws aws) {
        return awsRepository.save(aws);
    }

    // Read
    public List<Aws> getAllAws() {
        return awsRepository.findAll();
    }

    public Optional<Aws> getAwsById(Long id) {
        return awsRepository.findById(id);
    }

    // Update
    public Aws updateAws(Long id, Aws updatedAws) {
        if (awsRepository.existsById(id)) {
            updatedAws.setId(id);
            return awsRepository.save(updatedAws);
        }
        return null;
    }

    // Delete
    public boolean deleteAws(Long id) {
        if (awsRepository.existsById(id)) {
            awsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

