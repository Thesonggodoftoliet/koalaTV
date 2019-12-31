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

    <!-- top bar navigation -->
    <div class="headerbar">

      <!-- LOGO -->
      <div class="headerbar-left">
        <a href="index.jsp" class="logo"><img alt="Logo" src="assets/images/logo.png" /> <span>koalaTV</span></a>
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
                <h5><small>搜索</small></h5>
              </div>

            </div>
          </li>

          <li class="list-inline-item dropdown notif">
            <a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
              <img src="assets/images/avatars/admin.png" alt="Profile image" class="avatar-rounded">
            </a>
            <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
              <!-- item-->
              <div class="dropdown-item noti-title">
                <h5 class="text-overflow"><small>Hello, koalaer</small> </h5>
              </div>

              <!-- item-->
              <a href="personcenter_basic.jsp" class="dropdown-item notify-item">
                <i class="fa fa-user"></i> <span>Profile</span>
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

        </div>

      </div>

    </div>
    <!-- End Sidebar -->


    <div class="content-page">
      <!-- Start content -->
      <div class="content" style="width: 90%;padding: 5%;">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
          <div class="card mb-3">
            <div class="card-header"  style="text-align:center;">
              <h3><i class="fa fa-hand-pointer-o"></i> 欢迎注册KoalaTV</h3>
              请填写以下信息
            </div>

            <div class="card-body">

              <form class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-9" method="post"  onsubmit="return false;">
                <div class="form-group">
                  <label for="phone">账号（手机号）<span class="text-danger">*</span></label>
                  <input type="text" data-parsley-trigger="change" required="" placeholder="请输入11位手机号" class="form-control" id="phone">
                </div>
                <div class="form-group">
                  <label for="userpassword">用户密码<span class="text-danger">*</span></label>
                  <input type="password" name="email" data-parsley-trigger="change" required="" placeholder="请输入10到19位密码" class="form-control" id="userpassword">
                </div>
                <div class="form-group">
                  <label for="userpasswordagain">确认密码<span class="text-danger">*</span></label>
                  <input id="userpasswordagain" type="password" placeholder="请再次输入你的密码" required="" class="form-control">
                </div>
                <div class="form-group">
                  <label for="nickname">昵称 <span class="text-danger">*</span></label>
                  <input data-parsley-equalto="#pass1" type="text" required="" placeholder="昵称" class="form-control" id="nickname">
                </div>
                <div class="form-group">
                  <label>性别(男/女)</label>
                  <div>
                    <input type="text" class="form-control" id="gender" placeholder="性别">
                  </div>
                </div>
                <div class="form-group col-md-4">
                  <label for="inputLike">喜欢的游戏类型</label>
                  <select id="inputLike" class="form-control">
                    <option selected>英雄联盟</option>
                    <option>守望先锋</option>
                    <option>qq三国</option>
                    <option>斗地主</option>
                    <option>和平精英</option>
                  </select>
                </div>
                <div class="form-row col-md-12">
                  <div class="form-group col-md-4">

                    <input type="text" class="form-control" id="inputphoneNum" placeholder="会发送短信给您的手机号">

                  </div>
                  <div class="form-group col-md-4">
                    <button type="button" class="btn btn-primary">获取验证码</button>
                  </div>

                </div>
                <div class="row">
                  <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <div class="card mb-3">
                      <div class="card-header">
                        <h3><i class="fa fa-file"></i>头像</h3>
                        文件大小必须小于1MB，且格式为jpg/jpeg
                      </div>

                      <div class="card-body">

                        <input type="file" name="files[]" id="filer_example2" multiple="multiple">

                      </div>
                    </div><!-- end card-->
                  </div>


                </div>
                <div class="form-group text-right m-b-6">
                  <div class="checkbox">
                    <input id="remember-1" type="checkbox" data-parsley-multiple="remember-1">
                    <label for="remember-1"> 记住我 </label>
                  </div>
                </div>

                <div class="form-group text-right m-b-6">
                  <input class="btn btn-primary" type="submit"  onclick="applyButton()">
                    <a href="login.jsp"><i>已经注册了～ 快去登陆叭</i></a>
                </div>

              </form>

            </div>
          </div><!-- end card-->
        </div>

      </div>
      <!-- END content -->
    </div>
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
          // data-tables
          $('#example1').DataTable();

          // counter-up
          $('.counter').counterUp({
              delay: 10,
              time: 600
          });
      } );
  </script>

  <!-- 注册请求 -->
  <!-- 这个注册还差，验证码，还差上传（默认）头像的功能-->
  <script type="text/javascript">

      function setCookie(token) {
          $.cookie("token", token);
      }

      function getCookie(token) {
          token = $.cookie("token");
      }

      function updateBasic(){
          var gender;
          var flag=0;
          if($('#gender').val()=="女"){
              gender=2;
          }else{
              gender=1;
          }
          var icon="";
          data1={phone: $('#phone').val(),userpassword: $('#userpassword').val(),gender:gender,nickname:$('#nickname').val(),icon:icon};
          alert(JSON.stringify(data1));
          $.ajax({
              type:"post",
              url:"/api/auth/register",
              data:JSON.stringify(data1),
              dataType:"json",
              success:function(msg){
                  var tag = msg.tag;
                  if (tag == 1){
                      setCookie(msg.token);
                      flag=1;
                      swal({
                          title:"欢迎进入考拉直播～",
                          icon:"success",
                          button:{
                              text: "吖咪！",
                              closeModal: false,
                          },
                      }).then(
                          function (value) {
                              if(value){
                                  window.location.href="index.jsp"
                              }
                          }
                      );
                  }else if(tag == -1){
                      swal({
                          title:"再检查一下，看看哪里的信息错了哦！～",
                          icon:"warning",
                          button:{
                              text: "好der～",
                              closeModal: false,
                          },
                      }).then(
                          function (value) {
                              if(value){
                                  swal.close();
                              }
                          }
                      );
                  }else if(tag == 0){
                      swal({
                          title:"疑～服务器开小差了呢，再试一次吧！",
                          icon:"warning",
                          button:{
                              text: "害，好吧",
                              closeModal: false,
                          },
                      }).then(
                          function (value) {
                              if(value){
                                  swal.close();
                              }
                          }
                      );
                  }else{
                      swal({
                          title:"疑～好像哪里出错了呀！",
                          icon:"warning",
                          button:{
                              text: "害，再试一次",
                              closeModal: false,
                          },
                      }).then(
                          function (value) {
                              if(value){
                                  swal.close();
                              }
                          }
                      );
                  }

              }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                  alert(XMLHttpRequest.status);
                  alert(XMLHttpRequest.readyState);
                  alert(textStatus);
              }
          });

          $.ajax({
              type: "post",
              url: "/api/auth/register",
              data: JSON.stringify(data1),
              dataType: "json",
              success: function x() {


              }
          });
      }

      function applyButton() {
          <!-- judge password -->
          var password1 = $('#userpassword').val();
          var password2 = $('#userpasswordagain').val();
          if(password1!==password2){
              swal({
                  title:"再检查一下，两次密码不一样哦！～",
                  icon:"warning",
                  button:{
                      text: "好der～",
                      closeModal: false,
                  },
              }).then(
                  function (value) {
                      if(value){
                          swal.close();
                      }
                  }
              );
          }else{
              updateBasic();
          }
      }
  </script>
  <!-- END Java Script for this page -->

  </body>
</html>
