function register(){
	
	var name = document.getElementById("username").value;
	var pwd = document.getElementById("userpwd").value;
	
	$.getJSON('ctrls/users.php', {
        operation: 'register',
        name: 'Nutzername',
        password: 'Passwort'
    },
	function(data) {
		// hier kann die Antwort des Servers verarbeitet werden!
	} ); 
	
}