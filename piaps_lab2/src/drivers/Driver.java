package drivers;

import java.util.Random;
import static java.lang.Math.random;

public class Driver
{

    public TypeLicence lt;
    //зарандомим лицензию водителя
    public Driver()
    {
        new Random();
        int random_licence = (int) (random()* 4);
        switch (random_licence)
        {
            case  (1):
                this.lt = TypeLicence.A;
                break;
            case (2):
                this.lt = TypeLicence.B;
                break;
            case (3):
                this.lt = TypeLicence.T;
                break;
            default:
                this.lt = TypeLicence.MISS;
                break;
        }
    }

}