package com.example.session.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADM_R_ACCESS_MATRIX")
@Getter
@Setter
public class AccessMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String urlRest;
    private Integer formId;
    private Integer aclValue;

}