package Methods.Level1;

public class SpringSeason {
    boolean isSpringSeason(int day, int month){
        if(month == 3 && day >=20){
            return true;
        }else if(month == 6 && day <= 20){
            return true;
        }else if(month <6 && month >3){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        SpringSeason obj = new SpringSeason();
        boolean result = obj.isSpringSeason(day,month);
        if(result){
            System.out.println("It is spring");
        }else{
            System.out.println("It is not spring");
        }
    }
}
