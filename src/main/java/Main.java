import mykgrow.domain.entities.Actuator;
import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Actuator actuator = new Actuator("Actuator 1", ActuatorType.VENTILATION, ActuatorStatus.OFF);
        System.out.println(actuator.getId());
    }
}