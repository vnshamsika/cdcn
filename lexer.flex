%%
%class Lexer
%public
%standalone

%%

"int"                  { System.out.println("Keyword: " + yytext()); }

[0-9]+                 { System.out.println("Number: " + yytext()); }

[a-zA-Z_][a-zA-Z0-9_]* { System.out.println("Identifier: " + yytext()); }

"+"|"-"|"*"|"/"        { System.out.println("Operator: " + yytext()); }

[ \t\r\n]+             { }

.                      { System.out.println("Unknown: " + yytext()); }
