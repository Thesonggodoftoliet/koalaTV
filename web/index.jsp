<%--
  Created by IntelliJ IDEA.
  User: 53564
  Date: 2019/12/25
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>考拉直播---一个快乐的游戏直播平台</title>
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
    <div class="left main-sidebar mydiv" style="background: snow">

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
              <a href="#"><i class="fa fa-fw fa-tv"></i> <span> 我的关注 </span></a>
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

          <div class="clearfix"></div>

        </div>

        <div class="clearfix"></div>

      </div>

    </div>
    <!-- End Sidebar -->


    <div class="content-page">
      <div>
        <div class="content">

          <br/> 

          <div class="row">

            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4 col-xl-4">
              <div class="card mb-3">
                <div class="card-header">
                  <h3> 直播房间 1</h3>
                </div>

                <div class="card-body">

                  <div><img class="img-fluid" data-toggle="magnify" src="assets/images/sample-image-1.jpg" alt="Sample Image"></div>

                </div>
              </div><!-- end card-->
            </div>


          </div>
          <!-- END content -->
          <div class="alert" role="alert">
            <h4 class="alert-heading">游 戏 分 区</h4>
          </div>

          <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
              <div class="card mb-3">

                <div class="card-body">

                  <div class="row">
                    <a href="showlivebycategory.jsp?category=csgo" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                      <img alt="image" src="assets/images/gamelogo/csgo.png" class="img-fluid">
                    </a>
                    <a href="showlivebycategory.jsp?category=overwatch" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                      <img alt="image" src="assets/images/gamelogo/overwatch.png" class="img-fluid">
                    </a>
                    <a href="showlivebycategory.jsp?category=lol" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                      <img alt="image" src="assets/images/gamelogo/lol.png" class="img-fluid">
                    </a>

                    <a href="showlivebycategory.jsp?category=dota2" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                      <img alt="image" src="assets/images/gamelogo/dota2.png" class="img-fluid">
                    </a>
                    <a href="showlivebycategory.jsp?category=hs" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                      <img alt="image" src="assets/images/gamelogo/hs.png" class="img-fluid">
                    </a>
                    <a href="showlivebycategory.jsp?category=majiang" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-2">
                      <img alt="image" src="assets/images/gamelogo/majiang.png" class="img-fluid">
                    </a>
                  </div>

                </div>
              </div><!-- end card-->
            </div>





            <div class="row" style="bottom: 0px;position: fixed;width: 100%">
              <img src="assets/images/bottom.png" style="margin: 0 auto;width: 100%;">
          </div>
          </div>
        </div>

      </div>
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

  <!-- App js -->
  <script src="assets/js/pikeadmin.js"></script>

  <!-- BEGIN Java Script for this page -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

  <!-- Counter-Up-->
  <script src="assets/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
  <script src="assets/plugins/counterup/jquery.counterup.min.js"></script>

  <script>
      $(document).ready(function() {
      } );
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
