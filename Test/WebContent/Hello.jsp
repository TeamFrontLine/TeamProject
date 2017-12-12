<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재시간</title>
</head>
<body>
 <% java.util.Date today = new java.util.Date(); %>
 <% out.print("현재 시각은 [" + today +"] 입니다"); %>
</body>