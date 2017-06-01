///$(document).ready( function(){$("#addblog").hide();});
//parent.window.location.reload(true);

$(document).ready(function(){ $("#table1").hide();   });
$(document).ready(function() {
	$("#MainSearchForm #TitleSearchButton").click(function() {
	
		var toSearch = $('#search1').val();
				alert("searching post for " + toSearch);
				
				var searchtxt = {
						title : toSearch
				}
				
				$.ajax({
					url:'/blog.rest/rest/Posts/'+toSearch,
						
					type: 'GET',
					dataType : 'text',
					contentType: "application/json; charset=utf-8",
					
					 beforeSend: function() {
				            alert('sending data' + toSearch);
				            
				        },
				        //data : toSearch,
				        success: function(data) {
				        	alert(' success result');
							
							var receive_data = JSON.parse(data);
							var i=0;
							var posttitle1=[];
							var blogpost1=[];
							
							
							$.each(receive_data, function(idx,obj){
							//alert(obj.posttitle);
						  posttitle1[i] = obj.posttitle;
						  blogpost1[i]= obj.blogpost;	
							
						 
						  $('#table1 .table1class').empty();
						  html = '<li id="'+i+'">'+ posttitle1[i]+  "</li></br>";
							alert(html);
							$('#table1 .table1class').append(html);
							i=i+1;
							
							//$('.change1').text(obj.posttitle);
						} // for loop
							);  //.each
					
							 $( "#table1 #p3").text(blogpost1[0]);
								$("#table1 #title3").text(posttitle1[0]);
						
							
							 $('.table1class li').click(function(){
							      //alert( $(this).attr('id') );
							 var x = $(this).attr('id');  
							 $( "#table1 #p3").text(blogpost1[x]);
							$("#table1 #title3").text(posttitle1[x]);
							 
							 });
							
							
							
							$('#addUser').hide();
							$('#login').hide();
						$('#deleteuser').hide();
						//	$('#blogtabs').show();
			//				$("#loginresult").html("<h1>Welcome " +name + "</h1><HR>");
							//$("#addblog").show();
							//	$("#tabs").show();
							//$('#links').show();
							$('#table1').show();
				        },
				        error: function(jqXHR, textstatus,errorThrown){
						    //alert(' error result');
					//	 document.write("There is an error in find Posts");
						 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
						  }
					 
				        
				}); // ajax
	});
	});




$(document).ready(function() {
	$("#addUser").click(function(e) {
		$("#addForm").show(); 
		$("#loginForm").hide(); 
		$("#findResult").hide();
		$("#DeleteForm").hide();
		$("#addresult").hide();
		$("#blogtabs").hide();
		
		
		$("#mainSearchForm").show();
	});
	$("#addBtn").click(function() {
		$("#addForm").hide();
		var isbn1 = $('#name1').val();
		alert(isbn1);
		var title1 = $('#password1').val();
		alert(title1);
		//var id1= 3;
		
	//	var book ={ "Username":"John", "Personid":30, "Password":"New York"};
		var user1 = {
			username : isbn1,
			password : title1
		};
		$.ajax({
			url : 'rest/User/',
			type : 'post',
			dataType : 'text',
			contentType: "application/json; charset=utf-8",
			 beforeSend: function() {
		            alert('sending data');
		            
		        },
		        data : JSON.stringify(user1),
		        success: function() {
		          //  callback(data); // return data in callback
		        document.write("User "+ data+ " is added");
		        },
			error: function(){
				document.write("Can't add user!");
			}
		        
			
			});
	});

});

$(document).ready(function(){
	$("#login").click(function(){$("#addForm").hide(); $("#loginForm").show(); $("#DeleteForm").hide();$("#tabs").hide(); });

$("#loginButton").click(function(){
	$("#loginForm").hide();
	var name = $('#name3').val();
	alert(name);
	var password = $('#password3').val();
	alert(password);
	var logindata = 
		{
			username : name,
			password : password
		};
	
	//  this is for checking if user is authorized, if yes, show its most recent post and links
	$.ajax({
	   url : 'rest/User/',
		//url : 'rest/User?username='+name+'&password='+password,
		type : 'GET',
		dataType : 'text',
		contentType: "application/json ; charset=utf-8",
		success : function(data) {
			
			alert(' success result');
			//document.write(data);
			//alert(name+ data.postid[0] );
			var receive_data = JSON.parse(data);
			var i=0;
			var posttitle1=[];
			var blogpost1=[];
			
			
			$.each(receive_data, function(idx,obj){
			//alert(obj.posttitle);
		  posttitle1[i] = obj.posttitle;
		  blogpost1[i]= obj.blogpost;	
			
		 
		  
		//html = '<li><a href=" '+i +' ">' + posttitle1[i] + "</a></li><br/>;"
		// html = '<li><a href="'+i+'">' + posttitle1[i] +  "</a></li><br/>"
		//  html = '<li><a href="">' + posttitle1[i] +  "</a></li><br/>"
		  html = '<li id="'+i+'">'+ posttitle1[i]+  "</li></br>";
		  //$("a").attr("href", "swetang");
			alert(html);
		//  $('#links .linklists').append(html);
			$('#table1 .table1class').append(html);
			i=i+1;
			
			//$('.change1').text(obj.posttitle);
		} // for loop
			);  //.each
	
			 $('.table1class li').click(function(){
			      //alert( $(this).attr('id') );
			 var x = $(this).attr('id');  
			 $( "#table1 #p3").text(blogpost1[x]);
			$("#table1 #title3").text(posttitle1[x]);
			 
			 });
			
			//$('.p3class').click(function(){
				//alert(this.id);
	//		});
		//$("#table1 .table1class #0").click(function(){alert("helllo0");$( "#table1 #p3").text(blogpost1[0]);});
	//	$("#table1 .table1class #1").click(function(){alert("helllo1");});
//		$("#table1 .table1class #2").click(function(){alert("helllo2");});
	//	$("#links .linklists li:contains(posttitle1[1])").click(function(){alert("helllo1");});
		//$("#links .linklists li a:contains(posttitle1[2])").click(function(){alert("helllo2");$("#3").text('test is succeed');});
			//$('#links .linklists li a:contains(postitle1[0])').click(function(){alert("helllo1"); document.write("swetang1");});
			//$('#links .linklists li a:contains(postitle1[1])').click(function(){alert("helllo2"); document.write("swetang2");});
			//$('#links .linklists li a:contains(postitle1[2])').click(function(){alert("helllo3"); document.write("swetang3");});
			
			
			$('#addUser').hide();
			$('#login').hide();
		$('#deleteuser').hide();
		//	$('#blogtabs').show();
			$("#loginresult").html("<h1>Welcome " +name + "</h1><HR>");
			//$("#addblog").show();
			//	$("#tabs").show();
			//$('#links').show();
			$('#table1').show();
							
			
		},
		 error: function(jqXHR, textstatus,errorThrown){
			    //alert(' error result');
			 document.write("There is an error in find user");
			 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
			  },
		//data : name+"/"+password
			//  data : name+"/"+password
		data: logindata
	});

		
});

});


$(document).ready(function(){
	$("#deleteuser").click(function(){$("#addForm").hide(); $("#loginForm").hide(); $("#DeleteForm").show();$("#findResult").hide();});

$("#DeleteButton").click(function(){
	//$("#findResult").show();

	var user1 = $("#name2").val();
	//alert(user1);
	if(user1.toLowerCase()=="admin") {
		//return Browser.msgBox("can't delete Admin User");
		//alert("can't use Admin");
	//document.write('<a href="#"  onclick="(deleteuser).click();">back</a>');
		document.write("Deleting Admin User is not Allowed");
		//<a href="#" onClick="window.alert(document.myImage.width)">Width</a><br>
		return ;}
	$.ajax({
		url : 'rest/User/{user1}',
		type : 'post',
		dataType : 'text',
		contentType: "text/plain; charset=utf-8",
		success : 
			function(data) {
			alert(data);
		//	$("#addResult").show();
		//	$('.result').html(data);
		},
		data : user1
		
	});
});

});







//function(data) {
//	$("#addResult").show();
	//$('.result').html(data);
//	document.write(data);
//},