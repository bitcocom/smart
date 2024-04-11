<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
          Hello Java Spring~~~(박매일)<br/>
          <%
              java.util.Date date=new java.util.Date();
          %>
          지금 시간은? <%=date.toString()%>(동적인 데이터)
</body>
</html>