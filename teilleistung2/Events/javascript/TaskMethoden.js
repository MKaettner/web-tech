function list_users_of_task() {

	var id = document.getElementById("taskID").value;
	
	$.getJSON('ctrls/tasks.php', {
		operation : 'list_users_of_task',
		tid : id
	}, function(data) {
		$("#datatable2").html("");
		$("#datatable2").append("<tr><th>Name</th></tr>");
		$.each(data.tasks, function(key, value) {
			//JSON Objekt in variable
			var name = value.name;
			$("#datatable2").append("<tr><td> " + name + "</td></tr>");
		});
	});
}

function create() {

	var ttitle = document.getElementById("title").value;
	var tvol = document.getElementById("vol").value;

	$.getJSON('ctrls/events.php', {
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
