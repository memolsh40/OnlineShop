app.controller('sliderEditCtrl',function ($scope,apiHandler,$rootScope){

    $scope.data={};
    $scope.id=$rootScope.dataId;

    $scope.editData = () =>{
        if ($rootScope.uploadedFile!=undefined && $rootScope.uploadedFile!=null && $rootScope.uploadedFile!="")
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

        apiHandler.callPut('slider/',$scope.data,(response)=>{
          $scope.changeMenu('slider-list');
        },(error)=>{

         },true);
    }

    $scope.getData = () =>{
        apiHandler.callGet('slider/'+$scope.id,(response)=>{
        $scope.data=response.dataList[0];
        },(error)=>{},true);
    }
    $scope.getData();


})