package Methods.Level1;
/*
 * This class determines if a given date falls within the Spring season.
 * Spring is defined as March 20 (3/20) through June 20 (6/20).
 * Input is provided via command line arguments.
 */
public class SpringSeason {
    boolean isSpringSeason(int day, int month){
        // Case 1: Late March (March 20 or later)
        if(month == 3 && day >=20){
            return true;
        }
        // Case 2: Early June (June 20 or earlier)
        else if(month == 6 && day <= 20){
            return true;
        }
        // Case 3: Entirety of April and May (Months 4 and 5)
        else if(month <6 && month >3){
            return true;
        }
        // Case 4: Everything else
        else{
            return false;
        }
    }
    public static void main(String[] args){
        // args[0] and args[1] are Strings provided at startup.
        // We must parse them into integers.
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
