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

	<title>UserCreate画面</title>

	<style type="text/css">

	/*========TAG LAYOUT========*/
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

	/*========ID LAYOUT=========*/
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

.error {
	text-align:center;
	font-size : 10px;
	margin:0 auto;
	margin-bottom:5px;
	width : 40%;
	color: #D8000C;
	background-color: #FFBABA;
}

.error-message {
	color : red;
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
</head>
<body>

<div id="header">
<div id="pr">
</div>
</div>

<div id="main">
<div id="top">
	<h2><span></span>UserCreate</h2>
</div>
<s:if test="!#session.loginUserIdErrorMessageList.isEmpty()">
<div class="error">
<div class="error-message">
	<s:iterator value="#session.loginUserIdErrorMessageList"><s:property /><br></s:iterator>
</div>
</div>
</s:if>
<s:if test="!#session.loginPasswordErrorMessageList.isEmpty()">
<div class="error">
<div class="error-message">
	<s:iterator value="#session.loginPasswordErrorMessageList"><s:property /><br></s:iterator>
</div>
</div>
</s:if>

<s:if test="!#session.userNameErrorMessageList.isEmpty()">
<div class="error">
<div class="error-message">
	<s:iterator value="#session.userNameErrorMessageList"><s:property /><br></s:iterator>
</div>
</div>
</s:if>

<div>

	<table>
	<s:form action="UserCreateConfirmAction">

	<tr>
		<td>
		<s:textfield name="loginUserId" value="%{#session.loginUserId}" label="ログインID" placeholder="8文字以下で入力してください" size="25" />
		</td>
	</tr>

	<tr>
		<td>
		<s:textfield name="loginPassword" value="%{#session.loginPassword}" label="パスワード" placeholder="16文字以下で入力してください" size="25 "/>
		</td>
	</tr>

	<tr>
		<td>
		<s:textfield name="userName" value="%{#session.userName}" label="ユーザー名" placeholder="8文字以下で入力してください" size="25" />
		</td>
	</tr>

	<s:submit value="登録" />
	</s:form>
	</table>


	<div>
		<span>前画面に戻る場合は</span>
		<a href='<s:url action="HomeAction" />'>こちら</a>
	</div>
</div>
</div>


<div id="footer">
<div id="pr">
</div>
</div>






</body>
</html>