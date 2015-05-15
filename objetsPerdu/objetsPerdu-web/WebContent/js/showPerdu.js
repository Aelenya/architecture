$(function(){
	var hash = window.location.hash;
	
	if(hash == ""){
		remplirTableau("/home/facade/objetPerdu/lastAnnonces");
	}
	
	else{
		hash = hash.replace('#','');
		remplirTableau("/home/facade/facadeRecherche/" + hash);
	}
});

function remplirTableau(url){
	$.getJSON(url, function(data){
		var items = ["<div>"];
		$.each(data, function(num, val){

			items.push("<div class=\"row\"> <div class=\"col-md-2 annonce\">" + val["nom"] + "</div><div class=\"col-md-2 annonce\">"+  
					val["texteAnnonce"] + "</div><div class=\"col-md-2 annonce\">"+  
					val["adresse"] + "</div><div class=\"col-md-2 annonce\">"+  val["dateCreation"] +"</div><div class=\"col-md-2 annonce\">"+
					"<a href=\"/home/user/contact.html#"+val["id"]+"\"+" +
					"<button id=\""+val["id"]+"\"class=\"btn btn-warning\">Contacter</button></div><div class=\"col-md-2 annonce\">"+
					"<a href=\"/home/user/report.html#"+val["id"]+"\"<button id=\""+
					val["id"]+"\"class=\"btn btn-warning\">Signaler</button></a></div></div>");
			//items.push("<dd>" + val["nom"] + "</dd><dd>" + val["texteAnnonce"] + "</dd><dd>" + val["adresse"] +
			//		+ "</dd><dd>" + val["tags"] +"</dd><dd>" + val["dateCreation"] + "</dd>");
		});
		items.push("</div>");
		$("#annonces").append(items.join(""));
	});
}
