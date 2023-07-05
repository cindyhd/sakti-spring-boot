package com.example.session.controller;

import com.example.session.model.PaginatedList;
import com.example.session.request.SaldoPerKategoriDetailPaginatedRequest;
import com.example.session.request.TotalSaldoKasTunaiXRequest;
import com.example.session.response.CommonResponse;
import com.example.session.response.SaldoPerKategoriDetailWrapperPaginatedResponse;
import com.example.session.service.BenKasHelperService;
import com.example.session.wrapper.SaldoPerKategoriDetailWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class BenKasHelperController {
    @Autowired
    private BenKasHelperService benKasHelperService;
    private static final Logger LOGGER = LoggerFactory.getLogger(BenKasHelperController.class);

    @RequestMapping(value= {"/totalSaldoKasTunaiX"}, method= RequestMethod.POST, consumes = "application/json")
    public CommonResponse totalSaldoKasTunaiX(@RequestBody TotalSaldoKasTunaiXRequest request) {
        BigDecimal totalSaldoKasTunaiX = benKasHelperService.totalSaldoKasTunaiX(request.getKodeSatker());
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(totalSaldoKasTunaiX);
        return response;
    }

    @RequestMapping(value= {"/saldoPerKategoriDetailPaginated"}, method=RequestMethod.POST, consumes = "application/json")
    public SaldoPerKategoriDetailWrapperPaginatedResponse saldoPerKategoriDetailPaginated(@RequestBody SaldoPerKategoriDetailPaginatedRequest request) {
        PaginatedList<SaldoPerKategoriDetailWrapper> saldoPerKategoriDetailPaginated = benKasHelperService.saldoPerKategoriDetailPaginated(request.getPagingInfo(),
                request.getSatkerId(), request.getTahun());
        SaldoPerKategoriDetailWrapperPaginatedResponse response = new SaldoPerKategoriDetailWrapperPaginatedResponse();
        response.setStatus(true);
        response.setObject(saldoPerKategoriDetailPaginated);
        return response;
    }
}
