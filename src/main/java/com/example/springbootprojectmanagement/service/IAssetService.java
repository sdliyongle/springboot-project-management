package com.example.springbootprojectmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootprojectmanagement.pojo.Asset;
import com.example.springbootprojectmanagement.query.AssetQuery;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiYongle
 * @since 2021-11-30
 */
public interface IAssetService extends IService<Asset> {
    void addAsset(Asset asset);

    Map<String, Object> assetList(AssetQuery assetQuery);

    void deleteAsset(Integer[] ids);

    void updateAsset(Asset asset);
}
