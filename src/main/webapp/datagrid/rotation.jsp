<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    $(function () {
        $('#dd').dialog({
            title: '添加管理',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            modal: true,
            closed: true
        });
        $('#btn').linkbutton({
            iconCls: 'icon-search'
        });

        $("#tata").edatagrid({
            destroyUrl: "${pageContext.request.contextPath}/banner/delete",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/queryAll',
            pagination: true,
            fitColumns: true,
            fit: true,
            columns: [[
                {field: 'name', title: '名字', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'description', title: '描述', width: 100},
                {field: 'creatDate', title: '上传日期', width: 100, align: 'right'}
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加按钮',
                handler: function () {
                    $('#dd').dialog("open");
                }
            }, {
                iconCls: 'icon-edit',
                text: '修改按钮',
                handler: function () {
                    var row = $("#tata").edatagrid("getSelected");
                    if (row == null) {
                        alert("请先选中行")
                    } else {
                        var index = $("#tata").edatagrid("getRowIndex", row);
                        $("#tata").edatagrid("editRow", index);
                    }
                }
            }, {
                iconCls: 'icon-remove',
                text: '删除按钮',
                handler: function () {
                    $("#tata").edatagrid('destroyRow');
                }
            }, {
                iconCls: 'icon-save',
                text: '保存按钮',
                handler: function () {
                    var row = $("#tata").edatagrid("getSelected");
                    $("#tata").edatagrid("saveRow");
                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="../pic/' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.description + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '<p>Status: ' + rowData.creatDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

    });
    function doadd() {
        $("#ac").form("submit", {
            url: "${pageContext.request.contextPath}/banner/insert",
            success: function (data) {
                if (data == "true") {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
                //关闭修改对话框
                $("#dd").dialog("close");
                //刷新datagrid
                $("#tata").datagrid("reload");
            }
        });
    }
</script>


<table id="tata"></table>

<div id="dd">
    <form id="ac" method="post" enctype="multipart/form-data" >
        名字：<input id="tb" name="name" type="text"/><br>
        图片：<input id = "to" type="file" name = "pic" ><br>
        图片状态：<input type="radio" checked="checked" value="0" name="status" id="td"/> 显示 <input type="radio" name="status" value="1" id="te"/>不显示<br>
        描述信息：<input type="text" name="description" id="tf"/><br>
        <a id="btn" href="#" onclick="doadd()">立即添加</a>
    </form>
</div>