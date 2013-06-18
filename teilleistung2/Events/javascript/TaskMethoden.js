function list_users_of_task() {

	var id = document.getElementById("taskID").value
	$.getJSON('ctrls/tasks.php', {
		operation : 'list_users_of_task',
		eid : id
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

function assign() {
	
}
