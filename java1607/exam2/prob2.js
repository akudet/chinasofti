var validate = function() {
	var form = document.forms[0];
	var username = form.username.value;
	var password = form.userpass.value;
	var confirmpass = form.confirmpass.value;

	if (username.length == 0) {
		alert("用户名不能为空");
	}

	if (password.length == 0) {
		alert("密码不能为空");
	}

	if (confirmpass.length == 0) {
		alert("验证密码不能为空");
	}

};
