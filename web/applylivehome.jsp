<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2019/12/29
  Time: 下午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>申请成为主播</title>
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
        <div class="content" style="padding: 5%;">

            <div class="container-fluid">

                <br/>
                <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xl-10">
                    <div class="card mb-3">
                        <div class="card-header"  style="text-align:center;">
                            <br/>
                            <h3> ～申请成为主播～ </h3>

                        </div>

                        <div class="card-body" >

                            <form  class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-9"  method="post"  onsubmit="return false;" >
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="truename">真实姓名</label>

                                        <input type="text" class="form-control" id="truename" autocomplete="off">

                                    </div>
                                    <div class="form-group col-md-8">
                                        <label for="identify" class="col-sm-3 col-form-label">身份证件</label>

                                        <input type="text" class="form-control" id="identify" autocomplete="off">

                                    </div>
                                    <div class="form-group col-md-8">
                                        <label for="title" class="col-sm-3 col-form-label">房间标题</label>

                                        <input type="text" class="form-control" id="title" autocomplete="off">

                                    </div>
                                    <div class="form-group col-md-8">
                                        <label for="category">直播间的游戏类型</label>
                                        <select id="category" class="form-control">
                                            <option selected>英雄联盟</option>
                                            <option>DOTA2</option>
                                            <option>炉石传说</option>
                                            <option>CS:GO</option>
                                            <option>麻将</option>
                                            <option>守望先锋</option>
                                        </select>
                                    </div>
                                    <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xl-10">
                                        <div class="card mb-3">
                                            <div class="card-header">
                                                <h3><i class="fa fa-file"></i>直播封面</h3>
                                                文件大小需小于1MB
                                            </div>

                                            <div class="card-body">
                                                <input type="file" name="icon" id="icon" multiple="multiple">
                                            </div>
                                        </div>
                                    </div></div>

                                    <div class="form-group text-right m-b-6">
                                        <div class="checkbox">
                                            <input id="remember-1" type="checkbox" data-parsley-multiple="remember-1">
                                            <label for="remember-1" >我已阅读</label>
                                            <a href="zhubo.html"><i>《考拉直播用户阳光行为规范》</i></a>
                                        </div>
                                    </div>

                                    <div class="form-group col-md-8">
                                        <div class="col-sm-10" style="text-align:center;">
                                            <input type="submit" onclick="applyButton()" class="btn btn-primary" id="apply">
                                        </div>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div><!-- end card-->
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

<!-- Counter-Up-->
<script src="assets/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
<script src="assets/plugins/counterup/jquery.counterup.min.js"></script>

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



    //上传图片
    //返回了ICON的值 || -1 失败
    function setImg(obj) {
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
        console.log(data);
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
                    apply(obj.files[0].name);
                    return obj.files[0].name;
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

    function applyButton() {
        setImg(document.getElementById("icon"));

    }

    function apply(coverpic){
        var token = $.cookie("token");
        var options = $("#category option:selected");  //获取选中的option
        var category = options.text();
        var title = $('#title').val();

        if(category === "英雄联盟"){
            category = "lol";
        }else if(category === "麻将"){
            category = "majiang";
        }else if(category === "CS:GO" || category === "csgo"){
            category = "csgo";
        }else if(category === "守望先锋"){
            category = "overwatch";
        }else if(category === "DOTA2"){
            category = "dota2";
        }else if(category === "炉石传说"){
            category = "hs";
        }

        var data1={token:token,category:category,title:title,coverpic:coverpic};
        //alert(JSON.stringify(data1));
        $.ajax({
            type:"post",
            url:"http://ccnubt.club:8080/koalaTV/api/youtuber/applyyoutuber",
            data:JSON.stringify(data1),
            dataType:"json",
            success:function(msg){
                var tag = msg.tag;
                if (tag === 1){
                    setCookie(msg.token);
                    swal({
                        icon : "success",
                        text:"恭喜你成为主播！拥有自己的直播间啦！",
                        buttons : {
                            button1 : {
                                text : "前往直播中心开播",
                                value : true,
                            },
                            button2 : {
                                text : "暂不直播",
                                value : false,
                            }
                        },
                    })
                        .then(
                            function (value) {
                                if(value){
                                    window.location.href="personcenter_basic.jsp"
                                }else{
                                    window.location.href="personcenter_live.jsp"
                                }

                            }
                        );
                }else if(tag === -1){
                    setCookie(msg.token);
                    swal({
                        title:"已经是主播了哦！～",
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
                    setCookie(msg.token);
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
                    setCookie(msg.token);
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
