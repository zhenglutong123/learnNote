package main;



public class Test2 {


    public static void main(String[] args) {
        Test2 t=new Test2();
        t.talk(new String());//匿名对象

        //匿名子类
        Person m=new Person(){

            @Override
            public void eat() {

            }

            @Override
            public void talk() {

            }
        };

        m.eat();
    }

    public static void talk(Object man) {

    }

    abstract static class Person{
        public abstract void eat();
        public abstract void talk();
    }



    class Man extends Person {


        @Override
        public void eat() {

        }

        @Override
        public void talk() {

        }
    }
}
