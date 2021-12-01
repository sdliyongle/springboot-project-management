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
 * 
 * </p>
 *
 * @author LiYongle
 * @since 2021-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xm04_t_asset")
@ApiModel(value="Asset对象", description="")
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目代码")
    private String projectCode;

    @ApiModelProperty(value = "资产名称")
    private String assetName;

    @ApiModelProperty(value = "资产类型")
    private String assetType;

    @ApiModelProperty(value = "资产状态")
    private String assetStatus;

    @ApiModelProperty(value = "资产价值")
    private String assetValue;

    @ApiModelProperty(value = "资产外借状态")
    private String assetRentalStatus;

    @ApiModelProperty(value = "资产购买时间")
    private LocalDateTime assetBuyTime;


}
