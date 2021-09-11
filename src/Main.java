import exeption.ConstructorException;

public class Main {
    public static void main(String[] args) throws ConstructorException {
//        System.out.println("OK");
//        SimpleFraction F=new SimpleFraction(1,2);
//        F.print();
//        SimpleFraction F2=new SimpleFraction(3,9);
//        F2.print();
        SimpleFraction F3 = new SimpleFraction("3/9");
        F3.print();
        F3.copy().print();
    }
}