<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2020/1/2
  Time: 下午7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考拉直播----游戏分区直播</title>
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
<body style="background: rgb(255,255,255)">

<div id="main">

    <!-- top bar navigation -->
    <div class="headerbar">

        <!-- LOGO -->
        <div class="headerbar-left">
            <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/logo.png" /> <span>Admin</span></a>
        </div>

        <nav class="navbar-custom">

            <ul class="list-inline float-right mb-0">

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-fw fa-question-circle"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5><small>Help and Support</small></h5>
                        </div>

                        <!-- item-->
                        <a target="_blank" href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Do you want custom development to integrate this theme?</b>
                                <span>Contact Us</span>
                            </p>
                        </a>

                        <!-- item-->
                        <a target="_blank" href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Do you want PHP version of the theme that save dozens of hours of work?</b>
                                <span>Try Pike Admin PRO</span>
                            </p>
                        </a>

                        <!-- All-->
                        <a title="Clcik to visit Pike Admin Website" target="_blank" href="#" class="dropdown-item notify-item notify-all">
                            <i class="fa fa-link"></i> Visit Pike Admin Website
                        </a>

                    </div>
                </li>

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-fw fa-envelope-o"></i><span class="notif-bullet"></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5><small><span class="label label-danger pull-xs-right">12</span>Contact Messages</small></h5>
                        </div>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Jokn Doe</b>
                                <span>New message received</span>
                                <small class="text-muted">2 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Michael Jackson</b>
                                <span>New message received</span>
                                <small class="text-muted">15 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Foxy Johnes</b>
                                <span>New message received</span>
                                <small class="text-muted">Yesterday, 13:30</small>
                            </p>
                        </a>

                        <!-- All-->
                        <a href="#" class="dropdown-item notify-item notify-all">
                            View All
                        </a>

                    </div>
                </li>

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-fw fa-bell-o"></i><span class="notif-bullet"></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-lg">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5><small><span class="label label-danger pull-xs-right">5</span>Allerts</small></h5>
                        </div>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <div class="notify-icon bg-faded">
                                <img src="assets/images/avatars/avatar2.png" alt="img" class="rounded-circle img-fluid">
                            </div>
                            <p class="notify-details">
                                <b>John Doe</b>
                                <span>User registration</span>
                                <small class="text-muted">3 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <div class="notify-icon bg-faded">
                                <img src="assets/images/avatars/avatar3.png" alt="img" class="rounded-circle img-fluid">
                            </div>
                            <p class="notify-details">
                                <b>Michael Cox</b>
                                <span>Task 2 completed</span>
                                <small class="text-muted">12 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <div class="notify-icon bg-faded">
                                <img src="assets/images/avatars/avatar4.png" alt="img" class="rounded-circle img-fluid">
                            </div>
                            <p class="notify-details">
                                <b>Michelle Dolores</b>
                                <span>New job completed</span>
                                <small class="text-muted">35 minutes ago</small>
                            </p>
                        </a>

                        <!-- All-->
                        <a href="#" class="dropdown-item notify-item notify-all">
                            View All Allerts
                        </a>

                    </div>
                </li>

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <img src="assets/images/avatars/admin.png" alt="Profile image" class="avatar-rounded">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5 class="text-overflow"><small>Hello, admin</small> </h5>
                        </div>

                        <!-- item-->
                        <a href="pro-profile.html" class="dropdown-item notify-item">
                            <i class="fa fa-user"></i> <span>Profile</span>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <i class="fa fa-power-off"></i> <span>Logout</span>
                        </a>

                        <!-- item-->
                        <a target="_blank" href="#" class="dropdown-item notify-item">
                            <i class="fa fa-external-link"></i> <span>Pike Admin</span>
                        </a>
                    </div>
                </li>

            </ul>

            <ul class="list-inline menu-left mb-0">
                <li class="float-left">
                    <button class="button-menu-mobile open-left">
                        <i class="fa fa-fw fa-bars"></i>
                    </button>
                </li>
            </ul>

        </nav>

    </div>
    <!-- End Navigation -->


    <!-- Left Sidebar -->
    <div class="left main-sidebar">

        <div class="sidebar-inner leftscroll">

            <div id="sidebar-menu">

                <ul>

                    <li class="submenu">
                        <a class="active" href="index.jsp"><i class="fa fa-fw fa-bars"></i><span> 主页 </span> </a>
                    </li>

                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-tv"></i> <span> 直播分类 </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="">守望先锋</a></li>
                            <li><a href="">英雄联盟</a></li>
                            <li><a href="">斗地主</a></li>
                            <li><a href="">qq三国</a></li>
                            <li><a href="">和平精英</a></li>
                        </ul>
                    </li>

                    <li class="submenu">
                        <a class="active" href="#"><i class="fa fa-fw fa-tv"></i> <span> 我的关注 </span></a>
                    </li>

                    <li class="submenu">
                        <a><i class="fa fa-fw fa-th"></i> <span> 个人中心 </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="personcenter_basic.jsp">基本信息</a></li>
                            <li><a href="personcenter_live.jsp">直播管理</a></li>
                            <li><a>退出登陆</a></li>
                        </ul>
                    </li>

                </ul>


            </div>

        </div>

    </div>
    <!-- End Sidebar -->


    <div class="content-page">
        <div>
            <div class="content">
                <br/>
                <div class="row" id="home">
                   <!-- end card-->
                </div>
                </div>
                <!-- END content -->
            </div>

        </div>
    </div>
    <!-- END content-page -->

</div>
<!-- END main -->


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
        $(document).ready(function() {
        } );
    </script>
<script>
    function getQueryString(name) {
        let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        let r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        };
        return null;
    }

    let cate = getQueryString("category");

    <!-- 获取某个CATEGORY的直播间 -->

    function setCookie(token) {
        $.cookie("token", token);
    }

    function getCookie() {
        token = $.cookie("token");
        return token;
    }

    var token = getCookie();


    $(function addlivediv(){
        data1={token: token,category: cate};
        $.ajax({
            type:"post",
            url:"/api/live/getliveroom",
            data:JSON.stringify(data1),
            cache: false,
            dataType:"json",
            success:function(json){
                var tem = " ";
                alert(json.tag);
                if(json.tag === -1){
                     tem+="<div class='col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12'><h2>啊哦，当前主播们都休息了呢</h2></div>";
                }
                else{
                    alert("hhhhhhhhhhhh");
                    for(var i=0,l=json.rooms.length;i<l;i++){
                        tem+="<div class='col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3'><div class='card mb-3' style='border: 1px solid transparent;'><div class='card-header' style='border: 1px solid transparent;'>\n";
                        tem+="<h3>"+json.rooms[i].title+"</h3>";
                        tem+="</div><div class='card-body'><div><img class='img-fluid' data-toggle='magnify' src='"+json.rooms[i].coverpic+"'>";
                        tem+="</div></div></div></div>";
                    }
                }
                $("#home").html(tem);
            },error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    });
</script>

</body>
</html>
