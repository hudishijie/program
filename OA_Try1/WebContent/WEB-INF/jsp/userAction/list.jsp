<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>岗位列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				序号
			</td>
			<td>
				岗位名称
			</td>
			<td>
				岗位职责
			</td>
			
			<td>
				操作
			</td>
		</tr>
		<s:iterator value="roleList">
		<tr>
			<td>
				${id}
			</td>
			<td>
				${name}
			</td>
			<td>
				${description}
			</td>
			<td>
				<s:a action="role_delete?id=%{id}">删除</s:a>&nbsp;&nbsp;
				<s:a action="role_editUI?id=%{id}">修改</s:a>&nbsp;&nbsp;
				<s:a action="role_setPrivilegeUI?id=%{id}">设置权限</s:a>
			</td>
		</tr>
		</s:iterator>
	</table>
	<s:a action="role_addUI">新建</s:a>
</body>
</html>