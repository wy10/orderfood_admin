<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<div class="header">
    <h2>管理员界面</h2>
    &nbsp; &nbsp; &nbsp;<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath }/logout">退出登录</a>
</div>
<div class="comwidth">
    <div class="main">
        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="tab_gongneng">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
                        <li role="presentation">
                            <a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                                <div class="flipper">
                                    <div class="front">
                                        &nbsp; &nbsp; &nbsp;<img src="../../../statics/imgs/othermesssage.png" style="width:200px">
                                        <div>
                                            ${mess}
                                        </div>
                                    </div>
                                    <div class="back">
                                        <form method="post" action="${pageContext.request.contextPath}/updatePass">
                                            <h5>密码修改</h5>
                                            &nbsp;<input type="text" value="" style="border-radius: 3px" placeholder="请输入新密码" name="password">
                                            <input type="submit" value="修改" class="btn btn-xs btn-primary">
                                        </form>
                                        <hr>
                                        <form method="post" action="${pageContext.request.contextPath}/addMess">
                                            <h5>添加备忘录</h5>
                                            <input type="text" value="" style="border-radius: 3px;" placeholder="请输入..." name="mess">
                                            <input type="submit" value="添加" class="btn btn-xs btn-primary">
                                        </form>
                                        <hr>
                                        <form method="get" action="${pageContext.request.contextPath}/selFoodCount">
                                            <input type="hidden" name="pageIndex" value="1"/>
                                            <span>查询库存</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="submit" value="查询库存" class="btn btn-xs btn-primary">
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="profile">
                            <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                                <div class="flipper">
                                    <div class="front">
                                        &nbsp; &nbsp;&nbsp;<img src="../../../statics/imgs/Notepad.png">
                                    </div>
                                    <div class="back">
                                        <form action="${pageContext.request.contextPath}/clearMess" method="GET" style="display: inline">
                                            <p>${message}</p>
                                            <input type="submit" class="btn btn-sm btn-primary" value="清空">
                                        </form>
                                        <form action="${pageContext.request.contextPath}/selMess" method="get" style="display: inline">
                                            <input type="submit" class="btn btn-sm btn-primary" value="查看">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><br>

                <li>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/selAllUser"><img src="../../../statics/imgs/selectUser.png" alt="" style="border-radius: 5px"></a></li>
                <br>
                <div>
                    &nbsp;&nbsp;&nbsp;<a href="#" data-toggle="modal" data-target="#myEditUserModal"><img src="../../../statics/imgs/editUser.png" style="border-radius: 5px"/></a>
                </div>
            </div>
            <div class="col-md-8 col-sm-8 col-xs-3 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
                <form action="${pageContext.request.contextPath}/selAllFood" method="GET">
                    <%--<input type="hidden" name="pageIndex" value="1"/>--%>
                    <input type="submit" id="selectMenu" value=""/>&nbsp;&nbsp;
                    <input type="button" id="editMenu" value="" data-toggle="modal" data-target="#myEditfoodModal"/>&nbsp;&nbsp;
                    <input type="button" id="addMenu" value="" data-toggle="modal" data-target="#myAddfoodModal"/>
                </form>

                <div>
                    <br><br>

                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Message
                            &nbsp;&nbsp;&nbsp;<span class="mess"></span>
                        </div>

                        <!-- Table -->
                        <table class="table">
                            <tr>
                                <td>菜品ID</td>
                                <td>菜品名称</td>
                                <td>菜品进入量</td>
                                <td>菜品现库存</td>

                            </tr>
                            <c:forEach var="food" items="${page.list }" varStatus="status">
                                <tr>
                                    <td>${food.foodid}</td>
                                    <td>${food.foodname}</td>
                                    <td id="maxoutput_${status.index}">${food.maxoutput}</td>
                                    <td id="foodcount_${status.index}">${food.count}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <input type="hidden" id="totalPageCount" value="${page.pages}"/>
                <c:import url="../rollpage1.jsp">
                    <c:param name="totalCount" value="${page.total}"/>
                    <c:param name="currentPageNo" value="${page.pageNum}"/>
                    <c:param name="totalPageCount" value="${page.pages}"/>
                </c:import>
            </div>
        </div>
        <%-- </div>--%>
    </div>
</div>
</div>
</div>
</div>
</div>

<%@include file="/WEB-INF/views/common/footer.jsp" %>
