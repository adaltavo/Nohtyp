package NohtypPackage;
////////////////////////////import static NohtypPackage.Token.*;
import java_cup.runtime.*;
%%
%cupsym Simbolo
%class Lexer2
%cup
%public
%unicode
%line
%char
%ignorecase
%type Token
L = [a-zA-Z_]
D = [0-9]
W=[ \t\n\x0B\f\r]
%{
public String lexeme;
%}
%%
({W}) {/*Ignore*/}


"False" {return new Symbol(Simbolo.tfalse,yychar,yyline);}
"None"  {return new Symbol(Simbolo.tnone,yychar,yyline);}
"True"  {return new Symbol(Simbolo.ttrue,yychar,yyline);}
"and"   {return new Symbol(Simbolo.tand,yychar,yyline);}
"as"    {return new Symbol(Simbolo.tas,yychar,yyline);}
"assert" {return new Symbol(Simbolo.tassert,yychar,yyline);}
"break" {return new Symbol(Simbolo.tbreak,yychar,yyline);}
"class" {return new Symbol(Simbolo.tclass,yychar,yyline);}
"continue"  {return new Symbol(Simbolo.tcontinue,yychar,yyline);}
"def"   {return new Symbol(Simbolo.tdef,yychar,yyline);}
"del"   {return new Symbol(Simbolo.tdel,yychar,yyline);}
"elif"  {return new Symbol(Simbolo.telif,yychar,yyline);}
"else"  {return new Symbol(Simbolo.telse,yychar,yyline);}
"except" {return new Symbol(Simbolo.texcept,yychar,yyline);}
"finally" {return new Symbol(Simbolo.tfinally,yychar,yyline);}  
"for"   {return new Symbol(Simbolo.tfor,yychar,yyline);}
"from"  {return new Symbol(Simbolo.tfrom,yychar,yyline);}
"global" {return new Symbol(Simbolo.tglobal,yychar,yyline);}
"if"    {return new Symbol(Simbolo.tif,yychar,yyline);}
"import" {return new Symbol(Simbolo.timport,yychar,yyline);}
"in"    {return new Symbol(Simbolo.tin,yychar,yyline);}
"is"    {return new Symbol(Simbolo.tis,yychar,yyline);}
"lambda" {return new Symbol(Simbolo.tlambda,yychar,yyline);}
"nonlocal" {return new Symbol(Simbolo.tnonlocal,yychar,yyline);}
"not"   {return new Symbol(Simbolo.tnot,yychar,yyline);}
"or"    {return new Symbol(Simbolo.tor,yychar,yyline);}
"pass"  {return new Symbol(Simbolo.tpass,yychar,yyline);}
"raise" {return new Symbol(Simbolo.traise,yychar,yyline);}
"return" {return new Symbol(Simbolo.treturn,yychar,yyline);}
"try"   {return new Symbol(Simbolo.ttry,yychar,yyline);}
"while" {return new Symbol(Simbolo.twhile,yychar,yyline);}
"with"  {return new Symbol(Simbolo.twith,yychar,yyline);}
"yield" {return new Symbol(Simbolo.tyield,yychar,yyline);}
"range" {return new Symbol(Simbolo.trange,yychar,yyline);}
";" {return new Symbol(Simbolo.tpuntocoma,yychar,yyline);}
"input" {return new Symbol(Simbolo.tinput,yychar,yyline);}
"print" {return new Symbol(Simbolo.tprint,yychar,yyline);}

"\""({L}|{D})*"\"" {return new Symbol(Simbolo.tstring,yychar,yyline,new String (yytext()));}
"'"({L}|{D})*"'" {return new Symbol(Simbolo.tstring,yychar,yyline,new String (yytext()));}
"'"({L}|{D})"'" {return new Symbol(Simbolo.tchar,yychar,yyline,new String (yytext()));}
{L}({L}|{D})* {return new Symbol(Simbolo.tid,yychar,yyline,new String (yytext()));}
("(-"{D}+")")|{D}+ {return new Symbol(Simbolo.tint,yychar,yyline,new String (yytext()));}
(("-"{D}+"."{D}+)|({D}+"."{D}+)) {return new Symbol(Simbolo.treal,yychar,yyline,new String (yytext()));}


("#"(" "|{L}|{D}|"."|",")*)  {/*return new Symbol(Simbolo.tcomentarios,yychar,yyline); ignorar */}

"+" {return new Symbol(Simbolo.tmas,yychar,yyline);}
"-" {return new Symbol(Simbolo.tmenos,yychar,yyline);}
"*" {return new Symbol(Simbolo.tpor,yychar,yyline);}
"/" {return new Symbol(Simbolo.tentre,yychar,yyline);}
"%" {return new Symbol(Simbolo.tmodulo,yychar,yyline);}


"==" {return new Symbol(Simbolo.tigualque,yychar,yyline);}
"!=" {return new Symbol(Simbolo.tdiferente,yychar,yyline);}
"<=" {return new Symbol(Simbolo.tigualmenor,yychar,yyline);}
">=" {return new Symbol(Simbolo.tigualmayor,yychar,yyline);}
"<"  {return new Symbol(Simbolo.tmenor,yychar,yyline);}
">"  {return new Symbol(Simbolo.tmayor,yychar,yyline);}

"=" {return new Symbol(Simbolo.tigual,yychar,yyline);}
"+=" {return new Symbol(Simbolo.tigualmas,yychar,yyline);}
"-=" {return new Symbol(Simbolo.tigualmenos,yychar,yyline);}

"{" {return new Symbol(Simbolo.tabre,yychar,yyline);}
"}" {return new Symbol(Simbolo.tcierra,yychar,yyline);}
"[" {return new Symbol(Simbolo.tabrec,yychar,yyline);}
"]" {return new Symbol(Simbolo.tcierrac,yychar,yyline);}
"(" {return new Symbol(Simbolo.tabrep,yychar,yyline);}
")" {return new Symbol(Simbolo.tcierrap,yychar,yyline);}
"," {return new Symbol(Simbolo.tcoma,yychar,yyline);}
":" {return new Symbol(Simbolo.tpuntos,yychar,yyline);}
"." {return new Symbol(Simbolo.tpunto,yychar,yyline);}

.		{Ventana.error("ERROR LEXICO: Cadena:   '"+  yytext()+"'    inválida, en la línea:"+(yyline+1) +" y columna " + yychar+"Revisa tus caracteres utilizados");}
