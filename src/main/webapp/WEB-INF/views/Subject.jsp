<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">        
</head>

<body>
    <div>
        <div class="row form-group"></div>
        <div class="row justify-content-center form-group">
        <div id="navDiv" class="col-md-8 col-sm-8 col-xs-8 col-xs-offset-2 col-md-offset-2 col-sm-offset-2 bg-white border rounded">
            <a href="/subjects" class="col-md-2">Subjects</a>
            <a href="/books" class="col-md-1">Books</a>
        </div>
        </div>
        <div class="row justify-content-center form-group">
            <div class="col-md-8 col-sm-8 col-xs-8 col-xs-offset-2 col-md-offset-2 col-sm-offset-2 bg-white border rounded">
                <form action="/saveSubject" method="post">
                    <div class="alert mt-3 alert-primary" role="alert">
                        ${message}
                    </div>
                    <div class="row form-group mt-3">
                        <label class="col-md-12 control-lable" style="text-align:center"><h3>Please enter Details</h3></label>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="subTitle">subject title*:</label>
                        <div class="col-md-8">
                            <input type="text" name="subtitle" class="form-control input-sm" required/>        
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="duration">duration*:</label>
                        <div class="col-md-8">
                            <input type="number" name="durationInHours" class="form-control input-sm" required/>
                            
                        </div>
                    </div>
                    

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-8">
                            <input type="Submit" class="btn btn-success" value="Create a Subject">   
                                  
                        </div>
                    </div>
                </form>
                <div class="row form-group"></div>
                <form action="/searchSubject" method="post">
                <div class="input-group mb-3">
                	
                    <div class="col-md-8">
                        <input type="text" class="form-control" placeholder="Enter for search" name="searchBox" required>
                    </div>
                    <div class="col-md-3">
                        <input type="Submit" class="btn btn-success" value="Search"/>
                        <a class="btn btn-danger" href="/subjects">Clear Search</a> 
                    </div>
                    
                </div>
                </form>
                <table class="table table-bordered">
                    <thead>
                        <tr>  	
                            <th class="col-xs-2">Id</th>
                            <th class="col-xs-2">Title</th>
                            <th class="col-xs-6">Duration</th>
                            <th class="col-xs-2">Controls</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="subject" items="${listSubject}" varStatus="status">
                		<tr>
                    		<td>${subject.subjectId}</td>
                    		<td>${subject.subtitle}</td>
                    		<td>${subject.durationInHours}</td>
                    		<td>
                        		<a href="/deleteSubject?subjectId=${subject.subjectId}">Delete</a>
                    		</td>
                             
                		</tr>
                		</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>




