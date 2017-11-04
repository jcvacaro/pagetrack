var SERVER_URL = "api/v1/pagetrac";

var start = function() {
	var data = JSON.stringify({
		"url": window.location.pathname,
		"timestamp":new Date().getTime()
	});
	$.ajax({
		type: "POST",
		dataType: "jsonp",
		contentType: "application/json",
		url: SERVER_URL + "/pageaccess",
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
                url: SERVER_URL + "/contact",
                data: data
        });
	alert("thank you for requesting our contact service");
};

window.onload = start;
