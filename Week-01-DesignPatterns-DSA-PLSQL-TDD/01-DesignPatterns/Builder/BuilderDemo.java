package builder;

public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("--- Builder Pattern Demo ---");
        
        // Building a basic office workstation
        Computer officePC = new Computer.ComputerBuilder("16GB", "512GB SSD")
                .setBluetoothEnabled(true)
                .build();
        System.out.println("Office PC: " + officePC);

        // Building a high-end gaming rig
        Computer gamingPC = new Computer.ComputerBuilder("32GB", "2TB NVMe SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();
        System.out.println("Gaming PC: " + gamingPC);
    }
}
