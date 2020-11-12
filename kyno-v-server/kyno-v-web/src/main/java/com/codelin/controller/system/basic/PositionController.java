package com.codelin.controller.system.basic;

import com.codelin.bean.Position;
import com.codelin.bean.RespBean;
import com.codelin.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/28 14:35
 */

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public RespBean getAllPosition() {
        List<Position> list = positionService.getAllPosition();
        RespBean ok = RespBean.ok("", list);
        return ok;

    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        // if (positionService.addPosition(position) == 1) {
        //     return RespBean.ok("添加成功");
        // }
        // return RespBean.error("添加失败");
        // TODO: 2020/10/28 已解决，前端须传json对象
        if (positionService.addPosition(position) == 1) {
               return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    // id可以以数组或者字符串的形式传递
    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids) {
        if (positionService.deletePositionByIds(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
