<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

	<div class="container">
		<h1>Edição de Usuario</h1>
		<form action="usuario" method="post">
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${usuario.codigoUsuario}" name="codigo">
		<div class="form-goup">
			<label for="id-senha">Senha</label>
			<input type="password" name="senha" id="id-senha" class="form-control" value="${usuario.senha}" />
		</div>
		<div class="form-goup">
			<label for="id-email">Email</label>
			<input type="email" name="email" id="id-email" class="form-control" value="${usuario.email}" />
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
		<a href="usuario?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>