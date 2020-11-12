package com.codelin.kynov;

import com.codelin.bean.Employee;
import com.codelin.bean.Position;
import com.codelin.bean.RespPageBean;
import com.codelin.mapper.EmployeeMapper;
import com.codelin.service.EmployeeService;
import com.codelin.service.PositionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KynoVApplicationTests {

    @Autowired
    PositionService positionService;
    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() {
        Position position = new Position();
        position.setId(39);
        position.setName("Java");
        System.out.println(positionService.updatePosition(position));
    }

    @Test
    public void testArr(){
        String[] test = {"1", "2", "3"};
        System.out.println(test.length);
    }

    @Test
    public void testEmp(){

    }

}
