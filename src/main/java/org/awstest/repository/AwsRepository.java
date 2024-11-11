package org.awstest.repository;

import org.awstest.entity.Aws;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwsRepository extends JpaRepository<Aws, Long> {
}
