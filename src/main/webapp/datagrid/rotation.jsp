
<script type="text/javascript">
    $(function(){
       $("#tata").datagrid({
           url:'datagrid_data.json',
           columns:[[
               {field:'code',title:'Code',width:100},
               {field:'name',title:'Name',width:100},
               {field:'price',title:'Price',width:100,align:'right'}
           ]]
       });
    });
</script>





<table id="tata"></table>