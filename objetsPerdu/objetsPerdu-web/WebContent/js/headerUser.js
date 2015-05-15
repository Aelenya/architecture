//Fonction pour l'auto-completion dans la barre de recherche
$(function(){
	
	$("#header").load("/home/user/headerUser.html");
	$("#footer").load("/home/footer.html");
	$(window).load(function(){
		$.getJSON("/home/facade/cloud/autocomplete",function(data){
			var tags = [];
			$.each(data, function(info1, info2){
				tags.push(info2.value);
			});
			$("#mc").autocomplete({source: tags});
			
		});
	});
});