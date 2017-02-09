/**
 * Created by Administrator on 2017/2/3.
 */
//初始化弹窗样式以及位置
Messenger.options = {
    extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
    theme: 'air'
};

//修改密码ajax
$(document).ready(function () {
    $("#uPass").click(function () {
        if($("#newPass").val()==$("#newPassAgain").val()) {
            $.ajax({
                type: "POST",
                url: "/updatePassServlet",
                dataType: "text",
                data: $("#updatePassForm").serialize(),
                success: function(data) {
                    if(data=="success"){
                        Messenger().post({message: '修改成功', type: 'success', showCloseButton: true});
                        $("#updatePass").modal('hide');
                    }
                    else if(data=="updateFail")
                        Messenger().post({message: '修改失败 请重试', type: 'error', showCloseButton: true});
                    else if(data=="checkFail")
                        Messenger().post({message: '原密码输入错误 请重试', type: 'error', showCloseButton: true});
                    else
                        Messenger().post({message: '未知错误', type: 'error', showCloseButton: true});
                }
            });
        } else {
            Messenger().post({message: '两次密码输入不符 请重试', type: 'error', showCloseButton: true});
        }
    });
});

//退出登录 页面重定向到login.jsp
$(document).ready(function () {
   $("#realOut").click(function () {
       location.href = "/Login/login.jsp";
   });
});

//添加设备ajax
$(document).ready(function () {
    $("#submitAdd").click(function () {
        $.ajax({
            type: "POST",
            url: "/addFacServlet",
            dataType: "text",
            data: $("#addFacForm").serialize(),
            success: function(data) {
                if(data=="success"){
                    Messenger().post({message: '添加成功', type: 'success', showCloseButton: true});
                    $("#addModal").modal('hide');
                    window.location.reload();
                }
                else if(data=="insertFail")
                    Messenger().post({message: '添加失败 请重试', type: 'error', showCloseButton: true});
                else if(data=="repeatFail")
                    Messenger().post({message: '添加失败 设备重复 请重试', type: 'error', showCloseButton: true});
                else
                    Messenger().post({message: '未知错误', type: 'error', showCloseButton: true});
            }
        });
    });
});

//个人信息ajax
$(document).ready(function () {
    $("#personalBtn").click(function () {
        $.ajax({
            type: "POST",
            url: "/personalServlet",
            dataType: "text",
            data: $("#personalForm").serialize(),
            success: function(data) {
                if(data=="success") {
                    Messenger().post({message: '提交成功', type: 'success', showCloseButton: true});
                    window.location.reload();
                }
                else if(data=="fail")
                    Messenger().post({message: '提交失败 请重试', type: 'error', showCloseButton: true});
                else
                    Messenger().post({message: '未知错误', type: 'error', showCloseButton: true});
            }
        });
    });
});

//借用设备ajax
$(document).ready(function () {
    $("#submitBorrow").click(function () {
        $.ajax({
            type: "POST",
            url: "/borrowServlet",
            dataType: "text",
            data: $("#borrowForm").serialize(),
            success: function(data) {
                if(data=="success"){
                    Messenger().post({message: '提交成功', type: 'success', showCloseButton: true});
                    $("#borrowModal").modal('hide');
                    window.location.reload();
                }
                else if(data=="fail")
                    Messenger().post({message: '提交失败 请重试', type: 'error', showCloseButton: true});
                else
                    Messenger().post({message: '未知错误', type: 'error', showCloseButton: true});
            }
        });
    });
});

//修改设备ajax
$(document).ready(function () {
    $("#submitUpdateFac").click(function () {
        $.ajax({
            type: "POST",
            url: "/updateFacServlet",
            dataType: "text",
            data: $("#updateFacForm").serialize(),
            success: function(data) {
                if(data=="success"){
                    Messenger().post({message: '修改成功', type: 'success', showCloseButton: true});
                    $("#updateModal").modal('hide');
                    window.location.reload();
                }
                else if(data=="fail")
                    Messenger().post({message: '修改失败 请重试', type: 'error', showCloseButton: true});
                else
                    Messenger().post({message: '未知错误', type: 'error', showCloseButton: true});
            }
        });
    });
});

//删除设备ajax
$(document).ready(function () {
    var facIdd;
    $("[name='deleteBtn']").click(function () {
        facIdd = $(this).parents("tr").find("td").eq(2).text().trim();  //删除设备编号
    });
    $("#sureDelete").click(function () {
        $.ajax({
            type: "POST",
            url: "/deleteServlet",
            dataType: "text",
            data: {facid:facIdd},
            success: function(data) {
                if(data=="success"){
                    window.location.reload();
                    Messenger().post({message: '删除成功', type: 'success', showCloseButton: true});
                }
                else if(data=="fail")
                    Messenger().post({message: '删除失败 请重试', type: 'error', showCloseButton: true});
                else
                    Messenger().post({message: '未知错误', type: 'error', showCloseButton: true});
            }
        });
    });
});

$(document).ready(function () {
   $("[name='borrowBtn']").click(function () {
       var facName = $(this).parents("tr").find("td").eq(2).text().trim();//设备名称
       var facId = $(this).parents("tr").find("td").eq(1).text().trim();//设备编号
       $("#borrowFacIn").val(facName);
       $("#borrowFacID").val(facId);
   });
});

$(document).ready(function () {
   $("[name='updateBtn']") .click(function () {
       $("#upinputLabNo").val($(this).parents("tr").find("td").eq(1).text().trim());
       $("#upinputFacNo").val($(this).parents("tr").find("td").eq(2).text().trim());
       $("#upinputFacName").val($(this).parents("tr").find("td").eq(3).text().trim());
       $("#upinputFacMod").val($(this).parents("tr").find("td").eq(4).text().trim());
       $("#upStock").val($(this).parents("tr").find("td").eq(5).text().trim());
   });
});

$(function(){
   $("#refreshBtn").click(function () {
       refresh_2();
   });
});

//刷新table
function refresh_1() {
    
}

function refresh_2() {
    $.post("/jsonServlet",{No:"2"},function (data) {
        alert(data);
    });
}

