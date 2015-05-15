//remplis le menu deroulant expediteur
//!!! attention, va chercher dans facadeMessagerie et pas facadeCreationSessionMessage !!!
$.getJSON("/home/facade/facadeMessagerie/User", function(data) {
	$.each(data, function(info1, info2) {
		$("#MenuExpediteur").append("<option value="+info2["pseudo"]+">"+info2["pseudo"]+"</option>");
		$("#MenuDestinataire").append("<option value="+info2["pseudo"]+">"+info2["pseudo"]+"</option>");
	});
});
     
//rempli le menu deroulant de la liste des annonces
$.getJSON("/home/facade/facadeCreationSessionMessage/Annonce", function(data) {
	$.each(data, function(info1, info2) {
		$("#MenuAnnonce").append("<option value="+info2["id"]+">"+info2["titre"]+"</option>");
	});
});

//on envoye le message
$("p").click(function() {
	$.ajax({
		type: "POST",
    	url: '/home/facade/facadeCreationSessionMessage',
    	dataType: 'json',
    	contentType: "application/json; charset=utf-8",
    	async: false,
    	data: '{"texte": "'+$("#message").val()+'", "destinataire" : "'+$("#MenuDestinataire").val()+'", "expediteur":"'+$("#MenuExpediteur").val()+ '", "idAnnonce":"'+$("#MenuAnnonce").val()+'"}',
    	success: function () {
    		//location.reload();
    		alert("ok");
    	}
	});
});