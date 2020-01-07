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
    <div class="content" style="height: 90%;width: 90%;padding: 5%;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="breadcrumb-holder">
                        <h1 class="float-left" id="livetitle"></h1>
                        <ol class="breadcrumb float-right">
                            <a href="index.jsp"><li class="breadcrumb-item">回到主页</li></a>
                        </ol>
                        <div class="clearfix"></div>
                        <div class="row">
                        <div class="fa-hover col-md-4 col-lg-4 col-xl-4"><i class="fa fa-user-circle-o bigfonts" aria-hidden="true"></i><p id="username"></p></div>

                        <div class="fa-hover col-md-4 col-lg-4 col-xl-4"><i class="fa fa-tags bigfonts" aria-hidden="true"></i><p id="category"></p></div>

                        <div class="fa-hover col-md-4 col-lg-4 col-xl-4"><i class="fa fa-venus-double bigfonts" aria-hidden="true"></i><p id="watch"></p></div>

                            <div class="fa-hover col-md-4 col-lg-4 col-xl-4"></div>
                        <div class="clearfix"></div>
                        </div>
                    </div>
                </div>


            </div>
            <!-- end row -->
        </div>

            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="col-md-4 col-lg-4 col-xl-4">
                            <div id="focusbutton"></div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4">
                            <div class="card-box tilebox-one noradius">
                                <div id='charts'>
                                    <h4>聊天室嘿嘿嘿</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
                    <div  id="id_video_container" style="width:100%; height:auto;"></div>
                </div>
            </div>
            <!-- end row -->




        <!-- END container-fluid -->

    </div>
    <!-- END content -->

</div>


</body>

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

    function getQueryString(name) {
        let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        let r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }

    function cancelone(hostid) {
        var data4 = {hostid:hostid,token:$.cookie("token")};
        $.ajax({
            type:"POST",
            url: "api/youtuber/applyyoutuber",
            data: JSON.stringify(data4),
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success:function (msg) {
                setCookie(msg.token);
                if(msg.tag === 1){
                    swal({
                        title:"嘤嘤嘤，你不要我了",
                    });
                }else if(msg.tag === -1){
                    swal({
                        title:"害，你就没关注过我好叭",
                    });
                }

            }
        });

    }

    function followone(follow) {
        var data3 = {follow:follow,token:$.cookie("token")};
        $.ajax({
            type:"POST",
            url: "http://localhost:8080/koalaTV/api/youtuber/followyoutuber",
            data: JSON.stringify(data3),
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success:function (msg) {
                setCookie(msg.token);
                if(msg.tag === 1){
                    swal({
                        title:"成功关注",
                    });
                }else if(msg.tag === -1){
                    swal({
                        title:"之前关注过了",
                    });
                }

            }
        });

    }

    function getfocus(roomid){
        var data2 = {roomid:roomid,token:$.cookie("token")};
        $.ajax({
            type:"POST",
            url: "http://localhost:8080/koalaTV/api/live/showfocus",
            data: JSON.stringify(data2),
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success:function (msg) {
                setCookie(msg.token);
                var tem = "";
                if(msg.tag === 1){
                    tem += "<button onclick='cancelone("+roomid+")'>"
                    tem += "已关注";
                }else if(msg.tag === -1){
                    tem += "<button onclick='followone("+roomid+")'>"
                    tem += "未关注";
                }
                tem +="</button>";
                document.getElementById("focusbutton").innerHTML = tem;

            }
        });
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
        //显示信息
            roomid=getQueryString("roomid");
            data1={token:$.cookie("token"),roomid:roomid};
            $.ajax({
                type: "POST",
                url: "http://47.106.186.164:8080/koalaTV/api/live/getroom",
                data: JSON.stringify(data1),
                cache: false,
                contentType: false,    //不可缺
                processData: false,    //不可缺
                dataType: "json",
                success: function (msg) {
                    setCookie(msg.token);
                    document.getElementById("livetitle").innerText = msg.title;
                    document.getElementById("category").innerText = msg.category;
                    document.getElementById("username").innerText = msg.username;
                    document.getElementById("watch").innerText = msg.watch;
                    var option = {
                        "live_url" : msg.rtmpurl,
                        "live_url2" : msg.flvurl,
                        "live_url3": msg.hlsurl,
                        "width" : 600,
                        "height" : 400
                    };
                    (function(){
                        var player = new qcVideo.Player("id_video_container", option)
                    })()

                    getfocus(roomid);

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });

        }
    });
</script>
<style type="text/css">
    .mydiv{
        width:250px;

        height:auto;

        background:#fff;

        box-shadow: 4px 0 2px #909090;
    }
</style>

</html>
