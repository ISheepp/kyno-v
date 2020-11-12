package com.codelin.service;

import com.codelin.bean.JobLevel;
import com.codelin.bean.RespBean;
import com.codelin.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/29 12:54
 */

@Service
@Transactional
public class JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;


    public List<JobLevel> getAllJobLevel() {
        return jobLevelMapper.getAllJobLevel();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteMany(Integer[] ids) {
        return jobLevelMapper.deleteMany(ids);
    }
}
