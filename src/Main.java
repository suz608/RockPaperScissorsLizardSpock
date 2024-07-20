public class Main {
    public static void main(String[] args) {
        Model testModel=new Model();
        JFrameView testView=new JFrameView();
        Controller testController=new Controller(testModel,testView);
        testController.go();
    }
}