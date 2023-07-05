package com.example.session.service;

import com.example.session.repository.SaldoBySumberDanaPerKategoriTahunRepository;
import com.example.session.repository.SaldoPerKategoriBankTahunRepository;
import com.example.session.repository.SaldoPerKategoriTunaiTahunRepository;
import com.example.session.repository.TotalSaldoKasTunaiXRepository;
import com.example.session.wrapper.SaldoPerKategoriDetailWrapper;
import com.example.session.wrapper.SumberDanaSaldoPerKategoriDetailWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.session.model.PagingInfo;
import com.example.session.model.PaginatedList;
import com.example.session.exception.BenException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BenKasHelperService {
    @Autowired
    private SaldoPerKategoriBankTahunRepository saldoPerKategoriBankTahunRepository;

    @Autowired
    private SaldoPerKategoriTunaiTahunRepository saldoPerKategoriTunaiTahunRepository;

    @Autowired
    private SaldoBySumberDanaPerKategoriTahunRepository saldoBySumberDanaPerKategoriTahunRepository;

    @Autowired
    private TotalSaldoKasTunaiXRepository totalSaldoKasTunaiXRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BenKasHelperService.class);

    public PaginatedList<SaldoPerKategoriDetailWrapper> saldoPerKategoriDetailPaginated(PagingInfo pagingInfo, String satkerId, String tahun) throws BenException {
        try {
            PaginatedList<SaldoPerKategoriDetailWrapper> paginatedList = new PaginatedList<>();
            paginatedList.setDataList(toWrapperListSaldoDetail(satkerId, tahun));
            paginatedList.setPagingInfo(pagingInfo);
            paginatedList.setTotalRowCount(null);

            return paginatedList;
        } catch (Exception e) {
            throw new BenException(e);
        }
    }

    private List<SaldoPerKategoriDetailWrapper> toWrapperListSaldoDetail(String kodeSatker, String tahun) {
        List<SaldoPerKategoriDetailWrapper> list = new ArrayList<SaldoPerKategoriDetailWrapper>();
        // SALDO UP
        SaldoPerKategoriDetailWrapper kasUP = new SaldoPerKategoriDetailWrapper();
        List<SumberDanaSaldoPerKategoriDetailWrapper> listKasUP = new ArrayList<SumberDanaSaldoPerKategoriDetailWrapper>();
        kasUP.setIndex(1);
        kasUP.setDescKategori("UP");

        kasUP.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "311", tahun));
        kasUP.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "311", tahun));

        List<Object[]> resultListKasUpTunai = saldoBySumberDanaPerKategoriTahun(kodeSatker, "311", tahun);

        if (resultListKasUpTunai != null && !resultListKasUpTunai.isEmpty()) {
            int index = 1;
            for (Object[] objects : resultListKasUpTunai) {
                SumberDanaSaldoPerKategoriDetailWrapper newwrapper = new SumberDanaSaldoPerKategoriDetailWrapper();
                newwrapper.setIndex(index);
                newwrapper.setDescKategori("UP");
                newwrapper.setDetailKategori("UP-"+ (objects[0] != null ? objects[0] : ""));
                newwrapper.setSaldoKasTunai((BigDecimal) (objects[1] != null ? objects[1] : BigDecimal.ZERO));
                newwrapper.setSaldoKasBank((BigDecimal) (objects[2] != null ? objects[2] : BigDecimal.ZERO));
                newwrapper.setSumberDana((objects[3] != null ? objects[3] : "").toString());
                newwrapper.getSaldoTotal();
                index++;
                listKasUP.add(newwrapper);
            }
        }
        kasUP.setSumberDanaSaldoPerKategoriDetailWrapper(listKasUP);
        list.add(kasUP);


        // SALDO UP-KKP
        SaldoPerKategoriDetailWrapper kasUPKKP = new SaldoPerKategoriDetailWrapper();
        kasUPKKP.setIndex(2);
        kasUPKKP.setDescKategori("UP KKP");

        kasUPKKP.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "317", tahun));
        kasUPKKP.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "317", tahun));
        list.add(kasUPKKP);

        // SALDO TUP
        SaldoPerKategoriDetailWrapper kasTUP = new SaldoPerKategoriDetailWrapper();
        List<SumberDanaSaldoPerKategoriDetailWrapper> listKasTUP = new ArrayList<SumberDanaSaldoPerKategoriDetailWrapper>();
        kasTUP.setIndex(3);
        kasTUP.setDescKategori("TUP");

        kasTUP.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "321", tahun));
        kasTUP.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "321", tahun));

        List<Object[]> resultListTUPTunai = saldoBySumberDanaPerKategoriTahun(kodeSatker, "321", tahun);

        if (resultListTUPTunai != null && !resultListTUPTunai.isEmpty()) {
            int index = 1;
            for (Object[] objects : resultListTUPTunai) {
                SumberDanaSaldoPerKategoriDetailWrapper newwrapper = new SumberDanaSaldoPerKategoriDetailWrapper();
                newwrapper.setIndex(index);
                newwrapper.setDescKategori("TUP");
                newwrapper.setDetailKategori("TUP-"+(objects[0] != null ? objects[0] : ""));
                newwrapper.setSaldoKasTunai((BigDecimal) (objects[1] != null ? objects[1] : BigDecimal.ZERO));
                newwrapper.setSaldoKasBank((BigDecimal) (objects[2] != null ? objects[2] : BigDecimal.ZERO));
                newwrapper.setSumberDana((objects[3] != null ? objects[3] : "").toString());
                newwrapper.getSaldoTotal();
                index++;
                listKasTUP.add(newwrapper);
            }
        }
        kasTUP.setSumberDanaSaldoPerKategoriDetailWrapper(listKasTUP);
        list.add(kasTUP);

        // SALDO TUP-KKP
        SaldoPerKategoriDetailWrapper kasTUPKKP = new SaldoPerKategoriDetailWrapper();
        kasTUPKKP.setIndex(4);
        kasTUPKKP.setDescKategori("TUP KKP");

        kasTUPKKP.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "323", tahun));
        kasTUPKKP.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "323", tahun));
        list.add(kasTUPKKP);

        // SALDO UP-KP
        SaldoPerKategoriDetailWrapper kasUPKP = new SaldoPerKategoriDetailWrapper();
        kasUPKP.setIndex(5);
        kasUPKP.setDescKategori("Kas UP-KP");

        kasUPKP.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "314", tahun));
        kasUPKP.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "314", tahun));
        list.add(kasUPKP);

        // SALDO TUP-KP
        SaldoPerKategoriDetailWrapper kasTUPKP = new SaldoPerKategoriDetailWrapper();
        kasTUPKP.setIndex(6);
        kasTUPKP.setDescKategori("Kas TUP-KP");

        kasTUPKP.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "325", tahun));
        kasTUPKP.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "325", tahun));
        list.add(kasTUPKP);

        // SALDO LS BENDAHARA
        SaldoPerKategoriDetailWrapper kasLSBEN = new SaldoPerKategoriDetailWrapper();
        kasLSBEN.setIndex(7);
        kasLSBEN.setDescKategori("LS BENDAHARA");

        kasLSBEN.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "231", tahun));
        kasLSBEN.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "231", tahun));
        list.add(kasLSBEN);

        // SALDO LS BANYAK PENERIMA
//        SaldoPerKategoriDetailWrapper kasLSBANY = new SaldoPerKategoriDetailWrapper();
//        kasLSBANY.setIndex(5);
//        kasLSBANY.setDescKategori("LS BANYAK PENERIMA");
//
//        kasLSBANY.setSaldoKasBank(bukuBenPengeluaranDao.saldoPerKategoriBankTahun(kodeSatker, "237", tahun));
//        kasLSBANY.setSaldoKasTunai(bukuBenPengeluaranDao.saldoPerKategoriTunaiTahun(kodeSatker, "237", tahun));
//        list.add(kasLSBANY);

        // SALDO PNBP UMUM
        SaldoPerKategoriDetailWrapper kasPNBPUMUM = new SaldoPerKategoriDetailWrapper();
        kasPNBPUMUM.setIndex(8);
        kasPNBPUMUM.setDescKategori("PNBP UMUM");

        kasPNBPUMUM.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "999", tahun));
        kasPNBPUMUM.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "999", tahun));
        list.add(kasPNBPUMUM);

        // SALDO DROPPING
        SaldoPerKategoriDetailWrapper kasDROPPING = new SaldoPerKategoriDetailWrapper();
        kasDROPPING.setIndex(9);
        kasDROPPING.setDescKategori("LAIN-LAIN");

        kasDROPPING.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "666", tahun));
        kasDROPPING.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "666", tahun));
        list.add(kasDROPPING);

        // SALDO PUNGUTAN PAJAK
        SaldoPerKategoriDetailWrapper kasPAJAK = new SaldoPerKategoriDetailWrapper();
        kasPAJAK.setIndex(10);
        kasPAJAK.setDescKategori("PUNGUTAN PAJAK");

        kasPAJAK.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "777", tahun));
        kasPAJAK.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "777", tahun));
        list.add(kasPAJAK);

        // SALDO HIBAH
        SaldoPerKategoriDetailWrapper kasHIBAH = new SaldoPerKategoriDetailWrapper();
        kasHIBAH.setIndex(11);
        kasHIBAH.setDescKategori("HIBAH");

        kasHIBAH.setSaldoKasBank(saldoPerKategoriBankTahun(kodeSatker, "512", tahun));
        kasHIBAH.setSaldoKasTunai(saldoPerKategoriTunaiTahun(kodeSatker, "512", tahun));
        list.add(kasHIBAH);
        return list;
    }

    public BigDecimal saldoPerKategoriBankTahun(String satkerId, String kategori, String tahun) {
        Integer panjang = satkerId.length();
        BigDecimal result;
        try {
            if (panjang != 6) {
                result = saldoPerKategoriBankTahunRepository.satkerLengthIsNotSix (satkerId, kategori, tahun);
            } else {
                result = saldoPerKategoriBankTahunRepository.satkerLengthIsSix (satkerId, kategori, tahun);
            }
        } catch (NonUniqueResultException e) {
            result = BigDecimal.ZERO;
        } catch (NoResultException e) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

    public BigDecimal saldoPerKategoriTunaiTahun(String satkerId, String kategori, String tahun) {
        Integer panjang = satkerId.length();
        BigDecimal result;
        try {
            if (panjang != 6) {
                result = saldoPerKategoriTunaiTahunRepository.satkerLengthIsNotSix (satkerId, kategori, tahun);
            } else {
                result = saldoPerKategoriTunaiTahunRepository.satkerLengthIsSix (satkerId, kategori, tahun);
            }
        } catch (NonUniqueResultException e) {
            result = BigDecimal.ZERO;
        } catch (NoResultException e) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

    public List<Object[]> saldoBySumberDanaPerKategoriTahun(String satkerId, String kategori, String tahun) {
        List<Object[]> result = new ArrayList<Object[]>();
        try {
            result = saldoBySumberDanaPerKategoriTahunRepository.listSaldoBySumberDanaPerKategoriTahun(satkerId, kategori, tahun);
        } catch (NonUniqueResultException e) {
            result = null;
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }

    public BigDecimal totalSaldoKasTunaiX(String kodeSatker) throws BenException {
        try {
            return kasTunaiBenPengTotalSaldoKasTunaiX(kodeSatker);
        } catch (Exception e) {
            throw new BenException(e);
        }
    }

    public BigDecimal kasTunaiBenPengTotalSaldoKasTunaiX(String kodeSatker) {
        BigDecimal result;
        try {
            result = totalSaldoKasTunaiXRepository.findUniqueByCriteria(kodeSatker);
        } catch (NonUniqueResultException e) {
            result = BigDecimal.ZERO;
        } catch (NoResultException e) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

}
