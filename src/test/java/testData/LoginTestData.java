package testData;

public class LoginTestData {

    private final String EMAIL_KEY = "HRM_EMAIL";
    private final String PASSWORD_KEY = "HRM_PASS";

    public String userLoginEmail;
    public String userLoginPassword;

    public String invalidLoginEmail;

    public String invalidLoginPassword;

    public String expectedTitle = "HRM";
    public String loginPageURL = "https://staging-hrm.htec.co.rs/#/login";

    public LoginTestData() {
        userLoginEmail = System.getenv(EMAIL_KEY);
        userLoginPassword = System.getenv(PASSWORD_KEY);

        invalidLoginEmail = "invalid"  + userLoginEmail;
        invalidLoginPassword = "invalid"  + userLoginPassword;
    }
}
