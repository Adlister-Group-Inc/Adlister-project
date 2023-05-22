package adlister.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//---------------------RETURNS TRUE IF ERROR IS PRESENT----------------------\\
public class InputValidation {

    public static boolean emailError (String email) {
        if (email == null) {
            return true;
        } else {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
            Pattern pat = Pattern.compile(emailRegex);

            if(pat.matcher(email).matches()){
                return false;
            }
        }
        return true;
    }

    public static boolean passwordError (String password, String passwordConfirmation){
        if (password == null) {
            return true;
        } else if (password.equals(passwordConfirmation)) {
            String regex = "^(?=.*[a-z])(?=\\S+$).{8,20}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(password);
            if (m.matches()){
                return false;
            }
        }
        return true;
    }

    public static boolean usernameError (String username){
        if (username == null) {
            return false;
        } else {
            String regex = "^(?=.*[a-z])(?=\\S+$).{4,25}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(username);
            if (m.matches()){
                return false;
            }
        }
        return true;
    }

    public static boolean adTitleError (String title){
        System.out.println("made it into adTitleError check");
        String regex = "^(?=.*[a-z]).{5,70}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(title.trim());
        if (m.matches()){
            System.out.println(title + "--- no problems for this ad title");
            return false;
        }
        return true;
    }

    public static boolean adDescError (String description){
        System.out.println("made it into adDescError check");
        String regex = "^(?=.*[a-z]).{5,255}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(description.trim());
        if (m.matches()){
            System.out.println(description + "--- no problems for this ad description");
            return false;
        }
        return true;
    }
}
