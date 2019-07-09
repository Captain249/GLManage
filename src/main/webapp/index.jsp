<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    response.sendRedirect("user/toLogin");
%>
<%--<script>
    layui.use('table', function () {
        var table = layui.table;

        //渲染
        table.render({
            elem: '#test'  //绑定table表格
            , height: 450
            , url: '<%=request.getContextPath()%>/admin/backContent' //后台springmvc接收路径
            , page: true    //true表示分页
            , limit: 10
            , id: 'contenttable'
            , toolbar: '#toolbarDemo'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'id', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'content', title: '内容', width: 120}
                , {field: 'userid', title: '用户id', width: 80, sort: true}
                , {field: 'nice', title: '点赞数', width: 100}
                , {field: 'createtime', title: '分享时间', width: 80, sort: true}
                , {
                    field: 'pic1',
                    title: '图片1',
                    width: 120,
                    templet: '<div><img src="http://localhost:8089/SharedImageServer/contentpic/{{ d.pic1}}"></div>'
                }
                , {
                    field: 'pic2',
                    title: '图片2',
                    width: 120,
                    templet: '<div><img src="http://localhost:8089/SharedImageServer/contentpic/{{ d.pic2}}"></div>'
                }
                , {
                    field: 'pic3',
                    title: '图片3',
                    width: 120,
                    templet: '<div><img src="http://localhost:8089/SharedImageServer/contentpic/{{ d.pic3}}"></div>'
                }
            ]]
        });


        var $ = layui.jquery, active = {

            reload: function () {
                var keyWord = $("#keyWord").val();
                var keyType = $("#key_type option:selected").val();
                table.reload('contenttable', {
                    method: 'post',
                    where: {keyWord: keyWord, keyType: keyType}
                });
            }
        };

        $('.layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

</script>--%>
