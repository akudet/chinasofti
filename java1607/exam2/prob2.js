var validate = function() {
	var form = document.forms[0];
	var username = form.username.value;
	var password = form.userpass.value;
	var confirmpass = form.confirmpass.value;

	if (username.length == 0) {
		alert("�û�������Ϊ��");
	}

	if (password.length == 0) {
		alert("���벻��Ϊ��");
	}

	if (confirmpass.length == 0) {
		alert("��֤���벻��Ϊ��");
	}

};
