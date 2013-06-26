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
		if(data.error=="true"){
			alert("Username or Password invalid!");
		}
		else{
			alert("Login successfull!");
			window.location.href="user.html";
		} 
	} ); 
	
}

function logout(){
		$.getJSON("ctrls/users.php", {
        operation: "logout"
    },
	function(data) {
		alert(data.msg);
		if(error = "false")
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
		if(data.error=="false"){
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
				// tabellenzeile hinzufügen
				$("#datatable").append(
					"<tr> <td> " + id + "</td> <td> " + title + "</td> <td> " + desc + "</td> <td> " + date + "</td>"
				);
			});
		}
		else{
				alert(data.msg);
			}
	});
}

function list_tasks_of_user(){
	$.getJSON("ctrls/users.php", {
		operation: "list_tasks_of_user"
	},
	function(data) {
		//leert die Tabelle
		$("#datatable").html("");
		if(data.error=="false"){
			//fuegt den tableheader ein
			$("#datatable").append(
					"<tr> <th>Event ID</th> <th>Titel</th> <th>Aufgabe</th> <th>Stichtag</th> </tr>"
			);
			$.each(data.tasks, function(key, value){
				// auslesen der JSON Objekte in Variablen
				var id = value.eid;
				var event = value.event;
				var task = value.task;
				var due = value.due;
				// tabellenzeile einfügen
				$("#datatable").append(
					"<tr> <td> " + id + "</td> <td> " + event + "</td> <td> " + task + "</td> <td> " + due + "</td>"
				);
			});
		}
		else{
			alert(data.msg);
		}
	});
}
















