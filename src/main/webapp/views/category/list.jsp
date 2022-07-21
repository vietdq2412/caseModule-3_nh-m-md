<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                    <a class="nav-link" href="/accounts?action=edit&id=1">
                        <i class="nc-icon nc-circle-09"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li >
                    <a class="nav-link" href="/books?action=shop">
                        <i class="nc-icon nc-notes"></i>
                        <p>Shop</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="/accounts">
                        <i class="nc-icon nc-notes"></i>
                        <p>Accounts</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="/books">
                        <i class="nc-icon nc-paper-2"></i>
                        <p>Books</p>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/category">
                        <i class="nc-icon nc-atom"></i>
                        <p>Category</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="/authors">
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
                                        <h4 class="card-title">List Category</h4>
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
                                                            <h5 class="modal-title" id="exampleModalLabel">CREATE CATEGORY</h5>
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">


                                                            <form action="/category?action=create" method="POST">
                                                                <div class="form-group">
                                                                    <label for="name">Name Category</label>
                                                                    <input type="text" id="name" name="name" class="form-control">
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
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="category"  items="${categories}">
                                        <tr>
                                            <td><c:out value="${category.id}"/></td>
                                            <td><c:out value="${category.name}"/></td>
                                            <td><c:out value="${quantity.get(category.id)}"/></td>
                                            <td>

                                                <div style="margin: 20px;">
                                                    <!-- Button trigger modal -->
                                                    <a type="button" class="close" data-toggle="modal"
                                                       data-target="#${category.id}">
                                                        <span style="color: #0059B3; " aria-hidden="true"><i class="fa fa-edit"></i></span>
                                                    </a>

                                                    <!-- Modal -->
                                                    <div class="modal fade" id="${category.id}" tabindex="-1" role="dialog"
                                                         aria-labelledby="exampleModalLabel1" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel1">EDIT CATEGORY</h5>
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">

                                                                    <form action="/category?action=edit&id=${category.id}" method="POST">
                                                                        <c:if test="${category != null}">
                                                                            <input type="hidden" name="id" value="<c:out value='${category.id}' />"/>
                                                                        </c:if>
                                                                        <div class="form-group">
                                                                            <label for="nameEdit">Name Category</label>
                                                                            <input type="text" id="nameEdit" name="nameEdit" class="form-control"
                                                                                   value="<c:out value='${category.name}'/>">
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

                                                <div style="margin: 20px;">
                                                    <a type="button" class="close" data-toggle="modal"
                                                       data-target="#delete-${category.id}">
                                                        <span style="color: #0059B3;" aria-hidden="true"><i class="fa fa-close"></i></span>
                                                    </a>

                                                    <!-- Modal -->
                                                    <div class="modal fade" id="delete-${category.id}" tabindex="-1" role="dialog"
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

                                                                    <form action="/category?action=delete&id=${category.id}" method="post">
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
