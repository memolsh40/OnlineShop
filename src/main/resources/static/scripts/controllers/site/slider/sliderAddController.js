app.controller('SliderAddCtrl',function ($scope,apiHandler,$rootScope){

    $scope.data={};

    $scope.addData = () =>{
$scope.data.image = $rootScope.uploadedFile;
        if ($scope.data.title == undefined || $scope.data.title == null || $scope.data.title == ""){
            Swal.fire('please enter title');
        }
        if ($scope.data.link == undefined || $scope.data.link == null || $scope.data.link == ""){
            Swal.fire('please enter link');
        }
        if ($scope.data.image == undefined || $scope.data.image == null || $scope.data.image == ""){
            Swal.fire('please upload an image');
        }
        if ($scope.data.enable == undefined || $scope.data.enable == null ){
            Swal.fire('please set enable');
        }

        apiHandler.callPost('slider/',$scope.data,(response)=>{
          $scope.changeMenu('slider-list');
        },(error)=>{
debugger;
         },true);
    }


})