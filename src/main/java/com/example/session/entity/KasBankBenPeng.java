package com.example.session.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BEN_T_KAS_BANK_BEN_PENG")
@Getter
@Setter
public class KasBankBenPeng {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "KAS_BANK_BEN_PENG_SEQ")
    @TableGenerator(
            name = "KAS_BANK_BEN_PENG_SEQ",
            table = "BEN_SEQUENCE",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "KAS_BANK_BEN_PENG_SEQ",
            valueColumnName = "SEQ_COUNT",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;
    private Date tanggal;
    private String jenisAktifitas;
    private String kategoriKas;
    private BigDecimal jumlah;
    private String noReferensi;
    private String noSP2D;
    private String jenisSP2D;
    private String noUangMuka;
    private String uraian;
    private String sumberDana;
    private String tahunAnggaran;
    private String satuanKerja;
    private String noRefGL;
    private Integer statusHistori;
    private String noRegister;
    private String kdUnitTehknis;
    private Long idSpp;
    private Long idRekBank;
    private Long idUM;
    private Date tglBuku;
    private Date createdDateTime;
    private String createdBy;
    private Date modifiedDateTime;
    private String modifiedBy;
    private boolean hidden;
    private Integer version;
    private String sessionId;

}
