package com.example.springbootprojectmanagement.controller;


import com.example.springbootprojectmanagement.model.RespBean;
import com.example.springbootprojectmanagement.pojo.Asset;
import com.example.springbootprojectmanagement.query.AssetQuery;
import com.example.springbootprojectmanagement.service.IAssetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiYongle
 * @since 2021-11-30
 */
@Controller
@RequestMapping("/asset")
public class AssetController {

    @Resource
    private IAssetService assetService;

    /**
     * 资产管理主界面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "asset/asset";
    }

    /**
     * 添加更新资产页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("addOrUpdateAssetPage")
    public String addOrUpdatePage(Integer id, Model model) {
        if (null!=id) {
            model.addAttribute("asset",assetService.getById(id));
        }
        return "asset/add_update";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> assetList(AssetQuery assetQuery) {
        return assetService.assetList(assetQuery);
    }

    @RequestMapping("delete")
    @ResponseBody
    public RespBean deleteAsset(Integer[] ids) {
        assetService.deleteAsset(ids);
        return RespBean.success("资产记录删除成功");
    }

    @RequestMapping("add")
    @ResponseBody
    public RespBean addAsset(Asset asset) {
        assetService.addAsset(asset);
        return RespBean.success("资产记录添加成功");
    }


    @RequestMapping("update")
    @ResponseBody
    public RespBean updateAsset(Asset asset) {
        assetService.updateAsset(asset);
        return RespBean.success("资产记录更新成功");
    }
}
