 $("#SignInForm").validate({
                rules: {
                    user_login: {
                        required :true
                    },
                    password: {
                        required: true   
                    }
                    
                },
                messages: {
                     user_login: {
                        required: "Please provide a login"
                    },
                    password: {
                        required: "Please provide a password"
                    }
                    
                }
            });
