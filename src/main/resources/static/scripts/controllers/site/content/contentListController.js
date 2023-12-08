app.controller('contentListCtrl',function ($scope,apiHandler,$rootScope){
        $scope.query={
        pageSize:10,
        pageNumber:0
};
        $scope.totalCount=0;
        $scope.pageCount=0;
        $scope.dataList=[];
$scope.getDataList=()=>{
    let url = 'content/getAll?pageSize='+$scope.query.pageSize + '&pageNumber='+$scope.query.pageNumber;
    debugger;
   apiHandler.callGet(url,(response)=>{
       debugger;
$scope.dataList=response.dataList;
$scope.totalCount=response.totalCount;
$scope.pageCount=$scope.totalCount / $scope.query.pageSize;
$scope.pageCount=parseInt($scope.pageCount);
if ($scope.pageCount % $scope.query.pageSize > 0)
    $scope.pageCount++;
   },(error)=>{

   },true);
}
$scope.changePage=(pageNumber)=>{
    $scope.query.pageNumber=pageNumber;
    $scope.getDataList();
}
$scope.range=(max)=>{
    return new Array(max);
}
$scope.editItem=(id)=>{
    $rootScope.dataId=id;
    $scope.changeMenu('content-edit');
}

    $scope.changeOrder=(id,direction)=>{
        Swal.fire({
            title: "Are you sure?",
            text: "Do you want to change order?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, delete it!"
        }).then((result) => {
            if (result.isConfirmed) {

                apiHandler.callPost('content /changeOrder/'+id+'/'+direction,null,(response)=>{

                    Swal.fire({
                        title: "Changed!",
                        text: "Your data has been changed.",
                        icon: "success"
                    });
                    $scope.getDataList();

                },(error)=>{
                },true);

            }

        })
    }
   $scope.smallSubStr=(content)=>{
return content.substr(0,100);
}
$scope.getDataList();

})