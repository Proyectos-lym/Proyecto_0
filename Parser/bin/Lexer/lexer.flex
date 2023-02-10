package Lexer;
import static Lexer.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    public String lexeme;
%}
%%
if |
while {lexeme=yytext(); return reservadaCond;}
then |
do |
else {lexeme=yytext(); return reservadaBlock;}
facing {return condicion1;} 
canput |
canpick |
canmoveindir |
canjumpindir |
canmovetothe |
canjumptothe {lexeme=yytext(); return condicion2;}
not {return negacion;}
assignto |
goto |
put |
pick |
movetothe |
moveindir |
jumptothe |
jumpindir {lexeme=yytext(); return instruccion2;}
nop { return quieto;}
move |
turn |
face {lexeme=yytext(); return instruccion1;}
north |
south |
west |
east {lexeme=yytext(); return cardinal;}
front |
left |
right |
back {lexeme=yytext(); return direccion;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"repeat" {return times;}
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
"," {return comma;}
":" {return colon;}
"robot_r" {return inicio;}
"vars" {return var;}
"procs" {return funcion;}
"balloons" {return globo;}
"chips" {return chips;}
{L}({L}|{D})* {lexeme=yytext(); return identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return numero;}
 . {return error;}