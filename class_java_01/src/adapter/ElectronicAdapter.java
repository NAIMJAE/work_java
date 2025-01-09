package adapter;

// 핵심 개념
// 어댑터 클래스는 두 객체 간의 중재자로서, 서로 다른 인터페이스를 가진 객체들을 함께 동작하게 만들 수 있다.
// 코드 상에서 110v 을 220v 에서 사용 가능하게 중간 역할을 시킴

// 1 최종 쓰고자하는 인터페이스를 구현
public class ElectronicAdapter implements IElectronic220v {

    // 2 내부에 변경 기능 구현
    private IElectronic110v iElectronic110v;

    @Override
    public void connect() {
        iElectronic110v.connect();
        System.out.println("어댑터를 통해 110v를 220v로 연결");
    }

    public ElectronicAdapter(IElectronic110v iElectronic110v) {
        this.iElectronic110v = iElectronic110v;
    }
}
