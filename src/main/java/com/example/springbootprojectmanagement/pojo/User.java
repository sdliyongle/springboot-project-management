package com.example.springbootprojectmanagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xm04_t_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注名")
    private String bz;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String trueName;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "信息备注")
    private String remarks;

    @ApiModelProperty(value = "是否删除")
    private Integer isDel;

    @ApiModelProperty(value = "角色id（这里还是考虑多对一的关系，即一个角色对应多个用户）	1---内置管理员（其实没用）	2---项目经理	3---项目成员	4---主管")
    private Integer roleId;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "激活码")
    private String activeCode;

    @ApiModelProperty(value = "激活状态（0表示未激活，1表示激活)")
    private Integer activeStatus;


}
