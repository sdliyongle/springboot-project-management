package com.example.springbootprojectmanagement.query;

import lombok.Data;

/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin.query]
 * @ClassName: [BaseQuery]
 * @Description:
 * @Author: [ZengQi]
 * @CreateDate: [2021-08-06  11:40]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-08-06  11:40]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Data
public class BaseQuery {
    private Integer page = 1;
    private Integer limit = 10;

}
