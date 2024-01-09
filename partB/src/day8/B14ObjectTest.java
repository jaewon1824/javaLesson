package day8;

import Test.Square;
import day7.Diamond;
import day7.Shape;
import day7.Triangle;

/* 
 * 모든 자바 클래스의 부모는 Object 타입.
 * 
 * 
 * 
 */
public class B14ObjectTest {
    public static void main(String[] args) {
        
        //Object 타입으로 업캐스팅
        Object ob1 = new String("Hello java~");
        Object ob2 = new Diamond();
        Object ob3 = 3;         // 3은 int 정수. -> Integer 객체로 변경 -> Object

        //기본형 타입은 Wrapper 클래스로 객체로 변경되서 Object 로 업캐스팅
        //                  ㄴ Byte,Character,Short,Integer,Long,Float,Double
        //                  ㄴ 다른 자료구조 List, Map, Set 등은 객체(클래스) 타입만 다룹니다.

        //Object 클래스의 메소드 - 모든 자바클래스가 상속받고 있습니다.
        //                  ㄴ getClass, toString, hashcode, equals,  그 외는 스레드 관련 메소드
        //                  ㄴ String 클래스 equals는 Object 메소드 재정의(오버라이드)

        System.out.println("getClass는 클래스의 타입 정보를 리턴합니다. ");
        //getName은 클래스 타입정보 중 클래스 이름 리턴
        System.out.println("ob1 getClass = " + ob1.getClass().getName());
        System.out.println("ob2 getClass = " + ob2.getClass().getName());
        System.out.println("ob3 getClass = " + ob3.getClass().getName());
    
        System.out.println("hashcode는 객체의 참조값(식별값)을 리턴");
        System.out.println("\t ob1 hashcode =" + ob1.hashCode()+ "," + Integer.toHexString(ob1.hashCode()));
        System.out.println("\t ob1 hashcode =" + ob2.hashCode()+ "," + Integer.toHexString(ob2.hashCode()));
        System.out.println("\t ob1 hashcode =" + ob3.hashCode()+ "," + Integer.toHexString(ob3.hashCode()));
        
        
        
        System.out.println("toString 확인 - 참조변수를 출력할 때 문자열 표현값 리턴");
        System.out.println("\t ob1 toString = " + ob1.toString());      //String은 toString 재정의
        System.out.println("\t ob2 toString = " + ob2.toString());      //Object toString의 기본값 출력
        System.out.println("\t ob3 toString = " + ob3.toString());      //Integer는 toString 재정의
        System.out.println("\t ob1 = " + ob1);              //toString메소드는 생략하고 쓸 수 있습니다.
        System.out.println("\t ob2 = " + ob2);
        System.out.println("\t ob3 = " + ob3);


        System.out.println("우리가 만든 클래스의 toString 재정의 확인");
        Shape sh2 = new Shape("아직모름", 25, 20);
        Shape diamond = new Diamond();      //인스턴스 필드는 초기값 0 입니다.
        Shape square = new Square();
        Triangle tirangle = new Triangle("삼각형", 20, 30, 65);
        
        System.out.println("\t sh2 = " + sh2);
        System.out.println("\t diamond = " + diamond);      //자식클래스 Diamond가 정의한 toString
        System.out.println("\t square = " + square);        //부모 Shape이 정의한 toString
        System.out.println("\t triangle = " + tirangle);    //부모 Shape이 정의한 toString



         



    }
}
