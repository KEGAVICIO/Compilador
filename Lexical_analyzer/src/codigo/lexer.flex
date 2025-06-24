import static codigo.Tokens.*;
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
float |
long |
double |
string |
char |
int |
if |
else |
sing | //leer
lyrica | //escribir
raiz |
for |
switch |
y |
o |
break |
case |
do |
void |
return |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignora*/}
"//".* {/*Ignora*/}
"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"<" {lexeme=yytext(); return Menorque;}
"%" {lexeme=yytext(); return Residuo;}
"'" {lexeme=yytext(); return ComillasS;}
"\"" {lexeme=yytext(); return ComillasD;}
">" {lexeme=yytext(); return Mayorque;}
"<=" {lexeme=yytext(); return Menorigual;}
">=" {lexeme=yytext(); return Mayorigual;}
"!=" {lexeme=yytext(); return Diferente;}
"{" {lexeme=yytext(); return Ibloque;}
"}" {lexeme=yytext(); return Fbloque;}
"(" {lexeme=yytext(); return Iparent;}
")" {lexeme=yytext(); return Fparent;}
";" {lexeme=yytext(); return Flinea;}
":" {lexeme=yytext(); return Iinstru;} //comentario
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}