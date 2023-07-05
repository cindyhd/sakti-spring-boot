package com.example.session.wrapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoPerKategoriDetailWrapper {
    private Integer index;
    private String descKategori;
    private BigDecimal saldoKasBank = BigDecimal.ZERO;
    private BigDecimal saldoKasTunai = BigDecimal.ZERO;
    private BigDecimal saldoTotal = BigDecimal.ZERO;
    private List<SumberDanaSaldoPerKategoriDetailWrapper> sumberDanaSaldoPerKategoriDetailWrapper = new ArrayList<SumberDanaSaldoPerKategoriDetailWrapper>();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SaldoPerKategoriDetailWrapper that = (SaldoPerKategoriDetailWrapper) o;
//        return Objects.equals(index, that.index) && Objects.equals(descKategori, that.descKategori) && Objects.equals(saldoKasBank, that.saldoKasBank) && Objects.equals(saldoKasTunai, that.saldoKasTunai) && Objects.equals(saldoTotal, that.saldoTotal) && Objects.equals(sumberDanaSaldoPerKategoriDetailWrapper, that.sumberDanaSaldoPerKategoriDetailWrapper);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(index, descKategori, saldoKasBank, saldoKasTunai, saldoTotal, sumberDanaSaldoPerKategoriDetailWrapper);
//    }
//
//    @Override
//    public String toString() {
//        return "SaldoPerKategoriDetailWrapper{" +
//                "index=" + index +
//                ", descKategori='" + descKategori + '\'' +
//                ", saldoKasBank=" + saldoKasBank +
//                ", saldoKasTunai=" + saldoKasTunai +
//                ", saldoTotal=" + saldoTotal +
//                ", sumberDanaSaldoPerKategoriDetailWrapper=" + sumberDanaSaldoPerKategoriDetailWrapper +
//                '}';
//    }
}
