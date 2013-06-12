function register(){
	
	var username = document.getElementById("username").value;
	var userpassword = document.getElementById("userpwd").value;
	
	$.getJSON("ctrls/users.php", {
        operation: "register",
        name: username,
        password: userpassword
    },
	function(data) {
		// hier kann die Antwort des Servers verarbeitet werden!
		alert(JSON.stringify(data));
	} ); 
	
}