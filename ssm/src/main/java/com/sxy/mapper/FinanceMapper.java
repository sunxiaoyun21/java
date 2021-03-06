package com.sxy.mapper;

import com.sxy.pojo.Finance;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface FinanceMapper {
    List<Finance> findFinanceByMap(Map<String, Object> map);

    Long count();

    Long findFilterByMap(Map<String, Object> map);

    void save(Finance finance);

    Finance findFinanceById(Integer id);

    void update(Finance finance);

    List<Finance> findFinanceByCreatDay(String day);

    List<Map<String,Object>> findPieDataByDay(@Param("today") String today,@Param("type") String type);
}
