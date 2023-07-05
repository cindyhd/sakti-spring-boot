package com.example.session.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADM_R_SEC_ACL")
@Getter
@Setter
public class Acl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Number id;
    private String createdBy;
    private Date createdDate;
    private String deleted;
    private String modifiedBy;
    private Date modifiedDate;
    private Number vesion;
    private Number aclObjectId;
    private Number rekam;
    private Number hapus;
    private Number eksekusi;
    private String kodeAcl;
    private Number baca;
    private Number ubah;
    private String kodeKelompokPengguna;
    private String kodeKelompok;
}