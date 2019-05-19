$(document).ready(
		function() {

			// SUBMIT FORM
			$("#productForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

		    // PREPARE FORM DATA
				var formData = {
						name : $("#name").val(),
						price : $("#price").val(),
						qyt : $("#qyt").val(),
						image : $("#image").val(),
						createDate : $("#createDate").val(),
						shop_id:$("#shop_id").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "products",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.name
											+ " Saved Successfully! <br>");
						} else {
							$("#postResultDiv").html("<strong> Not Success </strong>"+result.status);
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error1")
						console.log("ERROR: ", e);
					}
				});

			}

		})