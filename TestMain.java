public class TestMain {

    public static void main(String[] args) {

        Saab95 mySaab = new Saab95();

        // Testa Saab95-specifika metoder
        mySaab.setTurboOn();
        System.out.println("Saab Turbo on: " + mySaab.speedFactor());

        mySaab.setTurboOff();
        System.out.println("Saab Turbo off: " + mySaab.speedFactor());

        // Testa generella metoder från Car-klassen
        System.out.println("Saab Speed at start: " + mySaab.getCurrentSpeed());
        mySaab.startEngine();
        mySaab.gas(2);
        System.out.println("Saab Speed after gas: " + mySaab.getCurrentSpeed());

        mySaab.brake(1);
        System.out.println("Saab Speed after braking: " + mySaab.getCurrentSpeed());

        Volvo240 myVolvo = new Volvo240();
        System.out.println("Volvo Speed at start: " + myVolvo.getCurrentSpeed());
        myVolvo.startEngine();
        myVolvo.gas(2);
        System.out.println("Volvo Speed after gas: " + myVolvo.getCurrentSpeed());

        myVolvo.brake(1);
        System.out.println("Volvo Speed after braking: " + myVolvo.getCurrentSpeed());
    }
    
}
