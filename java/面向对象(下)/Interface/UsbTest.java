/**
 * @author zlt
 * @create 2021-04-22 17:47
 */
public class UsbTest {
    public static void main(String[] args) {
        Computer c=new Computer();
        c.usb(new Flash());



        Usb u=new Usb() {
            @Override
            public void start() {

            }

            @Override
            public void end() {

            }
        };
        c.usb(u);

        c.usb(new Usb() {
            @Override
            public void start() {

            }

            @Override
            public void end() {

            }
        });
    }

}
class Computer{
    public void usb(Usb usb){
        usb.start();
        System.out.println("电脑数据传输中。。。。。。。。。");
        usb.end();
    }
}
interface Usb{
    public void start();
    public void end();
}

class Print implements Usb{

    @Override
    public void start() {
        System.out.println("打印机开始打印");
    }

    @Override
    public void end() {
        System.out.println("打印机结束打印");
    }
}

class Flash implements Usb{

    @Override
    public void start() {
        System.out.println("动画播放");
    }

    @Override
    public void end() {
        System.out.println("动画结束");
    }
}