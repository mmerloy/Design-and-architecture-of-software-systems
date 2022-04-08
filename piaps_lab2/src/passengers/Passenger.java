package passengers;

import java.util.Random;

public class Passenger
{
    public TypePassenger pt;
    public Passenger()
    {
        Random random = new Random();
        int random_passenger =  (random.nextInt(3)+1);
        switch (random_passenger) {
            case (1) -> this.pt = TypePassenger.ADULT;
            case (2) -> this.pt = TypePassenger.CHILD;
            case (3) -> this.pt = TypePassenger.PRIVILEGED;
        }
    }
}

