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
            <a class="nav-link dropdown-toggle nav-user" id="xiaoren" href="">
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
          <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>

      </div>

    </div>
    <!-- END content-page -->
      <div class="content-page">

          <!-- Start content -->
          <div class="content"  style="background-image: url(assets/images/onebk.png);background-size: 100% 65%;background-repeat:no-repeat;">

              <div class="container-fluid" style="padding: 10%;">

                  <!-- end row -->

                <div>
                  <div class="row" id="rowdiv">
                      <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
                          <div  id="id_video_container" style="width:100%; height:auto;"></div>
                      </div>
                      <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3" style="background-color: rgba(0,0,0,0)">
                              <div id='external-events' class="breadcrumb-holder" style="height: 400px;background-color: rgba(247,203,102,0.8)">
                                  <div  class="fa-hover" ><h2 id="livetitle" style="color: rgb(255,255,255)"></h2></div>
                                  <div  class="fa-hover" ><i class="fa fa-tags" aria-hidden="true"></i><h4 id="category" style="color: rgb(255,255,255)"></h4></div>
                                  <div  class="fa-hover" ><i class="fa fa-user-circle-o" aria-hidden="true"></i><h4 id="username" style="color: rgb(255,255,255)"></h4></div>
                                  <div  class="fa-hover" ><i class="fa fa-venus-double" aria-hidden="true"></i><h4 id="watch" style="color: rgb(255,255,255)"></h4></div>
                                  <div style="text-align:center;">
                                      <button class="btn btn-warning" href="currentlive.jsp?roomid=1" align="center" style="background-color: rgba(255,255,255,1.0);color: rgb(247,203,102)">前往直播间</button>
                                  </div>


                              </div>

                      </div>
                  </div>

                      <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                          <div class="card mb-3" style="border:1px solid transparent;margin-top: 7%;">
                              <div class="card-body" style="border:1px solid transparent">

                                  <div class="row">

                                      <a data-fancybox="gallery" href="showlivebycategory.jsp?category=csgo" class="col-sm-2">
                                          <img alt="image" src="assets/images/gamelogo/csgo.png" class="img-fluid">
                                      </a>

                                      <a data-fancybox="gallery" href="showlivebycategory.jsp?category=dota2" class="col-sm-2">
                                          <img alt="image" src="assets/images/gamelogo/dota2.png" class="img-fluid">
                                      </a>

                                      <a data-fancybox="gallery" href="showlivebycategory.jsp?category=hs" class="col-sm-2">
                                          <img alt="image" src="assets/images/gamelogo/hs.png" class="img-fluid">
                                      </a>

                                      <a data-fancybox="gallery" href="showlivebycategory.jsp?category=lol" class="col-sm-2">
                                          <img alt="image" src="assets/images/gamelogo/lol.png" class="img-fluid">
                                      </a>

                                      <a data-fancybox="gallery" href="showlivebycategory.jsp?category=majiang" class="col-sm-2">
                                          <img alt="image" src="assets/images/gamelogo/majiang.png" class="img-fluid">
                                      </a>

                                      <a data-fancybox="gallery" href="showlivebycategory.jsp?category=overwatch" class="col-sm-2">
                                          <img alt="image" src="assets/images/gamelogo/overwatch.png" class="img-fluid">
                                      </a>
                                  </div>

                              </div>
                          </div><!-- end card-->
                      </div>

                  </div>

              </div>
              <!-- END container-fluid -->

          </div>
          <!-- END content -->

      </div>

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
  <script>
      $(document).ready(function(){
          if(checkCookie("token") === false){
              var id=document.getElementById("xiaoren");
              id.href="login.jsp";
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
          }else{
              var id = document.getElementById('xiaoren');
              id.href="personcenter_basic.jsp";
              data1={token:$.cookie("token")};
              $.ajax({
                  type: "POST",
                  url: "/api/live/hotlive",
                  data: JSON.stringify(data1),
                  cache: false,
                  contentType: false,    //不可缺
                  processData: false,    //不可缺
                  dataType: "json",
                  success: function (msg) {
                      setCookie(msg.token);
                      if( msg.tag === 1){
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
                      }else {
                          var tem = "<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12\" style=\"background-color: rgba(247,203,102,0.8);height: 500px;text-align: center;\">";
                          tem += "<img src='assets/images/sleep.png' style='width:auto;height:95%;' />"
                          tem += "</div>";
                          document.getElementById("rowdiv").innerHTML = tem;

                      }

                  },
                  error: function (XMLHttpRequest, textStatus, errorThrown) {
                  }
              });

          }
      });
  </script>

  <!-- END Java Script for this page -->
  </body>
</html>
