<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <script src="../js/bootstrap.min.js"></script>       
    </head>

    <body>          
        <div class="container">
            <h2>Rest Call</h2>
            <!--Search Form -->
            <form action="/employee" method="get" id="seachEmployeeForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="employeeName" id="employeeName" class="form-control" required="false" value="http://ip.jsontest.com/" placeholder="EndPoint URL of API in Server"/>                    
                </div>
                <button type="submit" class="btn btn-primary  btn-md">Rest POST Call</button> 
                <br></br>
                <br></br>
            </form>

            <!--Employees List-->
            <c:if test="${not empty message}">                
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if> 
            
        </div>
       
    </body>
</html>