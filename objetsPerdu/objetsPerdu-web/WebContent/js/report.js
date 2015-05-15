
$(function(){
	var hash = window.location.hash;
	hash = hash.replace('#','');
	$.getJSON("/home/facade/objetPerdu/"+hash,function(data){
		var items = ["<div>"];
		$.each(data,function(num,val){
			items.push(" "+val);
		});
		items.push("</div>");
		$("#recap").append(items.join(""));
	}).error(function(){
		window.location.replace("/home/showPerdu.html");
	});
	
	$("#confirm").click(function(){
		$.ajax({
			type: "POST",
			url: "/home/facade/objetPerdu/report/"+hash,
			dataType: 'json',
			contentType: "application/json; charst=utf-8",
			async: false
		});
	});
});