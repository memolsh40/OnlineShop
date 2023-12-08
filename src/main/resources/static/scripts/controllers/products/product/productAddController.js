app.controller('productAddCtrl',function ($scope,apiHandler,$rootScope){

    $scope.data={};
    $scope.category=$rootScope.Category;
    $scope.colors={};
    $scope.sizes={};
    $scope.addData = () =>{
$scope.data.image = $rootScope.uploadedFile;
$scope.data.categoryId = $scope.category.id;
        if ($scope.data.title == undefined || $scope.data.title == null || $scope.data.title == ""){
            Swal.fire('please enter title');
        }
        if ($scope.data.price == undefined || $scope.data.price == null || $scope.data.price == ""){
            Swal.fire('please enter price');
        }
        if ($scope.data.image == undefined || $scope.data.image == null || $scope.data.image == ""){
            Swal.fire('please upload an image');
        }
        if ($scope.data.exists == undefined || $scope.data.exists == null ){
            Swal.fire('please set exists');
        }
        if ($scope.data.enable == undefined || $scope.data.enable == null ){
            Swal.fire('please set enable');
        }

        apiHandler.callPost('product/',$scope.data,(response)=>{
          $scope.changeMenu('product-list');
        },(error)=>{
debugger;
         },true);
    }
    $scope.changeMenuWithCategory =(template) =>{
        $rootScope.Category = $scope.category;
        $scope.changeMenu(template);
    }
    $scope.getColors = () =>{
        apiHandler.callGet('color/',(response)=>{
$scope.colors = response.dataList;
        },(error)=>{

        },true);
    }
    $scope.getSizes = () =>{
        apiHandler.callGet('size/',(response)=>{
$scope.sizes = response.dataList;
        },(error)=>{

        },true);
    }
    $scope.getColors();
    $scope.getSizes();


})