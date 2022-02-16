<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>注册界面</title>
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
        <h2>新用户注册页面</h2>
      </div>
      <div class="layadmin-user-Login-box layadmin-user-Login-body layui-form" >
      <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-nickname"></label>
          <input type="text" name="name" id="LAY-user-login-name"  placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="密码" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
          <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码" class="layui-input">
      </div>
      </div>
     <!--    <div class="layui-form-item">
          <input type="checkbox" name="agreement" lay-skin="primary" title="同意用户协议" checked>
        </div> -->  
        
        <form action="" class="layui-form"> <!-- 加上form组件，解决三个单选框隐藏的问题 -->
         <div class="layui-input-item">
         	  <label class="layui-form-label">您的身份：</label>
              <input type="radio" name="entity" value="学生" title="学生" checked="" >
              <input type="radio" name="entity" value="教师" title="教师" >
            </div>
        </form>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-nickname"></label>
          <input type="text" name="nickname" id="LAY-user-login-nickname" lay-verify="nickname" placeholder="请输入您的学号或者工号" class="layui-input">
        </div>
        
        <div class="layui-form-item">
          <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-reg-submit" onclick="zhuce()">注 册</button>
        </div>
        <div class="layui-trans layui-form-item layadmin-user-login-other">
     <!--     <label>社交账号注册</label>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>
          -->  
          <a href="#" onClick="delayURL('/g_designv1.0/LoginServlet',2000)" class="layadmin-user-jump-change layadmin-link layui-hide-xs">用已有帐号登入</a>
          <a href="login.html" class="layadmin-user-jump-change layadmin-link layui-hide-sm layui-show-xs-inline-block">登入</a>
        </div>
      </div>
    </div>
    
    <div class="layui-trans layadmin-user-login-footer">
      
      <p>© All Rights Reserved </p>

    </div>

  </div>
<script type="text/javascript">
	function zhuce() {
		//1.获取用户的输入
		var name = $('#LAY-user-login-name').val();
		var password = $('#LAY-user-login-password').val();
		var repass = $('#LAY-user-login-repass').val();
		var id = $('#LAY-user-login-nickname').val();
		var entity = $('input[name="entity"]:checked').val(); //单选框不能直接通过jequery的#使用获取Id的方法获取值
	//	alert("用户名："+name+" 密码:"+password+" Id:"+id+" 身份:"+entity);
		if(password != repass) {
			layer.msg('两次密码不相同，请重新输入！！',{icon: 5});
			//layer.msg('两次输入的密码不同，请重新输入！', {icon: 5});
		}else {
			//出现过其他代码都正确，但还没有写过的else代码少半个“）”影响到注册提交事件。并且IDE没有报错。
			$.ajax({
				type:'post',
				url:'CheckZhuceServlet',
				data:{
					'name':name,
					'password':password,
					'id':id,
					'entity':entity
				},
				datatype:'text',
				success:function(res) {
					if(res=="success") {
						layer.msg('注册成功！',{icon:6});
						setTimeout(function () {
							window.location.href="/g_designv1.0/LoginServlet"; //注册成功1500ms后跳转到登录页面
						},1500)
					}else{
						layer.msg('注册失败！',{icon:5});
					}
				}
			})
		}
	}
</script>
  <script src=".//layui/layui.js"></script>  
   <script>
  layui.use('form', function(){
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功,用于显示layui隐藏的单选框控件如注册时选择身份的控件
	  
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
      alert("即将在"+time/1000+"秒后跳转到登录界面！！");
 }
</script>


</body>
</html>