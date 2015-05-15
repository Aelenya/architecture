function compteur(x){
	var txt = x.zone.value;
	var char = txt.length;
	var max = 32;
	if(char > max){
		alert("Maximum "+max+"caractères");
		x.zone.value = txt.substring(0,max);
		char = max;
	}
	x.nbcar.value = char;
}
