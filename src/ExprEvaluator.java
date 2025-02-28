package src;

// Implements ExprVisitor to evaluate expressions
public class ExprEvaluator implements ExprVisitor<Float> {
    private float result;  // Stores the computed result

    public float getResult() {
        return result;
    }

    @Override
    public Float visit(FloatExpr expr) {
        return expr.eval(); 
    }

    @Override
    public Float visit(PlusExpr expr) {
        return expr.getE1().accept(this) + expr.getE2().accept(this);
    }

    @Override
    public Float visit(MinusExpr expr) {
        return expr.getE1().accept(this) - expr.getE2().accept(this);
    }

    @Override
    public Float visit(TimesExpr expr) {
        return expr.getE1().accept(this) * expr.getE2().accept(this);
    }

    @Override
    public Float visit(DivExpr expr) {
        float denominator = expr.getE2().accept(this);
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return expr.getE1().accept(this) / denominator;
    }
}
