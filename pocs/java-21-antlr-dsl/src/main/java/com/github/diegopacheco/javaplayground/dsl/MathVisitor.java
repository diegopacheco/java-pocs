package com.github.diegopacheco.javaplayground.dsl;

import com.github.diegopacheco.javaplayground.dsl.generated.*;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.ExprContext;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.ProgContext;

public class MathVisitor extends MathOperationsBaseVisitor<Integer> {
    @Override
    public Integer visitProg(ProgContext ctx) {
        for (ExprContext expr : ctx.expr()) {
            System.out.println(visit(expr));
        }
        return 0;
    }

    @Override
    public Integer visitExpr(ExprContext ctx) {
        int result = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            if (ctx.getChild(2 * i - 1).getText().equals("plus")) {
                result += visit(ctx.term(i));
            } else if (ctx.getChild(2 * i - 1).getText().equals("minus")) {
                result -= visit(ctx.term(i));
            }
        }
        return result;
    }

    @Override
    public Integer visitTerm(com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.TermContext ctx) {
        int result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            if (ctx.getChild(2 * i - 1).getText().equals("multiply by")) {
                result *= visit(ctx.factor(i));
            } else if (ctx.getChild(2 * i - 1).getText().equals("divided by")) {
                result /= visit(ctx.factor(i));
            }
        }
        return result;
    }

    @Override
    public Integer visitFactor(com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.FactorContext ctx) {
        return Integer.parseInt(ctx.NUMBER().getText());
    }
}