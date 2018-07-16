<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%--模态框菜单--%>

<div class="modal fade" id="myEditfoodModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑菜品</h4>
            </div><br>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/updateFood" enctype="multipart/form-data">
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;foodId</span>
                        <input type="text" class="form-control" placeholder="foodId" aria-describedby="basic-addon1"  name="foodId" value="">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodName</span>
                        <input type="text" class="form-control" placeholder="foodName" aria-describedby="basic-addon1"  name="foodName" value="" id="foodname">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodPrice</span>
                        <input type="text" class="form-control" placeholder="foodPrice" aria-describedby="basic-addon1" name="foodPrice" value="" id="foodprice">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodType</span>
                        <input type="text" class="form-control" placeholder="" aria-describedby="basic-addon1" name="foodType" value="" id="foodtype">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;foodImg</span>
                        <input type="file" name="foodImg">

                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodMax</span>
                        <input type="text" class="form-control" placeholder="foodMax"  name="foodMax" value="" id="foodmax">
                    </div><span></span><br>
                    <input type="submit" class="btn btn-default btn-primary" value="Save changes" id="submitF" onclick="return checkF();">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myAddfoodModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加菜品</h4>
            </div><br>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/addFood" enctype="multipart/form-data">
                    <%-- <div class="input-group">
                         <span class="input-group-addon">&nbsp;foodId</span>
                         <input type="text" class="form-control" placeholder="foodId" aria-describedby="basic-addon1"  name="foodId" value="57">
                     </div><br>--%>
                    <div class="input-group">
                        <span class="input-group-addon">foodName</span>
                        <input type="text" class="form-control" placeholder="foodName" aria-describedby="basic-addon1"  name="foodName" value="" id="foodname1">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodPrice</span>
                        <input type="text" class="form-control" placeholder="foodPrice" aria-describedby="basic-addon1" name="foodPrice" value="" id="foodprice1">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodType</span>
                        <input type="text" class="form-control" placeholder="foodType" aria-describedby="basic-addon1" name="foodType" value="" id="foodtype1">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;foodImg</span>
                        <input type="file" name="foodImg" id="foodimg">

                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">foodMax</span>
                        <input type="text" class="form-control" placeholder="foodMax"  name="foodMax" value="" id="foodmax1">
                    </div><span></span><br>
                    <input type="submit" class="btn btn-default btn-primary" value="Save changes" onclick="return checkF1();">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="delFoodModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">删除该菜品</h4>
            </div>
            <div class="modal-body">
                <p>你确定删除该菜品吗?</p><br>
                <input type="button" class="btn btn-default btn-primary" value="确定" id="delFood" data-dismiss="modal">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<%--模态框用户--%>
<div class="modal fade" id="myEditUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑用户</h4>
            </div><br>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/updateUser">
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;用&nbsp;户&nbsp;&nbsp;id</span>
                        <input type="text" class="form-control" placeholder="Userid" aria-describedby="basic-addon1"  name="userId" value="">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;用&nbsp;户&nbsp;名</span>
                        <input type="text" class="form-control" placeholder="userName" aria-describedby="basic-addon1"  name="userName" value="" id="username">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">用户密码</span>
                        <input type="text" class="form-control" placeholder="password" aria-describedby="basic-addon1" name="password" value="" id="password">
                    </div><span></span><br>
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;手&nbsp;机&nbsp;号</span>
                        <input type="text" class="form-control" placeholder="PhoneNum" aria-describedby="basic-addon1" name="phoneNum" value="" id="phoneNum">
                    </div><span></span><br>
                    <input type="submit" class="btn btn-default btn-primary" value="Save changes" id="submit" onclick="return check();"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="delUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">删除该用户</h4>
            </div>
            <div class="modal-body">
                <p>你确定删除该用户吗?</p><br>
                <input type="button" class="btn btn-default btn-primary" value="确定" id="delUser" data-dismiss="modal">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<%--模态框admin--%>

<div class="footer">
    <div>
        copyRight:唐浩东 文艳 吴铭铭 吴彬
    </div>
</div>

<script>
    var a = false,b=false,c=false;
    var f = false,g=false,h=false;i=false;
    var f1 = false,g1=false,h1=false;i1=false;j = false;
    $(function(){
        var comObj;
        function deleteUser(obj){
            $.ajax({
                type:"GET",
                url:"/delUser",
                data:{userid:obj.attr("userid")},
                dataType:"json",
                success:function(data){
                    if(data.result == "true"){//删除成功：移除删除行
                        obj.parents("td").parents("tr").remove();
                        $(".mess").text("该用户被成功删除!");
                    }else if(data.result == "false"){//删除失败
                        $(".mess").text("该用户删除失败!");
                    }else if(data.result == "notexist"){
                        $(".mess").text("该用户不存在!");
                    }
                },
                error:function(data){
                    $(".mess").text("该用户不存在!");

                }
            });
        }
        function deleteFood(obj){
            $.ajax({
                type:"GET",
                url:"/delFood",
                data:{foodid:obj.attr("foodid")},
                dataType:"json",
                success:function(data){
                    if(data.result == "true"){//删除成功：移除删除行
                        obj.parents("td").parents("tr").remove();
                        $(".mess").text("该菜品被成功删除!");
                    }else if(data.result == "false"){//删除失败
                        $(".mess").text("该菜品删除失败!");
                    }else if(data.result == "notexist"){
                        //alert("对不起，用户【"+obj.attr("username")+"】不存在");
                        $(".mess").text("该菜品不存在!");
                    }
                },
                error:function(data){
                    $(".mess").text("该菜品不存在!");

                }
            });
        }
        $('.delFood').click(function(){
            comObj = $(this);

        });

        $('#delFood').click(function(){
            deleteFood(comObj);
        });
        $('.delUser').click(function(){
            comObj = $(this);
        });
        $('#delUser').click(function(){
            deleteUser(comObj);
        });





        /*----------------------------------------前台验证------------------------------*/

        var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
        $("#username").blur(function () {
            if($("#username").val() ==""){
                $("#username").parent().next("span").text("用户名不可以为空");
                a = false;
            }else{
                $("#username").parent().next("span").text("");
                a = true;
            }
        });
        $("#password").blur(function () {
            if($("#password").val() == "" || $("#password").val().length < 6){
                $("#password").parent().next("span").text("密码长度不可小于6位");
                b = false;
            }else{
                $("#password").parent().next("span").text("");
                b = true;
            }
        });
        $("#phoneNum").blur(function () {
            if(!phoneReg.test($("#phoneNum").val())){
                $("#phoneNum").parent().next("span").text("请输入正确手机号码");
                c = false;
            }else{
                $("#phoneNum").parent().next("span").text("");
                c = true;
            }
        });


        //食物验证
        $("#foodname").blur(function () {
            if($("#foodname").val() ==""){
                $("#foodname").parent().next("span").text("用户名不可以为空");
                f = false;
            }else{
                $("#foodname").parent().next("span").text("");
                f = true;
            }
        });
        $("#foodprice").blur(function () {
            if(isNaN(parseFloat($("#foodprice").val()) )|| parseFloat($("#foodprice").val()) <= 0){
                $("#foodprice").parent().next("span").text("价格输入不合法");
                g = false;
            }else{
                $("#foodprice").parent().next("span").text("");
                g = true;
            }
        });
        $("#foodtype").blur(function () {
            if($("#foodtype").val() !="蔬菜"){
                $("#foodtype").parent().next("span").text("蔬菜/水果");
                h = false;
            }else{
                $("#foodtype").parent().next("span").text("");
                h = true;
            }
        });

        $("#foodmax").blur(function () {
            if(isNaN(parseInt($("#foodmax").val())) || parseInt($("#foodmax").val()) <= 0){
                $("#foodmax").parent().next("span").text("请输入正确数值");
                i = false;
            }else{
                $("#foodmax").parent().next("span").text("");
                i = true;
            }
        });

        $("#foodname1").blur(function () {
            if($("#foodname1").val() ==""){
                $("#foodname1").parent().next("span").text("用户名不可以为空");
                f1 = false;
            }else{
                $("#foodname1").parent().next("span").text("");
                f1 = true;
            }
        });
        $("#foodprice1").blur(function () {
            if(isNaN(parseFloat($("#foodprice1").val()) )|| parseFloat($("#foodprice").val()) <= 0){
                $("#foodprice1").parent().next("span").text("价格输入不合法");
                g1 = false;
            }else{
                $("#foodprice1").parent().next("span").text("");
                g1 = true;
            }
        });
        $("#foodtype1").blur(function () {
            if($("#foodtype1").val() !="蔬菜"){
                $("#foodtype1").parent().next("span").text("蔬菜/水果");
                h1 = false;
            }else{
                $("#foodtype1").parent().next("span").text("");
                h1 = true;
            }
        });

        $("#foodmax1").blur(function () {
            if(isNaN(parseInt($("#foodmax1").val())) || parseInt($("#foodmax1").val()) <= 0){
                $("#foodmax1").parent().next("span").text("请输入正确数值");
                i1 = false;
            }else{
                $("#foodmax1").parent().next("span").text("");
                i1 = true;
            }
        });
        $("#foodimg").blur(function () {
            if($("#foodimg").val()==""){
                $("#foodimg").parent().next("span").text("请插入图片");
                j = false;
            }else{
                $("#foodimg").parent().next("span").text("");
                j = true;
            }
        });
    });



    function check() {
        return a&&b&&c;
    }
    function checkF() {

        return f&&g&&h&&i;
    }
    function checkF1() {

        return f1&&g1&&h1&&i1&&j;
    }
</script>

</body>
</html>
