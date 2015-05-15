
function loadHTML(href)
{
	var xml = new XMLHttpRequest();
	xml.open("GET", href, false);
	xml.send();
	return xml.responseText;
}