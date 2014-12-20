<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="comm.jsp"%>
<html>
<head>
<link type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css" href="${ctx}/css/public.css" rel="stylesheet">
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JOFFER</title>
</head>
</head>
<style type="text/css">

#gotoTop{display:none;position:fixed;top:80%;left:55%;cursor:pointer;margin-top:-50px;margin-left:520px;padding:9px 4px;width:45px;height:45px;background-image:url(../images/gotop1.png); text-align:center;border:1px solid #e0e0e0;}
/*用CSS表达式(expression)来实现ie6下position:fixed效果*/
#gotoTop{_position:absolute;_top:expression(documentElement.scrollTop + documentElement.clientHeight * 3/4 + "px")}
/*鼠标进入的反馈效果*/
#gotoTop.hover{background-image:url(../images/gotop2.png);color:#fff;text-decoration:none;}

.register{width: 500px;height:500px;background-color:#99ccff;text-align: center;padding: 10px;font-size: 18px;}
table tr{height:30px;}
table tr th{text-align: right;}
.input{width: 300px;height: 40px;line-height:40px;margin-top: 10px;color:#999999;font-size: 18px;}
.ss{height: 20px;}
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
	 <form action="${ctx}/worker/save" method="post" name="form1">
		
		<table>
		<tr><th>姓名：</th><td><input class="input" type="text" id="name" name="name"></td></tr>
		
		<tr><th>性别：</th><td>
		<select name="sex" class="input">
		<option value="1">男</option>
		<option value="2">女</option>
		</select>
		</td></tr>
		
		<tr><th>年龄：</th><td><input class="input" type="text" id="age" name="age"></td></tr>
		
		<tr><th>学历：</th><td><select class="input" name="education">
		     <option value="1">初中</option>
		     <option value="1">高中</option>
		     <option value="1">大专</option>
		     <option value="1">本科</option>
		     <option value="1">硕士</option>
		     <option value="1">博士</option>
		   </select>  </td>  
	    </tr>
	     <tr><th> 手机号码：</th><td><input class="input" type="text" name="phone"  ></td></tr>
	     
	     <tr><th>期望薪资</th>
	      <td>
	      <select name="salary" class="input">
	       <option value="1">1000~3000</option>
	       <option value="2">3000~6000</option>
	       <option value="3">6000~10000</option>
	       <option value="4">10000~15000</option>
	       <option value="5">15000~20000</option>
	       <option value="6">20000以上</option>
	      </select>
	      </td>
	     </tr>
	     
	     <tr><th> 目前状态：</th><td>
	     <select name="condition" class="input">
	     <option>目前离职</option>
	     <option>正在考虑新的环境</option>
	     </select>
	     </td></tr>
		</table>
		<div class="clickme" onclick="register()">保存</div>
		</form>
		</div>
	</div>
    ${worker.userID}
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