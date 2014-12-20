<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="comm.jsp"%>
<html>
<head>
<link type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="${ctx}/css/public.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
</head>
<style type="text/css">

#gotoTop{display:none;position:fixed;top:80%;left:55%;cursor:pointer;margin-top:-50px;margin-left:520px;padding:9px 4px;width:45px;height:45px;background-image:url(../images/gotop1.png); text-align:center;border:1px solid #e0e0e0;}
/*用CSS表达式(expression)来实现ie6下position:fixed效果*/
#gotoTop{_position:absolute;_top:expression(documentElement.scrollTop + documentElement.clientHeight * 3/4 + "px")}
/*鼠标进入的反馈效果*/
#gotoTop.hover{background-image:url(../images/gotop2.png);color:#fff;text-decoration:none;}

.register{width: 500px;height:300px;background-color:#99ccff;line-height: 300px;text-align: center;padding: 10px;}
.input{width: 300px;height: 40px;line-height:40px;margin-top: 10px;color:#999999;font-size: 18px;}
.check{width:300px;margin-top: 10px;height: 40px;line-height: 40px;font-size: 15px;}
.clickme{margin-left:100px;margin-top:10px;width:120px;height: 40px;line-height:40px;background-color:#0099cc;cursor: pointer;text-align: center;color: #fff;font-size: 20px}
.clickme:hover{background-color:#0077dd;text-decoration:none;transition:background-color 0.3s linear;}
</style>
<body>
	<div id="menu">
		<ul>
			<li><a href="${ctx}/index">首页</a></li>
			<li><a href="#">公司</a></li>
			<li><a href="#">论坛</a></li>
			<li><a href="#">我的简历</a></li>
			<li><a href="#">发布职位</a></li>
		</ul>
		
		
		<div class="login"><a href="#">注册</a>|<a href="#">登录</a></div>
	</div>

	<div id="content-warp">
	
	
	 <div class="register">
	 <form action="${ctx}/users/save" method="post" name="form1">
		<input class="input" type="text" id="userID" name="userID"  value="请输入常用的邮箱" onfocus="if(value=='请输入常用的邮箱') {value='';}this.style.color='#000';" onblur="if (value=='') {value='请输入常用的邮箱';this.style.color='#999';}">      
	    <input class="input" type="text" name="password"  value="请输入密码"  onfocus="if(value=='请输入密码') {value='';}$(this).attr('type','password');this.style.color='#000';" onblur="if (value=='') {value='请输入密码';this.style.color='#999';$(this).attr('type','text'); }">
		<div class="check"><input  type="checkbox">我已同意协议。</div>
		<div class="clickme" onclick="register()">注册</div>
		</form>
		</div>
	</div>
    
    <span id="page"></span>
    
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div id="bottom"></div>

</body>
<script type="text/javascript">

function register(){
	document.form1.submit();
}

function gotoTop(min_height){
    //预定义返回顶部的html代码，它的css样式默认为不显示
    var gotoTop_html = '<div id="gotoTop"></div>';
    
    //将返回顶部的html代码插入页面上id为page的元素的末尾 
    $("#page").append(gotoTop_html);
    
    
    
  //获取页面的最小高度，无传入值则默认为600像素
    min_height ? min_height = min_height : min_height = 600;
    //为窗口的scroll事件绑定处理函数
    $(window).scroll(function(){
        //获取窗口的滚动条的垂直位置
        var s = $(window).scrollTop();
        //当窗口的滚动条的垂直位置大于页面的最小高度时，让返回顶部元素渐现，否则渐隐
        if( s > min_height){
            $("#gotoTop").fadeIn(100);
        }else{
            $("#gotoTop").fadeOut(200);
        };
    });
    
    $("#gotoTop").click(//定义返回顶部点击向上滚动的动画
        function(){$('html,body').animate({scrollTop:0},500);
    }).hover(//为返回顶部增加鼠标进入的反馈效果，用添加删除css类实现
        function(){$(this).addClass("hover");},
        function(){$(this).removeClass("hover");
    });
    
};
gotoTop(50);

</script>
</html>