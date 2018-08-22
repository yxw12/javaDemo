<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/fun.js"></script>
<title>修改商品信息</title>

</head>
<body>
<input type="button" value="ajax异步" onclick="jsonData();">
<input type="button" value="ajax异步boolean" onclick="checkName();">
<input type="button" value="ajax异步Object" onclick="findUser();">
<input type="button" value="ajax异步list" onclick="findUsers();">
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/uploadFile.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="product.pid" value="${item.pid }" /> 修改商品信息：
		<table width="100%" border=1 cellspacing="0">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="product.pname" value="${item.pname }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="product.price" value="${item.price }" /></td>
			</tr>

			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="product.createtime"
					value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr>
        <tr>
            <td>商品图片</td>
            <td>
              <%--  <c:if test="${item.pic !=null}">
                    <img src="/${item.pic}" width=100 height=100/>
                    <br/>
                </c:if>--%>
          <%--     <input type="file"  name="pictureFile"/>--%>
				<div id="localImag">
					<img id="preview" width=200 height=120 style="diplay:none" src="${pageContext.request.contextPath }/${item.pic}"/>
				</div>
				<input type="file" name="pictureFile" id="doc" onchange="javascript:setImagePreview();">
            </td>
        </tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="product.detail">${item.detail }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>


</body>

</html>
<script type="text/javascript">
	function setImagePreview() {
		var docObj = document.getElementById("doc");
		var imgObjPreview = document.getElementById("preview");
		if (docObj.files && docObj.files[0]) {
			//火狐下，直接设img属性
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '200px';
			imgObjPreview.style.height = '120px';
			//imgObjPreview.src = docObj.files[0].getAsDataURL();
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");
			//必须设置初始大小
			localImagId.style.width = "250px";
			localImagId.style.height = "200px";
			//图片异常的捕捉，防止用户修改后缀来伪造图片
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}
</script>
<%--<script type="text/javascript">
	function uploadPic() {
		$.ajax({
			url:"${pageContext.request.contextPath }/uploadFile.do",
			success:function (data) {

			}
		})
	}
</script>--%>
