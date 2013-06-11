function register(){
	
	$.getJSON('ctrls/users.php', {
        operation: 'register',
        name: 'Nutzername',
        password: 'Passwort'
    },
	function(data) {
		// hier kann die Antwort des Servers verarbeitet werden!
		
	} );
} 