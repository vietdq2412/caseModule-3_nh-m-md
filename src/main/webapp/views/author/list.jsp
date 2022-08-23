<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="apple-touch-icon" sizes="76x76" href="views/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="views/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Admin</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="views/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>

    <!-- CSS Files -->
    <link href="views/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="views/assets/css/light-bootstrap-dashboard.css?v=1.4.0 " rel="stylesheet"/>
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
                    <a class="nav-link" href="/authors?action=edit&id=1">
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
                    <a class="nav-link" href="/accounts?page=1">
                        <i class="nc-icon nc-notes"></i>
                        <p>Accounts</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="/books?page=1">
                        <i class="nc-icon nc-paper-2"></i>
                        <p>Books</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="/category">
                        <i class="nc-icon nc-atom"></i>
                        <p>Category</p>
                    </a>
                </li>
                <li class="nav-item active">
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
                                        <h4 class="card-title">List author</h4>
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
                                                            <h5 class="modal-title" id="exampleModalLabel">CREATE AUTHOR</h5>
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">


                                                            <form action="/authors?action=create" method="POST">
                                                                <div class="form-group">
                                                                    <label for="name">Name</label>
                                                                    <input type="text" id="name" name="name" class="form-control">
                                                                </div>

                                                                <div class="form-group">
                                                                    <label for="image">image</label>
                                                                    <input type="text" id="image" name="image" class="form-control">
                                                                </div>
                                                                <div class="form-group">

                                                                    <label for="dateOfBirth">DATE OF BIRTH</label>
                                                                    <input type="text" id="dateOfBirth" name="dateOfBirth" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="numberOfArts">NUMBER OF ART</label>
                                                                    <input type="text" id="numberOfArts" name="numberOfArts" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="nation">NATION</label>
                                                                    <input type="text" id="nation" name="nation" class="form-control">
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
                            <div class="card-body table-full-width table-responsive" style="margin: 0px">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>Name</th>
                                    <th>Image</th>
                                    <th>Date of birth</th>
                                    <th>Number of art</th>
                                    <th>Nation</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="author" items="${authorList}">
                                        <tr>
                                            <td><c:out value="${author.name}"/></td>
                                            <td><img style="height: 100px; width: 70px;" src="<c:out value="${author.image}"/>" alt="image"></td>
                                            <td><c:out value="${author.dateOfBirth}"/></td>
                                            <td><c:out value="${author.numberOfArts}"/></td>
                                            <td><c:out value="${author.nation}"/></td>
                                            <td>

                                                <div style="margin: 20px;">
                                                    <!-- Button trigger modal -->
                                                    <a type="button" class="close" data-toggle="modal"
                                                       data-target="#${author.id}">
                                                        <span style="color: #0059B3; " aria-hidden="true"><i class="fa fa-edit"></i></span>
                                                    </a>

                                                    <!-- Modal -->
                                                    <div class="modal fade" id="${author.id}" tabindex="-1" role="dialog"
                                                         aria-labelledby="exampleModalLabel1" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel1">CREATE AUTHOR</h5>
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">

                                                                    <form action="/authors?action=edit&id=${author.id}" method="POST">
                                                                        <c:if test="${author != null}">
                                                                            <input type="hidden" name="id" value="<c:out value='${author.id}' />"/>
                                                                        </c:if>
                                                                        <div class="form-group">
                                                                            <label for="nameEdit">Name</label>
                                                                            <input type="text" id="nameEdit" name="nameEdit" class="form-control"
                                                                                   value="<c:out value='${author.name}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="imageEdit">Image</label>
                                                                            <input type="text" id="imageEdit" name="imageEdit" class="form-control"
                                                                                   value="<c:out value='${author.image}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="dateOfBirthEdit">Date of birth</label>
                                                                            <input type="text" id="dateOfBirthEdit" name="dateOfBirthEdit" class="form-control"
                                                                                   value="<c:out value='${author.dateOfBirth}'/>" >
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="numberOfArtsEdit">Number of art</label>
                                                                            <input type="text" id="numberOfArtsEdit" name="numberOfArtsEdit" class="form-control"
                                                                                   value="<c:out value='${author.numberOfArts}'/>">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="nationEdit">Nation</label>
                                                                            <input type="text" id="nationEdit" name="nationEdit" class="form-control"
                                                                                   value="<c:out value='${author.nation}'/>" >
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
                                            </td>
                                            <td style="display: revert !important;">
                                                <div style="margin: 20px;">
                                                    <a type="button" class="close" data-toggle="modal"
                                                       data-target="#delete-${author.id}">
                                                        <span style="color: #0059B3;" aria-hidden="true"><i class="fa fa-close"></i></span>
                                                    </a>

                                                    <!-- Modal -->
                                                    <div class="modal fade" id="delete-${author.id}" tabindex="-1" role="dialog"
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

                                                                    <form action="/authors?action=delete&id=${author.id}" method="post">
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
<script src="views/assets/js/light-bootstrap-dashboard.js?v=1.4.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="views/assets/js/demo.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
    .modal-backdrop {
        /* bug fix - no overlay */
        display: none;
    }

</style>
<script>
    $(document).ready(() => {
        $('#nav-mobile-menu').remove();
    })
</script>
</html>