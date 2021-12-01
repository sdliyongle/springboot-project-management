package com.example.springbootprojectmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootprojectmanagement.mapper.AssetMapper;
import com.example.springbootprojectmanagement.pojo.Asset;
import com.example.springbootprojectmanagement.query.AssetQuery;
import com.example.springbootprojectmanagement.service.IAssetService;
import com.example.springbootprojectmanagement.utils.AssertUtil;
import com.example.springbootprojectmanagement.utils.PageResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiYongle
 * @since 2021-11-30
 */
@Service
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements IAssetService {
    @Override
    public void addAsset(Asset asset) {
        /**
         * 资产名
         * 非空 不可重复
         * 资产默认有效
         */
        AssertUtil.isTrue(StringUtils.isBlank(asset.getAssetName()),"资产名不能为空");
        AssertUtil.isTrue(null!=this.findAssetByAssetName(asset.getAssetName()),"资产名已存在");
        asset.setAssetBuyTime(LocalDateTime.now());
        AssertUtil.isTrue(!(this.save(asset)),"资产记录添加失败");
    }

    @Override
    public Map<String, Object> assetList(AssetQuery assetQuery) {
        //分页的类
        IPage<Asset> page = new Page<Asset>(assetQuery.getPage(), assetQuery.getLimit());
        //QueryWrapper：sql条件查询
        //eq("is_del", 0) 代表 where is_del=0
        //详细可搜索相关用法
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();
//        queryWrapper.eq("is_del",0).eq("active_status",1);

        //这里就是代表 sql语句中的 like
        if(StringUtils.isNotBlank(assetQuery.getAssetName())) {
            queryWrapper.like("asset_name",assetQuery.getAssetName());
        }
        //已经写好的接口
        page = this.baseMapper.selectPage(page,queryWrapper);
        System.out.println(page.getTotal());
        return PageResultUtil.getResult(page.getTotal(),page.getRecords());
    }

    @Override
    public void deleteAsset(Integer[] ids) {
        /**
         * 批量删除资产
         */
        AssertUtil.isTrue(null==ids || ids.length==0,"请选择待删除的id");

        /**
         * 第一种删除，只设置IsDel值为1，不从数据库中删除
         */
//        List<Asset> assets = new ArrayList<>();
//        for (Integer id : ids) {
//            Asset temp = this.getById(id);
//            temp.setIsDel(1);
//            assets.add(temp);
//        }
//        AssertUtil.isTrue(!(this.updateBatchById(assets)),"资产记录删除失败");
        /**
         * 第二种删除，直接从数据库删除
         * 先采用这一种
         */
        AssertUtil.isTrue(!(this.removeByIds(Arrays.asList(ids))),"资产记录删除失败");
    }

    @Override
    public void updateAsset(Asset asset) {
        /**
         * 资产名
         * 非空 不可重复
         */
        AssertUtil.isTrue(StringUtils.isBlank(asset.getAssetName()),"资产名不能为空");
        Asset temp = this.findAssetByAssetName(asset.getAssetName());
        AssertUtil.isTrue(null!=temp&&!(temp.getId().equals(asset.getId())),"资产名已存在！");
        AssertUtil.isTrue(!(this.updateById(asset)),"资产记录更新失败");
    }

    private Asset findAssetByAssetName(String assetName) {
        return this.baseMapper.selectOne(new QueryWrapper<Asset>().eq("asset_name",assetName));
    }
}
