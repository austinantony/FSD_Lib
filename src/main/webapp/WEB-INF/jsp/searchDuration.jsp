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
				<h3 class="navbar-brand">Search subject by duration</h3>
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
		<form:form method="post" action="getSubjectByDuration" class="form-horizontal">  
      	  
        <div class="form-group">
			<label class="control-label col-sm-2" for="duration">Subject duration</label>
			<div class="col-sm-4"> 
          		<form:input path="duration" class="form-control"/>
         	</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">  
          		<input type="submit" value="Search" class="btn btn-default"/>  
         	</div>
			<div class="col-sm-3">
				<button type="reset" class="btn btn-default">Reset</button>
			</div>
		</div>
		</form:form>
	
	<div class="col-md-8 col-sm-9 col-xs-12">
		<table class="table table-striped">
		<thead><tr><th><b>Subject Id</b></th><th><b>Subject Title</b></th><th><b>Duration</b></th></tr></thead>
		<c:forEach items="${subList}" var="showSub">
			<tr><td>${showSub.subjectId}</td>
			<td>${showSub.subjectTitle}</td>
			<td>${showSub.duration}</td></tr>
		</c:forEach>
		</table>	
	</div>
	${message}
	</article>
	<footer class="row">
		<p align="center"><b>Copyright © 2018</b></p>
	</footer>
</div>	
</body>
</html>
    