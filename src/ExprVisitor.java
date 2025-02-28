package src;

public interface ExprVisitor<R> {
    
        R visit(FloatExpr expr);
        R visit(PlusExpr expr);
        R visit(MinusExpr expr);
        R visit(TimesExpr expr);
        R visit(DivExpr expr);
    }

