package com.example.springbootprojectmanagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 项目-成员表
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xm04_t_project_user")
@ApiModel(value="ProjectUser对象", description="项目-成员表")
public class ProjectUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目id")
    private Integer projectId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;


}
