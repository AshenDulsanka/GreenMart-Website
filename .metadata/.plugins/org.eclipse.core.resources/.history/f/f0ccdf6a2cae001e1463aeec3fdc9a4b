<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>GreenMart Login</title>
		
		<!--Font-Icon-->
		<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
			
		<!--Favicon-->
		<link rel="icon" type="image/x-icon" href="images/favicon.ico" />
		
		<!--Main-css-->
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
	
		<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	
		<div class="main">
	
			<!--Sing-in-Form-->
			<section class="sign-in">
				<div class="container">
					<div class="signin-content">
						<div class="signin-image">
							<figure>
								<a href="index.jsp"><img src="images/Greenmart.png" alt="sing up image"></a>
							</figure>
							<a href="signup.jsp" class="signup-image-link">Create an
								account</a>
						</div>
	
						<div class="signin-form">
							<h2 class="form-title">Sign in</h2>
							<form method="post" action="login" class="register-form"
								id="login-form">
								<div class="form-group">
									<label for="email"><i
										class="zmdi zmdi-account material-icons-name"></i></label> <input
										type="text" name="email" id="email"
										placeholder="Your Email" required="required"/>
								</div>
								<div class="form-group">
									<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
										type="password" name="password" id="password"
										placeholder="Password" required="required"/>
								</div>
								<div class="form-group">
									<a href="forgotPassword.jsp">Forgot Password?</a>
								</div>
								<div class="form-group form-button">
									<input type="submit" name="signin" id="signin"
										class="form-submit" value="Log in" />
								</div>
							</form>
							
						</div>
					</div>
				</div>
			</section>
		</div>
	
		<!--JS-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="js/main.js"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<link rel="stylesheet" href="alert/dist/sweetalert.css">
		
		<script type = "text/javascript">
			var status = document.getElementById("status").value;
			if (status == "Failed"){
				swal("Sorry", "Wrong email or password", "error");
			}
			else if (status == "invalidEmail"){
				swal("Sorry", "Please enter email", "error");
			}
			else if (status == "invalidPassword"){
				swal("Sorry", "Please enter password", "error");
			}else if (status == "resetSuccess"){
				swal("Congratulations", "Password Reset Successful", "success");
			}else if (status == "resetFailed"){
				swal("Sorry", "Password Reset Failed", "error");
			}
		</script>
	</body>
</html>