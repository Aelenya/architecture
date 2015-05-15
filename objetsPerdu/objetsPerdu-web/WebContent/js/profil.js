/**
 * 
 */
$(function() {
	$("#SubmitModifierMotDePasse").click(
			function() {
				event.preventDefault();
				alert("Mewtwo");
				$.ajax({
					type : "PUT",
					url : '/home/facade/profil/profilModifPassword',
					dataType : 'json',
					contentType : "application/json; charst=utf-8",
					async : false,
					data : '{"pseudo": "' + $("#pseudoPassword").val()
							+ '", "password": "' + $("#passwod").val() + '" }',
					success : function() {
						location.reload();
					},
					failure : function() {
						alert("fail !");
					}
				});
			});
});

$(function() {
	$("#SubmitModifierAdresse").click(
			function() {
				event.preventDefault();
				alert("Mewthree");
				$.ajax({
					type : "PUT",
					url : '/home/facade/profil/profilModifMail',
					dataType : 'json',
					contentType : "application/json; charst=utf-8",
					async : false,
					data : '{"pseudo": "'
						+ $("#pseudoEmail").val() + '","email": "' + $("#email").val() + '" }',
					success : function() {
						location.reload();
					},
					failure : function() {
						alert("fail !");
					}
				});
			});
});

$(function() {
	$("#SubmitSupprimerCompte").click(function() {
		event.preventDefault();
		alert("Mew");
		alert('{"pseudo": "' + $("#pseudoCompte").val() + '"  }');
		$.ajax({
			//type : "DELETE",
			type:"PUT",
			url : '/home/facade/profil/deleteProfil',
			dataType : 'json',
			contentType : "application/json; charst=utf-8",
			async : false,
			data : '{"pseudo": "' + $("#pseudoCompte").val() + '"  }',
			success : function() {
				location.reload();
			},
			failure : function() {
				alert("fail !");
			}
		});
	});
});

$(function() {
	$("#ModifierAdresse").click(
			function() {
				event.preventDefault();
				$("#SubmitModifierAdresse").toggle();
				$("#pseudoEmail").toggle();
				$("#email").toggle();
			});
});

$(function() {
	$("#ModifierMotDePasse").click(
			function() {
				event.preventDefault();
				$("#SubmitModifierMotDePasse").toggle();
				$("#pseudoPassword").toggle();
				$("#password").toggle();
			});
});

$(function() {
	$("#SupprimerCompte").click(
			function() {
				event.preventDefault();
				$("#SubmitSupprimerCompte").toggle();
				$("#pseudoCompte").toggle();
			});
});

$(function() {
	$("#SubmitModifierAdresse").hide();
	$("#pseudoEmail").hide();
	$("#email").hide();
	$("#SubmitModifierMotDePasse").hide();
	$("#pseudoPassword").hide();
	$("#password").hide();
	$("#SubmitSupprimerCompte").hide();
	$("#pseudoCompte").hide();
});
