package com.example.session.repository;

import com.example.session.entity.KasBankBenPeng;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface SaldoPerKategoriBankTahunRepository extends CrudRepository<KasBankBenPeng, Long> {
    @Query(value = "SELECT SUM (JUMLAH) "
            + "FROM BEN_T_KAS_BANK_BEN_PENG "
            + "WHERE KODE_UNIT_TEKNIS = :kodeSatker "
            + "AND KATEGORI_KAS = :kategorinya "
            + "AND KODE_TAHUN_ANGGARAN = :tahun "
            + "AND (DELETED = 0) " , nativeQuery = true)
    BigDecimal satkerLengthIsNotSix(@Param("kodeSatker") String satkerId, @Param("kategorinya") String kategori,
                                    @Param("tahun") String tahun);

    @Query(value = "SELECT JUMLAH "
            + "FROM BEN_T_KAS_BANK_BEN_PENG "
            + "WHERE KODE_SATKER = :kodeSatker "
            + "AND KATEGORI_KAS = :kategorinya "
            + "AND KODE_TAHUN_ANGGARAN = :tahun "
            + "AND (DELETED = 0) " , nativeQuery = true)
    BigDecimal satkerLengthIsSix(@Param("kodeSatker") String satkerId, @Param("kategorinya") String kategori,
                                 @Param("tahun") String tahun);
}
