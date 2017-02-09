Messenger.options = {
    extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
    theme: 'air'
};

$(document).ready(function () {
   $("[value=submit]").click(function () {
      $.ajax({
         type: "POST",
         url: "/loginServlet",
         dataType: "text",
         data: $("#loginForm").serialize(),
         success: function(data) {
             if(data=="true")
                 location.href = "/Index/index.jsp";
             else if(data=="false") {
                 Messenger().post({message: '账户名或密码错误 登录失败 请重试', type: 'error', showCloseButton: true});
             }
         }
      });
   });
});