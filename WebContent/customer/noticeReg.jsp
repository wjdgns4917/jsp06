<%@page import="notice.vo.Notice"%>
<%@page import="notice.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>noticeReg.jsp</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<form action="noticeRegProc.jsp" method="post">
	<table class="twidth">
	<colgroup>
		<col width="15%"/>
		<col width="35%"/>
		<col width="15%"/>
		<col width="35%"/>
	</colgroup>
	<caption>Write</caption>
	<tbody>
		
		<tr>
			<th class="left">제목</th>
			<td colspan="3">
			<input class="inp" name="title" />
			</td>
		</tr>
		<tr>
			<th class="left">내용</th>
			<td colspan="3" id="content">
			<textarea class="txt" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<th class="left">첨부</th>
			<td colspan="3" id="addfile">
			첨부
			</td>
		</tr>
	</tbody>
</table>
<div>

	<input type="submit"  value="save" />
	<input type="button"  value="cancel" class="cancel"/>
</form>
</body>
</html>