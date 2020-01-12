<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2019/12/29
  Time: 下午8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>考拉直播-个人管理</title>

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
        <div class="content" style="width: 100%;margin-top: 80px;padding-left: 5%" >
            <nav class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <ul class="nav nav-tabs">
                    <li class="active" style="margin-left: 2%;margin-right: 2%"><a data-toggle="tab" href="#livem" onclick="flivem()"><h4>直播间管理</h4></a></li>
                    <li><a data-toggle="tab" href="#barm" onclick="fbarm()"><h4>话圈管理</h4></a></li>
                    <li style="margin-right: 2%;margin-left: 2%"><a data-toggle="tab" href="#applym" onclick="fapplym()"><h4>申请本次直播</h4></a></li>
                </ul>
            </nav>
            <div class="row">
                <div  class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xl-10" style="margin-top: 10px">
                    <div class="tab-content">
                        <div id="livem" class="tab-pane fade row in active show">
                        </div>
                        <div id="barm" class="tab-pane fade row">
                        </div>
                        <div id="applym" class="tab-pane fade row">
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- END content -->
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
<style type="text/css">
    .mydiv{
        height:100%;

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
            var data1={token:$.cookie("token")};
            $.ajax({
                type: "POST",
                url: "http://ccnubt.club:8080/koalaTV/api/manage/personalinfo",
                data: JSON.stringify(data1),
                dataType: "json",
                success: function (msg) {
                    console.log(msg);
                    setCookie(msg.token);
                    $.cookie("isYT", msg.isYoutuber);
                    $.cookie("isBH", msg.isBarhost);
                    $.cookie("isAD", msg.isAdmin);
                    flivem();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });
        }
    });

    function flivem() {
       // alert($.cookie("isYT"));
        var data1 = {
          token : $.cookie("token")
        };
        if($.cookie("isYT") === "1"){
            var title;
            var category;
         //   alert("他是主播");
            $.ajax({
                type: "POST",
                url: "http://ccnubt.club:8080/koalaTV/api/live/showhostmanage",
                data: JSON.stringify(data1),
                cache: false,
                contentType: false,    //不可缺
                processData: false,    //不可缺
                dataType: "json",
                success: function (msg) {
                    setCookie(msg.token);
                    title = msg.title;
                    category = msg.category;
                  //  alert(title+" "+category);
                    var tem = " ";
                    tem += "<div class=\"col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xl-10\">";
                    tem += "<div class=\"card mb-3\"><div class=\"card-header\"><h3><i class=\"fa fa-check-square-o\"></i> 直播间管理 </h3>";
                    tem += "</div><div class=\"card-body\"><form><div class=\"form-group\">";
                    tem += "<h5 style='color:#f4c63d'>直播间名字</h5>";
                    tem += "<p id=\"liveid\" style='padding: 10px'>"+title+"</p>";
                    tem += "</div><div class=\"form-group\" style='padding-top:5%'><h5 style='color:#f4c63d'>直播间的分类</h5>";
                    tem += "<P id=\"category\" style='padding:10px'>"+category+"</P>";
                    tem += "</div></form></div></div></div>";
                    document.getElementById("livem").innerHTML = tem;
                    console.log(msg);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        }else{
            var tem = "";
            tem+="<div class='col-xl-12' align='center'><img src='assets/images/nohost.png' style='width:auto;height:500px;' /></div><div class='clearfix'></div>";
            document.getElementById("livem").innerHTML = tem;

        }
    }

    function fbarm() {
       // alert($.cookie("isBH"));
        var data1 = {
            token : $.cookie("token")
        };
        var  tem = "<div class=\"card-body\">" +
            "<div class=\"table-responsive\">" +
            "<table id=\"example3\" class=\"table table-bordered table-hover display\"><thead><tr><th scope='col'>话圈名</th>" +
            "<th scope='col'>主持人ID</th><th scope='col'>主持人姓名</th><th scope='col'>话圈关注度</th><th scope='col'>话圈权限</th></tr></thead><tbody>";
        if($.cookie("isYT") === "1"){
           // alert("他是主播");
            $.ajax({
                type: "POST",
                url: "http://ccnubt.club:8080/koalaTV/api/live/showhostmanage",
                data: JSON.stringify(data1),
                cache: false,
                contentType: false,    //不可缺
                processData: false,    //不可缺
                dataType: "json",
                async:false,
                success: function (msg) {
                    setCookie(msg.token);
                   // alert("他是主播111");

                    tem += "<tr>" +
                        "<td>"+msg.barname+"</td>" +
                        "<td>" + msg.adminid + "</td>" +
                        "<td>" + msg.adminname + "</td>"+
                        "<td>" +msg.numofpost + "</td>"+
                        "<td>"+"<a role='button' class='btn btn-warning' style='float: right;' onclick=setbarhost()>修改话圈信息</a>"+"</td>"+"</tr>";
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                   // alert(XMLHttpRequest.status);
                   // alert(XMLHttpRequest.readyState);
                   // alert(textStatus);
                }
            });
        }
        if($.cookie("isBH") === "1"){  //是主持人
            var data1={token:$.cookie("token")};
           // alert("他是主chiren");
            $.ajax({
                type: "POST",
                url: "http://ccnubt.club:8080/koalaTV/api/bar/getbar",
                data: JSON.stringify(data1),
                cache: false,
                contentType: false,    //不可缺
                processData: false,    //不可缺
                dataType: "json",
                async:false,
                success: function (msg) {
                 //   alert("他是主chiren222");
                    setCookie(msg.token);
                    for(var i = 0; i<msg.bars.length;i++){
                     //   alert(msg.bars[i].adminid+" "+msg.bars[i].hostid);
                        if(msg.bars[i].hostid !== msg.bars[i].adminid) {
                            tem += "<tr>" +
                                "<td>"+msg.bars[i].barname+"</td>" +
                                "<td>" + msg.bars[i].adminid + "</td>" +
                                "<td>" + msg.bars[i].adminname + "</td>"+
                                "<td>" +msg.bars[i].numofpost + "</td>"+
                                "<td>"+"<a role='button' class='btn btn-warning' style='float: right;'>无权修改</a>"+"</td>"+"</tr>";
                        }
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });
        }

        tem += "</tbody></table></div></div>";
        document.getElementById("barm").innerHTML = tem;

        if($.cookie("isBH") === "0" && $.cookie("isYT") === "0"){
            var tem = "";
            tem+="<div class='col-xl-12' align='center'><img src='assets/images/nobar.png' style='width:auto;height: 500px;' /></div><div class='clearfix'></div>";
            document.getElementById("barm").innerHTML = tem;
        }

    }

    function fapplym() {
       // alert($.cookie("isYT"));
        if($.cookie("isYT") === "1") {
            var tem = "<div class=\"col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xl-10\">";
            tem += "<div class=\"card mb-3\" style='padding:5%'><div class=\"card-header\">";
            tem += "<h3><i class=\"fa fa-check-square-o\"></i> 申请直播 </h3></div>";
            tem += "<div class=\"card-body\"><form method=\"post\"><div class=\"form-group\">";
            tem += "<label>直播间标题</label><input data-parsley-equalto=\"#pass1\" type=\"text\" required=\"\" class=\"form-control\" id=\"title\">";
            tem += "</div><div class=\"form-group text-right m-b-6\"><input class=\"btn btn-primary\" type=\"button\" value='申请直播' onclick=\"applyButton()\">";
            tem += "</div></form>";
            tem += "<div><div class=\"card border-info col-sm-12 col-lg-12 col-xl-12\">";
            tem += "<div class=\"card-body text-info\">";
            tem += "<h4 class=\"card-title\">rtmp链接</h4> <p class=\"card-text\" id=\"rtmp\"></p>";
            tem += "</div></div>";
            tem += "<div class=\"card border-info col-sm-12 col-lg-12 col-xl-12\" style='margin-top: 3%'>";
            tem += "<div class=\"card-body text-info\">";
            tem += "<h4 class=\"card-title\">密匙</h4>";
            tem += "<p class=\"card-text\" id=\"secretkey\"></p>";
            tem += "</div></div></div></div>";
            document.getElementById("applym").innerHTML = tem;
        }else{
            var tem = "";
            tem+="<div class='col-xl-12' align='center'><img src='assets/images/nohost.png' style='width:auto;height:500px;' /></div><div class='clearfix'></div>";
            document.getElementById("applym").innerHTML = tem;
        }
    }

    // 任命主持人
    function setbarhost() {
        swal({
            text: '请输入待任命主持人的id',
            content: "input",
            button: {
                text: "确定",
                closeModal: false,
            },
        }).then(applyid=>{
            var data1={
                adminid:applyid,
                token: $.cookie("token")
            };
            $.ajax({
                type: "POST",
                url: "http://ccnubt.club:8080/koalaTV/api/bar/changeadmin",
                dataType: "json",
                data: JSON.stringify(data1),
                contentType: "appication/json",
                success: function(msg) {
                    setCookie(msg.token);
                    if (msg.tag == 1) {
                        swal("修改成功");
                    }else{
                        swal("修改失败");
                    }
                    javascipt:location.reload();
                },error: function(XMLHttpRequest, textStatus, errorThrown) {
                  //  alert(XMLHttpRequest.status);
                  //  alert(XMLHttpRequest.readyState);
                  //  alert(textStatus);
                }
            });

        }).catch(err => {
            if (err) {
                swal("失败", "AJAX请求失败!", "error");
            } else {
                swal.stopLoading();
                swal.close();
            }
        });
    }

    function applyButton(){
        var title = document.getElementById("title").value;
        data1={token:$.cookie("token"),title:title};
        $.ajax({
            type: "POST",
            url: "http://ccnubt.club:8080/koalaTV/api/live/onlive",
            data: JSON.stringify(data1),
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType: "json",
            success: function (msg) {
                setCookie(msg.token);
                if (msg.tag === 1) {
                     var rtmp = document.getElementById("rtmp");
                     var secretkey = document.getElementById("secretkey");
                     rtmp.innerText=msg.rtmp;
                     secretkey.innerText=msg.secretkey;
                } else if(msg.tag === -1){
                    swal({
                        title:"你的直播间被封禁了呢！联系人工客服TEL:15071091360"
                    }).then(
                        function (){
                           swal.close();
                        }
                    );

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        });
    }
</script>

</body>
</html>
