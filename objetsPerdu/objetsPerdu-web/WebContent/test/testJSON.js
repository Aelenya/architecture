$(document).ready(
	function() {
	$.getJSON("/home/facade/testJSON", function(data) {
		var items = [ "<tbody>" ];
		$.each(data, function(key, val) {
			items.push("<tr><td>" + key + "</td><td>" + val + "</td></tr>");
		});
		items.push("</tbody>");
		$("table").append(items.join(""));
	});
});