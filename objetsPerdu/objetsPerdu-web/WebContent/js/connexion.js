/*Cette fonction est OBLIGATOIRE pour le passage par hash du numero d'annonce que
l'utilisateur cherche a report. Par defaut, si l'utilisateur n'est pas connecte et qu'il
passe donc par le formulaire d'inscription, celui-ci 'purge' l'url des elements
en plus (le hash donc). Cette fonction permet donc de forcer le submit a conserver le hash
meme en passant par la connexion
*/
$(function(){
	$("#co").on('submit',function(event){
		event.preventDefault();
		var hash = window.location.hash;
		this.action = this.action+hash;
		this.submit();
	});
});