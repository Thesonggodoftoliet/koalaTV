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

    <!--chat -->
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <script src="assets/js/amazeui.min.js"></script>
    <!-- UM相关资源 -->
    <link href="assets/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="assets/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="assets/umeditor/umeditor.min.js"></script>
    <script type="text/javascript" src="assets/umeditor/lang/zh-cn/zh-cn.js"></script>

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
                        <div class="col-md-1 col-lg-1 col-xl-1">
                            <div id="focusbutton"></div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4">
                            <div class="card-box tilebox-one noradius">
                                <div id='chat'>
                                    <div id="ChatBox" class="am-g am-g-fixed" >
                                        <div class="am-u-lg-12" style="height:400px;border:1px solid #999;overflow-y:scroll;">
                                            <ul id="chatContent" class="am-comments-list am-comments-list-flip">
                                                <li id="msgtmp" class="am-comment" style="display:none;">
                                                    <a href="">
                                                        <img class="am-comment-avatar" src="assets/images/other.jpg" alt=""/>
                                                    </a>
                                                    <div class="am-comment-main" >
                                                        <header class="am-comment-hd">
                                                            <div class="am-comment-meta">
                                                                <a ff="nickname" href="#link-to-user" class="am-comment-author">某人</a>
                                                                <time ff="msgdate" datetime="" title="">2014-7-12 15:30</time>
                                                            </div>
                                                        </header>
                                                        <div ff="content" class="am-comment-bd">此处是消息内容</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- 聊天内容发送区域 -->
                                    <div id="EditBox" class="am-g am-g-fixed">
                                        <!--style给定宽度可以影响编辑器的最终宽度-->
                                        <script type="text/plain" id="myEditor" style="width:100%;height:140px;"></script>
                                        <button id="send" type="button" class="am-btn am-btn-primary am-btn-block">发送</button>
                                    </div>

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

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });

        }
    });
</script>
<script type="text/javascript">

    $(function(){


        //实例化编辑器
        var um = UM.getEditor('myEditor',{
            initialContent:"请输入聊天信息...",
            autoHeightEnabled:false,
            toolbar:[
                'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
                'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
                '| justifyleft justifycenter justifyright justifyjustify |',
                'link unlink | emotion image video  | map'
            ]
        });


        var nickname = "风清扬"+Math.random();
        var socket = new WebSocket("ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket/"+1);
        //接收服务器的消息
        socket.onmessage=function(ev){
            var obj = eval(   '('+ev.data+')'   );
            addMessage(obj);
        }

        $("#send").click(function(){
            if (!um.hasContents()) {  // 判断消息输入框是否为空
                // 消息输入框获取焦点
                um.focus();
                // 添加抖动效果
                $('.edui-container').addClass('am-animation-shake');
                setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
            } else {
                //获取输入框的内容
                var txt = um.getContent();
                //构建一个标准格式的JSON对象
                var obj = JSON.stringify({
                    nickname:nickname,
                    content:txt
                });
                // 发送消息
                socket.send(obj);
                // 清空消息输入框
                um.setContent('');
                // 消息输入框获取焦点
                um.focus();
            }

        });





    });

    //人名nickname，时间date，是否自己isSelf，内容content
    function addMessage(msg){

        var box = $("#msgtmp").clone(); 	//复制一份模板，取名为box
        box.show();							//设置box状态为显示
        box.appendTo("#chatContent");		//把box追加到聊天面板中
        box.find('[ff="nickname"]').html(msg.nickname); //在box中设置昵称
        box.find('[ff="msgdate"]').html(msg.date); 		//在box中设置时间
        box.find('[ff="content"]').html(msg.content); 	//在box中设置内容
        box.addClass(msg.isSelf? 'am-comment-flip':'');	//右侧显示
        box.addClass(msg.isSelf? 'am-comment-warning':'am-comment-success');//颜色
        box.css((msg.isSelf? 'margin-left':'margin-right'),"20%");//外边距

        $("#ChatBox div:eq(0)").scrollTop(999999); 	//滚动条移动至最底部

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
