package com.example.session.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginatedList<T> {
    private List<T> dataList;
    private PagingInfo pagingInfo;
    private Long totalRowCount;

//    public PaginatedList(List<T> data, PagingInfo pagingInfo, Long totalRowCount) {
//        this.dataList = data;
//        this.pagingInfo = pagingInfo;
//        this.totalRowCount = totalRowCount;
//    }
}
