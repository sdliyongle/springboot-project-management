package com.example.springbootprojectmanagement.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin.query]
 * @ClassName: [UserQuery]
 * @Description:
 * @Author: [ZengQi]
 * @CreateDate: [2021-08-06  11:40]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-08-06  11:40]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQuery extends BaseQuery{
    private String userName;

}
