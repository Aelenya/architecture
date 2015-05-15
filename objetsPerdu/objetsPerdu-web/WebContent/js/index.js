
function fun(data) {
	var items = [ "<tbody>" ];
	$.each(data, function(key, val) {
		items.push("<tr><td>" + val["titre"] + "</td><td>" + val["tags"] + "</td><td>" + val["dateCreation"] + "</td></tr>");
	});
	items.push("</tbody>");
	$("table").append(items.join(""));
};

$(document).ready(function() {
	$.getJSON("/home/facade/lastPosts", fun);
});

//Fonction pour la creation du tag-cloud
$(function(){
	$.getJSON("/home/facade/cloud/autocomplete", function(data){
		var words = [];
		$.each(data, function(info1,info2){
			var word = {};
			word['text'] = info2.value;
			//On met plus d'importance (mot plus gros) aux elements sortis en premier
			word['weight'] = 15-info1;
			//Il faudra mettre ici le lien de la barre de recherche quand ce sera fonctionnel !
			word['link'] = "http://pinfo2.unige.ch:8080/home#"+info2.value;
			words.push(word);
		});
		
		$("#cloud").jQCloud(words, {
			  autoResize: true
		});
	});
	
});

