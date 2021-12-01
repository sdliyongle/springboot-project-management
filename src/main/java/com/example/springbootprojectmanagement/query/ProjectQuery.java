package com.example.springbootprojectmanagement.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ZengQi
 * @description: TODO
 * @date 2021/11/26 0026 17:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectQuery extends BaseQuery{
    private String projectName;
}
