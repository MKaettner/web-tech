function list_events() {
	$.getJSON('ctrls/events.php', {
		operation : 'list_events'
	}, function(data) {
		//leert die Tabelle
		$("#datatable").html("");
		if (data.error == "false") {
			//fuegt den tableheader ein
			$("#datatable").append("<tr> <th>Event ID</th> <th>Titel</th> <th>Beschreibung</th> <th>Datum</th> </tr>");

			$.each(data.events, function(key, value) {

				// auslesen der JSON Objekte in Variablen
				var id = value.eid;
				var title = value.title;
				var desc = value.description;
				var date = value.date;
				// tabellenzeile hinzufügen
				$("#datatable").append("<tr> <td> " + id + "</td> <td> " + title + "</td> <td> " + desc + "</td> <td> " + date + "</td>");
			});
		} else {
			alert(data.msg);
		}
	});
}

function list_users_of_event() {

	var id = document.getElementById("eventID").value
	//if() wenn keine zahl übergeben??!!
	$.getJSON('ctrls/events.php', {
		operation : 'list_users_of_event',
		eid : id
	}, function(data) {
		$("#datatable2").html("");
		if (data.error == "false") {
			$("#datatable2").append("<tr><th>Name</th></tr>");
			$.each(data.users, function(key, value) {
				//JSON Objekt in variable
				var name = value.name;
				$("#datatable2").append("<tr><td> " + name + "</td></tr>");
			});
		}
		else{
			alert(data.msg);
		}
	});
}

function list_tasks_of_event() {

	var id = document.getElementById("eventID").value
	$.getJSON('ctrls/events.php', {
		operation : 'list_tasks_of_event',
		eid : id
	}, function(data) {
		$("#datatable2").html("");
		if (data.error == "false") {

			$("#datatable2").append("<tr><th>ID</th><th>Titel</th><th>Max. Teilnehmer</th></tr>");
			$.each(data.tasks, function(key, value) {
				//JSON Objekt in variable
				var id = value.tid;
				var titel = value.title;
				var volume = value.volume;
				$("#datatable2").append("<tr><td> " + id + "</td><td>" + titel + "</td><td>" + volume + "</td></tr>");
			});
		} else {
			alert(data.msg);
		}
	});
}

function create() {

	var etitle = document.getElementById("title").value;
	var edesc = document.getElementById("desc").value;
	var edate = document.getElementById("date").value;

	$.getJSON('ctrls/events.php', {
		operation : 'create',
		title : etitle,
		description : edesc,
		date : edate
	}, function(data) {
		alert(data.msg);
	});
}

function join() {
	var id = document.getElementById("eventID").value;
	$.getJSON('ctrls/events.php', {
		operation : 'join',
		eid : id
	}, function(data) {
		alert(data.msg);
	});
}
