<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">

</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input name="id" type="hidden" value="${(asset.id)!}"/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">资产名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input assetName"
                   lay-verify="required" name="assetName" id="assetName"  value="${(asset.assetName)!}" placeholder="请输入资产名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">项目ID</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                    name="projectCode" id="projectCode" value="${(asset.projectCode)!}" placeholder="请输入所属项目id">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">资产类型</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                    name="assetType" value="${(asset.assetType)!}"
                   id="assetType"
                   placeholder="请输入资产类型">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">资产状态</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   name="assetStatus" value="${(asset.assetStatus)!}" id="assetStatus" placeholder="请输入资产状态">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">资产价值</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                  name="assetValue" value="${(asset.assetValue)!}" id="assetValue" placeholder="请输入资产价值">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">外借状态</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   name="assetRentalStatus" value="${(asset.assetRentalStatus)!}" id="assetRentalStatus" placeholder="是否已外借？">
        </div>
    </div>



    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="addOrUpdateAsset">确认
            </button>
            <a class="layui-btn layui-btn-lg layui-btn-normal"  id="closeDlg" href="javascript:void(0)">取消</a>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx.contextPath}/public/js/asset/add.update.js"></script>
</body>
</html>