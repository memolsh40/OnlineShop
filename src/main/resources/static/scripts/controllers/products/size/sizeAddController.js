app.controller('sizeAddCtrl',function ($scope,apiHandler){

    $scope.data={};

    $scope.addData = () =>{

        if ($scope.data.title == undefined || $scope.data.title == null || $scope.data.title == ""){
            Swal.fire('please enter title');
        }


        apiHandler.callPost('size/',$scope.data,(response)=>{
          $scope.changeMenu('size-list');
        },(error)=>{
debugger;
         },true);
    }


})