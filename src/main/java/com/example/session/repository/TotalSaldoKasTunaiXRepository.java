package com.example.session.repository;

import com.example.session.entity.KasTunaiBenPeng;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TotalSaldoKasTunaiXRepository extends CrudRepository<KasTunaiBenPeng, Long> {
    @Query(value = "SELECT SUM (JUMLAH) "
            + "FROM BEN_T_KAS_TUNAI_BEN_PENG "
            + "WHERE KODE_UNIT_TEKNIS = :kodeSatker ", nativeQuery = true)
    BigDecimal findUniqueByCriteria(@Param("kodeSatker") String kodeSatker);
}
