<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Book Management Application</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h1>Book Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/books?action=create">Add New Book</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Book</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Title</th>--%>
<%--            <th>Category ID</th>--%>
<%--            <th>Author ID</th>--%>
<%--            <th>Publish Year</th>--%>
<%--            <th>Description</th>--%>
<%--            <th>Image</th>--%>
<%--            <th>Views</th>--%>
<%--            <th>Quantity</th>--%>
<%--            <th>Price</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="book" items="${listBook}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${book.id}"/></td>--%>
<%--                <td><c:out value="${book.title}"/></td>--%>
<%--                <td><c:out value="${book.categoryId.name}"/></td>--%>
<%--                <td><c:out value="${book.authorId.name}"/></td>--%>
<%--                <td><c:out value="${book.publishYear}"/></td>--%>
<%--                <td><c:out value="${book.description}"/></td>--%>
<%--                <td><c:out value="${book.image}"/></td>--%>
<%--                <td><c:out value="${book.views}"/></td>--%>
<%--                <td><c:out value="${book.quantity}"/></td>--%>
<%--                <td><c:out value="${book.price}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/books?action=edit&id=${book.id}">Edit</a>--%>
<%--                    <a href="/books?action=delete&id=${book.id}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%------------------------------------------------------------------------------------------------------------------------%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="views/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="views/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Admin</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="views/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="views/assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="views/assets/css/demo.css" rel="stylesheet"/>
    <link href="views/assets/css/style.css" rel="stylesheet"/>
</head>

<body>
<div class="wrapper">
    <div class="sidebar" data-image="views/assets/img/sidebar-5.jpg">
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li>
                    <a class="nav-link" href="#">
                        <i class="nc-icon nc-circle-09"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li >
                    <a class="nav-link" href="/books?action=shop">
                        <i class="nc-icon nc-notes"></i>
                        <p>Shop</p>
                    </a>
                </li><li >
                    <a class="nav-link" href="/accounts">
                        <i class="nc-icon nc-notes"></i>
                        <p>Accounts</p>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/books">
                        <i class="nc-icon nc-paper-2"></i>
                        <p>Books</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="#">
                        <i class="nc-icon nc-atom"></i>
                        <p>Category</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="#">
                        <i class="nc-icon nc-album-2"></i>
                        <p>Author</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="#">
                        <i class="nc-icon nc-air-baloon"></i>
                        <p>Order</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->

        <nav class="navbar navbar-expand-lg " color-on-scroll="500">
            <div class="container-fluid">

                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="nav navbar-nav mr-auto">

                        <li class="dropdown nav-item">
                            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                                <i class="nc-icon nc-planet"></i>
                                <span class="notification">5</span>
                                <span class="d-lg-none">Notification</span>
                            </a>
                            <ul class="dropdown-menu">
                                <c:forEach var="category" items="${categories}">
<%--                                    <option value="${category.id}"></option>--%>
                                    <a class="dropdown-item" href="/books?action=categoryID&id=${category.id}">
                                        <c:out value="${category.name}"/>
                                    </a>
                                </c:forEach>

                                <a class="dropdown-item" href="/accounts?action=admin">1</a>
                                <a class="dropdown-item" href="/accounts?action=user">2</a>
                                <a class="dropdown-item" href="/accounts?action=user">3</a>
                                <a class="dropdown-item" href="/accounts?action=user">4</a>
                                <a class="dropdown-item" href="/accounts?action=user">5</a>

                                <a class="dropdown-item" href="/books">All</a>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link">
                                <i class="nc-icon nc-zoom-split"></i>
                                <span class="d-lg-block">&nbsp;Search</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h4 class="card-title">List book</h4>
                                        <p class="card-category">You can create, update, delete</p></div>
                                    <div class="col-md-6">
                                        <div>
                                            <!-- Button trigger modal -->
                                            <a type="button" class="close" data-toggle="modal"
                                               data-target="#exampleModal">
                                                <span style="color: #0059B3; " aria-hidden="true"><i
                                                        class="fa fa-plus"></i></span>
                                            </a>

                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">CREATE BOOK</h5>
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">


                                                            <form action="/books?action=create" method="POST">
                                                                <div class="form-group">
                                                                    <label for="title">Title</label>
                                                                    <input type="text" id="title" name="title" class="form-control"
                                                                           value="<c:out value='${account.fullName}'/>">
                                                                </div>

                                                                <div class="form-group">
                                                                    <label for="categoryId">Category</label>
                                                                    <select name="categoryId" id="categoryId">
                                                                        <c:forEach var="category" items="${categories}">
                                                                            <option value="${category.id}"><c:out value="${category.name}"/></option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="authorId">Author</label>
                                                                    <select name="authorId" id="authorId">
                                                                        <c:forEach var="author" items="${authors}">
                                                                            <option value="${author.id}"><c:out value="${author.name}"/></option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="publishYear">Publish Year:</label>
                                                                    <input type="text" id="publishYear" name="publishYear" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="description">Description</label>
                                                                    <input type="text" id="description" name="description" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="image">Image</label>
                                                                    <input type="text" id="image" name="image" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="views">Views</label>
                                                                    <input type="text" id="views" name="views" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="image">Quantity</label>
                                                                    <input type="text" id="quantity" name="quantity" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="price">Price</label>
                                                                    <input type="text" id="price" name="price" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                    <button type="submit" class="btn btn-primary">Save</button>
                                                                </div>
                                                            </form>

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--                            bảng-->
                            <div class="card-body table-full-width table-responsive">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Category</th>
                                    <th>Image</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="book" items="${listBook}">
                                        <tr>
                                            <td><c:out value="${book.title}"/></td>
                                            <td><c:out value="${book.authorId.name}"/></td>
                                            <td><c:out value="${book.categoryId.name}"/></td>
                                            <td><img style="height: 100px; width: 70px;" src="<c:out value="${book.image}"/>" alt="image"></td>
                                            <td><c:out value="${book.price}"/></td>
                                            <td><c:out value="${book.quantity}"/></td>
                                            <td>
                                                <div style="margin: 40px;">
                                                    <!-- Button trigger modal -->
                                                    <a type="button" class="close" data-toggle="modal"
                                                       data-target="#${book.id}">
                                                        <span style="color: #0059B3; " aria-hidden="true"><i class="fa fa-edit"></i></span>
                                                    </a>

                                                    <!-- Modal -->
                                                    <div class="modal fade" id="${book.id}" tabindex="-1" role="dialog"
                                                         aria-labelledby="exampleModalLabel1" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel1">CREATE ACCOUNT</h5>
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">

                                                                    <form action="/books?action=edit&id=${book.id}" method="POST">
                                                                        <c:if test="${book != null}">
                                                                            <input type="hidden" name="id" value="<c:out value='${book.id}' />"/>
                                                                        </c:if>
                                                                        <div class="form-group">
                                                                            <label for="titleEdit">Title</label>
                                                                            <input type="text" id="titleEdit" name="titleEdit" class="form-control"
                                                                                   value="<c:out value='${book.title}'/>">
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <label for="categoryIdEdit">Category</label>
                                                                            <select name="categoryIdEdit" id="categoryIdEdit" style="height: 40px; width: 350px;">
                                                                                <c:forEach var="category" items="${categories}">
                                                                                    <option value="${category.id}"><c:out value="${category.name}"/></option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="authorIdEdit">Author</label>
                                                                            <select name="authorIdEdit" id="authorIdEdit" style="height: 40px; width: 350px;">
                                                                                <c:forEach var="author" items="${authors}">
                                                                                    <option value="${author.id}"><c:out value="${author.name}"/></option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="publishYearEdit">Publish Year:</label>
                                                                            <input type="text" id="publishYearEdit" name="publishYearEdit" class="form-control"
                                                                                   value="<c:out value='${book.publishYear}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="descriptionEdit">Description</label>
                                                                            <input type="text" id="descriptionEdit" name="descriptionEdit" class="form-control"
                                                                                   value="<c:out value='${book.description}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="imageEdit">Image</label>
                                                                            <input type="text" id="imageEdit" name="imageEdit" class="form-control"
                                                                                   value="<c:out value='${book.image}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="viewsEdit">Views</label>
                                                                            <input type="text" id="viewsEdit" name="viewsEdit" class="form-control"
                                                                                   value="<c:out value='${book.views}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="imageEdit">Quantity</label>
                                                                            <input type="text" id="quantityEdit" name="quantityEdit" class="form-control"
                                                                                   value="<c:out value='${book.quantity}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="priceEdit">Price</label>
                                                                            <input type="text" id="priceEdit" name="priceEdit" class="form-control"
                                                                                   value="<c:out value='${book.price}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                            <button type="submit" class="btn btn-primary">Save</button>
                                                                        </div>
                                                                    </form>

                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div style="margin: 40px;">
                                                    <a type="button" class="close" data-toggle="modal"
                                                       data-target="#delete-${book.id}">
                                                        <span style="color: #0059B3;" aria-hidden="true"><i class="fa fa-close"></i></span>
                                                    </a>

                                                    <!-- Modal -->
                                                    <div class="modal fade" id="delete-${book.id}" tabindex="-1" role="dialog"
                                                         aria-labelledby="exampleModalLabel2" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel2">Do you want to delete now?</h5>
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">

                                                                    <form action="/books?action=delete&id=${book.id}" method="post">
                                                                        <div class="form-group">
                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>
                                                                            <button type="submit" class="btn btn-primary">DELETE</button>
                                                                        </div>
                                                                    </form>

                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
<%--                                                <a href="/books?action=delete&id=${book.id}">Delete</a>--%>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container-fluid">
                <nav>
                    <p class="copyright text-center">
                        ©
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="http://www.creative-tim.com">TEAM CODEGYM</a>
                    </p>
                </nav>
            </div>
        </footer>
    </div>
</div>
</body>
<!--   Core JS Files   -->
<script src="views/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="views/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="views/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="views/assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="views/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="views/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="views/assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="views/assets/js/demo.js"></script>

</html>
