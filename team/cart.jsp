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
	<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Cart</title>
<link rel="stylesheet" href="./css/cart.css">
</head>
<body>
<s:include value="header.jsp" />
<div class="contents">
	<div class="title">
	<p>カート</p>
</div>
<s:if test="checkListErrorMessageList!=null">
	<div class="error-message">
		<s:iterator value="checkListErrorMessageList">
		<s:property />
		</s:iterator>
	</div>
</s:if>
<div id="main">
	<s:if test="#session.cartInfoDtoList.size()>0">
	カートには以下の商品が入っています
	<s:form id="form" action="SettlementConfirmAction">
	<s:iterator value="#session.cartInfoDtoList">
		<table>
			<tr>
			<td><s:checkbox name="checkList" fieldValue="%{productId}"/></td>
			<td><img src='<s:property value="imageFilePath" />/
			<s:property value="imageFileName" />' /></td>
			</tr>
		</table>
		<div id="right">
			<s:hidden name="productId" value="%{productId}" />
			<div class="namekana"><s:property value="productNameKana" /></div>
			<div class="name">商品名： <s:property value="productName" /></div>
			<div class="price">価格： ¥<s:property value="price" /></div>
			<div class="text">(購入数： <s:property value="productCount" />点)</div>
			<div>発売会社： <s:property value="releaseCompany" /></div>
			<div class="text">発売日： <s:property value="releaseDate" /></div>
			<div class="total">合計金額： <s:property value="subtotal" />円</div>
		</div>
	<s:hidden name="productName" value="%{productName}" />
	<s:hidden name="productNameKana" value="%{productNameKana}" />
	<s:hidden name="imageFilePath" value="%{imageFilePath}" />
	<s:hidden name="imageFileName" value="%{imageFileName}" />
	<s:hidden name="price" value="%{price}" />
	<s:hidden name="releaseCompany" value="%{releaseCompany}" />
	<s:hidden name="releaseDate" value="%{releaseDate}" />
	<s:hidden name="productCount" value="%{productCount}" />
	<s:hidden name="subtotal" value="%{subtotal}" />
		<p class="box">  </p>
	</s:iterator>
	<h2><s:label value="カート合計金額 :"/><s:property value="#session.totalPrice" />円</h2>
	<s:token/>
	<s:submit value="決済" class="btn_blue" />
	<s:submit value="削除" class="btn_red" onclick="this.form.action='DeleteCartAction';" />
	</s:form>
	</s:if>
</div>
<s:else>
<div class="info">
カート情報はありません。
</div>
</s:else>
</div>
<div id="footer">
<s:include value="footer.jsp" />
</div>
</body>
</html>