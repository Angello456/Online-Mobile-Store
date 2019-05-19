GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getAllProducts").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "products",	
					dataType : 'json',
					success : function(data) {
						var items=[];
						$.each(data, function (index, product) {
//							 var $print=$('#getResultDiv .list-group');
//							 $print.append('<li>Code :'+ product.code+' Name :'+ product.name+'</li>');
							 items.push("<tr>");
							 items.push("<td id=''"+index+"''>"+product.code+"</td>");
							 items.push("<td id=''"+index+"''>"+product.name+"</td>");
							 items.push("<td id=''"+index+"''>"+product.price+"</td>");
							 items.push("<td id=''"+index+"''>"+product.image+"</td>");
							 items.push("<td id=''"+index+"''>"+product.createDate+"</td>");
							 items.push("</tr>");
							  });
							$("<tbody/>",{"class":"productT",html:items.join("")}).appendTo("table");
							
							
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						alert("fune")
						console.log("ERRORL: ", e);
					}
				});
			}
		})



