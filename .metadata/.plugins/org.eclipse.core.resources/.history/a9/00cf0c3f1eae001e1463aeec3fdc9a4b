<%@ page import = "java.util.*"%>
<%@ page import = "com.greenmart.dao.*"%>
<%@ page import = "com.greenmart.connection.*"%>
<%@ page import = "com.greenmart.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	productDao pd = new productDao(dbCon.getConnection());
	List<ProductModel> products = pd.getAllProducts();
	
	UserModel auth = (UserModel) request.getSession().getAttribute("auth");
	if (auth != null){
		request.setAttribute("auth", auth);
	}
	
	ArrayList<CartModel> cart_list = (ArrayList<CartModel>) session.getAttribute("cart-list");
	if(cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GreenMart</title>

        <!--Stylesheet-->
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <!--Favicon-->
		<link rel="icon" type="image/x-icon" href="images/favicon.ico" />

        <script src = 'js/index.js' defer></script>
    </head>

    <body>
        <!--nav-->
        <nav class="navigation">

            <!--logo-->
            <a href="#" class="logo">
                <span>Green</span>Mart
            </a>

            <!--menu-->
            <ul class="menu">
                <li>
                    <a href="index.jsp" class="active"> 
                        Home
                    </a>
                </li>

				<li>
					<a href="AboutUs.jsp">
						About&nbsp;us
					</a>
                </li>
				
				<%
				if (session.getAttribute("name") != null){%>
	                <li>
	                    <a href="logout">
	                        Logout
	                    </a>
	                </li>
				<%} else {%>
					<li>
                    <a href="login.jsp">
                        Login
                    </a>
                </li>
                
                <li>
                    <a href="signup.jsp">
                        Sign&nbsp;Up
                    </a>
                </li>
				<%}%>
			</ul>

            <!--right-nav-(cart-like)-->
            <div class="right-nav">
                <!--cart-->
                <a href="ShoppingCart.jsp" class="cart">
                    <i class="fa-solid fa-cart-shopping">
                    	<span>${cart_list.size() }</span>
                    </i>
                </a>
            </div>
        </nav>
        <!--nav-end-->

        <!--banner-->
        <section id="banner">

            <!--bg-->
            <img alt="bg" class="bg-1" src="images/banner.jpg">

            <!--text-->
            <div class="banner-text">
                <h1>  
                    Order Your Daily Groceries <br>and Essential Needs
                </h1>

                <br>

                <h3 style="color: rgb(0, 0, 0); text-align: center;" >
                    Your Fresh Choice for a Greener Life
                </h3>
            </div>
        </section>
        <!--main-banner-end-->
        
        <!--products-->
        <section id="product">
            <!--heading-->
            <div class="product-heading">
                <h3>Products</h3>
            </div>

            <!--box-container-->
            <div class="product-container">
            <%
                	if(!products.isEmpty()){
                		for(ProductModel p:products){%>
                			<div class="product-box">
                            <img alt="<%= p.getName()%>" src="<%= p.getImage() %>">
                            <strong><%= p.getName() %></strong>
                            <span class="quantity"><%= p.getSize() %></span>
                            <span class="price">Rs. <%= p.getPrice() %></span>
                            <!--cart-btn-->
                            <a href="add-to-cart?id=<%= p.getProductID() %>" class="cart-btn">
                                Add to cart
                            </a>
                        </div>
                		<%}
                	}
            %>
            </div>
        </section>
        <!--products-end-->  
        
        <!--footer-->
        <footer>
            <div class="footer-container">
                <!--logo-container-->
                <div class="footer-logo">
                    <a href="#">
                        <span>Green</span>Mart
                    </a>
                    <!--social-->
                    <div class="footer-social">
                        <img src ="images/paypal.png">
                    </div>
                </div>
            
            <div class="footer-links">
                <strong>Contact</strong>
                <ul>
                    <li style = "color: white;">Phone : +94 112 345 678</li>
                    <li style = "color: white;">Email : greenmart@gmail.com</li>
                </ul>
				<br><p style="color: aliceblue;">Copyright ©2023 | GreenMart All Rights Reserved</p>
            </div>
            </div>
        </footer>
        <!--footer-end-->

    </body>
</html>
