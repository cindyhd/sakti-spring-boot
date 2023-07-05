package com.example.session.repository;

import com.example.session.entity.KasBankBenPeng;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SaldoBySumberDanaPerKategoriTahunRepository extends CrudRepository<KasBankBenPeng, Long> {
    @Query(value = "SELECT JENIS_SUMBER_DANA, sum(kas_tunai) kas_tunai, sum(kas_bank) kas_bank,  \n" +
            "         RTRIM(REGEXP_REPLACE( \n" +
            "         LISTAGG(KODE_SUMBER_DANA,', ') WITHIN GROUP(ORDER BY KODE_SUMBER_DANA), \n" +
            "           '([^, ]*)(, \\1)+($|, )', \n" +
            "           '\\1\\3'), \n" +
            "         ', ') KODE_SUMBER_DANA \n" +
            "	FROM (select sum(a.jumlah) kas_tunai, 0 kas_bank, a.KODE_SUMBER_DANA, \n" +
            "	CASE \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'A' THEN 'RM' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'B' THEN 'PLN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'C' THEN 'RMP' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'D' THEN 'PNBP' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'E' THEN 'PDN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'F' THEN 'BLU' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'G' THEN 'STM' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'H' THEN 'HDN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'I' THEN 'HLN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'J' THEN 'HLD' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'K' THEN 'HLL' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'T' THEN 'SBSN' \n" +
            "	    ELSE 'RM'   \n" +
            "	END JENIS_SUMBER_DANA \n" +
            "	from BEN_T_KAS_TUNAI_BEN_PENG a \n" +
            "	where a.KODE_UNIT_TEKNIS  = :satkerId \n" +
            "	and a.KATEGORI_KAS = :kategori \n" +
            "	and a.KODE_TAHUN_ANGGARAN  = :tahun \n" +
            "	and a.DELETED  = 0  \n" +
            "	GROUP BY a.KODE_SUMBER_DANA \n" +
            "	UNION  \n" +
            "	select 0 kas_tunai, sum(a.jumlah) kas_bank, a.KODE_SUMBER_DANA,  \n" +
            "	CASE   \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'A' THEN 'RM' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'B' THEN 'PLN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'C' THEN 'RMP' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'D' THEN 'PNBP' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'E' THEN 'PDN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'F' THEN 'BLU' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'G' THEN 'STM' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'H' THEN 'HDN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'I' THEN 'HLN' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'J' THEN 'HLD' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'K' THEN 'HLL' \n" +
            "	    WHEN a.KODE_SUMBER_DANA = 'T' THEN 'SBSN' \n" +
            "	    ELSE 'RM'   \n" +
            "	END JENIS_SUMBER_DANA  \n" +
            "	from BEN_T_KAS_BANK_BEN_PENG a  \n" +
            "	where a.KODE_UNIT_TEKNIS  = :satkerId  \n" +
            "	and a.KATEGORI_KAS = :kategori \n" +
            "	and a.KODE_TAHUN_ANGGARAN  = :tahun \n" +
            "	and a.DELETED  = 0  \n" +
            "	GROUP BY a.KODE_SUMBER_DANA \n" +
            ")GROUP BY JENIS_SUMBER_DANA", nativeQuery = true)
    List<Object[]> listSaldoBySumberDanaPerKategoriTahun(@Param("satkerId") String satkerId, @Param("kategori") String kategori, @Param("tahun") String tahun);
}
