package com.example.demo.DTO;



public class UserDTO {
    private String email;
    private String password;

    //  @ValidPassword

/*
    //@ValidPassword
    @Size(max = 50, min = 6)
    private String passwordConfirmation;
    @Size(max = 100)
    private String resetPasswordToken;
*/

/*
    @Email
    @Size(max = 200)
    private String email;
*/

    public boolean isPasswordCorrect() {
        return password.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{6,}$");
    }


/*
    public boolean arePasswordsTheSame() {
        return password.equals(passwordConfirmation);
    }
*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public UserDTO() {
    }
}
