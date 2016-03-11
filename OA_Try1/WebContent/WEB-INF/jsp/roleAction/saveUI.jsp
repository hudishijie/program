<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="role_%{id == null ? 'add':'edit'}">
		<s:hidden name="id" value="%{id}"></s:hidden>
		<table>
			<tr>
				<td>
					<s:textfield name="name" value="%{name}">岗位名称: </s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="description" value="%{description}">岗位职责: </s:textfield>
				</td>
			</tr>
		</table>
	<input type="submit"  value="保存"/>
	</s:form>
</body>
</html>