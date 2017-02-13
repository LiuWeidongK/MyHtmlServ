<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="resource/ico.ico">
    <title>实验室器材管理系统</title>

    <!-- CssCodeLink Start -->
    <link href="css/bootstrap.min.css" rel="stylesheet">    <!-- Bootstrap Code -->
    <link href="css/dashboard.css" rel="stylesheet">
    <link href="../Common/Css/messenger.css" rel="stylesheet">   <!-- Alert Message -->
    <link href="../Common/Css/messenger-theme-future.css" rel="stylesheet">
    <link href="../Common/Css/messenger-theme-air.css" rel="stylesheet">
    <link href="../Common/Css/bootstrapValidator.css" rel="stylesheet">   <!-- Check Form -->
    <link href="css/indexCss.css" rel="stylesheet">     <!-- Own Code -->

    <!-- JsCodeLink Start -->
    <script type="text/javascript" src="js/jquery-3.0.0.js"></script>	    <!-- Jquery -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>     <!-- Bootstrap Code-->
    <script type="text/javascript" src="../Common/Js/messenger.min.js"></script>   <!-- Alert Message -->
    <script type="text/javascript" src="../Common/Js/messenger-theme-future.js"></script>
    <script type="text/javascript" src="../Common/Js/bootstrapValidator.js"></script>    <!-- Check Form -->
    <script type="text/javascript" src="js/jquery.tablesorter.js"></script>    <!-- Table Sort -->
    <script type="text/javascript" src="js/indexJs.js"></script>   <!-- Own Code -->
    <script type="text/javascript" src="js/ajaxJs.js"></script>
    <script type="text/javascript" src="../Common/Js/checkForm.js"></script>

    <!--
        问题概述：
            1.表单验证基本实现  数据长度暂未验证
            2.重要数据传递时应进行加密处理
            3.个人信息完善不显示提示   不重要 可不显示
            4.表单不能重置
            5.ie模式下input的默认字段属性不能显示
                                            ——更新于 2017/2/13 20:37

            --3.若可使用本地缓存保存数据 可减少客户端与服务器的交互 暂不解决
            --4.暂时刷新（刷新一次就需要向服务器发送一次请求）只有四种情况：页面加载、手动点击按钮、数据提交成功、div切换

            //1.批量删除暂已实现
            //2.个人信息不全不予以借用未实现
            //3.拼接html代码的时候 详细信息不弹出 排序函数无法实现 表格信息无法获取 已解决
            //4.详细信息弹框会出现不能消失的问题 未解决
    -->
</head>

<body onload="displayTime()">
<!-- Top -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">实验室器材管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a id="Date"></a></li>
                <li>
                    <a href="#" class="dropdown-toggle" id="user" data-toggle="dropdown">
                        <%
                            session.setMaxInactiveInterval(3600);
                            String username = (String)session.getAttribute("username");
                            out.write(username);
                        %>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#" data-toggle="modal" data-target="#updatePass"><span class="glyphicon glyphicon-pencil"></span> 修改密码</a></li>
                        <li><a id="sOut" href="#" data-toggle="modal" data-target="#signoutModal"><span class="glyphicon glyphicon-off"></span> 退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <!-- Left-List-->
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar" id="leftlist">
                <li class="active"><a href="#">设备状态信息</a></li>
                <li><a href="#">设备信息管理</a></li>
                <li><a href="#">设备借用信息</a></li>
                <li><a href="#">个人信息 <span class="badge" id="tips">1</span></a></li>
            </ul>
        </div>

        <!-- First-Content-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" name="content" id="content1">
            <h1 class="sub-header">设备状态信息</h1>
            <div class="table-responsive">
                <!-- Searching -->
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="searchId_1" placeholder="实验室编号">
                </div>

                <div class="btn-group" id="outExcel">
                    <button type="button" class="btn btn-default" onclick="outToExcel('StateInfo')">
                        <span class="glyphicon glyphicon-floppy-save"></span> 导出到Excel
                    </button>
                    <button type="button" class="btn btn-default" id="refreshBtn1">
                        <span class="glyphicon glyphicon-refresh"></span>
                    </button>
                </div>

                <table class="table table-hover" id="StateInfo">
                    <thead>
                    <tr>
                        <th class="pointer">实验室编号 <span class="glyphicon glyphicon-sort-by-order"></span></th>
                        <th class="pointer">设备编号 <span class="glyphicon glyphicon-sort-by-order"></span></th>
                        <th class="pointer">设备名称 <span class="glyphicon glyphicon-sort-by-alphabet"></span></th>
                        <th>设备型号</th>
                        <th>剩余数量</th>
                        <th>详细信息</th>
                        <th>借用</th>
                    </tr>
                    </thead>
                    <tbody id="firstTbody"></tbody>
                </table>
            </div>
        </div>

        <!-- Second-Content-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" name="content" id="content2">
            <h1 class="sub-header">设备信息管理</h1>
            <div class="table-responsive">
                <!-- Search -->
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="searchId_2" placeholder="实验室编号">
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal">
                        <span class="glyphicon glyphicon-plus"></span> 添加设备
                    </button>
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#deleteAllModal">
                        <span class="glyphicon glyphicon-minus"></span> 批量删除
                    </button>
                    <button type="button" class="btn btn-default" id="refreshBtn2">
                        <span class="glyphicon glyphicon-refresh"></span>
                    </button>
                </div>

                <table class="table table-hover" id="ManageInfo">
                    <thead>
                    <tr>
                        <th><input type="checkbox" onclick="checkAll(this)"></th>
                        <th class="pointer">实验室编号 <span class="glyphicon glyphicon-sort-by-order"></span></th>
                        <th class="pointer">设备编号 <span class="glyphicon glyphicon-sort-by-order"></span></th>
                        <th class="pointer">设备名称 <span class="glyphicon glyphicon-sort-by-alphabet"></span></th>
                        <th>设备型号</th>
                        <th>库存总量</th>
                        <th>修改</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody id="secondTbody"></tbody>
                </table>
            </div>
        </div>

        <!-- Third Content-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" name="content" id="content3">
            <h1 class="sub-header">设备借用信息</h1>
            <div class="table-responsive">
                <!-- Search -->
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="searchId_3" placeholder="学号">
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default" id="refreshBtn3">
                        <span class="glyphicon glyphicon-refresh"></span> Refresh
                    </button>
                </div>
                <table class="table table-hover" id="BorrowInfo">
                    <thead>
                    <tr>
                        <th class="pointer">学号 <span class="glyphicon glyphicon-sort-by-order"></span></th>
                        <th class="pointer">姓名 <span class="glyphicon glyphicon-sort-by-alphabet"></span></th>
                        <th class="pointer">所属学院 <span class="glyphicon glyphicon-sort-by-alphabet"></span></th>
                        <th class="pointer">借用日期 <span class="glyphicon glyphicon-sort-by-order"></span></th>
                        <th>所借设备</th>
                        <th>联系电话</th>
                        <th>借用时长</th>
                        <th>借用目的</th>
                    </tr>
                    </thead>
                    <tbody id="thirdTbody"></tbody>
                </table>
            </div>
        </div>

        <!-- Forth Content-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" name="content" id="content4">
            <h1 class="sub-header">个人信息</h1>
                <form id="personalForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="collegeInput" class="col-sm-3 control-label">所属学院</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="collegeInput" name="collegeInput" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idNo" class="col-sm-3 control-label">学号</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="idNo" type="text" value="<%=username %>" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nameInput" class="col-sm-3 control-label">姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameInput" name="nameInput" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telInput" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="telInput" name="telInput" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                            <button id="personalBtn" type="button" class="btn btn-primary" style="float:right">提交</button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
</div>

<!--------------------------------------------------------------------- Modal Code ------------------------------------------------------------------------->
<!-- 修改密码Modal -->
<div class="modal fade bs-example-modal-sm" id="updatePass" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改密码</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="updatePassForm">
                    <div class="form-group">
                        <label for="oldPass" class="col-sm-3 control-label">原密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="oldPass" name="oldPass"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPass" class="col-sm-3 control-label">新密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="newPass" name="newPass"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPassAgain" class="col-sm-3 control-label">确认新密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="newPassAgain" name="newPassAgain"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="uPass" type="button" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>

<!-- 退出登录提示Modal -->
<div class="modal fade" id="signoutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Warning</h4>
            </div>
            <div class="modal-body">确定要退出么?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                <button id="realOut" type="button" class="btn btn-default">确定</button>
            </div>
        </div>
    </div>
</div>

<!-- 借用设备Modal -->
<div class="modal fade bs-example-modal-sm" id="borrowModal" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">借用设备登记</h4>
            </div>
            <div class="modal-body">
                <form id="borrowForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="StuNo" class="col-sm-3 control-label">学号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="StuNo" value="<%=username%>" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="college" class="col-sm-3 control-label">所属学院</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="college" readonly = "readonly"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="StuName" class="col-sm-3 control-label">姓名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="StuName" readonly = "readonly"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Telenum" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="Telenum" readonly = "readonly"/>
                        </div>
                    </div>
                    <div class="form-group" style="display: none">
                        <label for="borrowFacID" class="col-sm-3 control-label">借用设备编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="borrowFacID" name="borrowFacID" readonly = "readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="borrowFacIn" class="col-sm-3 control-label">借用设备</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="borrowFacIn" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="StartDate" class="col-sm-3 control-label">借用日期</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="StartDate" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="UseDate" class="col-sm-3 control-label">借用时长(天)</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="UseDate" name="UseDate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="UseAim" class="col-sm-3 control-label">借用目的</label>
                        <div class="col-sm-6">
                            <textarea class="form-control" rows="3" id="UseAim" name="UseAim"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="submitBorrow" type="button" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>

<!-- 添加设备Modal -->
<div class="modal fade bs-example-modal-sm" id="addModal" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">添加设备</h4>
            </div>
            <div class="modal-body">
                <!-- Content -->
                <form id="addFacForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <!-- 实验室编号可固定 -->
                        <label for="inputLabNo" class="col-sm-3 control-label">实验室编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="inputLabNo" name="addLabNo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFacNo" class="col-sm-3 control-label">设备编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="inputFacNo" name="addFacNo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFacName" class="col-sm-3 control-label">设备名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="inputFacName" name="addFacName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFacMod" class="col-sm-3 control-label">设备型号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="inputFacMod" name="addFacMod">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="HavaNum" class="col-sm-3 control-label">库存数量</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="HavaNum" name="addHaveNum">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="DetaInfo" class="col-sm-3 control-label">详细信息</label>
                        <div class="col-sm-6">
                            <textarea class="form-control" rows="3" id="DetaInfo" name="addDataInfo"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="submitAdd" type="button" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>

<!-- 修改设备Modal -->
<div class="modal fade bs-example-modal-sm" id="updateModal" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改信息</h4>
            </div>
            <div class="modal-body">
                <form id="updateFacForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="upinputLabNo" class="col-sm-3 control-label">实验室编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="upinputLabNo" name="upinputLabNo"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upinputFacNo" class="col-sm-3 control-label">设备编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="upinputFacNo" name="upinputFacNo" readonly = "readonly"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upinputFacName" class="col-sm-3 control-label">设备名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="upinputFacName" name="upinputFacName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upinputFacMod" class="col-sm-3 control-label">设备型号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="upinputFacMod" name="upinputFacMod"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upStock" class="col-sm-3 control-label">库存总量</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="upStock" name="upStock"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="submitUpdateFac" type="button" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>

<!-- 删除设备提示Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Warning</h4>
            </div>
            <div class="modal-body">删除此条信息后会导致相应的借用记录也随之删除,数据不可恢复,你确定要删除么?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                <button type="button" id="sureDelete" class="btn btn-default">确定</button>
            </div>
        </div>
    </div>
</div>

<!-- 批量删除设备提示Modal -->
<div class="modal fade" id="deleteAllModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Warning</h4>
            </div>
            <div id="deleteAlert" class="modal-body"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-default" id="sureDeleteAll" >确定</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
