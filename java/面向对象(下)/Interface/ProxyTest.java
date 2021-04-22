public class ProxyTest {
    public static void main(String[] args) {
        Worker zhuli=new Zhuli(new Mingx());
        zhuli.openDoor();

        new Worker(){

            @Override
            public void openDoor() {
                System.out.println("出了");
            }
        };
        M m=new M();
        m.k(new H(){

            @Override
            void h() {
                System.out.println("hhh");
            }
        });
    }

}

abstract class H{
    abstract void h();
}
class M {

    public void k(H h){
        h.h();
    }
}
interface Worker{
    void openDoor();
}

class Mingx implements Worker{
    @Override
    public void openDoor() {

        System.out.println("222");
    }
}

class Zhuli implements Worker{
    Worker worker;
    public Zhuli(Worker worker){
        this.worker=worker;
    }
    public void chuan(){
        System.out.println("111");
    }
    @Override
    public void openDoor() {
        chuan();
        worker.openDoor();
    }
}


