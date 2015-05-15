$(function(){
	$("#uniqueMail span").hide();
})

$(function(){
	$("#button").click(function(event) {
		event.preventDefault();
		$.ajax({
			type: "POST",
			url: '/home/facade/inscription',
			dataType: 'json',
			contentType: "application/json; charst=utf-8",
			async: false,
			data: '{"email": "'+$("#email").val()+'" , "pseudo": "'+$("#pseudo").val()+'" , "password": "'+$("#password").val()+
			'" , "response" : "'+grecaptcha.getResponse()+' " , "confirmMail" : "'+$("#confirmMail").val()+
			'" , "confirmPassword" : "'+$("#confirmation").val()+' "}',
			success: function(info1, info2, info3){
				location.reload();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				$("#msgError span").show();
				$("#msgError span").text(xhr.responseText);
				grecaptcha.reset();
		      }
		});
	});
});