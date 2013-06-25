function list_users_of_task() {

	var id = document.getElementById("taskID1").value;
	
	$.getJSON('ctrls/tasks.php', {
		operation : 'list_users_of_task',
		tid : id
	}, function(data) {
		$("#datatable").html("");
		$("#datatable").append("<tr><th>Name</th></tr>");
		$.each(data.users, function(key, value) {
			//JSON Objekt in variable
			var name = value.name;
			$("#datatable").append("<tr><td> " + name + "</td></tr>");
		});
	});
}

function create() {

	var ttitle = document.getElementById("ttitle").value;
	var tvol = document.getElementById("tvol").value;
	var id = document.getElementById("eventID").value;

	$.getJSON('ctrls/tasks.php', {
		operation : 'create',
		title : ttitle,
		volume : tvol,
		eid: id
	}, function(data) {
		alert(data.msg);
	});
}

function assign() {
	var id = document.getElementById("taskID").value;
	$.getJSON('ctrls/tasks.php', {
		operation : 'assign',
		tid : id
	}, function(data) {
		alert(data.msg);
	});
}
