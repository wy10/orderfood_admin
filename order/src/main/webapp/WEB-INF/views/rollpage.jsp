<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">

    </script>
</head>
<body>
<div class="page-bar">
    <ul class="page-num-ul clearfix">
        <li style="color:#ffffff">共${page.total }条记录&nbsp;&nbsp; ${page.pageNum }/${page.pages }页</li>
        <c:if test="${page.total > 1}">
            <a href="javascript:page_nav(document.forms[6],1);" style="color:#ffffff">首页</a>
            <a href="javascript:page_nav(document.forms[6],${page.pageNum-1});" style="color:#ffffff">上一页</a>
        </c:if>
        <c:if test="${param.currentPageNo < param.totalPageCount }">
            <a href="javascript:page_nav(document.forms[6],2);" style="color:#ffffff">下一页</a>
            <a href="javascript:page_nav(document.forms[6],${page.pages });" style="color:#ffffff">最后一页</a>
        </c:if>
        &nbsp;&nbsp;
    </ul>
    <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" style="border-radius: 5px"/>&nbsp;页
	     <button class="btn btn-primary btn-sm" type="button" class="page-btn" onClick='jump_to(document.forms[6],document.getElementById("inputPage").value)'>GO</button>
		</span>
</div>
</body>                                                                                                               
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/rollpage.js"></script>
</html>