package com.codelin.bean;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/11/3 10:37
 * 保存分页查询的结果
 * 1. 当前展示的数据 2.一共查了多少条记录
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
