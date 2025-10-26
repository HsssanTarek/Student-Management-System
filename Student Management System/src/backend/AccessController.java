package backend;

public class AccessController {
    private final String username="Admin";
    private final String password="1234";

    public AccessController(){

    }

    public AccessController(backend.AccessController a){
        a.login(username,password);
    }
    public boolean login(String username,String password){
        if(this.username==username && this.password== password)

        {
            return true;
        }
        return false;
    }



}
