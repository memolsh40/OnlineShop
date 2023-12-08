app.controller('userAddCtrl',function ($scope,apiHandler){

    $scope.data={};

    $scope.addData = () =>{

        if ($scope.data.lastName == undefined || $scope.data.lastName == null || $scope.data.lastName == ""){
            Swal.fire('please enter lastName');
        }
        if ($scope.data.username == undefined || $scope.data.username == null || $scope.data.username == ""){
            Swal.fire('please enter username');
        }
        if ($scope.data.password == undefined || $scope.data.password == null || $scope.data.password == ""){
            Swal.fire('please enter password');
        }
        if ($scope.data.email == undefined || $scope.data.email == null || $scope.data.email == ""){
            Swal.fire('please enter email');
        }
        if ($scope.data.enable == undefined || $scope.data.enable == null ){
            Swal.fire('please set enable');
        }
        if ($scope.data.role == undefined || $scope.data.role == null ){
            Swal.fire('please set role');
        }

        apiHandler.callPost('user/',$scope.data,(response)=>{
          $scope.changeMenu('user-list');
        },(error)=>{
debugger;
         },true);
    }


})