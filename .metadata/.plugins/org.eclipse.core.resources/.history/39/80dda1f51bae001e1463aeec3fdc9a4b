<%@page import = "java.text.*" %>
<%@page import = "java.util.*" %>
<%@page import = "com.greenmart.connection.*"%>
<%@page import = "com.greenmart.model.*"%>
<%@page import = "com.greenmart.dao.*"%>
<%@page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding = "ISO-8859-1"%>
<%
	DecimalFormat df = new DecimalFormat("#.##");
	request.setAttribute("df", df);

	UserModel auth = (UserModel) request.getSession().getAttribute("auth");
	if (auth != null){
		request.setAttribute("auth", auth);
	}
	
	ArrayList<CartModel> cart_list = (ArrayList<CartModel>) session.getAttribute("cart-list");
	List<CartModel> cartProduct = null;
	if(cart_list != null){
		productDao pDao = new productDao(dbCon.getConnection());
		cartProduct = pDao.getCartProducts(cart_list);
		double total = pDao.getTotalCartPrice(cart_list);
		request.setAttribute("cart_list", cart_list);
		request.setAttribute("total", total);
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<title>Shopping Cart</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
		
		<style type = "text/css">
			.table tbody td{
				vartical-align: middle;
			} 
			
			.btn-incre, .btn-decre{
				box-shadow: none;
				font-size: 25px;
			}
		</style>
		
        <!--Favicon-->
		<link rel="icon" type="image/x-icon" href="images/favicon.ico" />
	</head>
	
	<body>
		<div class = "container">
			<div class = "d-flex py-3">
				<h3>Total Price: Rs. ${ (total>0)?df.format(total):0 }</h3>
				<a class = "mx-3 btn btn-primary" href = "#">Check Out</a>
			</div>
			
			<table class = "table table-light">
				<thead>
					<tr>
						<th scope = "col">Name</th>
						<th scope = "col">Price</th>
						<th scope = "col">Buy Now</th>
						<th scope = "col">Cancel</th>
					</tr>
				</thead>
				<tbody>
				<% if (cart_list != null){
						for(CartModel c:cartProduct){%>
							<tr>
							<td><%= c.getName() %></td>
							<td>Rs. <%= df.format(c.getPrice()) %></td>
							<td>
								<form method = "POST" action = "" class = "form-inline">
									<input type = "hidden" name = "id" value = "<%= c.getProductID() %>" class = "form-input">
									<div class = "form-group d-flex justify-content-between">
										<a class = "btn btn-sm btn-decre" href = "quantityincdec?action=dec&id=<%= c.getProductID() %>"><i class = "fas fa-minus-square"></i></a>
										<input type = "text" name = "quantity" class = "form-control" value = "<%= c.getQuantity() %>" readonly>
										<a class = "btn btn-sm btn-incre" href = "quantityincdec?action=inc&id=<%= c.getProductID() %>"><i class = "fas fa-plus-square"></i></a>
									</div>
								</form>
							</td>
							<td>
								<a href = "removecart?id=<%= c.getProductID() %>" class = "btn btn-sm btn-danger">Remove</a> 
							</td>
						</tr>
						<%}
					}
				%>
					
				</tbody>			
			</table>
		</div>
		
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/js/all.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	</body>
</html>