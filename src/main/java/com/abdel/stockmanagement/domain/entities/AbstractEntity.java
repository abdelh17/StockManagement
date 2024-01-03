package com.abdel.stockmanagement.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Id
    private Integer id;
    @CreatedDate
    @JsonIgnore
    @Column(name = "creationDate", nullable = false)
    private Instant createdDate;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;
}
