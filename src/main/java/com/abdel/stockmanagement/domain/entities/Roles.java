package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="roles")
public class Roles extends AbstractEntity{
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;}
