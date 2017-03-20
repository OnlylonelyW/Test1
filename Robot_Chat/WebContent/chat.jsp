<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="content-type" charset="UTF-8" content="text/html">
		<title>laing</title>
		<meta name="discription"  content="">
		<meta name="keywords" content="">
		<style type="text/css">
			*{margin:0px;padding:0px;}
			body{background:url('images/bg.jpg') no-repeat; background-size:cover; font-size:12px;font-family:"微软雅黑";}

			#chat{height:530px; width:900px; background:yellow; margin:100px auto;}
			#chat .head{height:68px; background:#6cf; font-size:20px; line-height:64px; color:white; padding-left:10px;}
			#chat .body .con{width:900px; height:380px; background:#EFF0F2; overflow:auto;}
			#chat .body .con img{border-radius:50%; width:50px; height:50px; vertical-align:middle;}
			#chat .body .message .in{width:780px; height:62px; padding:10px; background:#E8E8E8; float:left; outline:none;}
			#chat .body .message .put{width:100px; height:82px; background:#c4c4c4; cursor:pointer; border:none; outline:none;}
			#chat .body .message .put:hover{background:;}
			#chat .body .con .con1{padding:10px; outline:none;}
			#chat .body .con .con2{padding:10px; text-align:right; outline:none;}
			
			::-webkit-scrollbar{width:5px;height:6px;background:#ccc;}
			::-webkit-scrollbar-button{background-color:#e5e5e5;}
			::-webkit-scrollbar-track{background:#999;}
			::-webkit-scrollbar-track-piece{background:#ccc}
			::-webkit-scrollbar-thumb{background:#666;}
			::-webkit-scrollbar-corner{background:#82AFFF;}
			::-webkit-scrollbar-resizer{background:#FF0BEE;}
			scrollbar{-moz-appearance:none !important;background:rgb(0,255,0) !important;}
			scrollbarbutton{-moz-appearance:none !important;background-color:rgb(0,0,255) !important;}
			scrollbarbutton:hover{-moz-appearance:none !important;background-color:rgb(255,0,0) !important;}
		</style>
	</head>
<body>
	<div id="chat">
		<div class="head">
			人工智能客服机器人系统
		</div>
		<div class="body">
			<div class="con">
				<div class="con1">
					<img src="images/icon_header.png">
					 你好
				</div>
			</div>
			<div class="message">
				<div class="in" contenteditable="true" id="message"></div>
				<input type="submit" class="put" value="发送" id="send">
			</div>
		</div>
	</div>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("#send").click(function(){
			var value = $("#message").text();
			$(".con").append("<div class='con2'>"+
								" "+value+"<img src='images/meng.jpg' alt='arry老师' width='50' height='50' />"+
								"</div>");
			$.ajax({
				type:"post",
				url:"data.jsp",
				data:{info:value},
				success:function(data){
					var json = JSON.parse(data);//解析为数组
					$(".con").append("<div class='con1'>"+
										"<img src='images/icon_header.png' alt='智能客服' width='50' height='50' />"+
										" "+json.text+""+
										"</div>");	
				}
			});
		});
	});

</script>
</body>
</html>