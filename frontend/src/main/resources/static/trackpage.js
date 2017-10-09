var server = window.location.hostname + ":8080";

var start = function() {
	var text = server + " " + new Date().getTime() + " " + window.location.pathname;
	document.getElementById("field1").innerHTML = text;
	var data = JSON.stringify({
		"url": window.location.pathname,
		"timestamp":new Date().getTime()
	});
	$.ajax({
		type: "POST",
		dataType: "jsonp",
		contentType: "application/json",
		url: "http://" + server + "/api/v1/pageaccess",
		data: data,
		success: function(data){
			alert(data);
		},
		error: function(data) {
			alert("ajax error" + data);
		}
	});
};

function processForm() {
	alert(document.getElementById("myform").elements["email"].value);
	location.href="/index.html"
};

window.onload = start;
