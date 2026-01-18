package Inheritance;

/*
this class represents a generic Smart Device.
it acts as the superclass, defining properties shared by
all gadgets in a smart home (like ID and current power state).
*/
class Device {
    String deviceId;
    boolean isOn;

    // constructor to initialize common device properties
    Device(String deviceId, boolean isOn) {
        this.deviceId = deviceId;
        this.isOn = isOn;
    }

    // general method to display basic device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Power Status: " + (isOn ? "ON" : "OFF"));
    }
}

/*
this class represents a Thermostat and extends the Device class.
it inherits the power status and ID logic while adding
specific temperature control functionality.
*/
class Thermostat extends Device {
    double temperatureSetting;

    // subclass constructor initializing inherited and local fields
    Thermostat(String deviceId, boolean isOn, double temperatureSetting) {
        /* using super() to invoke the parent constructor,
           ensuring the basic device properties are set up first
        */
        super(deviceId, isOn);
        this.temperatureSetting = temperatureSetting;
    }

    /* method overriding: this specialized version displays
       the basic status PLUS the specific climate settings.
    */
    @Override
    void displayStatus() {
        super.displayStatus(); // reuse parent's display logic
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("------------------------------------------");
    }
}

/*
this class serves as the controller for the smart home system.
*/
public class SmartHome{
    public static void main(String[] args) {
        /* creating a Thermostat object.
           notice that it 'is-a' Device and carries all parent traits.
        */
        Thermostat livingRoomAir = new Thermostat("TH-501", true, 22.5);

        System.out.println("--- Smart Home Dashboard ---");
        // calls the overridden method in the Thermostat class
        livingRoomAir.displayStatus();

        /* demonstrating the ability to use parent methods
           directly if needed.
        */
        if (livingRoomAir instanceof Device) {
            System.out.println("Status Verified: Object is a registered Smart Device.");
        }
    }
}