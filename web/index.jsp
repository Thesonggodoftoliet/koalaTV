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
        <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/slg.png" />
      </div>

      <nav class="navbar-custom">

        <ul class="list-inline float-right mb-0">



          <li class="list-inline-item dropdown notif" >
            <a class="nav-link dropdown-toggle nav-user" href="personcenter_basic.jsp" data-toggle="dropdown" role="button" aria-haspopup="false" aria-expanded="false">
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
          <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>

      </div>

    </div>
    <!-- END content-page -->

  </div>
  <!-- END main -->

  <script src="assets/js/modernizr.min.js"></script>
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/moment.min.js"></script>

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

  <style type="text/css">
    .mydiv{
          width:250px;

          height:auto;

          background:#fff;

          box-shadow: 4px 0 2px #909090;
    }
  </style>

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
          if(getCookie(name) == null || getCookie(name)==="" || getCookie(name)==="null" || typeof(getCookie(name))==="undefined" || getCookie(name)===false || getCookie(name) === undefined){
              return false;
          }else{
              return true;
          }
      }
  </script>

  <!-- END Java Script for this page -->
  </body>
</html>
