package adapter;

interface IElectronic220v {
    void connect();
}

interface IElectronic110v {
    void connect();
}

public class MyHouse {
    
    // 정적 메서드
    // 집에 220v 전기콘센트를 연결하는 메서드
    public static void homeConnect(IElectronic220v iElectronic220v) {
        // 콘센트 연결하는 행위
        iElectronic220v.connect();
    }
    
    //
    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        AirConditioner airConditioner = new AirConditioner();

        ElectronicAdapter adapterHairDryer = new ElectronicAdapter(hairDryer);

        // 문제 110v -> 220v
        // homeConnect(hairDryer);
        homeConnect(adapterHairDryer);

        homeConnect(airConditioner);
    }
}

class HairDryer implements IElectronic110v {
    @Override
    public void connect() {
        System.out.println("헤어 드라이어 연결");
    }
}

class AirConditioner implements IElectronic220v {
    @Override
    public void connect() {
        System.out.println("에어컨 연결");
    }
}
