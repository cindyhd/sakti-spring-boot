package com.example.session.response;

import com.example.session.model.PaginatedList;
import com.example.session.wrapper.SaldoPerKategoriDetailWrapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoPerKategoriDetailWrapperPaginatedResponse<T> extends CommonResponse{
    private PaginatedList<SaldoPerKategoriDetailWrapper> object;
}
