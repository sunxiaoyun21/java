package com.sxy.service;

import com.sxy.pojo.Finance;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface FinanceService {
    List<Finance> findFinanceByMap(Map<String, Object> map);

    Long findFinanceCountByMap();

    Long findFilterByMap(Map<String, Object> map);

    void confirmById(Integer id);

    List<Finance> findFinanceByCreateDay(String day);

    List<Map<String,Object>> findPieDataByDay(String today, String type);
}
