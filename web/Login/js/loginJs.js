Messenger.options = {
    extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
    theme: 'air'
};

$(document).ready(function () {
   $("[value=submit]").click(function () {
       var reg = /^[A-Za-z0-9]+$/;
       if($("#username").val().trim()==""||$("#password").val().trim()=="")
           Messenger().post({message: '用户名或密码为空', type: 'error', showCloseButton: true});
       else if($("#username").val().match(reg) == null)
           Messenger().post({message: '用户名只能包含字母和数字 请重试', type: 'error', showCloseButton: true});
       else if($("#password").val().match(reg) == null)
           Messenger().post({message: '密码只能包含字母和数字 请重试', type: 'error', showCloseButton: true});
       else {
           $.ajax({
               type: "POST",
               url: "/loginServlet",
               dataType: "text",
               data: $("#loginForm").serialize(),
               success: function(data) {
                   if(data=="true")
                       location.href = "/Index/index.jsp";
                   else if(data=="false") {
                       Messenger().post({message: '用户名或密码错误 登录失败 请重试', type: 'error', showCloseButton: true});
                   }
               }
           });
       }
   });
});