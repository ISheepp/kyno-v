package com.codelin.kynov;

import com.codelin.bean.Position;
import com.codelin.service.PositionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KynoVApplicationTests {

    @Autowired
    PositionService positionService;

    @Test
    void contextLoads() {
        Position position = new Position();
        position.setId(39);
        position.setName("Java");
        System.out.println(positionService.updatePosition(position));
    }

}
