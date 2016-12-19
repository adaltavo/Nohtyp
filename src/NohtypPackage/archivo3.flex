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
%type Symbol
L = [a-zA-Z_]
D = [0-9]
W=[ \t\n\x0B\f\r]
%{
public String lexeme;
%}
%%
({W}) {/*Ignore*/}
	

"False" {return new Symbol(Simbolo.tfalse,yychar,yyline);}
"True"  {return new Symbol(Simbolo.ttrue,yychar,yyline);}
"and"   {return new Symbol(Simbolo.tand,yychar,yyline);}
"elif"  {return new Symbol(Simbolo.telif,yychar,yyline);}
"else"  {return new Symbol(Simbolo.telse,yychar,yyline);}
"for"   {return new Symbol(Simbolo.tfor,yychar,yyline);}
"if"    {return new Symbol(Simbolo.tif,yychar,yyline);}
"in"    {return new Symbol(Simbolo.tin,yychar,yyline);}
"not"   {return new Symbol(Simbolo.tnot,yychar,yyline);}
"or"    {return new Symbol(Simbolo.tor,yychar,yyline);}
"while" {return new Symbol(Simbolo.twhile,yychar,yyline);}
"range" {return new Symbol(Simbolo.trange,yychar,yyline);}
";" {return new Symbol(Simbolo.tpuntocoma,yychar,yyline);}
"input" {return new Symbol(Simbolo.tinput,yychar,yyline);}
"print" {return new Symbol(Simbolo.tprint,yychar,yyline);}
"str" {return new Symbol(Simbolo.tstr,yychar,yyline);}
"xinput" {return new Symbol(Simbolo.txinput,yychar,yyline);}
"array"  {return new Symbol(Simbolo.tarray,yychar,yyline);}
"xarray" {return new Symbol(Simbolo.txarray,yychar,yyline);}

"\""({L}|{D}|{W}|"."|","|"\\"|"/"|"*"|"+"|"-"|"%"|"="|"!"|"<"|">"|"("|")"|"["|"]"|"{"|"}"|":"|";"|"$")*"\"" {return new Symbol(Simbolo.tstring,yychar,yyline,new String (yytext()));}
"'"({L}|{D}|{W})*"'" {return new Symbol(Simbolo.tstring,yychar,yyline,new String (yytext()));}
"'"({L}|{D})"'" {return new Symbol(Simbolo.tchar,yychar,yyline,new String (yytext()));}
{L}({L}|{D})* {TablaDS.Insertar(new String(yytext()),"",yyline,"id",""); return new Symbol(Simbolo.tid,yychar,yyline,new String (yytext()));}
{D}+ {return new Symbol(Simbolo.tint,yychar,yyline,new String (yytext()));}
({D}+"."{D}+) {return new Symbol(Simbolo.treal,yychar,yyline,new String (yytext()));}


("#"(" "|{L}|{D}|"."|","|"\\ñ")*)  {/*return new Symbol(Simbolo.tcomentarios,yychar,yyline); ignorar */}

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

"{" {return new Symbol(Simbolo.tabre,yychar,yyline);}
"}" {return new Symbol(Simbolo.tcierra,yychar,yyline);}
"[" {return new Symbol(Simbolo.tabrec,yychar,yyline);}
"]" {return new Symbol(Simbolo.tcierrac,yychar,yyline);}
"(" {return new Symbol(Simbolo.tabrep,yychar,yyline);}
")" {return new Symbol(Simbolo.tcierrap,yychar,yyline);}
"," {return new Symbol(Simbolo.tcoma,yychar,yyline);}
":" {return new Symbol(Simbolo.tpuntos,yychar,yyline);}
"." {return new Symbol(Simbolo.tpunto,yychar,yyline);}
("¬"|"\\|"|"$"|"^"|"`"|"´"|"~"|"°"|"¿"|"?"|"¨")+ {Ventana.error("ERROR LEXICO: Cadena:   '"+  yytext()+"'    inválida, en la línea:"+(yyline+1)+" Revisa tus caracteres utilizados");}

("\\ñ"|{L}|{D})+ {Ventana.error("ERROR LEXICO2: Cadena:   '"+  yytext()+"'    inválida, en la línea:"+(yyline+1) +" y columna " + yychar+"Revisa tus caracteres utilizados");}

.		{Ventana.error("ERROR LEXICO: Cadena:   '"+  yytext()+"'    inválida, en la línea:"+(yyline+1) +" y columna " + yychar+"Revisa tus caracteres utilizados");}
