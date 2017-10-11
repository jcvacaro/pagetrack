var server = window.location.hostname + ":8080";

var start2 = function() {
	var msg = $.ajax({type: "GET", url: "http://" + server + "/api/v1/contact", async: false}).responseText;
	document.getElementById("field1").innerHTML = msg;
};

window.onload = start2;
