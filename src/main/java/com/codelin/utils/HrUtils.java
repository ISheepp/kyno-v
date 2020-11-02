package com.codelin.utils;

import com.codelin.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ISheep
 * @create 2020/11/2 13:22
 */
public class HrUtils {

    public static Hr getCurrentHr() {
        // 当前用户对象
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
