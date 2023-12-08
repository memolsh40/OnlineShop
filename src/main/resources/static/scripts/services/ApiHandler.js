app.service("apiHandler",function ($http,$cookies){


    this.callPost = (url,data,onSuccess,onerror,setToken)=>{
        url="/api/"+url;


            let request = {
                url: url,
                method:'POST',
                data:data
            };


         this.checkAndSetToken(request,setToken);

         $http(request).then((respons) =>{

            if (respons != null &&  respons.data !=null){
                debugger;
                let result = respons.data;
                if (result.status === "SUCCESS"){
                    onSuccess(result);
                }else if (result.hasError){
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: result.message,
                    });
                }else {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "unKnown error!! :(",
                    });


                }
                debugger;
            }(err) => {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Exeption on server",
                });
                onerror(err);
            };
        })
    }

    this.callGet = (url,onSuccess,onerror,setToken)=>{
        url="/api/"+url;
        let request = {
            url: url,
            method:'GET',

        };

        this.checkAndSetToken(request,setToken);
        $http(request).then((respons) =>{
            if (respons != null &&  respons.data !=null){
                let result = respons.data;
                if (result.status == "SUCCESS"){
                    onSuccess(result);
                }else if (result.hasError){
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: result.message,
                    });
                }else {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "unKnown error!! :(",
                    });


                }
                debugger;
            }(err) => {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Exeption on server",
                });
                onerror(err);
            };

        })
    }

    this.callPut= (url,data,onSuccess,onerror,setToken)=>{
        url="/api/"+url;
        let request = {
            url: url,
            method:'PUT',
            data:data

        };

        this.checkAndSetToken(request,setToken);
        $http(request).then((respons) =>{

            if (respons != null &&  respons.data !=null){
                let result = respons.data;
                if (result.status == "SUCCESS"){
                    onSuccess(result);
                }else if (result.hasError){
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: result.message,
                    });
                }else {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "unKnown error!! :(",
                    });


                }
                debugger;
            }(err) => {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Exeption on server",
                });
                onerror(err);
            };

        })
    }

    this.callDelete = (url,onSuccess,onerror,setToken)=>{

        url="/api/"+url;
        let request = {
            url: url,
            method:'DELETE'

        };
        this.checkAndSetToken(request,setToken);
        $http(request).then((respons) =>{
            if (respons != null &&  respons.data !=null){

                let result = respons.data;
                if (result.status == "SUCCESS"){
                    onSuccess(result);
                }else if (result.hasError){
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: result.message,
                    });
                }else {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "unKnown error!! :(",
                    });


                }
                debugger;
            }(err) => {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Exeption on server",
                });
                onerror(err);
            };

        })
    }

    this.checkAndSetToken =  (request, setToken)=> {
        if (setToken) {

            let token = $cookies.get("usertoken");
            request.headers = {
                'Authorization': 'Bearer ' + token
            };

        }
    };

})