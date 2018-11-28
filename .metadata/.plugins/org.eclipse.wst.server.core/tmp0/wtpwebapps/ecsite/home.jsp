<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<title>Home画面</title>

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


/*========ECSITE LAYOUT========*/
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

a.cp_btn {
	display: inline-block;
	text-decoration: none;
	color: #FF5722;
	width: 120px;
	height: 120px;
	letter-spacing:2px;
	line-height: 120px;
	border: double 4px #FF5722;
	border-radius: 50%;
	vertical-align: middle;
	overflow: hidden;
	transition: .6s;
	margin:0px 30px 0px 30px;
}
a.cp_btn:hover {
	transform: rotateY(360deg);
}

#footer{
width:100%;
height:80px;
background-color:black;
}
</style>
</head>
<body>


<div id="header">
<div id="pr">
</div>
</div>



<div id="main">
	<div id="top">
		<h2><span></span>Home</h2>
	</div>


	<a href='<s:url action="HomeAction"/>' class="cp_btn">item</a>
		<a href='<s:url action="AdminAction" />' class="cp_btn">Admin</a>

	<s:if test="#session.id !=null">
		<p>ログアウトする場合は</p>
			<a href='<s:url action="LogoutAction" />'>こちら</a>
	</s:if>
	</div>

<div id="footer">
<div id="pr">
</div>
</div>


</body>
</html>