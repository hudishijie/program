<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>部门列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				部门名称
			</td>
			<td>
				上级部门名称
			</td>
			<td>
				职能说明
			</td>
			
			<td>
				相关操作
			</td>
		</tr>
		<s:iterator value="departmentList">
		<tr>
			<td>
				${name}
			</td>
			<td>
				${parent.name}
			</td>
			<td>
				${description}
			</td>
			<td>
				<s:a action="department_delete?id=%{id}">删除</s:a>&nbsp;&nbsp;
				<s:a action="department_editUI?id=%{id}">修改</s:a>&nbsp;&nbsp;
			</td>
		</tr>
		</s:iterator>
	</table>
	<s:a action="department_addUI">新建</s:a>
</body>
</html>