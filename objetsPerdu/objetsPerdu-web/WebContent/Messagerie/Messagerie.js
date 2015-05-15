

//remplis le menu deroulant expediteur
//$.getJSON("/home/facade/facadeMessagerie/User", function(data) {
	//$.each(data, function(info1, info2) {
		//$("#MenuUtilisateur").append("<option value="+info2["pseudo"]+">"+info2["pseudo"]+"</option>");
	//});
//});
//Quand on choisi un utilisateur=> met a jour la listebox avec la liste des messages concernant l'utilisateur choisit
//$("#choisir").click(function() {
$.getJSON("/home/facade/facadeMessagerie/getToutesLesSessionsDuUser", function(data){
	//$("#tableauSessionParticuliere").empty();
	//$("#Sessions").empty();
	$("#Sessions").attr('size', 1);
	//$.getJSON("/home/facade/facadeMessagerie/"+ $("#MenuUtilisateur").val() , function(data) {
		var taille=1;
		$.each(data, function(info1, info2) {
			$("#Sessions").append("<option value="+info2["idSession"]+"> Message de:"+ info2["expediteur"]+" a: "+info2["destinataire"]+" Titre: "+info2["annonce"]+"</option");
			taille=taille+1;
		});
		$("#Sessions").attr('size', taille);
	//});
});
//quand clique sur une session en listbox
$('body').on('click','#Sessions', function(clique) {
	//recupere tous les message de la session correspondante=> envoie l'id de la session
	var reponse =$.ajax({
		type: "POST",
    	url: '/home/facade/facadeMessagerie/getMessagesSession',
    	dataType: 'json',
    	contentType: "application/json; charset=utf-8",
    	async: false,
    	data: '{ "idSession": '+$("#Sessions").val()+'}',
	});
	//la reponse recu une fois le post effectue=> une liste de tous les messages de la session
	$("#tableauSessionParticuliere").empty();
	$.each(reponse.responseJSON, function(index, contenu){
		$("#tableauSessionParticuliere").append("<tr><td>"+contenu["date"]+"</td><td>"+contenu["texte"]+"</td></tr>");
	});
});
//ajouter un nouveau message a la session deja existante
$('body').on('click',"#ValidationTextArea", function(clique) {
	$.ajax({
		type: "POST",
    	url: '/home/facade/facadeMessagerie/ajoutMessageSession',
    	dataType: 'json',
    	contentType: "application/json; charset=utf-8",
    	async: false,
    	data: '{ "idSession": '+$("#Sessions").val()+', "texte" : "'+$("#texteArea").val()+'" }',
    	success: function () {
    		location.reload();
    		//il faudrait recharger que la session de message ...
    	}
	});
});
