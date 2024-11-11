package org.awstest.controller;

import org.awstest.entity.Aws;
import org.awstest.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aws")
public class AwsController {

    private final AwsService awsService;

    @Autowired
    public AwsController(AwsService awsService) {
        this.awsService = awsService;
    }

    // Create Aws
    @PostMapping
    public ResponseEntity<Aws> createAws(@RequestBody Aws aws) {
        Aws createdAws = awsService.createAws(aws);
        return ResponseEntity.ok(createdAws);
    }

    // Get All Aws
    @GetMapping
    public List<Aws> getAllAws() {
        return awsService.getAllAws();
    }

    // Get Aws by ID
    @GetMapping("/{id}")
    public ResponseEntity<Aws> getAwsById(@PathVariable Long id) {
        Optional<Aws> aws = awsService.getAwsById(id);
        return aws.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Aws
    @PutMapping("/{id}")
    public ResponseEntity<Aws> updateAws(@PathVariable Long id, @RequestBody Aws updatedAws) {
        Aws aws = awsService.updateAws(id, updatedAws);
        return (aws != null) ? ResponseEntity.ok(aws) : ResponseEntity.notFound().build();
    }

    // Delete Aws
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAws(@PathVariable Long id) {
        return awsService.deleteAws(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

