package NohtypPackage;
import static NohtypPackage.Token.*;
import java_cup.runtime.*;
%%
%class Lexer
%type Token
L = [a-zA-Z_]
D = [0-9]
W=[ \t\n\x0B\f\r]
%{
public String lexeme;
%}
%%
({W}) {/*Ignore*/}


("False"|"None"|"True"|"and"|"as"|"assert"|"break"|"class"|"continue"|"def"|"del"|"elif"|"else"|"except"|"finally"|"for"|"from"|"global"|"if"|"import"|"in"|"is"|"lambda"|"nonlocal"|"not"|"or"|"pass"|"raise"|"return"|"try"|"while"|"with"|"yield")
{lexeme=yytext(); return PalabraReservada;}

{L}({L}|{D})* {lexeme=yytext(); return ID;}
 ("(-"{D}+")")|{D}+ {lexeme=yytext(); return INT;}

(("-"{D}+"."{D}+)|({D}+"."{D}+)) {lexeme=yytext(); return REAL;} 

("#"(" "|{L}|{D}|"."|",")*)   
{lexeme = yytext(); return comentarios;}

("'''"(" "|{L}|{D}|"."|",")*"'''")   
{lexeme = yytext(); return Lineascomentarios;}

("+"|"-"|"*"|"/"|"%"|"**"|"//")
{lexeme=yytext(); return operadoresAritmeticos;} 

("=="|"!="|"<>"|">"|"<"|">="|"=<")
{lexeme=yytext(); return operadoresOperacion;} 

("="|"+="|"-="|"*="|"/="|"**="|"//=")
{lexeme=yytext(); return operadoresAsignacion;} 

("&"|"|"|"^"|"~"|"<<"|">>")
{lexeme=yytext(); return operadoresBit;} 

("and"|"or"|"not")
{lexeme=yytext(); return operadoresBoleanos;}

("{"|"}"|"["|"]"|"("|")"|":"|"."|"\""|"'")
{lexeme=yytext(); return operadoresAgrupacion;}


.		{Ventana.error("Cadena o Simbolo no pertenece al Alfabeto: "+  yytext());}

