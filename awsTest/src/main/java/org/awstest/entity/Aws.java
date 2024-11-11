package org.awstest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Aws {

    // getter, setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // 기본 생성자
    public Aws() {}

    // 생성자
    public Aws(String name, int age) {
        this.name = name;
        this.age = age;
    }

}