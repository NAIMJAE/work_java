package design_patten;

// 인터페이스 설계는 기능 중심 설계
// 1. 콜백 메서드는 자바에서 인터페이스가 필요하다.
interface IButtonListener {
    void clickEvent(String event);
}

public class Button{

    public Button(String name) {
        this.name = name;
    }

    String name;
    private IButtonListener iButtonListener;

    // 버튼이 클릭되었을 때 콜백 메서드를 호출하자
    public void click(String message) {
        if (iButtonListener != null) {
            iButtonListener.clickEvent(message);
        }
    }

    // 이벤트 리스너를 등록 받는 메서드
    // 생성자 의존 주입 DI
    // 메서드 의존 주입
    public void addEventListener(IButtonListener iButtonListener) {
        this.iButtonListener = iButtonListener;

    }
}
