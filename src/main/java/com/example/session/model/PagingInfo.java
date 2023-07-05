package com.example.session.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingInfo {
    private Integer currentPage;
    private Integer pageCount;
    private Integer pageSize;
    private boolean retrieveAll;
}
