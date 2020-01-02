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
        <a href="index.html" class="logo"><img alt="Logo" src="assets/images/logo.png" /> <span>Admin</span></a>
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
                        <li><a href="personcenter_basic.html">基本信息</a></li>
                        <li><a href="personcenter_live.html">直播管理</a></li>
                        <li><a>退出登陆</a></li>
                    </ul>
                </li>

            </ul>

            <div class="clearfix"></div>

        </div>

        <div class="clearfix"></div>

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
</html>
