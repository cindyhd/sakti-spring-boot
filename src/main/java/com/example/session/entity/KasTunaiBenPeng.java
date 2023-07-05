package com.example.session.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BEN_T_KAS_TUNAI_BEN_PENG")
@Getter
@Setter
public class KasTunaiBenPeng {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "KAS_TUNAI_BEN_PENG_SEQ")
    @TableGenerator(
            name = "KAS_TUNAI_BEN_PENG_SEQ",
            table = "BEN_SEQUENCE",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "KAS_TUNAI_BEN_PENG_SEQ",
            valueColumnName = "SEQ_COUNT",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;
    private Date tglTransaksi;
    private String jenisAktifitas;
    private String noReferensi;
    private String noUangMuka;
    private String kategoriKas;
    private BigDecimal jumlah;
    private String sumberDana;
    private String tahunAnggaran;
    private String satuanKerja;
    private String uraian;
    private String noRefGL;
    private String noRegister;
    private String kdUnitTehknis;
    private String kdUnitTeknisAsal;
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
