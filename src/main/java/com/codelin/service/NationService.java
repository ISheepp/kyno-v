package com.codelin.service;

import com.codelin.bean.Nation;
import com.codelin.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/11/8 10:32
 */
@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
