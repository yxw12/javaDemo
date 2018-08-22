<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/8/19
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<html>
<head>
    <title>北大青鸟考试系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width">

    <link rel="shortcut icon" href="http://img.58cdn.com.cn/jxedt/site/favicon.ico" />
    <meta name="keywords" content="北大青鸟考试">
    <meta name="description" content="北大青鸟考试">
    <link type="text/css"  rel="stylesheet" href="${baseurl}/css/home2.css?v=1462429138" />
    <script type="text/javascript" src="${baseurl}/js/zepto.min.js"></script>
    <script type="text/javascript" src="${baseurl}/js/home1.js"></script>
    <style >
        #topBannerBlankdiv{
            height: 5px!important;
        }
    </style>
    </head>
<body>

<div class="top">
    <div class="logo">
        <a href="javascript:void(0);"><img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/logo.png" width="100" height="25"></a>
    </div>

    <div style="height: 25px;width: 25px;float: right;padding-top: 12px;margin-right: 12px;">
        <a href="javascript:void(0);">
            <img src="http://j2.58cdn.com.cn/jxedt/m/list/images/login.png" width="25" height="25">
        </a>
    </div>
    <div class="clear"></div>
</div>
<div class="top_pic">
</div>
<div class="content">
    <div class="jk">
        <ul class="jk_menu">
            <li index="0" class="on"><a href="javascript:void(0);" onclick="return false">小车</a></li>
            <li index="1"><a href="javascript:void(0);" onclick="return false">货车</a></li>
            <li index="2"><a href="javascript:void(0);" onclick="return false">客车</a></li>
            <li index="3"><a href="javascript:void(0);"onclick="return false" >摩托车</a></li>
            <li index="4"><a href="javascript:void(0);"onclick="return false">资格证</a></li>
        </ul>
        <div class="jk_box" style="display:block">
            <div class="km1">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目一</span>
                        <span>小车(C1/C2)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_fir">
                    <li><a href="list.jsp"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>

            <div class="km4">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目四</span>
                        <span>小车(C1/C2)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_sec">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>

        </div>
        <div class="jk_box" style="display:none">
            <div class="km1">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目一</span>
                        <span>货车(A2/B2)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_fir">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>
            <div class="km4">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目四</span>
                        <span>货车(A2/B2)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_sec">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>
        </div>
        <div class="jk_box" style="display:none">
            <div class="km1">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目一</span>
                        <span>客车(A1/A3/B1)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_fir">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>
            <div class="km4">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目四</span>
                        <span>客车(A1/A3/B1)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_sec">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>
        </div>

        <div class="jk_box" style="display:none">
            <div class="km1">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目一</span>
                        <span>摩托车(D/E/F)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_fir">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>
            <div class="km4">
                <div class="km_nav">
                    <a href="javascript:void(0);">
                        <span class="km_title">科目四</span>
                        <span>摩托车(D/E/F)理论考试 </span>
                        <span class="more">更多</span>
                    </a>
                </div>
                <ul class="km_sec">
                    <li><a href="javascript:void(0);"><span  class="prac zhangjie"></span><p>章节练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac shunxu"></span><p>顺序练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac zhuanxiang"></span><p>专项练习</p></a></li>
                    <li><a href="javascript:void(0);"><span class="prac moni"></span><p>模拟考试</p></a></li>
                </ul>
            </div>
        </div>

        <div class="jk_box zgz"  style="display:none">
            <ul>
                <li>
                    <a href="javascript:void(0);">
                        <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/icon1_1.png" alt="">
                        <span>货运从业资格证</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/icon2.png" alt="">
                        <span>客运从业资格证</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/icon3.png" alt="">
                        <span>教练员从业资格证</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/icon4.png" alt="">
                        <span>危险品从业资格证</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/icon5.png" alt="">
                        <span>出租车从业资格证</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>


    <!-- 科目二 -->
    <div class="km2">
        <div class="km_nav">
            <a href="javascript:void(0);">
                <span class="km_title">科目二</span>
                <span class="more">科目二必过秘籍/侧方停车 </span>
            </a>
        </div>
    </div>
    <!-- 科目三 -->
    <div class="km3">
        <div class="km_nav">
            <a href="javascript:void(0);">
                <span class="km_title">科目三</span>
                <span class="more">夜考注意事项/16项秘籍 </span>
            </a>
        </div>
    </div>
    <!-- 考试视频 -->
    <div class="kstv">
        <div class="km_nav">
            <a href="javascript:void(0);">
                <span class="km_title">考试视频</span>
                <span class="more">学车教学视频/高清详解</span>
            </a>
        </div>
    </div>
</div>
<div class="bk">
    <h3>报考服务</h3>
    <div>
        <span>找驾校</span>
        <a href="javascript:void(0);">
            <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/home_02.png" alt="">
        </a>
    </div>
    <div class="middle">
        <span>找教练</span>
        <a href="javascript:void(0);">

            <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/home_03.png" alt="">
        </a>
    </div>
    <div>
        <span>找陪练</span>
        <a href="javascript:void(0);">

            <img src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/home_04.png" alt="">
        </a>
    </div>
</div>
<div class="xc">
    <h3>学车工具</h3>
    <ul class="xcgj">
        <li><a href="http://m.jxedt.com/info_723/"><img class="jtbz" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h1.png"/><p>交通标志</p></a></li>
        <li><a href="javascript:void(0);"><img class="xssl" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h2.png"/><p>新手上路</p></a></li>
        <li><a href="javascript:void(0);"><img class="bmxz" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h3.png"/><p>报名须知</p></a></li>
        <li><a href="javascript:void(0);"><img class="gengduo" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h4.png"/><p>更多</p></a></li>
    </ul>
</div>
<div class="yc">
    <h3>用车服务</h3>
    <ul class="ycfw">
        <li><a href="http://m.58che.com?from=jxedt.000045"><img class="jtbz" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h5.png"/><p>新车</p></a></li>
        <li><a href="http://jump.luna.58.com/s?spm=b-32486882048012-me-f-801&ch=shouye"><img class="xssl" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h6.png"/><p>二手车</p></a></li>
        <li><a href="http://weizhang.58.com/m/view?channelid=22&appsource=22&platform=1"><img class="bmxz" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/58_weizhan_60.png.png" style="width: 26px;"/><p>违章查询</p></a></li>
        <li><a href="javascript:void(0);"><img class="gengduo" src="http://j2.58cdn.com.cn/jxedt/m/kaoshi/images/h8.png"/><p>测车牌</p></a></li>
    </ul>
</div>
</div>
<div class="footer">
    <a href="http://mp.weixin.qq.com/s?__biz=MzA5NjE4NDIwOA==&mid=212253559&idx=1&sn=3ef9d239709382d139a6004178f18411#rd">官方微信<span>|</span></a>
    <a href="javascript:void(0);">触屏版<span>|</span></a>
    <a href="http://www.jxedt.com?nomobile=true">电脑版</a>
</div>
<div style="display:none">
    <!-- track1 -->
    <script type="text/javascript">
        var _trackURL = "{'cate':'','area':'','channel':'mother','pagetype':'other'}";
    </script>
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-64688741-1', 'auto');
        ga('send', 'pageview');

    </script>
    <script src=http://tracklog.58.com/referrer_jxedt_m.js async></script>
    <!-- track1 end -->
    <!-- track2 -->


    <script type="text/javascript">
        var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fe584a1042d8500ea083f2ec69c5abfae' type='text/javascript'%3E%3C/script%3E"));
    </script>
    <!-- track2 end-->
</div>       <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width">
    <meta name="format-detection" content="telephone=no" >
    <meta name="format-detection" content="email=no" >
    <meta name="format-detection" content="address=no;">
    <meta name="apple-mobile-web-app-capable" content="yes" >
    <meta name="apple-mobile-web-app-status-bar-style" content="default" >
    <title></title>
    <link rel="stylesheet" href="javascript:void(0)">
    <style>
        html,body,div,img,span{
            margin:0px;
            padding:0px;
            font-family:"微软雅黑";
            font-size:10px;
        }
        .bot_foot{
            width:100%;
            position:fixed;
            bottom:0px;
            left:0px;
            font-size:0;
        }
        .bot_foot>img{
            width:100%;
        }
        .cha{
            width:14px;
            right:0px;
            padding:15px 10px;
            position:absolute;
            top:50%;
            transform:translateY(-50%);
            -webkit-transform:translateY(-50%);
        }
        .cha img{
            width:100%;
        }
    </style>
</head>
<body>
<%--<div class="bot_foot">
    <img class="pic_foot" src="" alt="" onclick="clickLog('from=JXEDT_Dibu_click')">
    <span class="cha"><img src="http://pic6.58cdn.com.cn/opt/pic/n_v1bl2lwxtbvpxvn3jburxa_c5e82e3eff7fcb9a.png"  alt=""></span>
</div>--%>
</body>
<script>
    var src_suiji;
    window.onload=function(){
        var arr =["http://pic6.58cdn.com.cn/opt/pic/n_v1bl2lwi5xvlxvnkewyn4a_a8f586f05912c6e6.png",
            "http://pic6.58cdn.com.cn/opt/pic/n_v1bl2lwxvxvlxvmzc5nmha_c5e82e3eff7fcb9a.png",
            "http://pic6.58cdn.com.cn/opt/pic/n_v1bl2lwi5xvlxvntk3mznq_a8f586f05912c6e6.png"
        ];
        src_suiji = parseInt(Math.random()*10%3);
        console.log(src_suiji);
        document.querySelector(".pic_foot").src = arr[src_suiji];

        document.querySelector(".cha").addEventListener("click",function(){
            document.querySelector(".cha").style.display = "none";
            document.querySelector(".pic_foot").style.display = "none";
        });
        document.querySelector(".pic_foot").addEventListener("click",function(){
            setTimeout("window.open('/d/download_count?src='+src_suiji)", 1000)
        });
    }
</script>
<script type="text/javascript" src="${baseurl}/js/referrer_m.js"></script>
</html>
<script type="text/javascript">
    /*创建于2016-06-14*/
    var cpro_id = "u2671677";
</script>
<script src="http://cpro.baidustatic.com/cpro/ui/cm.js" type="text/javascript"></script>

</body>
</html>