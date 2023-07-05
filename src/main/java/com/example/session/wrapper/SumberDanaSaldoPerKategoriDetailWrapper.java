package com.example.session.wrapper;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumberDanaSaldoPerKategoriDetailWrapper {
    private Integer index;
    private String descKategori;
    private String detailKategori;
    private String sumberDana;
    private BigDecimal saldoKasBank = BigDecimal.ZERO;
    private BigDecimal saldoKasTunai = BigDecimal.ZERO;
    private BigDecimal saldoTotal = BigDecimal.ZERO;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SumberDanaSaldoPerKategoriDetailWrapper that = (SumberDanaSaldoPerKategoriDetailWrapper) o;
//        return Objects.equals(index, that.index) && Objects.equals(descKategori, that.descKategori) && Objects.equals(detailKategori, that.detailKategori) && Objects.equals(sumberDana, that.sumberDana) && Objects.equals(saldoKasBank, that.saldoKasBank) && Objects.equals(saldoKasTunai, that.saldoKasTunai) && Objects.equals(saldoTotal, that.saldoTotal);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(index, descKategori, detailKategori, sumberDana, saldoKasBank, saldoKasTunai, saldoTotal);
//    }
//
//    @Override
//    public String toString() {
//        return "SumberDanaSaldoPerKategoriDetailWrapper{" +
//                "index=" + index +
//                ", descKategori='" + descKategori + '\'' +
//                ", detailKategori='" + detailKategori + '\'' +
//                ", sumberDana='" + sumberDana + '\'' +
//                ", saldoKasBank=" + saldoKasBank +
//                ", saldoKasTunai=" + saldoKasTunai +
//                ", saldoTotal=" + saldoTotal +
//                '}';
//    }
}
