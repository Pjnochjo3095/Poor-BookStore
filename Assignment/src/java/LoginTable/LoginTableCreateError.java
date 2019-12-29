/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginTable;

import java.io.Serializable;

/**
 *
 * @author SE130162
 */
public class LoginTableCreateError implements Serializable{
    private String usernameLengthError;
    private String passwordLengthError;
    private String lastNameLengthError;
    private String confirmIsNotMatched;
    private String usernameIsExisted;

    public LoginTableCreateError() {
    }
    
    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getLastNameLengthError() {
        return lastNameLengthError;
    }

    public void setLastNameLengthError(String lastNameLengthError) {
        this.lastNameLengthError = lastNameLengthError;
    }

    public String getConfirmIsNotMatched() {
        return confirmIsNotMatched;
    }

    public void setConfirmIsNotMatched(String confirmIsNotMatched) {
        this.confirmIsNotMatched = confirmIsNotMatched;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
    
}
