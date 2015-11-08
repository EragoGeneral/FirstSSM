<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<jsp:include page="../base/common.jsp" flush="true" />
</head>

<body class="easyui-layout">
	<script type="text/javascript">  
        var index = 0;  
        function addPanel(url,title,tabId){  
        	/*if($("#"+tabId).html()==null){    
		        var name = 'iframe_'+tabId;    
		        $('#centerTab').tabs('add',{    
		            title: title,             
		            closable:true,    
		            cache : false,    
		            //注：使用iframe即可防止同一个页面出现js和css冲突的问题    
		            content : '<iframe name="'+name+'" id="'+tabId+'" src="'+url+'" width="100%" height="100%" frameborder="0" scrolling="auto" ></iframe>'    
		        });    
		    }*/    
        
        	var name = 'iframe_'+tabId;
            if($('#'+tabId).html()==null){  
                $('#tt').tabs('add',{  
                    title: title,     
		            cache : false, 
                    content: '<iframe name="'+ name +'" id="'+ tabId +'" src="'+url+'" frameBorder="0" border="0"  style="width: 100%; height: 100%;"/>',  
                    closable: true  
                });  
            }else{  
                $('#tabs').tabs('select', title);  
            }  
        }  
        function removePanel(){  
            var tab = $('#tt').tabs('getSelected');  
            if (tab){  
                var index = $('#tt').tabs('getTabIndex', tab);  
                $('#tt').tabs('close', index);  
            }  
        }  
    </script>

	<div data-options="region:'north',title:'North Title',split:true"
		style="height:100px;"></div>
	<div data-options="region:'south',title:'South Title',split:true"
		style="height:100px;"></div>
	<div data-options="region:'east',title:'East',split:true"
		style="width:100px;"></div>
	<div data-options="region:'west',title:'West',split:true"
		style="width:150px;">
		<ul id="tt1" class="easyui-tree">
			<li><span>Folder</span>
				<ul>
					<li><span>Sub Folder 1</span>
						<ul>
							<li><span><a href="javascript:void(0)"
									onclick="addPanel('/FirstSSM/article/list','tab1',1)">File 11</a>
							</span>
							</li>
							<li><span><a href="javascript:void(0)"
									onclick="addPanel('/FirstSSM/article/index','tab2',2)">File 11</a>
							</span>
							</li>
							<li><span><a href="javascript:void(0)"
									onclick="addPanel('tab1.jsp','tab3',3)">File 11</a>
							</span>
							</li>
						</ul></li>
					<li><span><a href="javascript:void(0)"
							onclick="addPanel('tab1.jsp','tab4',4)">File 11</a>
					</span>
					</li>
					<li><span><a href="javascript:void(0)"
							onclick="addPanel('tab1.jsp','tab5',5)">File 11</a>
					</span>
					</li>
				</ul></li>
			<li><span><a href="javascript:void(0)"
					onclick="addPanel('tab1.jsp','tab6')">File 11</a>
			</span>
			</li>
		</ul>

	</div>
	<div id="tt" data-options="region:'center',title:'center title'"
		class="easyui-tabs" style="padding:5px;background:#eee;">
	</div>

</body>
</html>