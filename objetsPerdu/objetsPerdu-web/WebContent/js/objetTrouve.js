//Fonction d'envoi des donnees en appuyant sur le bouton d'ajout

$(function(){
	$("#buttonObjetTrouve").on('click', function(event) {

		//On parse, effectue un reverse geocoding et met au format JSON l'adresse
		var adresse = "\"adresse\": \"";
		var lat = document.getElementById('lat').value;
		var lng = document.getElementById('lng').value;
		var latlng = new google.maps.LatLng(lat, lng);
		if(lat == 0 && lng == 0){
			adresse += "\"";
		}
		else{
			adresse += document.getElementById('addr').value;
		}
		alert(adresse);
		//On parse et met au format JSON nos tags
		var taille = $("li[class|=tag]").length;
		var tags = "\"tags\": [";
		$("li[class|=tag]").each(function(index){
			tags += "{\"value\" : \""+$(this).text()+"\"}";
			if(index < taille-1){
				tags += ",";
			}
		});
		tags += "]";

		event.preventDefault();
		$.ajax({
			type: "POST",
			url: '/home/facade/objetTrouve',
			dataType: 'json',
			contentType: "application/json; charst=utf-8",
			async: false,
			data: '{"nom": "'+$("#nomObjetTrouve").val()+'", '+tags+' , '+adresse+'}'
		});
	});
});

//	Fonction de gestion de la carte
	var marker = null;
	var geocoder = new google.maps.Geocoder();
	$(document).ready(function() {
		var position = new google.maps.LatLng(46.2200, 6.0900);
		$('#gmap').gmap({'center': position, zoom: 10}).bind('init', function(event, map) { 
			$(map).click( function(event) {
				if(marker == null){

					var pos = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
					document.getElementById('lat').value = event.latLng.lat();
					document.getElementById('lng').value = event.latLng.lng();
					reverseGeocoding(function(addr){
						document.getElementById('addr').value = addr;},pos);
					marker = new google.maps.Marker({
						position: pos, 
						map: map,
						draggable:true
					});
					$('#gmap').gmap('addMarker',marker);

					google.maps.event.addListener(
							marker,
							'drag',
							function() {
								document.getElementById('lat').value = marker.position.lat();
								document.getElementById('lng').value = marker.position.lng();
								var pos = new google.maps.LatLng(marker.position.lat(), marker.position.lng());
								reverseGeocoding(function(addr){
									document.getElementById('addr').value = addr;},pos);
							}
					);
				}
			});
		});
	});
	
function reverseGeocoding(callback,latlng){
	adresse = geocoder.geocode({'latLng': latlng}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			if (results[1]) {
				address = results[1].formatted_address;
				address = address.replace(/\,/g, ' ');
				adresse = address;
				adresse += "\"";
				callback(adresse);
			}
		}
	});

}