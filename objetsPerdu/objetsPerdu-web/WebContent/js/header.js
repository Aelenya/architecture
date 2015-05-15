//Fonction pour l'auto-completion dans la barre de recherche

$(document).ready(function() {
	$("#header").load("/home/header.html", function() {
		$("#search").click(function(){
				var typePerdu = $("#type input:radio")[0].checked;
				var typeTrouve = $("#type input:radio")[1].checked;
				var mc = $("#mc").val();
				var date = $("#date").val();
				var dateFields = date.split("/");
				date = dateFields.reverse().join("-");
				var lieu = $("#lieu").val();
				
				if(! ((!typePerdu && typeTrouve) || (typePerdu && !typeTrouve))) //NON XOR
					alert("Selectionnez soit Perdu soit Trouvé");
					
				else if(mc == "")
					alert("Il n'y a pas de mot clef");
		
				
				else if(date == "")
					alert("Il n'y a pas de date");
				
				else if(lieu == "")
					alert("Il n'y a pas de lieu");
				
				else{
					window.location.replace("/home/showPerdu.html#"+mc+"/"+date+"/"+lieu);
				}
		});
	});
	$("#footer").load("/home/footer.html");

	$(window).load(function() {
		$.getJSON("/home/facade/cloud/autocomplete", function(data) {
			var tags = [];
			$.each(data, function(info1, info2) {
				tags.push(info2.value);
			});
			$("#mc").autocomplete({
				source : tags
			});

		});
	});

});