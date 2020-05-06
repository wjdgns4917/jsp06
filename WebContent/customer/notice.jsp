<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
String sql="select * from notices order by to_number(seq) desc";
//db connect
//드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
//접속
String url="jdbc:oracle:thin:@localhost:1521:orcl";
String user="scott";
String pw="123456";
Connection conn=DriverManager.getConnection(url, user, pw);
//실행
Statement st=conn.createStatement();
//결과
ResultSet rs=st.executeQuery(sql);
%>    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>notice.jsp</title>
</head>
<body>
<table width="500" border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<%
	while(rs.next()){
	%>
	<tr>
		<td><%=rs.getString("seq")%></td>
		<td> <a href="noticeDetail.do?c=<%=rs.getString("seq")%>"><%=rs.getString("title")%></a></td>
		<td><%=rs.getString("writer")%></td>
		<td><%=rs.getDate("regdate")%></td>
		<td><%=rs.getInt("hit")%></td>
	</tr>
	<%
	}
	%>
</table>
<a href="noticeReg.jsp">Write</a>
</body>
</html>
<%
rs.close();
st.close();
conn.close();
%>