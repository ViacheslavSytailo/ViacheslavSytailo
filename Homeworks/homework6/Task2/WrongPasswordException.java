package homework6.Task2;

public class WrongPasswordException extends Exception
{
    public String wrongPasswordExceptionMessage(){
        return "Wrong password. Password must contain only latin characters and numbers";
    }
}
