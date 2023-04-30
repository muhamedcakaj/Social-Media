

import java.time.LocalTime;
import java.util.ArrayList;

public class Messaging {

    private String firstPerson;
    private String secondPerson;
    private ArrayList<String> messaging;

    public Messaging(String firstPerson, String secondPerson) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
        this.messaging = new ArrayList<>();
    }

    public String getFirstPerson() {
        return this.firstPerson;
    }

    public String getSecondPerson() {
        return this.secondPerson;
    }

    public void addMessaging(String name, String messaging) {
        LocalTime currentTime = LocalTime.now();
        this.messaging.add("#"+name + " *" + currentTime.getHour() + ":" + currentTime.getMinute() + "\n" + messaging);
    }

    public boolean conversationHistory(String firstPerson, String secondPerson) {
        return (this.firstPerson.equals(firstPerson) && this.secondPerson.equals(secondPerson))
                || (this.firstPerson.equals(secondPerson) && this.secondPerson.equals(firstPerson));
    }

    public void printMessage() {
        for (String messaging : this.messaging) {
            System.out.println(messaging);
        }
    }

}

