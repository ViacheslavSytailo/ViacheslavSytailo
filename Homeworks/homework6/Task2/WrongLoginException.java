package homework6.Task2;

public class WrongLoginException extends Exception
{
public String wrongLoginExcepionMessage(){
    return "Wrong login. Login must contain only latin characters and numbers";
}
}
