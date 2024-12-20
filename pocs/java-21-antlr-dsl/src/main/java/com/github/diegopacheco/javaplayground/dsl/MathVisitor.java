package com.github.diegopacheco.javaplayground.dsl;

import com.github.diegopacheco.javaplayground.dsl.generated.*;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.ExprContext;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.ProgContext;

public class MathVisitor extends MathOperationsBaseVisitor<Integer> {
    @Override
    public Integer visitProg(ProgContext ctx) {
        int result = 0;
        for (ExprContext expr : ctx.expr()) {
            result = visit(expr);
            System.out.println(result);
        }
        return result;
    }

    @Override
    public Integer visitExpr(ExprContext ctx) {
        int result = visit(ctx.term());
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            if (ctx.getChild(i).getText().equals("plus")) {
                result += visit(ctx.getChild(i + 1));
            } else if (ctx.getChild(i).getText().equals("minus")) {
                result -= visit(ctx.getChild(i + 1));
            } else if (ctx.getChild(i).getText().equals("add")) {
                result += visit(ctx.getChild(i + 1));
            }
        }
        return result;
    }

    @Override
    public Integer visitTerm(com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.TermContext ctx) {
        int result = visit(ctx.factor());
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            if (ctx.getChild(i).getText().equals("multiply by")) {
                result *= visit(ctx.getChild(i + 1));
            } else if (ctx.getChild(i).getText().equals("divided by")) {
                result /= visit(ctx.getChild(i + 1));
            }
        }
        return result;
    }

    @Override
    public Integer visitFactor(com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser.FactorContext ctx) {
        return Integer.parseInt(ctx.NUMBER().getText());
    }
}