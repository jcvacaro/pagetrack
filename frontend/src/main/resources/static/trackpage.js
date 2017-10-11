var server = window.location.hostname + ":8080";

var start = function() {
	var data = JSON.stringify({
		"url": window.location.pathname,
		"timestamp":new Date().getTime()
	});
	$.ajax({
		type: "POST",
		dataType: "jsonp",
		contentType: "application/json",
		url: "http://" + server + "/api/v1/pageaccess",
		data: data
	});
};

function processForm() {
        var data = JSON.stringify({
                "email": document.getElementById("myform").elements["email"].value
        });
        $.ajax({
                type: "POST",
                dataType: "jsonp",
                contentType: "application/json",
                url: "http://" + server + "/api/v1/contact",
                data: data
        });
	alert("thank you for requesting our contact service");
};

window.onload = start;
