app.controller("panelCtrl",function ($scope,apiHandler,$cookies,$rootScope){

    $scope.template="views/dashboard.html";
    $scope.templateName="dashboard";
    $scope.templateGroup ="dashboard";

$scope.checkAccess=()=>{

        var token = $cookies.get("usertoken");
        if (token==undefined || token==null || token == ""){
            location.href = "/login";
            return;
        }
        $scope.getUserInfo();

}

$scope.getUserInfo=()=>{

apiHandler.callGet('user/getUserInfo',(response)=>{

$rootScope.userInfo = response.dataList[0];
$scope.user = $rootScope.userInfo;
},(error)=>{

},true)
}

$scope.changeMenu = (templateName)=>{
    $scope.templateName=templateName;
    $scope.template=$scope.getMenuPrefix(templateName);
    $scope.templateGroup=$scope.getMenuGroup(templateName);
}
$scope.getMenuPrefix = (templateName)=>{
    if (templateName==='dashboard'){
        return 'views/'+templateName+'.html';
    } else if(templateName==='nav-list' || templateName ==='nav-add' || templateName ==='nav-edit'){
        return 'views/site/nav/'+templateName+'.html';
    } else if(templateName==='content-list' || templateName ==='content-add' || templateName ==='content-edit'){
        return 'views/site/content/'+templateName+'.html';
    }else if(templateName==='slider-list' || templateName ==='slider-add' || templateName ==='slider-edit'){
        return 'views/site/slider/'+templateName+'.html';
    }else if(templateName==='blog-list' || templateName ==='blog-add' || templateName ==='blog-edit'){
        return 'views/site/blog/'+templateName+'.html';
    }else if(templateName==='user-list' || templateName ==='user-add' || templateName ==='user-edit'){
        return 'views/people/users/'+templateName+'.html';
    }else if(templateName==='category-list' || templateName ==='category-add' || templateName ==='category-edit'){
        return 'views/products/category/'+templateName+'.html';
    }else if(templateName==='color-list' || templateName ==='color-add' || templateName ==='color-edit'){
        return 'views/products/color/'+templateName+'.html';
    }else if(templateName==='size-list' || templateName ==='size-add' || templateName ==='size-edit'){
        return 'views/products/size/'+templateName+'.html';
    }else if(templateName==='product-list' || templateName ==='product-add' || templateName ==='product-edit'){
        return 'views/products/product/'+templateName+'.html';
    }else if(templateName==='uploader'){
        return 'views/utils/'+templateName+'.html';
    }else {
        return 'views/dashboard.html';
    }
}
$scope.getMenuGroup = (templateName)=>{
    if (templateName=='dashboard'){
        return 'dashboard';
    } else if(templateName==='nav-list' || templateName==='nav-edit'||templateName==='nav-add'){
        return 'nav';
    }else if(templateName==='content-list' || templateName==='content-edit'||templateName==='content-add'){
        return 'content';
    }else if(templateName==='slider-list' || templateName==='slider-edit'||templateName==='slider-add'){
        return 'slider';
    }else if(templateName==='blog-list' || templateName==='blog-edit'||templateName==='blog-add'){
        return 'blog';
    }else if(templateName==='user-list' || templateName==='user-edit'||templateName==='user-add'){
        return 'user';
    }else if(templateName==='category-list' || templateName==='category-edit'||templateName==='category-add'){
        return 'category';
    }else if(templateName==='color-list' || templateName==='color-edit'||templateName==='color-add'){
        return 'color';
    }else if(templateName==='size-list' || templateName==='size-edit'||templateName==='size-add'){
        return 'size';
    }else if(templateName==='product-list' || templateName==='product-edit'||templateName==='product-add'){
        return 'product';
    }else if(templateName==='uploader'){
        return 'uploader';
    }else {
        return 'dashboard';
    }
}

    $scope.checkAccess();
});