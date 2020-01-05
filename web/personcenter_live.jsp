<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2019/12/29
  Time: 下午8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>考拉直播-个人管理</title>
    <meta name="description" content="Free Bootstrap 4 Admin Theme | Pike Admin">


    <!-- Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <!-- Font Awesome CSS -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

    <!-- BEGIN CSS for this page -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
    <!-- END CSS for this page -->
</head>
<body class="adminbody" background="assets/images/background2.png">
<div id="main">
    2. 主播管理页面
    一个表单：直播房间id，直播房间的类型

    一个表单：
    申请直播的页面：
    输入：标题，上传封面，
    返回：rtmp，密匙。

    一个表单：
    话圈名字，
    话圈主持人id，
    话圈的照片

    <!-- top bar navigation -->
    <div class="headerbar">

        <!-- LOGO -->
        <div class="headerbar-left">
            <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/slg.png" />
        </div>

        <nav class="navbar-custom">

            <ul class="list-inline float-right mb-0">



                <li class="list-inline-item dropdown notif" >
                    <a class="nav-link dropdown-toggle nav-user" href="" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
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
                            <li><a href="showlivebycategory.jsp?category=csgo">CS:GO</a></li>
                            <li><a href="showlivebycategory.jsp?category=overwatch">守望先锋</a></li>
                            <li><a href="showlivebycategory.jsp?category=lol">英雄联盟</a></li>
                            <li><a href="showlivebycategory.jsp?category=dota2">DOTA2</a></li>
                            <li><a href="showlivebycategory.jsp?category=hs">炉石传说</a></li>
                            <li><a href="showlivebycategory.jsp?category=majiang">麻将</a></li>
                        </ul>
                    </li>

                    <li class="submenu">
                        <a href="myfocuslive.jsp"><i class="fa fa-fw fa-tv"></i> <span> 我的关注 </span></span></a>
                    </li>

                    <li class="submenu">
                        <a><i class="fa fa-fw fa-th"></i> <span> 个人中心 </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="personcenter_basic.jsp">基本信息</a></li>
                            <li><a href="personcenter_live.jsp">直播管理</a></li>
                            <li><a>退出登陆</a></li>
                        </ul>
                    </li>
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
        <div class="content" style="width: 90%;padding: 5%;">

            <div class="row">

                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <h3><i class="fa fa-check-square-o"></i> 直播间管理 </h3>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="form-group">
                                    <label>直播间ID</label>
                                    <p id="liveid">00001</p>
                                </div>
                                <div class="form-group">
                                    <label>直播间的分类</label>
                                    <P id="category">英雄联盟</P>
                                </div>
                            </form>

                        </div>
                    </div>
                </div> <!-- end 直播间显示-->
            </div><!-- END ROW -->
            <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                <div class="card mb-3">
                    <div class="card-header">
                        <h3><i class="fa fa-check-square-o"></i> 话圈管理 </h3>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <label>话圈ID</label>
                                <p id="quanid">00001</p>
                            </div>
                            <div class="form-group">
                                <label>话圈主持人ID</label>
                                <P> id="quanuser">00001</P>
                            </div>
                            <div class="form-group">
                                <label>话圈主持人昵称</label>
                                <P id="quanname">考拉考拉</P>
                            </div>

                        </form>

                    </div>
                </div>

            </div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <h3><i class="fa fa-check-square-o"></i> 申请直播 </h3>
                        </div>
                        <div class="card-body">
                            <form method="post">
                                <div class="form-group">
                                    <label>直播间标题</label>
                                    <input data-parsley-equalto="#pass1" type="text" required="" class="form-control" id="title">
                                </div>

                                <div class="form-group text-right m-b-6">
                                    <input class="btn btn-primary" type="button"  onclick="applyButton()">
                                </div>
                            </form>

                            <div>
                                <div class="card border-info col-sm-12 col-lg-12 col-xl-12">
                                    <div class="card-body text-info">
                                        <h4 class="card-title">rtmp链接</h4>
                                        <p class="card-text" id="rtmp"></p>
                                    </div>
                                </div>
                                <div class="card border-info col-sm-12 col-lg-12 col-xl-12">
                                    <div class="card-body text-info">
                                        <h4 class="card-title">密匙</h4>
                                        <p class="card-text" id="secretkey"></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- 申请本次直播结束 -->
            </div><!-- end 直播间显示-->

        </div>
        <!-- END content -->
    </div>
    <!-- END content-page -->


</div>
<!-- END main -->

<script src="assets/js/modernizr.min.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/moment.min.js"></script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script src="assets/js/detect.js"></script>
<script src="assets/js/fastclick.js"></script>
<script src="assets/js/jquery.blockUI.js"></script>
<script src="assets/js/jquery.nicescroll.js"></script>
<script src="assets/js/jquery.cookie.js"></script>

<!-- App js -->
<script src="assets/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

<!-- Counter-Up-->
<script src="assets/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
<script src="assets/plugins/counterup/jquery.counterup.min.js"></script>
<!-- BEGIN Java Script for this page -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

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
            $.ajax({
                type:"POST",
                url:"",
            });
        }
    });

    function applyButton(){
        var title = document.getElementById("title").value;
        data1={token:$.cookie("token"),title:title};
        $.ajax({
            type: "POST",
            url: "/api/live/onlive",
            data: JSON.stringify(data1),
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success: function (msg) {
                setCookie(msg.token);
                if (msg.tag === 1) {
                     var rtmp = document.getElementById("rtmp");
                     var secretkey = document.getElementById("secretkey");
                     rtmp.innerText=msg.rtmp;
                     secretkey.innerText=msg.secretkey;
                } else if(msg.tag === -1){
                    swal({
                        title:"你的直播间被封禁了呢！联系人工客服"
                    }).then(
                        function (){
                           swal.close();
                        }
                    );

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        });

    }
</script>

</body>
</html>
