<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<LINK href="images/favicon.ico" type="image/x-icon" rel=icon>
<LINK href="images/favicon.ico" type="image/x-icon" rel="shortcut icon">
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/scripts/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 ${msg}sssssssss
 
 <table class="table">
   <caption>上下文表格布局</caption>
   <thead>
      <tr>
         <th>产品</th>
         <th>付款日期</th>
         <th>状态</th>
      </tr>
   </thead>
   <tbody>
      <tr class="active">
         <td>产品1</td>
         <td>23/11/2013</td>
         <td>待发货</td>
      </tr>
      <tr class="success">
         <td>产品2</td>
         <td>10/11/2013</td>
         <td>发货中</td>
      </tr>
      <tr  class="warning">
         <td>产品3</td>
         <td>20/10/2013</td>
         <td>待确认</td>
      </tr>
      <tr  class="danger">
         <td>产品4</td>
         <td>20/10/2013</td>
         <td>已退货</td>
      </tr>
   </tbody>
</table>

<table class="table table-hover">
   <caption>悬停表格布局</caption>
   <thead>
      <tr>
         <th>名称</th>
         <th>城市</th>
         <th>密码</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>Tanmay</td>
         <td>Bangalore</td>
         <td>560001</td>
      </tr>
      <tr>
         <td>Sachin</td>
         <td>Mumbai</td>
         <td>400003</td>
      </tr>
      <tr>
         <td>Uma</td>
         <td>Pune</td>
         <td>411027</td>
      </tr>
   </tbody>
</table>


<table class="table table-bordered">
   <caption>边框表格布局</caption>
   <thead>
      <tr>
         <th>名称</th>
         <th>城市</th>
         <th>密码</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>Tanmay</td>
         <td>Bangalore</td>
         <td>560001</td>
      </tr>
      <tr>
         <td>Sachin</td>
         <td>Mumbai</td>
         <td>400003</td>
      </tr>
      <tr>
         <td>Uma</td>
         <td>Pune</td>
         <td>411027</td>
      </tr>
   </tbody>
</table>


<button type="button" class="btn btn-default">默认按钮</button>

<!-- 提供额外的视觉效果，标识一组按钮中的原始动作 -->
<button type="button" class="btn btn-primary">原始按钮</button>

<!-- 表示一个成功的或积极的动作 -->
<button type="button" class="btn btn-success">成功按钮</button>

<!-- 信息警告消息的上下文按钮 -->
<button type="button" class="btn btn-info">信息按钮</button>

<!-- 表示应谨慎采取的动作 -->
<button type="button" class="btn btn-warning">警告按钮</button>

<!-- 表示一个危险的或潜在的负面动作 -->
<button type="button" class="btn btn-danger">危险按钮</button>

<!-- 并不强调是一个按钮，看起来像一个链接，但同时保持按钮的行为 -->
<button type="button" class="btn btn-link">链接按钮</button>


<img src="/images/test1.jpg" 
   class="img-rounded" style="width: 200px;height: 200px">
<img src="/images/test1.jpg" 
   class="img-circle" style="width: 200px;height: 200px">
<img src="/images/test1.jpg" 
   class="img-thumbnail" style="width: 200px;height: 200px">
   
   <button type="button" class="btn btn-primary btn-lg">
  <span class="glyphicon glyphicon-user"></span> User
</button>




<form role="form">
   <div class="form-group">
      <label for="name">名称</label>
      <input type="text" class="form-control" id="name" 
         placeholder="请输入名称" style="width: 400px">
   </div>
   <div class="form-group">
      <label for="inputfile">文件输入</label>
      <input type="file" id="inputfile">
      <p class="help-block">这里是块级帮助文本的实例。</p>
   </div>
   <div class="checkbox">
      <label>
      <input type="checkbox"> 请打勾
      </label>
   </div>
   <button type="submit" class="btn btn-default">提交</button>
</form>



<span class="label label-default">默认标签</span>
<span class="label label-primary">主要标签</span>
<span class="label label-success">成功标签</span>
<span class="label label-info">信息标签</span>
<span class="label label-warning">警告标签</span>
<span class="label label-danger">危险标签</span>

<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>