import exeption.ConstructorException;
import model.Fraction;

public class SimpleFraction extends Fraction {
    SimpleFraction(int a, int b) throws ConstructorException {
        super(a, b);
    }

    SimpleFraction(String f) throws ConstructorException {
        super(f);
    }

    @Override
    public SimpleFraction addition(Fraction f2) throws ConstructorException {
        SimpleFraction f = (SimpleFraction) super.getFraction();
        if (f.b == f2.getB()) {
            return new SimpleFraction(f.a + f2.getA(), f.b);
        } else {
            int b = f.b * f2.getB();
            int a = f.a * f2.getA();
            a += f2.getA() * f.b;
            return new SimpleFraction(a, b);
        }
    }

    @Override
    public SimpleFraction subtraction(Fraction f2) throws ConstructorException {
        return addition(new SimpleFraction(f2.getA() * (-1), f2.getB()));
    }

    @Override
    public Fraction multiplication(Fraction f2) throws ConstructorException {
        return new SimpleFraction(super.a * f2.getA(), super.b * f2.getB());
    }

    @Override
    public Fraction division(Fraction f2) throws ConstructorException {
        return new SimpleFraction(super.a * f2.getB(), super.b * f2.getA());
    }

    @Override
    public Fraction square() throws ConstructorException {
        return new SimpleFraction(super.a * super.a, super.b);
    }

    @Override
    public Fraction inverse() throws ConstructorException {
        return new SimpleFraction(super.b, super.a);
    }

    @Override
    public Fraction minus() throws ConstructorException {
        return new SimpleFraction((-1) * super.a, super.b);
    }
}
