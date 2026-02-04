interface LightAction {
    void execute();
}

public class SmartLighting {
    public static void main(String[] args) {

        LightAction motionDetected = () ->
                System.out.println("Lights ON at full brightness");

        LightAction nightTime = () ->
                System.out.println("Lights ON in dim mode");

        LightAction voiceCommand = () ->
                System.out.println("Lights turned ON by voice");

        // Trigger simulation
        motionDetected.execute();
        nightTime.execute();
        voiceCommand.execute();
    }
}
