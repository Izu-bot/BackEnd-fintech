<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar</title>
</head>
<%@ include file="header.jsp" %>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	
	<c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
</c:if>
<c:if test="${not empty erro }">
	<div class="alert alert-danger">${erro}</div>
</c:if>

<h1>Gastos</h1>
		<table class="table table-striped">
			<tr>
				<th>Nome</th>
				<th>Valor</th>
				<th>Descrição</th>
			</tr>
			<c:forEach items="${gasto}" var="g">
				<tr>
					<td>${g.nome}</td>
					<td>${g.valor}</td>
					<td>${g.descricao}</td>
					<td>
						<c:url value="gasto" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigo" value="${g.codigoGasto}" />
						</c:url>
						<a href="${link}" class="btn btn-primary btn-xs" >Editar</a>
						<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#excluirModal" onclick="codigoExcluir.value = ${g.codigoGasto}" >
  Excluir
</button>
					</td>
				</tr>
				</c:forEach>
		</table>
	</div>


<div class="modal fade" id="excluirModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir o produto?
      </div>
      <div class="modal-footer">
      	<form action="gasto" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigo" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>


<%@ include file="footer.jsp" %>

</body>
</html>