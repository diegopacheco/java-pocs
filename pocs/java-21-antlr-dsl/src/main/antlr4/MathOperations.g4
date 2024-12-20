grammar MathOperations;

@header {
package com.github.diegopacheco.javaplayground.dsl.generated;
}

prog:   expr+ ;

expr:   term (PLUS term | MINUS term)* ;

term:   factor (MULTIPLY factor | DIVIDE factor)* ;

factor: NUMBER ;

PLUS:   'plus' ;
MINUS:  'minus' ;
MULTIPLY: 'multiply by' ;
DIVIDE: 'divided by' ;
NUMBER: [0-9]+ ;

WS: [ \t\r\n]+ -> skip ;