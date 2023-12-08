<!DOCTYPE html>
<html lang="en-US">

<head>
    <title>Online Shop App | Panel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0 , maximum-scale=1.0">
    <link href="libs/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="libs/jquery-3.7.1.min.js"></script>
    <script src="libs/bootstrap-5.3.2-dist/js/bootstrap.min.js"></script>
    <script src="libs/angular.min.js"></script>
    <script src="libs/angular-cookies.js"></script>
    <link href="libs/fontawesome-free-6.4.2-web/css/all.min.css" rel="stylesheet">
    <link href="libs/sweetalert2/dist/sweetalert2.min.css" rel="stylesheet">
    <script src="libs/sweetalert2/dist/sweetalert2.all.min.js"></script>
    <link href="libs/textAngular-1.5.16/dist/textAngular.css" rel="stylesheet">
    <script src="libs/textAngular-1.5.16/dist/textAngular-rangy.min.js"></script>
    <script src="libs/textAngular-1.5.16/dist/textAngular-sanitize.min.js"></script>
    <script src="libs/textAngular-1.5.16/dist/textAngular.min.js"></script>
    <script src="scripts/app.js"></script>
    <script src="scripts/directives/fileModel.js"></script>
    <script src="scripts/controllers/utils/uploadFileController.js"></script>
    <script src="scripts/controllers/utils/getFilesCtrl.js"></script>
    <script src="scripts/services/ApiHandler.js"></script>
    <script src="scripts/directives/fileModel.js"></script>
    <script src="scripts/controllers/utils/uploadFileController.js"></script>
    <script src="scripts/controllers/panelController.js"></script>
    <script src="scripts/controllers/site/nav/navListController.js"></script>
    <script src="scripts/controllers/site/nav/navAddController.js"></script>
    <script src="scripts/controllers/site/nav/navEditController.js"></script>
    <script src="scripts/controllers/site/content/contentListController.js"></script>
    <script src="scripts/controllers/site/content/contentAddController.js"></script>
    <script src="scripts/controllers/site/content/contentEditController.js"></script>
    <script src="scripts/controllers/site/slider/sliderListController.js"></script>
    <script src="scripts/controllers/site/slider/sliderAddController.js"></script>
    <script src="scripts/controllers/site/slider/sliderEditController.js"></script>
    <script src="scripts/controllers/site/blog/blogListController.js"></script>
    <script src="scripts/controllers/site/blog/blogAddController.js"></script>
    <script src="scripts/controllers/site/blog/blogEditController.js"></script>
    <script src="scripts/controllers/people/users/userListController.js"></script>
    <script src="scripts/controllers/people/users/userAddController.js"></script>
    <script src="scripts/controllers/people/users/userEditController.js"></script>
    <script src="scripts/controllers/products/category/categoryListController.js"></script>
    <script src="scripts/controllers/products/category/categoryAddController.js"></script>
    <script src="scripts/controllers/products/category/categoryEditController.js"></script>
    <script src="scripts/controllers/products/color/colorListController.js"></script>
    <script src="scripts/controllers/products/color/colorAddController.js"></script>
    <script src="scripts/controllers/products/color/colorEditController.js"></script>
    <script src="scripts/controllers/products/size/sizeAddController.js"></script>
    <script src="scripts/controllers/products/size/sizeEditController.js"></script>
    <script src="scripts/controllers/products/size/sizeListController.js"></script>
    <script src="scripts/controllers/products/product/productListController.js"></script>
    <script src="scripts/controllers/products/product/productAddController.js"></script>

    <link href="styles/panel.css" rel="stylesheet">

</head>
<body ng-app="onlineShopApp">

<div class="container-fluid" ng-controller="panelCtrl">
    <div class="container-fluid">
    <div class="row">
        <div class="col p-0">
        <div class="panel-header">
            <a href="/logout" class="btn btn-danger btn-sm">Logout</a>
        </div>
        </div>
    </div>
    </div>
   <div class="row">
     <div class="col-2 p-0">
         <div class="side-nav">
             <div class="text-center p-3 ">
                 <img src="images/userImg.png" width="100">
                 <br/>
                 <span>{{user.fullName}}</span>
             </div>
<ul>
    <li ng-class="{'side-nav-active':templateGroup=='dashboard'}" ><a href="#" ng-click="changeMenu('dashboard')" ><i class="fa fa-dashboard p-1"></i><span>Dashboard</span></a></li>
    <li  ng-class="{'side-nav-active':templateGroup=='nav'}"><a href="#" ng-click="changeMenu('nav-list')" ><i class="fa fa-link p-1"></i><span>Navigation</span></a></li>
    <li   ng-class="{'side-nav-active':templateGroup=='content'}"><a href="#" ng-click="changeMenu('content-list')" ><i class="fa fa-file p-1"></i><span> Content</span></a></li>
    <li     ng-class="{'side-nav-active':templateGroup=='slider'}"><a href="#"ng-click="changeMenu('slider-list')" ><i class="fa fa-photo-film p-1"></i><span>Sliders</span></a></li>
    <li        ng-class="{'side-nav-active':templateGroup=='blog'}"><a href="#" ng-click="changeMenu('blog-list')"><i class="fa fa-newspaper p-1"></i><span>Blog</span></a></li>
    <li           ng-class="{'side-nav-active':templateGroup=='product'}"><a href="#"   ng-click="changeMenu('category-list')"><i class="fa fa-cube p-1"></i><span>Products</span></a></li>
    <li        ng-class="{'side-nav-active':templateGroup=='user'}"><a href="#" ng-click="changeMenu('user-list')"><i class="fa fa-user p-1"></i><span>Users</span></a></li>
    <li><a href="#"><i class="fa fa-shopping-bag p-1"></i><span >Customers</span></a></li>
    <li ng-class="{'side-nav-active':templateGroup=='uploader'}" ><a href="#" ng-click="changeMenu('uploader')" ><i class="fa fa-file-image p-1"></i><span>File Manager</span></a></li>


</ul>
         </div>
     </div>

       <div class="col p-0">
           <div class="main-container" ng-include="template"></div>
       </div>
   </div>
</div>


</body>
</html>