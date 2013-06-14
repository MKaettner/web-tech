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