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
      <div class="content" style="width: 50%;margin-left: 25%;margin-right: 25%;margin-top: 80px">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
          <div class="card mb-3">
            <div class="card-header"  style="text-align:center;">
              <h3><i class="fa fa-hand-pointer-o"></i> 欢迎注册KoalaTV</h3>
              请填写以下信息
            </div>

            <div class="card-body">

              <form class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xl-10" style="margin-left: 10%;margin-right: 10%" method="post"  onsubmit="return false;">
                <div class="form-group" >
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
                    <option>DOTA2</option>
                    <option>炉石传说</option>
                    <option>CS:GO</option>
                    <option>麻将</option>
                    <option>守望先锋</option>
                  </select>
                </div>
                <div class="form-row col-md-12">
                  <div class="form-group col-md-4">

                    <input type="text" class="form-control" id="newcode" placeholder="会发送短信给您的手机号">

                  </div>
                  <div class="form-group col-md-4">
                    <button type="button" id="getcode" class="btn btn-primary" onclick="getCode()">获取验证码</button>
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
                        <input type="file" name="icon" id="icon" multiple="multiple">
                      </div>
                    </div><!-- end card-->
                  </div>


                </div>
                <div class="form-group text-right m-b-6">
                  <div class="checkbox">
                    <input id="remember-1" type="checkbox" data-parsley-multiple="remember-1">
                    <label for="remember-1" >我已阅读</label>
                    <a href="yonghu.html"><i>《考拉直播用户注册协议》</i></a>
                  </div>
                </div>

                <div class="form-group text-right m-b-6">
                  <input class="btn btn-primary" type="submit" value="注册" onclick="applyButton()">
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


  <!-- 注册请求 -->
  <!-- 这个注册还差，验证码，还差上传（默认）头像的功能-->
  <script type="text/javascript">

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

      function disabledButton() {
          $("#getcode").attr({"disabled":"disabled"});     //控制按钮为禁用
          var second = 20;
          var intervalObj = setInterval(function () {
              $("#getcode").text(second+"之后再次发送验证码" );
              if(second === 0){
                  $("#getcode").text("获取验证码");
                  $("#getcode").removeAttr("disabled");//将按钮可用
                  /* 清除已设置的setInterval对象 */
                  clearInterval(intervalObj);
              }
              second--;
          }, 2000 );

      }

      // 前端验证码
      // 绑定了"发送验证码的按钮"
      function getCode() {
          data1={phone:$('#phone').val()};
          $.ajax({
              type:"post",
              url:"http://ccnubt.club:8080/koalaTV/api/auth/identify",
              data:JSON.stringify(data1),
              dataType:"json",
              success:function(msg) {
                  setCookie(msg.token);
                  disabledButton();
                  if(msg.tag === 1){
                      return 1;
                  }else{
                      swal({
                          title:"验证码错误～",
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
                      return 0;
                  }
               }
          });

      }

      //上传图片
      //返回了ICON的值 || null 失败
      function setImg(obj,gender) {
          var f = $(obj).val();
          if (f == null || f === undefined || f === '') {
              return null;
          }
          if (!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)) {
              alert("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
              $(obj).val('');
              return null;
          }
          var data = new FormData();
          console.log(data);
          $.each($(obj)[0].files, function (i, file) {
              data.append('file', file);
          });
          $.ajax({
              type: "POST",
              url: "http://ccnubt.club:8080/koalaTV/api/manage/uploadpic",
              data: data,
              cache: false,
              contentType: false,    //不可缺
              processData: false,    //不可缺
              dataType: "json",
              success: function (msg) {
                  if (msg.tag === 1) {
                    //  alert("msg.tag==1");
                      icon = $(obj)[0].files[0].name;
                      updateBasic(obj,gender,icon);
                      return $(obj)[0].files[0].name;
                  } else {
                      swal({
                          title:"图片上传失败，检查网络～",
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
                      return null;
                  }
              },
              error: function (XMLHttpRequest, textStatus, errorThrown) {
              }
          });
      }

      function updateBasic(obj,gender,icon){
              var oldcode=$.cookie("token");
              var newcode=$('#newcode').val();
              data1={phone: $('#phone').val(),userpassword: $('#userpassword').val(),gender:gender,nickname:$('#nickname').val(),icon:icon,oldcode:oldcode,newcode:newcode};
             // alert(JSON.stringify(data1));
              $.ajax({
                  type:"post",
                  url:"http://ccnubt.club:8080/koalaTV/api/auth/register",
                  data:JSON.stringify(data1),
                  dataType:"json",
                  success:function(msg){
                      var tag = msg.tag;
                      if (tag === 1){
                          setCookie(msg.token);
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
                      }else if(tag === -1){
                          swal({
                              title:"账号已经注册啦，请前往登陆～",
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
                      }else if(tag === 0){
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
      }


      function applyButton() {
          var gender;
          if($('#gender').val()==="女"){
              gender=2;
          }else{
              gender=1;
          }
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
              setImg(document.getElementById("icon"),gender);
          }
      }
  </script>
  <!-- END Java Script for this page -->

  </body>
  <style type="text/css">
    .mydiv{
      width:250px;

      height:auto;

      background:#fff;

      box-shadow: 4px 0 2px #909090;
    }
  </style>

</html>
