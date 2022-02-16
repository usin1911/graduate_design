<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>学生心理健康管理系统登录界面</title>
    <script src=".//layui/layui.js"></script>  
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script> <!-- 引入jquery方便login函数使用$符号 -->
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href=".//layui/css/layui.css" media="all">
  <link rel="stylesheet" href=".//style/admin.css" media="all">
  <link rel="stylesheet" href=".//style/login.css" media="all">
</head>
<body>

  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>大学生心理健康管理系统</h2>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
          <input type="text" name="username" id="name" lay-verify="required" placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="password" lay-verify="required" placeholder="密码" class="layui-input">
        </div>
        <form action="" class="layui-form"> <!-- 加上form组件，解决三个单选框隐藏的问题 -->
         <div class="layui-input-item">
         	  <label class="layui-form-label">您的身份：</label>
              <input type="radio" name="entity" value="管理员" title="管理员" checked="">
              <input type="radio" name="entity" value="学生" title="学生" >
              <input type="radio" name="entity" value="教师" title="教师" >
            </div>
        </form>
        </div>
         <form action="" class="layui-form">
        <div class="layui-form-item" style="margin-bottom: 20px;">
    <!--      <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">  
          <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
  -->        </div>
        </form>
        <div class="layui-form-item">
          <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit" id="login" onclick="login()">登 录</button>
        </div>
        <div class="layui-trans layui-form-item layadmin-user-login-other">
      <!--      <label>社交账号登入</label>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>
          -->
          <a href="#" onClick="delayURL('registerServlet',2000)" class="l
          
          ayadmin-user-jump-change layadmin-link">注册帐号</a>
        </div>
      </div>
    </div>
    
    <div class="layui-trans layadmin-user-login-footer">
      
      <p>© All Rights Reserved</p>

    </div>
    
    <!--<div class="ladmin-user-login-theme">
      <script type="text/html" template>
        <ul>
          <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
          <li data-theme="#03152A" style="background-color: #03152A;"></li>
          <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
          <li data-theme="#50314F" style="background-color: #50314F;"></li>
          <li data-theme="#344058" style="background-color: #344058;"></li>
          <li data-theme="#20222A" style="background-color: #20222A;"></li>
        </ul>
      </script>
    </div>-->
    
  </div>
  <script type="text/javascript">
  //jquery语法取值
  	function login() {
  		var name=$('#name').val(); //val取消
  		var password=$('#password').val(); //要记得加#，否则获取不到值
  		var entity=$('input[name="entity"]:checked').val();
  	//	alert("当前账号: "+name+" 当前账号密码:"+password+" 身份:"+entity); 
  	$.ajax({
  		type:'post', //两种方式get和post
  		url:'/g_designv1.0/CheckLoginServlet1', //通讯地址
  		data:{'name':name,'password':password,'entity':entity}, //发送用户输入的数据到服务器
  		dataType:"text", //传回来的数据类型 text json 
  		success:function(res) {
  			if(res=="success") {
  				if(entity=="管理员") {
  				alert("登陆成功！即将跳转到管理员主页！");
  				window.location.href="/g_designv1.0/ViewMainFormServlet";
  				}else if(entity=="学生") {
  				 	alert("登陆成功！即将跳转到学生主页！");
  	  				window.location.href="/g_designv1.0/ViewStudentFormServlet";
  				}else if(entity=="教师") {
  				 	alert("登陆成功！即将跳转到教师主页！");
  	  				window.location.href="/g_designv1.0/ViewTeacherFormServlet";
  				}
  			}else {
  				alert("登录失败！");
  			}
  		}
  	});
  	}
  </script>
  <script>
  layui.use('form', function(){
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  
	  //……
	  
	  //如果你的 HTML 是动态生成的，自动渲染就会失效
	  //因此你需要在相应的地方，执行下述方法来进行渲染
	  form.render();
	});      //结合三个身份选择的form组件，解决单选框隐藏的问题
  </script>
  
   <!-- 设置点击指定按钮后延迟跳转的时间delayURL函数 --> 
 <script type="text/javascript">
      function delayURL(url,time){
      setTimeout("top.location.href = '" + url + "'",time);
      alert("即将在"+time/1000+"秒后跳转到注册界面！！");
 }
</script>
  
</body>
</html>