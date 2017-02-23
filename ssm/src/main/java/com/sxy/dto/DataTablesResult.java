package com.sxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Administrator on 2017/2/23.
 */
@Data
@AllArgsConstructor
public class DataTablesResult {
    private String draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private Object data;
}
