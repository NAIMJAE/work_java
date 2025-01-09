package design_patten;
// 싱글톤 패턴 작성

// 1 정적 변수 선언
// 2 private 생성자 선언
// 3 외부에서 접근할 수 있는 public 메서드를 생성
public class SingleTon {
    // 유일한 인스턴스를 저장할 변수를 선언 (private static)
    private static SingleTon instance;

    // private 생성자 선언 (외부에서 객체를 생성하지 못하게 막음)
    private SingleTon(){}

    // 외부에서 인스턴스 주소를 반환 받을 수 있는 메서드 선언
    public static synchronized SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }

    public static void main(String[] args) {
        // 싱글톤 호출
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();

        System.out.println(singleTon1);
        System.out.println(singleTon2);
        
        if(singleTon1 == singleTon2) {
            System.out.println("같음");
        }
    }
}


