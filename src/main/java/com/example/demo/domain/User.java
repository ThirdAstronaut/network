package com.example.demo.domain;

import com.example.demo.DTO.UserDTO;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
//import javax.validation.constraints.Size;


@Entity
@Table(name="USERS", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {


    public User(UserDTO userDTO){
        this.email=userDTO.getEmail();
        this.password=userDTO.getPassword();
    }

    @Id
    @GeneratedValue
    private Long id;

/*    @NotNull
  //  @Size(max=100)
    private String username;*/

    //@Size(max = 50, min = 6)
    @Transient
    private String password;

    @NotNull
    private String passwordHash;

    @NotNull
    private String email;

    public User() {

    }

    /*private String passwordResetToken;

   // @Email
   // @Size(max = 200)
    @NotNull
    private String email;
   // @Email
    //@Size(max = 300)
    private String contactEmail;

    *//*@NotNull
    private LocalDateTime accountCreated;
    @NotNull
    private LocalDateTime accountUpdated;

    private LocalDateTime lastActive;


*/
    @PrePersist
    void onAccountCreate(){
    //    this.setAccountCreated(LocalDateTime.now());
     //   this.setLastActive(LocalDateTime.now());
  //      updateModifiedDate();
    }

/*
    private void updateModifiedDate() {
        this.setAccountUpdated(LocalDateTime.now());
    }
*/

/*
    @PreUpdate
    void onAccountUpdated(){
        updateModifiedDate();
    }
*/



    @ManyToMany
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles = new HashSet<>();


/*

    @OneToOne
    @NotNull
    private Image avatar;
*/


    public boolean addRoles(Role role){
        return userRoles.add(role);
    }

    /*public UserDTO userToUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setUsername(username);
        return userDTO;
    }*/

    public void setId(Long id) {
        this.id = id;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
