package com.lhf.mall.management.domain.std;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/3
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination<T> {
    /**
     * 总记录数
     */
    private Long count;
    /**
     * 记录
     */
    private List<T> data;

}
