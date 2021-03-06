<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html lang="en">
<head>
<title>Library</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<div  class="container">
	<header class="row">
		<div class="navbar navbar-inverse">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
		
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		
			<div class="navbar-header">
				<h3 class="navbar-brand">Add New Book</h3>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
		
				<ul class="nav navbar-nav navbar-right">
					<li><a href="subform">Add Subject</a></li>
					<li><a href="bookForm">Add Book</a></li>
					<li><a href="deleteSubject">Delete Subject</a></li>
					<li><a href="deleteBook">Delete Book</a></li>
					<li><a href="searchSubject">Search Subject</a></li>
					<li><a href="searchBook">Search Book</a></li>
					<li><a href="searchTitle">Search book by title</a></li>
					<li><a href="searchDuration">Search subject by duration</a></li>
				</ul>
			</div>
		</div>
	</header>
	<article class="content row">
	<div class="col-md-8 col-sm-9 col-xs-12">          
		<form:form method="post" action="addBook" class="form-horizontal">  
      	  
        <div class="form-group">
			<label class="control-label col-sm-2" for="bookId">Book Id</label>
			<div class="col-sm-4"> 
          		<form:input path="bookId" class="form-control"/>
         	</div>
		</div>
        <div class="form-group">
			<label class="control-label col-sm-2" for="title">Book Title</label>
			<div class="col-sm-4">  
          	<form:input path="title" class="form-control"/>
        </div></div> 
        <div class="form-group">
			<label class="control-label col-sm-2" for="price">Price</label>
			<div class="col-sm-4">  
          	<form:input path="price" class="form-control"/>
        </div></div>
        <div class="form-group">
			<label class="control-label col-sm-2" for="volume">Volume</label>
			<div class="col-sm-4">  
          	<form:input path="volume" class="form-control"/>
        </div></div>
        <div class="form-group">
			<label class="control-label col-sm-2" for="publishedDate">Published Date</label>
			<div class="col-sm-4">  
          	<form:input path="publishedDate" class="form-control"/>
        </div></div>
        <div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">  
          		<input type="submit" value="Save" class="btn btn-default"/>  
         	</div>
			<div class="col-sm-3">
				<button type="reset" class="btn btn-default">Reset</button>
			</div>
		</div>  
       	</form:form>
		${message}
		</div>
	</article>
	<footer class="row">
		<p align="center"><b>Copyright � 2018</b></p>
	</footer>
</div>	
</body>
</html>
