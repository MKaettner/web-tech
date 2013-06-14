function list_events(){
	$.getJSON('ctrls/events.php', {
        operation: 'list_events'
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
			// tabellenzeile hinzufügen
			$("#datatable").append(
				"<tr> <td> " + id + "</td> <td> " + title + "</td> <td> " + desc + "</td> <td> " + date + "</td>"
			);
		});
	});
}

function list_users_of_event(){
	
	var id = document.getElementById("eventID").value
	$.getJSON('ctrls/events.php', {
        operation: 'list_users_of_event',
        eid: id
    },
	function(data) {
		$("#datatable2").html("");
		$("#datatable2").append("<tr><th>Name</th></tr>");
		$.each(data.events, function(key, value){
			//JSON Objekt in variable
			var name = value.name;
			$("#datatable2").append("<tr><td> " + name + "</td></tr>");
		});
	});
}

function list_tasks_of_event(){
	
	var id = document.getElementById("eventID").value
	$.getJSON('ctrls/events.php', {
        operation: 'list_tasks_of_event',
        eid: id
    },
	function(data) {
		$("#datatable2").html("");
		$("#datatable2").append("<tr><th>ID</th><th>Titel</th><th>Umfang</th></tr>");
		$.each(data.events, function(key, value){
			//JSON Objekt in variable
			var id = value.tid;
			var titel = value.titel;
			var volume = value.volume;
			$("#datatable2").append(
				"<tr><td> " + id + "</td><td>"+ titel + "</td><td>" + volume +"</td></tr>"
			);
		});
	});
}

function create(){
	
	var etitle = document.getElementById("title").value; 
	var edesc = document.getElementById("desc").value;
	var edate = document.getElementById("date").value;
	
	$.getJSON('ctrls/events.php', {
        operation: 'create',
        title: etitle,
        description: edesc,
        date: edate
    },
	function(data) {
		alert(data.msg);
	});
}

function join(){
	alert("not yet implemented");
}
