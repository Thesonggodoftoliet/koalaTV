<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2020/1/2
  Time: 下午4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开始直播</title>

    <script src="//qzonestyle.gtimg.cn/open/qcloud/video/live/h5/live_connect.js" charset="utf-8"></script>
    <script src="assets/js/jquery.min.js"></script>
    <!-- Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <!-- Font Awesome CSS -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

    <!-- Modernizr -->
    <script src="assets/js/modernizr.min.js"></script>

    <!-- jQuery -->
    <script src="assets/js/jquery.min.js"></script>

    <!-- Moment -->
    <script src="assets/js/moment.min.js"></script>

    <!-- BEGIN CSS for this page -->
    <link href="assets/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" />

</head>
<body class="adminbody">
<!-- top bar navigation -->
<div class="headerbar">

    <!-- LOGO -->
    <div class="headerbar-left">
        <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/slg.png" />
    </div>

    <nav class="navbar-custom">

        <ul class="list-inline float-right mb-0">

            <li class="list-inline-item dropdown notif" >
                <a class="nav-link dropdown-toggle nav-user" href="" data-toggle="dropdown" role="button" aria-haspopup="false" aria-expanded="false">
                    <i class="fa fa-user-o bigfonts" aria-hidden="true"></i>
                </a>
            </li>

        </ul>


    </nav>

</div>
<!-- End Navigation -->


<!-- Left Sidebar -->

<div class="left main-sidebar" id="sdb" style="background:rgba(255,255,255,1)">

    <div class="sidebar-inner leftscroll mydiv" >
        <div id="sidebar-menu" >

            <ul>

                <li class="submenu">
                    <a   href="index.jsp"><i class="fa fa-fw fa-bars"></i><span> 主页 </span> </a>
                </li>

                <li class="submenu">
                    <a href="#"><i class="fa fa-fw fa-tv"></i> <span> 直播分类 </span> <span class="menu-arrow"></span></a>
                    <ul class="list-unstyled">
                        <li><a href="showlivecategory.jsp?category=csgo">CS:GO</a></li>
                        <li><a href="showlivecategory.jsp?category=overwatch">守望先锋</a></li>
                        <li><a href="showlivecategory.jsp?category=lol">英雄联盟</a></li>
                        <li><a href="showlivecategory.jsp?category=dota2">DOTA2</a></li>
                        <li><a href="showlivecategory.jsp?category=hs">炉石传说</a></li>
                        <li><a href="showlivecategory.jsp?category=majiang">麻将</a></li>
                    </ul>
                </li>

                <li class="submenu">
                    <a href="#"><i class="fa fa-fw fa-tv"></i> <span> 我的关注 </span></span></a>
                </li>

                <li class="submenu">
                    <a><i class="fa fa-fw fa-th"></i> <span> 个人中心 </span> <span class="menu-arrow"></span></a>
                    <ul class="list-unstyled">
                        <li><a href="personcenter_basic.jsp">基本信息</a></li>
                        <li><a href="personcenter_live.jsp">直播管理</a></li>
                        <li><a>退出登陆</a></li>
                    </ul>
                </li>
                <li></li>
                <li></li>
                <li></li>
                <li class="submenu" style="position:bottom left;">
                    <img src="assets/images/bgp2.png" height="500" width="255">
                </li>

            </ul>
        </div>

    </div>

</div>
<!-- End Sidebar -->


<div class="content-page">

    <!-- Start content -->
    <div class="content">

        <div class="container-fluid">


            <div class="row">
                <div class="col-xl-12">
                    <div class="breadcrumb-holder">
                        <h1 class="main-title float-left">当前直播间的名字</h1>
                        <ol class="breadcrumb float-right">
                            <li class="breadcrumb-item">返回上层</li>
                        </ol>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!-- end row -->


            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card-box tilebox-one noradius">
                        <div id='external-events'>
                            <h4>聊天室嘿嘿嘿</h4>
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
                    <div  id="id_video_container" style="width:100%; height:auto;"></div>
                </div>
            </div>
            <!-- end row -->




        </div>
        <!-- END container-fluid -->

    </div>
    <!-- END content -->

</div>


</body>
<script type="text/javascript">
    var option = {
        "live_url" : "rtmp://play.ccnubt.club/live/1",
        "live_url2" : "http://play.ccnubt.club/live/1.flv",
        "live_url3": "http://play.ccnubt.club/live/1.m3u8",
        "width" : 540,
        "height" : 360
    };
    (function(){
        var player = new qcVideo.Player("id_video_container", option)
    })()
</script>
<script>
    function setCookie(token) {
        $.cookie("token", token);
    }

    //读取cookies
    function getCookie(name){
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

        if(arr=document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return false;
    }

    // 判断cookie是否为空
    function checkCookie(name){
        if(getCookie(name) == null || getCookie(name)=="" || getCookie(name)=="null" || typeof(getCookie(name))=="undefined" || getCookie(name)==false || getCookie(name) == undefined){
            return false;
        }else{
            return true;
        }
    }


    <!-- 判断当前用户是否已经登陆了 -->
    $(document).ready(function(){
        if(checkCookie("token") === false){
            swal({
                title:"你还没有登陆哦～",
                icon:"warning",
                button:{
                    text: "我要登上我的考拉～",
                    closeModal: false,
                },
            }).then(
                function (value) {
                    if(value){
                        window.location.href="login.jsp";
                    }
                }
            );

        }
        else{
            swal({
                title: "okkk",

            });
        }
    });
</script>
</html>
