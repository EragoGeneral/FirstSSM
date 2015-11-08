<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 启用EL表达式 -->
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>模板管理</title>

<jsp:include page="../base/common.jsp" flush="true" />

<script type="text/javascript">
	/**  
	 * 创建新选项卡  
	 * @param tabId    选项卡id  
	 * @param title    选项卡标题  
	 * @param url      选项卡远程调用路径  
	 */
	function addTab(tabId, title, url) {
		//如果当前id的tab不存在则创建一个tab  
		if ($("#" + tabId).html() == null) {
			var name = 'iframe_' + tabId;
			$('#centerTab')
					.tabs(
							'add',
							{
								title : title,
								closable : true,
								cache : false,
								content : '<iframe name="'
										+ name
										+ '"id="'
										+ tabId
										+ '"src="'
										+ url
										+ '" width="100%" height="100%" frameborder="0" scrolling="auto" ></iframe>'
							});
		} else {
			$('#centerTab').tabs('select', title);
		}
	}
</script>

</head>

<!-- 主界面的框架 -->
<body class="easyui-layout">
	<!-- 北边区域 -->
	<div data-options="region:'north',border:false"
		style="height:60px;background:#B3DFDA;padding:10px">考试系统</div>
	<!-- 各个模块 -->
	<div data-options="region:'west',split:true,title:'功能索引'"
		style="width:150px;padding:10px;">
		<!-- 子模块：模板管理 -->
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="模板配置" style="padding:10px;">
				<li><a href="javascript:addTab('tabId_templet','模板管理','/FirstSSM/article/list');">模板管理</a>
				</li>
				<li><a 	href="javascript:addTab('tabId_datagrid','datagrid模板','/FirstSSM/article/index');">datagrid</a>
				</li>
			</div>
		</div>
	</div>
	<!-- 东部区域 -->
	<div data-options="region:'east',split:true"
		style="width:10px;padding:10px;"></div>
	<!-- 底部 -->
	<div data-options="region:'south',border:false"
		style="height:50px;background:#A9FACD;padding:10px;">
		<div id="footer">Copyright &copy; 2014 TGB-9 廊坊师范学院信息技术提高班</div>
	</div>
	<!-- 中央布局 -->
	<div data-options="region:'center'" fit="true" border="false">
		<div class="easyui-tabs" id="centerTab" fit="true" border="false">
			<div title="欢迎页" style="padding:20px;overflow:hidden;">
				<div style="margin-top:20px;">
					<h3>你好，欢迎来到系统</h3>
				</div>
			</div>
		</div>
	</div>
</body>

</html>