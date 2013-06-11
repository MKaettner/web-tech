function register(){
	var name = document.getElementsByName('name').value;
	var pw = document.getElementsByName('password').value;
	//window.alert(name);
	window.alert(pw);
	
	$.getJSON('ctrls/users.php', {
        operation: 'register',
        name: 'Nutzername',
        password: 'Passwort'
    },
	function(data) {
		// hier kann die Antwort des Servers verarbeitet werden!
	} );
	
}