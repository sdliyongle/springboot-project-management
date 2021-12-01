package com.example.springbootprojectmanagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xm04_t_project")
@ApiModel(value="Project对象", description="")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "项目创建者id")
    private Integer createId;

    @ApiModelProperty(value = "项目团队id")
    private Integer teamId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目需求描述")
    private String projectDesc;

    @ApiModelProperty(value = "项目进度")
    private Double schedule;

    @ApiModelProperty(value = "项目开始时间")
    private LocalDateTime beginTime;

    @ApiModelProperty(value = "项目截止时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "是否私有")
    private Boolean isPrivate;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDel;

    @TableField(exist = false)
    private String projectLeader;

}
