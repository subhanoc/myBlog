///$(document).ready( function(){$("#addblog").hide();});
//parent.window.location.reload(true);

$(document).ready(function(){ $("#table1").hide();    $("#addPostdiv").hide(); $("#BtnDeletePost").hide(); $('#test33').hide(); $('#update1').hide();$('#UpdateForm').hide();





});



























$(document).ready(function() {
	$("#MainSearchForm #TitleSearchButton").click(function() {
	
		var toSearch = $('#search1').val();
				//1// alert("searching post for " + toSearch);
				
				var searchtxt = {
						title : toSearch
				}
				
				$.ajax({
					url: 'rest/Posts/'+toSearch,
						
					type: 'GET',
					dataType : 'json',
					contentType: "text/plain; charset=utf-8",
					
					 beforeSend: function() {
				         //1//   alert('sending data' + toSearch);
				            
				        },
				        //data : toSearch,
				        success: function(data) {
				        //1//	alert(' success result');
				        	
				        	if(data && data !="")
				        	{
							var receive_data1 = data;
							//var receive_data1 = JSON.parse(data);
						//1//	alert(receive_data1);
							var i=0;
							var posttitle1=[];
							var blogpost1=[];
							var bloguser1=[];
							var blogdate1=[];
							 $('#table1 .table1class').empty();
							
							$.each(receive_data1, function(idx,obj){
							//alert(obj.posttitle);
						  posttitle1[i] = obj.posttitle;
						  blogpost1[i]= obj.blogpost;	
						  blogdate1[i]=obj.createdDate;
						  bloguser1[i]= obj.uname.username;
						  
						 //1//alert(bloguser1[i]);
						  //1// alert(blogdate1[i]);
						 
						  
						  html = '<li id="'+i+'">'+ posttitle1[i]+  "</li></br>";
						//1//	alert(html);
							$('#table1 .table1class').append(html);
							i=i+1;
							
							//$('.change1').text(obj.posttitle);
						} // for loop
							);  //.each
					
							 $("#table1 #p3").text(blogpost1[0]);
								$("#table1 #title3").text(posttitle1[0]);
								 $("#table1 #title4").text(blogdate1[0]);
								$("#table1 #title5").text(bloguser1[0]);
								
							
							 $('.table1class li').click(function(){
							      //alert( $(this).attr('id') );
							 var x = $(this).attr('id');  
							 $( "#table1 #p3").text(blogpost1[x]);
							$("#table1 #title3").text(posttitle1[x]);
							 $("#table1 #title4").text(blogdate1[x]);
								$("#table1 #title5").text(bloguser1[x]);
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
				        
				        	}
				        	},  // sucess
				        error: function(jqXHR, textstatus,errorThrown){
						    //alert(' error result');
					//	 document.write("There is an error in find Posts");
				        	
				        	 
							
						 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
						  }
					 
				        
				}); // ajax
	});  // title search
	
	$("#MainSearchForm  #UserSearchButton").click(function() {
		
		var toSearch = $('#search1').val();
			//1//	alert("searching post for " + toSearch);
				
				var searchtxt = {
						username : toSearch
				}
	
				$.ajax({
					url: 'rest/User/'+toSearch+'/Posts',
						
					type: 'GET',
					dataType : 'json',
					contentType: "text/plain; charset=utf-8",
					//data: searchtxt,
					 beforeSend: function() {
				 //1//           alert('sending data' + toSearch);
				            
				        },
				        //data : toSearch,
				        success: function(data) {
				      //1//  	alert(' success result');
				        	if(data && data!="")
				        		{
				        	
							var receive_data1 = data;
							
							//var receive_data1 = JSON.parse(data);
					//1//		alert(receive_data1);
							var i=0;
							var posttitle1=[];
							var blogpost1=[];
							var bloguser1=[];
							var blogdate1=[];
							
							 $('#table1 .table1class').empty();
							 
							
							$.each(receive_data1, function(idx,obj){
							//alert(obj.posttitle);
						  posttitle1[i] = obj.posttitle;
						  blogpost1[i]= obj.blogpost;	
						  blogdate1[i]=obj.createdDate;
						  bloguser1[i]= obj.uname.username;
						 
						 
						  html = '<li id="'+i+'">'+ posttitle1[i]+  "</li></br>";
						//1//	alert(html);
							$('#table1 .table1class').append(html);
							i=i+1;
							
							//$('.change1').text(obj.posttitle);
						} // for loop
							);  //.each
					
							 $( "#table1 #p3").text(blogpost1[0]);
								$("#table1 #title3").text(posttitle1[0]);
								 $("#table1 #title4").text(blogdate1[0]);
									$("#table1 #title5").text(bloguser1[0]);
							
							 $('.table1class li').click(function(){
							      //alert( $(this).attr('id') );
							 var x = $(this).attr('id');  
							 $( "#table1 #p3").text(blogpost1[x]);
							$("#table1 #title3").text(posttitle1[x]);
							 $("#table1 #title4").text(blogdate1[x]);
								$("#table1 #title5").text(bloguser1[x]);
							 
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
				       
				        		} // if	
				        }, // success
				 
				       
				        error: function(jqXHR, textstatus,errorThrown){
						    //alert(' error result');
					//	 document.write("There is an error in find Posts");
				        	
						 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
						  }
					 
				        
				}); // ajax

	});	 // User search
	
	
	
	});




$(document).ready(function() {
	$("#addUser").click(function(e) {
		$("#addForm").show(); 
		$("#loginForm").hide(); 
		$("#findResult").hide();
		$("#DeleteForm").hide();
		$("#addresult").hide();
		$("#blogtabs").hide();
		$("#UpdateForm").hide();
		
		
		$("#mainSearchForm").show();
	});
	$("#addBtn").click(function() {
		$("#addForm").hide();
		var isbn1 = $('#name1').val();
		//1//alert(isbn1);
		var title1 = $('#password1').val();
		//1// alert(title1);
		
		if(isbn1 !="" && title1 !="")
			{
		
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
			} // if
		else{alert("Please fill the values");}
	});

});


// ------------ Below is for login of user---- new screen will be displayed along with its posts ------------

$(document).ready(function(){
	
	var my_pid;
	var current_postid;
	var posttitle1=[];
	var blogpost1=[];
	var postid1=[];
	var bloguser1=[];
	var blogdate1=[];
	var name;
	
	$("#login").click(function(){$("#addForm").hide(); $("#loginForm").show(); $("#DeleteForm").hide();$("#tabs").hide(); $("#UpdateForm").hide();});

$("#loginButton").click(function(){
	$("#loginForm").hide();
	 name = $('#name3').val();
	//1//alert(name);
	var password = $('#password3').val();
	//1//alert(password);
	
	if(name !="" && password !="")
	{

	
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
		data: logindata,
		
		
		
		success : function(data) {
			
			//1//	alert(' success result');
			//document.write(data);
			//alert(name+ data.postid[0] );
			 $('#table1 .table1class').empty();  // empty list first
			
			var receive_data = JSON.parse(data);
			var i=0;
			
			 $('#table1 .table1class').empty();
			
			
			
			$.each(receive_data, function(idx,obj){
			//alert(obj.posttitle);
		  posttitle1[i] = obj.posttitle;
		  blogpost1[i]= obj.blogpost;	
		  postid1[i]=obj.postid;	
		  blogdate1[i]=obj.createdDate;
		  bloguser1[i]= obj.uname.username;
		  
		//html = '<li><a href=" '+i +' ">' + posttitle1[i] + "</a></li><br/>;"
		// html = '<li><a href="'+i+'">' + posttitle1[i] +  "</a></li><br/>"
		//  html = '<li><a href="">' + posttitle1[i] +  "</a></li><br/>"
		  html = '<li id="'+i+'">'+ posttitle1[i]+  "</li></br>";
		  //$("a").attr("href", "swetang");
		//1//alert(html);
		//  $('#links .linklists').append(html);
			$('#table1 .table1class').append(html);
			i=i+1;
			
			//$('.change1').text(obj.posttitle);
		} // for loop
			);  //.each
	
			 $( "#table1 #p3").text(blogpost1[0]);     // this is when user loging the first title and its post is displayed
			$("#table1 #title3").text(posttitle1[0]);  // same as above
			$("#table1 #title4").text(blogdate1[0]);
			$("#table1 #title5").text(bloguser1[0]);
			current_postid = postid1[0];


			//--------------------			// below is for clicking <UL LI>-----------------------------

			$('.table1class li').click(function(){
			    //1//  alert( $(this).attr('id') );
			 var x = $(this).attr('id');  
			 
			 current_postid = postid1[x];
			 my_pid = current_postid;
			alert("current post id is: " + my_pid);
			 //var selected_postid = postid1[x];
			 $( "#table1 #p3").text(blogpost1[x]);
			$("#table1 #title3").text(posttitle1[x]);
  //1//			$("#table1 #title4").text(current_postid);  // to view if proper postid is selected
			
			$("#table1 #title4").text(blogdate1[x]);
			$("#table1 #title5").text(bloguser1[x]);
			 
			 });

			///--------------------			// above is for clicking <UL LI>------------------------------------------------------


			
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
			$("#loginresult").html("<h2>Welcome " +name + "</h2><HR>");
			$('#table1').show();
			$("#addPostdiv").show(); 
			$("#txtarea1").hide(); $("#BtnCancel").hide();$("#BtnSave").hide();$("#newTitle").hide(); $("#BtnDeletePost").show();
			
			
			$("#BtnAdd").click(function(){$("#txtarea1").show();$("#newTitle").show(); $("#BtnCancel").show();$("#BtnSave").show();$("#BtnAdd").hide(); });
			$("#BtnCancel").click(function(){$("#txtarea1").hide();$("#BtnCancel").hide();$("#BtnSave").hide();$("#BtnAdd").show();$("#newTitle").hide(); });	
			
			
			/*
			$("#test33").click(function(){
				alert(current_postid);
				//alert(posttitle1[current_postid]);
				var h1 = posttitle1[current_postid];
				
				 $( "#table1 #p3").text("");
					$("#table1 #title3").text("");
				//$(".table1class  #current_postid").remove();
				$('#table1 .table1class li:contains(' + h1 + ')').remove();
				
			});
			*/
			
			
			
		}, // login success function
		 error: function(jqXHR, textstatus,errorThrown){
			    //alert(' error result');
			// document.write("There is an error in find user");
			 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
			  }
		//data : name+"/"+password
			//  data : name+"/"+password
		
	}); // ajax of login
	} // if not null
	
	else{ alert("Please provide login details");}
	
		
});  // loginbtn click




// ------------------deleting posts below-----------------

$("#BtnDeletePost").click(function(){
	//alert( $("#table1 .table1class  li").attr('id') );
	//alert( $("#table1 #title3").text() );
	//alert(postid1[current_postid]);
	//alert(current_postid);
	
	var pid = my_pid;
	alert("current pid is " + pid);	
		
			
		
	
	$.ajax({
		   url : 'rest/Posts/'+pid,
			
			type : 'delete',
			dataType : 'text',
			contentType: "text/plain ; charset=utf-8",
			success : function(data) {
			//1//	alert(data);
				alert("Post deleted!");
				//alert(current_postid);
				//alert(posttitle1[current_postid]);
				
				//var h1 = posttitle1[current_postid];
				//alert(h1);
				
				//1// $( "#table1 #p3").text("");
			//1//		$("#table1 #title3").text("");
				//$(".table1class  #current_postid").remove();
			//1//	$('#table1 .table1class li:contains(' + h1 + ')').remove();
				
				//$("#loginButton").trigger('click');
			//1//	$('#BtnCancel').trigger('click');
				
			}, // success function
			complete:function(data){$("#loginButton").click(); $("#BtnCancel").click();},
	error: function(jqXHR, textstatus,errorThrown){
	    //alert(' error result');
	// document.write("There is an error in Deleting Post");
	 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
	 $('#BtnCancel').trigger('click');
	  }
	  
	 // data: JSON.stringify(pid)
			}) // ajax
	
});


//above------------------deleting posts ---------------------		


//-------------saving post--------------------------------	
$("#BtnSave").click(function(){
	var postdata11 = $("textarea#txtarea1").val();  var t1 = "text is empty";
	var posttitle11 = $("#newTitle").val();
	
	if(!$.trim(postdata11))
	//if (postdata11 == "")
	{alert(t1); return false;}
	else
		{
		alert(postdata11);
		alert(posttitle11);
		var postdata11 = 
				{
					  uname : {username : name},
						posttitle : posttitle11,
						blogpost : postdata11
					};
			
			$.ajax({
				   url : 'rest/Posts/',
					//url : 'rest/User?username='+name+'&password='+password, dataType is what we receive
					type : 'post',
					dataType : 'text',
					contentType: "application/json ; charset=utf-8",
					success : function(data) {
			//1//			alert(data);
						alert("new post is created!");
						//alert(i);
					//1//	i=i+1;
						//1//	html = '<li id="'+i+'">'+ posttitle11+  "</li></br>";
						//1//		  posttitle1[i]=posttitle11; blogpost1[i] = postdata11;
						//	alert(html);
						//alert(posttitle1[i]); alert(blogpost1[i]);
						//1//				$('#table1 .table1class').append(html);
							
							//1// $("#BtnCancel").click();
						
					}, // success function
					complete:function(data){$("#loginButton").trigger('click'); $("#BtnCancel").click();},
			error: function(jqXHR, textstatus,errorThrown){
			    //alert(' error result');
			// document.write("There is an error in Posting data");
			 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
			 $("#BtnCancel").click();
			  },
			  
			  data: JSON.stringify(postdata11)
					}) // ajax
		

		} // else when data is there in text aread

});


//--- saving posts---------------------		
	







}); // this is document ready



//------------ Above is for login of user---- new screen will be displayed along with its posts ------------


//--------- Below is for delete users (supply uname and passwd)-----------------------//





$(document).ready(function(){
	$("#deleteuser").click(function(){$("#addForm").hide(); $("#loginForm").hide(); $("#DeleteForm").show();$("#findResult").hide(); $("#UpdateForm").hide(); });

	$("#updateuser").click(function(e) {
		$("#UpdateForm").show(); 
		$("#loginForm").hide(); 
		$("#findResult").hide();
		$("#DeleteForm").hide();
		$("#addresult").hide();
		$("#blogtabs").hide();
		$('#addForm').hide();
		
		$("#mainSearchForm").show();
	});
	
	
	
	
	
	$("#UpdateButton").click(function(){
		
		var user4 = $("#name4").val();
		var oldpassword4 = $("#password4").val();
		var newpassword4 = $("#newpassword4").val();
		alert(user4 + " " + oldpassword4 + " " + newpassword4);
		
		
		if(user4 !="" && oldpassword4 !="" && newpassword4 !="")
			{
			
			var updatedata = {
					username : user4,
					oldpassword : oldpassword4,
					newpassword : newpassword4
			        
			};
			
			$.ajax({
				url : 'rest/User/'+user4+'/'+oldpassword4+'/'+newpassword4,
				type : 'put',
				dataType : 'text',
				contentType: "text/plain; charset=utf-8",
				success : 
					function(data) {
					alert(data);
				//	$("#addResult").show();
				//	$('.result').html(data);
				},
				 error: function(jqXHR, textstatus,errorThrown){
					    //alert(' error result');
					 //document.write("There is an error in find user");
					 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
					  }
			//	data : JSON.stringify(updatedata)
				
			});
			
			
			
			} // if old, new and user is not null
		
		else{alert("please provide all values!");}
		
		
	});  //updateButton click
	
	
	
	
	//--------- Below is for delete users (supply uname and passwd)-----------------------//
	
	
	
	$("#DeleteButton").click(function(){
	//$("#findResult").show();

	var user1 = $("#name2").val();
	var password1 = $("#password2").val();
//1//	alert(password1);
//1//	alert(user1);
	
	if(user1 !=="" && password1 !="")
		{
	
	var deletedata = {
			username : user1,
			password : password1
	        
	}
	
	//alert(user1);
	if(user1.toLowerCase()=="admin") {
		//return Browser.msgBox("can't delete Admin User");
		//alert("can't use Admin");
	//document.write('<a href="#"  onclick="(deleteuser).click();">back</a>');
		document.write("Deleting Admin User is not Allowed");
		//<a href="#" onClick="window.alert(document.myImage.width)">Width</a><br>
		return ;}
	$.ajax({
		url : 'rest/User/'+user1+'/'+password1,
		type : 'delete',
		dataType : 'json',
		contentType: "text/plain; charset=utf-8",
		success : 
			function(data) {
			alert(data);
		//	$("#addResult").show();
		//	$('.result').html(data);
		},
		 error: function(jqXHR, textstatus,errorThrown){
			    //alert(' error result');
			 //document.write("There is an error in find user");
			 alert("status: "+ textstatus); alert("Error: "+ errorThrown);
			  },
		data : deletedata
		
	});
} // if not null
	else{alert("Please provide details!");}
});

});


//--------- above is for delete users (supply uname and passwd)-----------------------//




//function(data) {
//	$("#addResult").show();
	//$('.result').html(data);
//	document.write(data);
//},