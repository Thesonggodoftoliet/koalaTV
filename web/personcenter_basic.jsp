<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2019/12/29
  Time: 下午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>考拉直播---个人中心</title>

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

<body class="adminbody" style="background: rgb(255,255,255)">

<div id="main">

    <!-- top bar navigation -->
    <div class="headerbar">

        <!-- LOGO -->
        <div class="headerbar-left">
            <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/slg.png" /></a>
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
                            <li><a href="showlivebycategory.jsp?category=csgo">CS:GO</a></li>
                            <li><a href="showlivebycategory.jsp?category=overwatch">守望先锋</a></li>
                            <li><a href="showlivebycategory.jsp?category=lol">英雄联盟</a></li>
                            <li><a href="showlivebycategory.jsp?category=dota2">DOTA2</a></li>
                            <li><a href="showlivebycategory.jsp?category=hs">炉石传说</a></li>
                            <li><a href="showlivebycategory.jsp?category=majiang">麻将</a></li>
                            <li><a href="showlivebycategory.jsp?category=majiang">麻将</a></li>
                        </ul>
                    </li>

                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-tv"></i> <span> 我的关注 </span> </a>
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
        <div>
            <div class="content">

                <div class="row"  style="width: 95%;padding: 5%;">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12" style="border: 1px solid transparent;background:url(0);">
                        <div class="card mb-3" style="border: 1px solid transparent;background:url(0);">
                            <div class="card-header" style="border: 1px solid transparent;background:url(0);">
                                <h3><i class="fa fa-image"></i> 头 像 </h3>
                            </div>

                            <div class="card-body" style="border: 1px solid transparent;background:url(0);">
                                <a data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                                    <img alt="image" id="showphoto" class="img-fluid" style="width:50px; height:50px;">
                                </a>
                            </div>
                        </div><!-- end card-->
                    </div>

                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                        <div class="card mb-3">
                            <div class="card-header">
                                <h3><i class="fa fa-table"></i> 个 人 信 息</h3>
                            </div>

                            <div class="card-body">

                                <table class="table table-responsive-xl table-striped">
                                    <thead>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th scope="row">昵称</th>
                                        <td id="nickname"> </td>

                                    </tr>
                                    <tr>
                                        <th scope="row">性别</th>
                                        <td id="gender"> </td>

                                    </tr>
                                    <tr>
                                        <th scope="row">手机号</th>
                                        <td id="phone"> </td>

                                    </tr>
                                    <tr>
                                        <th scope="row">身份</th>
                                        <td id="identify"> </td>

                                    </tr>
                                    </tbody>
                                </table>
                                <a role="button" class="btn btn-primary" style="float: right;">修改个人信息</a>
                                <a role="button" class="btn btn-link" style="float: right;"></a>
                                <a role="button" class="btn btn-warning" style="float: right;" id="liveuper"></a>

                            </div>
                        </div><!-- end card-->


                </div>

            </div></div>
    </body>
    <!-- END content-page -->

    <footer class="footer">
    </footer>

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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

<!-- Counter-Up-->
<script src="assets/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
<script src="assets/plugins/counterup/jquery.counterup.min.js"></script>


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
           <!-- 获取当前用户的信息并载入到页面中 -->
            var data1={token:$.cookie("token")};
            $.ajax({
                type: "post",
                url: "/api/manage/personalinfo",
                data: JSON.stringify(data1),
                dataType: "json",
                success: function (msg) {
                    var tnn = document.getElementById("nickname");
                    var nickname = msg.nickname;
                    tnn.innerText = nickname;

                    var tg = document.getElementById("gender");
                    var gender = msg.gender;
                    tg.innerText = gender;

                    var tp = document.getElementById("phone");
                    var phone = msg.phone;
                    tp.innerText = phone;

                    alert(msg.icon);
                    $("#showphoto").attr("href",msg.icon);

                    var ti = document.getElementById("identify");
                    var tlu = document.getElementById("liveuper");
                    if(msg.isYoutuber === 1){
                        ti.innerText = "考拉主播";
                        $("#liveuper").attr("href","personcenter_live.jsp");
                        tlu.innerText = "主播管理";
                        $("#liveuper").attr("value","主播管理");
                    }else if(msg.isBarhost === 1){
                        ti.innerText = "普通用户（话圈主持人）";
                        $("#liveuper").attr("href","applylivehome.jsp");
                        tlu.innerText = "成为主播";
                    }else if(msg.isAdmin === 1){
                        ti.innerText = "管理员";
                    }else{
                        ti.innerText = "普通用户";
                        $("#liveuper").attr("href","applylivehome.jsp");
                        tlu.innerText = "成为主播";
                    }

                    if(msg.tag!==-1){
                        var tem ="<div class=\"col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6\">" +
                            "<div class=\"card mb-3\">" +
                            "<div class=\"card-header\">" +
                            "<h3><i class=\"fa fa-table\"></i> 我 的 考 拉 关 注</h3>" +
                            "</div>" +
                            "<div class=\"card-body\">" +
                            "<div class=\"table-responsive\">" +
                            "<table id=\"example3\" class=\"table table-bordered table-hover display\">" +
                            "<tbody>";
                        for(var i = 0 ; i < msg.follows.length ; i++){
                            tem +="<tr>"+
                                 "<td><img src="+msg.follows[i].userpic+
                                 "style=\"width:30px; height:30px; border-radius:50%;\"></td>"+
                                 "<td>"+msg.follows[i].nickname+"</td>"+
                                 "<td>"+numofans+"</td></tr>";
                        }
                        tem += "</tbody></table></div> </div> </div> </div>";
                        $("#follow").html(tem);

                    }
                },
            });
        }
    });
</script>

<script>

</script>
<style type="text/css">
    .mydiv{
        width:250px;

        height:auto;

        border:#909090 1px solid;

        background:#fff;

        color:#333;

        filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);

        -moz-box-shadow: 2px 2px 10px #909090;

        -webkit-box-shadow: 2px 2px 10px #909090;

        box-shadow:2px 2px 10px #909090;
    }
</style>
<!-- END Java Script for this page -->

</body>
</html>
