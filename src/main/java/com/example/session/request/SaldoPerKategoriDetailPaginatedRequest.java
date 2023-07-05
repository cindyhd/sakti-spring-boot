package com.example.session.request;

import com.example.session.model.PagingInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoPerKategoriDetailPaginatedRequest {
    private PagingInfo pagingInfo;
    private String satkerId;
    private String tahun;
}
