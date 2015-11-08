<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>

<jsp:include page="../base/common.jsp" flush="true" />

<script type="text/javascript">  
        jQuery.ajaxSetup({cache:false});//ajax不缓存  
        jQuery(function($){  
              
        });  
          
        function setmain(title,href){  
            $(".combo-panel").parent(".panel").remove(); //<span style="color: #0000ff;">清楚所有class为combo-panel的class为panel的父元素，解决combobox在页面缓存的问题</span>  
  
  
            var centerURL = href;  
            var centerTitle = title;  
            $('body').layout('panel','center').panel({  
                title:"所在位置："+centerTitle,  
                href:centerURL  
            });  
            $('body').layout('panel','center').panel('refresh');  
            return false;         
        }  
          
        //弹出窗口  
        function showWindow(options){  
            jQuery("#MyPopWindow").window(options);  
        }  
        //关闭弹出窗口  
        function closeWindow(){  
            $("#MyPopWindow").window('close');  
        }  
    </script>
</head>
<!-- easyui-layout 可分上下左右中五部分，中间的是必须的，支持href，这样就可以不用iframe了 -->
<body class="easyui-layout" id="mainBody">
	<!-- 上 -->
	<div region="north" split="false"
		style="height:100px;text-align: center;" border="false">
		<h1>欢迎： ${userSessionInfo.name}</h1>
	</div>

	<!-- 左-->
	<div region="west" class="menudiv" split="true" title="系统菜单"
		style="width:200px;overflow:hidden;">
		<div id="menuDiv" class="easyui-accordion" fit="false" border="false"
			animate="false">
			<div title="用户管理" style="overflow:hidden;">
				<ul>
					<li id="rightLi${child.id}" style="cursor: pointer;"
						onclick="setmain('用户管理','<%=basePath%>/article/hello')">用户管理</li>
				</ul>
				<ul>
					<li id="rightLi${child.id}" style="cursor: pointer;"
						onclick="setmain('用户管理','<%=basePath%>/article/index')">用户管理</li>
				</ul>
				<ul>
					<li id="rightLi${child.id}" style="cursor: pointer;"
						onclick="setmain('用户管理','<%=basePath%>/article/list')">用户管理</li>
				</ul>
			</div>
			<div title="部门管理" style="overflow:hidden;">
				<ul>
					<li id="rightLi${child.id}">部门管理</li>
					<li id="rightLi${child.id}">部门管理</li>
				</ul>
			</div>
			<div title="XXX管理" style="overflow:hidden;">
				<ul>
					<li id="rightLi${child.id}">XXX管理</li>
					<li id="rightLi${child.id}">XXX管理</li>
				</ul>
			</div>
			<div title="XXX管理" style="overflow:hidden;">
				<ul>
					<li id="rightLi${child.id}">XXX管理</li>
					<li id="rightLi${child.id}">XXX管理</li>
					<li id="rightLi${child.id}">XXX管理</li>
				</ul>
			</div>
		</div>
	</div>

	<!-- 中 -->
	<div region="center" class="maindiv" title="所在位置: 首页" style="overflow-x:hidden;padding: 0px;">
		<span style="color: #ff0000;"><a href="<%=basePath %>/static/html/datagrid/Basic.html">主页面</a></span>
    </div>
	<div id="MyPopWindow" modal="true" shadow="false" minimizable="false"
		cache="false" maximizable="false" collapsible="false"
		resizable="false" style="margin: 0px;padding: 0px;overflow: auto;"></div>
</body>
</html>
