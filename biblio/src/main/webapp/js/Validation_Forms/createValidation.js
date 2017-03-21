 $("#CreateUser").validate({
                rules: {
                    nom_user : {
                        required :true
                    },
                    prenom_user : {
                        required :true
                    },
                    email_user: {
                        required: true,
                        email: true
                    },
                    login_user: {
                        required: true
                    },
                    password_user: {
                        required: true,
                        minlength: 5
                    },
                    password2_user: {
                        required: true,
                        minlength: 5
                    }
                    
                },
                messages: {
                     nom_user: {
                        required: "Please provide a name"
                    },
                    prenom_user: {
                        required: "Please provide a prename"
                    },
                    email_user: {
                        email: "Please enter a valid email adress",
                        required: "Please provide an email"
                    },
                    login_user: {
                        required: "Please provide a login"
                    },
                    
                    password_user: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                    password2_user: {
                        required: "Please retype the password",
                        minlength: "Your password must be at least 5 characters long",
                        
                    }
                    
                }
            });
            
            

