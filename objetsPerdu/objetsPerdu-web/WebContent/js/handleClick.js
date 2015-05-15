var currentMarker = null;

function handleClick(event){
	if(currentMarker == null){
		document.getElementById('lat').value = event.latLng.lat();
		document.getElementById('lng').value = event.latLng.lng();
		currentMarker = new google.maps.Marker({
			position:new google.maps.LatLng(event.latLng.lat(),event.latLng.lng())
		});
		PF('gmap').addOverlay(currentMarker);
		PF('dialog').show();
	}
}

function markerAddComplete(){
	currentMarker = null;
	PF('dialog').hide();
}

function cancel(){
	PF('dialog').hide();
	currentMarker.setMap(null);
	currentMarker = null;
	return false;
}
