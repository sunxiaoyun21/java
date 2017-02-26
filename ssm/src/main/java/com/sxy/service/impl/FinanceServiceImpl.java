package com.sxy.service.impl;

import com.sxy.mapper.FinanceMapper;
import com.sxy.pojo.Finance;
import com.sxy.service.FinanceService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceMapper financeMapper;

    @Override
    public List<Finance> findFinanceByMap(Map<String, Object> map) {
        return financeMapper.findFinanceByMap(map);

    }

    @Override
    public Long findFinanceCountByMap() {
        return financeMapper.count();
    }

    @Override
    public Long findFilterByMap(Map<String, Object> map) {
        return financeMapper.findFilterByMap(map);
    }

    /**
     * 确认流水账号
     * @param id
     */
    @Override
    public void confirmById(Integer id) {
        Finance finance=financeMapper.findFinanceById(id);
        if(finance!=null){
            finance.setState(Finance.STATE_OK);
            finance.setConfirmDate(DateTime.now().toString("YYYY-MM-dd"));
            finance.setConfirmUser("jack");
            financeMapper.update(finance);
        }
    }

    @Override
    public List<Finance> findFinanceByCreateDay(String day) {
        return financeMapper.findFinanceByCreatDay(day);
    }

    /**
     * 日报表中显示饼图数据
     * @param today
     * @param type
     * @return
     */
    @Override
    public List<Map<String, Object>> findPieDataByDay(String today, String type) {
        return financeMapper.findPieDataByDay(today,type);
    }
}
