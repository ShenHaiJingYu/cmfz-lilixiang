<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<script type="text/javascript">
    $(function (){
        $('#yyy').dialog({
            title: '专辑详情',
            width: 400,
            height: 300,
            cache: false,
            modal: true,
            closed: true
        });
        $('#lll').dialog({
            title: '专辑详情',
            width: 400,
            height: 300,
            cache: false,
            modal: true,
            closed: true
        });
        $('#ppppp').dialog({
            title: '添加章节',
            width: 400,
            height: 200,
            cache: false,
            modal: true,
            closed: true
        });
        $('#ooo').dialog({
            title: '添加专辑',
            width: 400,
            height: 200,
            cache: false,
            modal: true,
            closed: true
        });
        $('#ccc').linkbutton({
            iconCls: 'icon-search'
        });
        $('#fff').linkbutton({
            iconCls: 'icon-search'
        });
        $('#oo').treegrid({
            url:'${pageContext.request.contextPath}/album/getAll',
            idField:'id',
            treeField:'name',
            onDblClickRow:function(row){
                $("#b1").val(row.name);
                $("#au").prop("src","${pageContext.request.contextPath}/miaoyin/"+row.url);
                $('#yyy').dialog("open");
            },
            columns:[[
                {field:'name',title:'名字',width:180},
                {field:'url',title:'下载路径',width:60,align:'right'},
                {field:'size',title:'章节大小',width:80},
                {field:'duration',title:'章节时长',width:80}
            ]],
            fit:true,
            fitColumns:true,
            toolbar: [{
                iconCls: 'icon-edit',
                text:'专辑详情',
                handler: function(){
                    var row = $('#oo').treegrid("getSelected");
                    if (row == null) {
                        alert("请先选中专辑");
                    } else {
                        $("#a1").prop("src","../pic/"+row.coverImg);
                        $("#a2").val(row.name);
                        $("#a3").val(row.count);
                        $("#a4").val(row.score);
                        $("#a5").val(row.author);
                        $("#a6").val(row.broadCast);
                        $("#a7").val(row.publishDate);
                        $('#lll').dialog("open");
                    }
                }
            },{
                iconCls: 'icon-help',
                text:'添加专辑',
                handler: function(){
                    $('#ooo').dialog("open");
                }
            },{
            iconCls: 'icon-edit',
                text:'添加章节',
                handler: function(){
                    var row = $('#oo').treegrid("getSelected");
                    if (row == null) {
                        alert("请先选中专辑");
                    } else {
                        $("#iii").val(row.id);
                        $('#ppppp').dialog("open");
                    }

                }
            },{
                iconCls: 'icon-edit',
                text:'章节下载',
                handler: function(){
                    var row = $('#oo').treegrid("getSelected");
                    if (row == null) {
                        alert("请先选中专辑");
                    }else{
                        window.location="${pageContext.request.contextPath}/chapter/testDownload?fileName="+row.url;
                    }
                }
            }]
        });
    });
    function doinsert() {
        $("#aaa").form("submit", {
            url: "${pageContext.request.contextPath}/album/insert",
            success: function (data) {
                if (data == "true") {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
                //关闭修改对话框
                $("#ooo").dialog("close");
                //刷新datagrid
                $("#oo").treegrid("reload");
            }
        });
    }
    function goinsert() {
        $("#bbb").form("submit", {
            url: "${pageContext.request.contextPath}/chapter/insert",
            success: function (data) {
                if (data == "true") {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
                //关闭修改对话框
                $("#ppppp").dialog("close");
                //刷新datagrid
                $("#oo").treegrid("reload");
            }
        });
    }
</script>



<table id="oo"></table>

<div id="ooo">
    <form id="aaa" method="post" enctype="multipart/form-data" >
        专辑名字：<input name="name" type="text"/><br>
        封面图片：<input type="file" name = "pic" ><br>
        评分：<input type="text" name="score"><br>
        作者：<input type="text" name="author"><br>
        播音：<input type="text" name="broadCast"><br>
        简介：<input type="text" name="brief"/><br>
        <a id="fff" href="#" onclick="doinsert()">立即添加</a>
    </form>
</div>
<div id="ppppp">
    <form id="bbb" method="post" enctype="multipart/form-data" >
        章节名字：<input name="name" type="text"/><br>
        音频文件：<input type="file" name = "mou" /><br>
        <input type="text" hidden="hidden" id = "iii" name = "album_id" ><br>
        <a id="ccc" href="#" onclick="goinsert()">立即添加</a>
    </form>
</div>
<div id="lll">
    <form  method="post" action="" >
        <img id = "a1" width="50px" height="50px" /><br>
        专辑名：<input id = "a2"type="text" readonly="readonly"/><br>
        章节数量：<input id = "a3"type="text" readonly="readonly"/><br>
        评分：<input id = "a4"type="text" readonly="readonly"/><br>
        作者：<input id = "a5"type="text" readonly="readonly"/><br>
        播音：<input id = "a6"type="text" readonly="readonly"/><br>
        上架日期：<input id = "a7"type="text" readonly="readonly"/><br>
    </form>
</div>

<div id="yyy">
    章节名:<input id = "b1"type="text" readonly="readonly"/><br>
    <audio id = "au" controls="controls" loop="loop" autoplay="autoplay"></audio>
</div>

