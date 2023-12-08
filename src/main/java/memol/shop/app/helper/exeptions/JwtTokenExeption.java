package memol.shop.app.helper.exeptions;

public class JwtTokenExeption extends Exception{
    public JwtTokenExeption(String mssage){
        super(mssage);
    }
}
