package homework6.Task2;

public class SighIn {

    public static boolean validationCheck (String validation)
    {
        if (!validation.matches("[0-9a-zA-Z_]*")){
            return false;
        }
        else if (validation.length() > 20 || validation.length() < 1) {
            return false;
        }
        else {
            return true;
        }
    }


    public static boolean loginFields(String login, String password, String confirmPassword)
    {
        try {
            if (!validationCheck(login)) {
                throw new WrongLoginException();
            } else if (!validationCheck(password))
            {
                throw new WrongPasswordException();
            } else if (!password.equals(confirmPassword))
            {
                System.out.println("Confirmation of password aren`t equal to password");
                return false;
            }
        }

        catch (WrongLoginException l)
        {
            System.out.println(l.wrongLoginExcepionMessage());
            return false;
        }

        catch (WrongPasswordException p)
        {
            System.out.println(p.wrongPasswordExceptionMessage());
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(loginFields("UserLog", "PASsswww11_1", "PASsswww11_1"));
    }
}
