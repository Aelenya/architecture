$(document).ready(
		function() {
			send = {
					type : "POST",
					// the url where you want to sent the userName and password to
					url : '/home/facade/testBDD',
					dataType : 'json',
					async : false,
					// json object to sent to the authentication url
					data : JSON.stringify({"contenu":"postTest","dateCreation":"2000-01-01T12:00:00Z","latitude":0.0,"longitude":0.0,"tags":"tag","titre":"secondTest","type":"typ"}),
					success : function() {

						alert("Thanks!");
					}
				};
			$.ajax(send);
		});