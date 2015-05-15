
//document.body.setAttribute("onhashchange", "update()");
var lastHash = "#home";
function update(){

	//ancre = document.getElementById("ancre");
	myHash = location.hash.substr(1);
	//ancre.innerHTML = myHash;
	//ancre.className = (myHash ? "ok" : "ko");
	var value = "#"+myHash;
		
	//$(lastHash).hide();
	//$(value).show();
	//alert(value);
	

	//lastHash = "#"+myHash;
	
	/*
	if(myHash == "objFind"){
		$("#objFind").show();
	}
	else{
		$("#test").hide();
	}
	*/
	alert("bouh");
	document.getElementById('test').innerHTML=loadHTML('header.html');
};
