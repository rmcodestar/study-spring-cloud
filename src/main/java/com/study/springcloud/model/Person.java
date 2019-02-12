package com.study.springcloud.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by rmcodestar on 2019. 2. 12..
 */
@Data
@Entity
@Table(name = "person")
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @CreatedDate
    @Column(name = "reg_ymdt")
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "mod_ymdt")
    private LocalDateTime modifiedDateTime;
}
