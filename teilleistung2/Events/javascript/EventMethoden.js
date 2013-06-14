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
	
	var eid = document.getElementById("eventID").value
	$.getJSON('ctrls/events.php', {
        operation: 'list_users_of_event',
        eid: eid
    },
	function(data) {
		$("#datatable2").html("");
		$("#datatable2").append("<th>Name</th>");
		$.each(data.events, function(key, value){
			//JSON Objekt in variable
			var name = value.name;
			$("#datatable2").append("<tr><td> " + name + "</td></tr>");
		});
	});
}