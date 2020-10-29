package com.codelin.controller.system.basic;

import com.codelin.bean.JobLevel;
import com.codelin.bean.RespBean;
import com.codelin.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/29 12:49
 */

@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public RespBean getAllJobLevel() {
        List<JobLevel> list = jobLevelService.getAllJobLevel();
        RespBean ok = RespBean.ok("", list);
        return ok;
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加职称成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteById(@PathVariable Integer id) {
        if (jobLevelService.deleteById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteMany(Integer[] ids) {
        if (jobLevelService.deleteMany(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
