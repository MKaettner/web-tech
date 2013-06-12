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
		alert(JSON.stringify(data));
	});
}
