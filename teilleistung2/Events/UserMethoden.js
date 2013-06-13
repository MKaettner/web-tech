function register(){
	
	var username = document.getElementById("username").value;
	var userpassword = document.getElementById("userpwd").value;
	
	$.getJSON("ctrls/users.php", {
        operation: "register",
        name: username,
        password: userpassword
    },
	function(data) {
		$("#message").html(""); //leert message 
		$("#message").append(data.msg); 
	} ); 
}

function login(){
	
	var username = document.getElementById("username").value;
	var userpassword = document.getElementById("userpwd").value;
	
	$.getJSON("ctrls/users.php", {
		operation: "login",
        name: username,
        password: userpassword		
	},
	function(data) {
		if(data.error=="false"){
			alert("Login successfull!");
			window.location.href="user.html";
		}
		else{
			alert("Username or Password invalid!");
		}
	});
}

function logout(){
		$.getJSON("ctrls/users.php", {
        operation: "logout"
    },
	function(data) {
		alert(data.msg);
		window.location.href="index.html";
	});
}

function list_events_of_user(){
	
	$.getJSON("ctrls/users.php", {
        operation: "list_events_of_user"
    },
	function(data) {
		//$.each(data.events, function(){
		//});
		alert(data.msg);
	});
	
}

function list_tasks_of_user(){
	$.getJSON("ctrls/users.php", {
		operation: "list_tasks_of_user"
	},
	function(data) {
		alert(data.msg);
	});
}
















