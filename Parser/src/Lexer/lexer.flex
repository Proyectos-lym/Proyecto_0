package Lexer;
import static Lexer.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
if |
while {lexeme=yytext(); return reservadaCond;}
then |
else {lexeme=yytext(); return reservadaBlock;}
facing |
canput |
canpick |
canmoveindir |
canjumpindir |
canmovetothe |
canjumptothe |
not {lexeme=yytext(); return condicion;}
assingto |
goto |
move |
turn |
face |
put |
pick |
movetothe |
moveindir |
jumptothe |
jumpindir |
nop {lexeme=yytext(); return instruccion;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"repeat" {return times;}
"do" {return abrirdo;}
"od" {return cerrardo;}
"=" {return igual;}
"+" {return suma;}
"-" {return resta;}
"*" {return multiplicacion;}
"/" {return division;}
"[" {return corchetei;}
"]" {return corcheted;}
"(" {return parentesisi;}
")" {return parentesisd;}
"|" {return pipeline;}
";" {return semicolon;}
"," {return coma;}
":" {return colon;}
"robot_r" {return inicio;}
"vars" {return var;}
"procs" {return funcion;}
{L}({L}|{D})* {lexeme=yytext(); return identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return numero;}
 . {return error;}