<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <script type="text/javascript">
  	function reg(){
  		var name = document.getElementById('name').value;
  		var pass = document.getElementById('pass').value;
  		
  		if (name.length==0) {
			alert("账号不能为空");
			return false;
		}else if (pass.length==0){
			alert("密码不能为空");
			return false;
			}else{
				form.submit();
			}
  	}
  	
  	function changpass(){
  		var pass1 = document.getElementById('pass').value;
  		var pass2 = document.getElementById('pass1').value;
  		
  		if(pass1===pass2){
  			document.getElementById('sp').innerHTML = "输入一致";
  		}else{
  			document.getElementById('sp').innerHTML = "输入不一致";
  		}
  	}
  
  	
  	

  </script>
  
  <body>
  	${requestScope.list}
    <form action="/TP4/admin/user/" method="post" onsubmit="reg()" align="center" >
    	姓&nbsp;&nbsp;名:<input type="text" name="username" id="name" onblur="regavalidate()"><span id="sp"></span><br>
    	密&nbsp;&nbsp;码:<input type="password" name="userpass" id="pass" ><span id="sp"></span><br>
    	确认密码:<input type="password" name="userpass" id="pass1" onblur="changpass()"><br>
    	特&nbsp;&nbsp;权:<input type="text" name="privilege"><br>
    	<input type="submit" value="添加"><br>
    
    </form>
  </body>
</html>
