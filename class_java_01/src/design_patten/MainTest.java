package design_patten;

public class MainTest {
    public static void main(String[] args) {
        Button button = new Button("Click1 btn");

        // 이벤트 리스너를 설계
        // 사용하는 측 입장에서 내가 원하는 이벤트 리스너를 등록하고 이벤트 핸들러 처리 가능
        button.addEventListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println("콜백 넘겨 받은 메세지 : " + event);
            }
        });

        System.out.println("-------------------------");

        button.click("내가 클릭했음!!!!");

    }
}
