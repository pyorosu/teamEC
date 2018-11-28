<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


	<title>削除確認</title>
<style type="text/css">

body{
margin:0;
padding:0;
line-height:1.6;
letter-spacing:1px;
font-family:Verdana,Helvetica,sans-serif;
font-size:12px;
color:#333;
background:#fff;
}

table{
text-align:center;
margin:0 auto;
}
#top{
	width:100%;
	text-align:center;
	margin-top:30px;
}
#top h2{
	position:relative;
	display:inline-block;
	padding:24px 64px;
}
#top h2:before, #top h2:after{
	content:"";
	display:block;
	width:50%;
	height:4px;
	border-top:1px solid #111;
	position:absolute;
	top:0;
}
#top h2:before{left:-24px;}
#top h2:after{right:-24px;}
#top h2 span{
	display:block;
	width:4px;height:4px;
	border:2px solid #111;
	-webkit-transform:rotate(45deg);
	transform:rotate(45deg);
	position:absolute;
	top:-4px;
	left:50%;
	margin-left:-4px;
}

#header{
width:100%;
height:80px;
background-color:black;
}

#main{
width:100%;
height:500px;
text-align:center;
}

#footer{
width:100%;
height:80px;
background-color:black;
clear:both;
}

</style>
<script type="text/javascript">
function submitAction(url){
	$('form').attr('action',url);
	$('form').submit();
}
</script>
</head>
<body>

<div id="header">
<div id="pr">
</div>
</div>


<div id="main">
<div id="top">
<h2><span></span>削除確認</h2>
</div>

<div>
<h3>全てのユーザー情報を削除します。よろしいですか？</h3>
<s:form>
	<input id="button" type="button" value="OK"
	onclick="submitAction('UserListDeleteCompleteAction')" />
	<input id="button" type="button" value="キャンセル"
	onclick="submitAction('UserListAction')" />
	</s:form>
</div>
</div>

<div id="footer">
<div id="pr">
</div>
</div>
</body>
</html>