app.controller('navAddCtrl',function ($scope,apiHandler){

    $scope.data={};

    $scope.addData = () =>{

        if ($scope.data.title == undefined || $scope.data.title == null || $scope.data.title == ""){
            Swal.fire('please enter title');
        }
        if ($scope.data.link == undefined || $scope.data.link == null || $scope.data.link == ""){
            Swal.fire('please enter link');
        }
        if ($scope.data.enable == undefined || $scope.data.enable == null ){
            Swal.fire('please set enable');
        }

        apiHandler.callPost('nav/',$scope.data,(response)=>{
          $scope.changeMenu('nav-list');
        },(error)=>{
debugger;
         },true);
    }


})