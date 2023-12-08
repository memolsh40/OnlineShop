app.controller('colorListCtrl',function ($scope,apiHandler,$rootScope){
        $scope.query={
        pageSize:10,
        pageNumber:0
};
        $scope.totalCount=0;
        $scope.pageCount=0;
        $scope.dataList=[];
$scope.getDataList=()=>{
    let url = 'color/getAll?pageSize='+$scope.query.pageSize + '&pageNumber='+$scope.query.pageNumber;
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
    $scope.changeMenu('color-edit');
}

$scope.getDataList();

})