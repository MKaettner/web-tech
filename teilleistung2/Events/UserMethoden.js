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
		//leert die Tabelle
		$("#datatable").html("");
		//fuegt den tableheader ein
		$("#datatable").append(
				"<tr> <th>Event ID</th> <th>Titel</th> <th>Beschreibung</th> <th>Datum</th> </tr>"
		);
		
		$.each(data.events, function(key, value){
			// auslesen der JSON Objekte in Variablen
			var id = value.eid;
			var title = value.title;
			var desc = value.description;
			var date = value.date;
			
		});
	});
}

function list_tasks_of_user(){
	$.getJSON("ctrls/users.php", {
		operation: "list_tasks_of_user"
	},
	function(data) {
		$.each(data.tasks, function(key, value){
			// auslesen der JSON Objekte in Variablen
			var id = value.eid;
			var event = value.event;
			var task = value.task;
			var due = value.due;
			
		});
	});
}
















