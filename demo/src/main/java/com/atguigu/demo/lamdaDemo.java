package com.atguigu.demo;

@FunctionalInterface
interface Foo{
    public  int sayHello(int x, int y);
     default  int div(int x ,int y){
         return  x*y;
     };
    static   int div2(int x ,int y){
        return  x*y;
    };
//    public  void speak();
}


public class lamdaDemo {
    public static void main(String[] args) {
//       Foo foo =new Foo() {
//           @Override
//           public void sayHello() {
//               System.out.println("hello 0805");
//           }
//       };
//       foo.sayHello();


        Foo foo2 = ( x,  y) -> {
            System.out.println("hello 0805java");
            return x + y;
        };
        foo2.sayHello(3, 5);
    }
}