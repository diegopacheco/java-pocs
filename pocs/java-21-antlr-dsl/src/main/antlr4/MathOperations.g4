grammar MathOperations;

@header {
package com.github.diegopacheco.javaplayground.dsl.generated;
}

prog:   expr+ ;

expr:   expr PLUS term
    |   expr MINUS term
    |   expr ADD term
    |   term
    ;

term:   term MULTIPLY factor
    |   term DIVIDE factor
    |   factor
    ;

factor: NUMBER ;

PLUS:   'plus' ;
MINUS:  'minus' ;
MULTIPLY: 'multiply by' ;
DIVIDE: 'divided by' ;
ADD:    'add' ;
NUMBER: [0-9]+ ;

WS: [ \t\r\n]+ -> skip ;