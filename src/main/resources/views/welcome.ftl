<!doctype html>
<html lang="en">
<head>
    <#include "common.ftl">
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <style type="text/css">
        body{background-image: url(${ctx.contextPath}/public/images/nybj.png);background-size:100% 100%;font-weight:bold;font-family:苹方;overflow: hidden;}
        .main{width:1024px;height:768px;position:relative;margin:auto;}
        div{border:0px solid white;margin:1px;}
        .layer{position:relative;width:100%;}
        #layer01{}
        #layer01 img{text-align: center;display: block;height: 35px;padding-top: 35px;margin: auto;}
        #layer02 > div{height:100%;float:left;position:relative;}
        .layer02-data{position: absolute;width: auto;height: 100px;color: white;top: 45px;left: 65px;}
        .layer03-panel{height:100%;position:relative;float:left;}
        .layer03-left-label{position:absolute;}
        #layer03_left_label01{top:10px;left:10px;color:white;height:20px;width:200px;font-weight: bold;}
        #layer03_left_label02{right:10px;top:10px;color:#036769;height:20px;width:200px;}
        .layer03-left-chart{position:relative;float:left;height:100%;}
        #layer03_right_label{position:absolute;top:10px;left:10px;color:white;height:20px;width:100px;}
        .layer03-right-chart{position:relative;float:left;height:100%;width:32%;}
        .layer03-right-chart-label{color: white;text-align: center;position: absolute;bottom: 60px;width: 100%;}
        .layer04-panel{position:relative;float:left;height:100%;width:48%;}
        .layer04-panel-label{width:100%;height:15%;color:white;padding-top:5px;}
        .layer04-panel-chart{width:100%;height:85%;}
    </style>

    <script src="${ctx.contextPath}/public/js/drive/jquery.min.js"></script>
    <script src="${ctx.contextPath}/public/js/drive/echarts.min.js"></script>
    <script src="${ctx.contextPath}/public/js/drive/monitor.js"></script>
    <script type="text/javascript">
        $(function(){
            drawLayer02Label($("#layer02_01 canvas").get(0),"接入终端数量",80,200);
            drawLayer02Label($("#layer02_02 canvas").get(0),"今日接入数据数量",80,300);
            drawLayer02Label($("#layer02_03 canvas").get(0),"今日新增存储数据",80,400);
            drawLayer02Label($("#layer02_04 canvas").get(0),"总存储数据",50,200);
            drawLayer02Label($("#layer02_05 canvas").get(0),"当前任务个数",40,200);
            drawLayer02Label($("#layer02_06 canvas").get(0),"当前集群数",50,200);

            renderLegend();

            //饼状图
            renderChartBar01();
            //renderChartBar02();

            //存储
            renderLayer03Right();

            //30天日均线流量趋势
            renderLayer04Left();

            //集群性能
            renderLayer04Right();
        });
    </script>
    <title>TIZA STAR大数据运维总览图</title>
</head>
<body>
<div class="main">

    <div id="layer02" class="layer" style="height:15%;">
        <div id="layer02_01" style="width:20%;">
            <div class="layer02-data">
                <span style="font-size:26px;">400000</span>
                <span style="font-size:16px;">台</span>
            </div>
            <canvas width="200" height="100"></canvas>
        </div>
        <div id="layer02_02" style="width:20%;">
            <div class="layer02-data">
                <span style="font-size:26px;">40000</span>
                <span style="font-size:16px;">KB</span>
            </div>
            <canvas width="200" height="100"></canvas>
        </div>
        <div id="layer02_03" style="width:21%;">
            <div class="layer02-data">
                <span style="font-size:26px;">31480</span>
                <span style="font-size:16px;">MB</span>
            </div>
            <canvas width="200" height="100"></canvas>
        </div>
        <div id="layer02_04" style="width:12%;">
            <div class="layer02-data">
                <span style="font-size:26px;">50</span>
                <span style="font-size:16px;">PB</span>
            </div>
            <canvas width="120" height="100"></canvas>
        </div>
        <div id="layer02_05" style="width:12%;">
            <div class="layer02-data">
                <span style="font-size:26px;">25</span>
                <span style="font-size:16px;">个</span>
            </div>
            <canvas width="120" height="100"></canvas>
        </div>
        <div id="layer02_06" style="width:12%;">
            <div class="layer02-data">
                <span style="font-size:26px;">5</span>
                <span style="font-size:16px;">个</span>
            </div>
            <canvas width="120" height="100"></canvas>
        </div>
    </div>
    <div id="layer03" class="layer" style="height:40%;">
        <div id="layer03_left" style="width:48%;" class="layer03-panel">
            <div id="layer03_left_label01" class="layer03-left-label">接入机型占比</div>
            <!--
            <div id="layer03_left_label02" class="layer03-left-label">(左)在线数量 (右)上线率</div>
            -->
            <div id="layer03_left_01" class="layer03-left-chart" style="width:16%;">
                <canvas width="100" height="200" style="margin:30px 0 0 20px;"></canvas>
            </div>

            <div id="layer03_left_02" class="layer03-left-chart" style="width:80%;"></div>
            <!--
            <div id="layer03_left_03" class="layer03-left-chart" style="width:80%;"></div>
            -->
        </div>
        <div id="layer03_right" style="width:50%;" class="layer03-panel">
            <div id="layer03_right_label">存储</div>
            <div id="layer03_right_chart01" class="layer03-right-chart">
                <canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
                <div class="layer03-right-chart-label">Hdfs</div>
            </div>
            <div id="layer03_right_chart02" class="layer03-right-chart">
                <canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
                <div class="layer03-right-chart-label">Rdbms</div>
            </div>
            <div id="layer03_right_chart03" class="layer03-right-chart">
                <canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
                <div class="layer03-right-chart-label">Rdies</div>
            </div>
        </div>
    </div>
    <div id="layer04" class="layer" style="height:30%;">
        <div id="layer04_left" class="layer04-panel">
            <div id="layer04_left_label" class="layer04-panel-label">30天日均线流量趋势</div>
            <div id="layer04_left_chart" class="layer04-panel-chart"></div>
        </div>
        <div id="layer04_right" class="layer04-panel">
            <div id="layer04_right_label" class="layer04-panel-label">
                <span>集群性能/</span><span style="color:#00A09A;">近一个小时</span>
            </div>
            <div id="layer04_right_chart" class="layer04-panel-chart"></div>
        </div>
    </div>
</div>
</body>
</html>
