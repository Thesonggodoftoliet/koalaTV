<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2019/12/29
  Time: 下午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>考拉直播---我的关注</title>
    <!-- Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- Switchery css -->
    <link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" />

    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <!-- Font Awesome CSS -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

    <!-- BEGIN CSS for this page -->
    <link href="assets/plugins/owlcarousel/owl.carousel.min.css" rel="stylesheet" />
    <link href="assets/plugins/owlcarousel/owl.theme.default.min.css" rel="stylesheet" />
    <style>
        .owl-carousel .item-video {
            height: 300px;
        }
        .counter {
            font-size: 3.5rem;
        }
    </style>
    <!-- END CSS for this page -->

</head>

<body class="adminbody">

<div id="main">
    <!-- top bar navigation -->
    <div class="headerbar">

        <!-- LOGO -->
        <div class="headerbar-left">
            <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/slg.png" /><span>&nbsp</span></a>
        </div>

        <nav class="navbar-custom">

            <ul class="list-inline float-right mb-0">



                <li class="list-inline-item dropdown notif" >
                    <a class="nav-link dropdown-toggle nav-user"  href="personcenter_basic.jsp.jsp" data-toggle="dropdown" role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-user-o bigfonts" aria-hidden="true"></i><span>&nbsp</span>
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
                        <a href="myfocuslive.jsp"><i class="fa fa-fw fa-tv"></i> <span> 我的关注 </span></a>
                    </li>

                    <li class="submenu">
                        <a><i class="fa fa-fw fa-th"></i> <span> 个人中心 </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="personcenter_basic.jsp">基本信息</a></li>
                            <li><a href="personcenter_live.jsp">直播管理</a></li>
                            <li><a href="login.jsp">切换账号</a></li>
                        </ul>
                    </li>
                    <li class="submenu" style="position:bottom left;">
                        <img src="assets/images/bgp2.png" height="500" width="255"/>
                    </li>

                </ul>
            </div>

        </div>

    </div>
    <!-- End Sidebar -->

    <div class="content-page">

        <!-- Start content -->
        <div class="content">

            <div class="container-fluid" >
                <div class="row" id="home" style="padding:8%;">


                </div>
            </div>
            <!-- END container-fluid -->

        </div>
        <!-- END content -->

    </div>
    <!-- END content-page -->

    <footer class="footer">
		<span class="text-right">
		Copyright <a target="_blank" href="#">Koala TV</a>
		</span>
        <span class="float-right">
		      用心创造快乐 用爱拉近距离
		</span>
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
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/plugins/switchery/switchery.min.js"></script>
<script src="assets/js/jquery.cookie.js"></script>

<!-- App js -->
<script src="assets/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->
<script src="assets/plugins/owlcarousel/owl.carousel.min.js"></script>
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
             data1={token: $.cookie("token"),category: "follow"};
             $.ajax({
                 type:"post",
                 url:"http://ccnubt.club:8080/koalaTV/api/live/getliveroom",
                 data:JSON.stringify(data1),
                 cache: false,
                 dataType:"json",
                 success:function(json){
                     var tem = " ";
                     setCookie(json.token);
                     if(json.tag === -1){
                         tem+="<div class='col-xl-12' align='center'><img src='assets/images/sleep.png' style='width:auto;height:500px;' /></div><div class='clearfix'></div>";
                     }
                     else{
                         for(var i=0;i<json.rooms.length;i++){
                             tem+="<div class='col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3'><div class='card md-3 lg-3 xl-3'><div class='card-header'>";
                             tem+="<h3>"+json.rooms[i].title+"</h3>";
                             tem+="</div><a href='currentlive.jsp?roomid="+json.rooms[i].roomid+"'><div class='card-body' style='width:100%;padding:0px'><img style='left:0;width: 100%;height: 190px' data-toggle='magnify' src='"+json.rooms[i].coverpic+"'></img>";
                             tem+="</div></div></a></div></div>";
                         }
                     }
                     $("#home").html(tem);
                 },error: function (XMLHttpRequest, textStatus, errorThrown) {
                     alert(XMLHttpRequest.status);
                     alert(XMLHttpRequest.readyState);
                     alert(textStatus);
                 }
             });

         }
    });
</script>
<!-- END Java Script for this page -->

</body>
<style type="text/css">
    .mydiv{
        height:100%;

        background:#fff;

        box-shadow: 4px 0 2px #909090;
    }
</style>

</html>
