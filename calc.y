```c
%{
#include <stdio.h>

int yylex(void);
void yyerror(const char *s);
%}

%token NUMBER
%left '+' '-'
%left '*' '/'

%%

start:
    expr { printf("Result = %d\n", $1); }
    ;

expr:
      expr '+' expr  { $$ = $1 + $3; }
    | expr '-' expr  { $$ = $1 - $3; }
    | expr '*' expr  { $$ = $1 * $3; }
    | expr '/' expr  { $$ = $1 / $3; }
    | '(' expr ')'   { $$ = $2; }
    | NUMBER         { $$ = $1; }
    ;

%%

void yyerror(const char *s)
{
    printf("Invalid expression\n");
}

int main(void)
{
    printf("Enter an arithmetic expression:\n");
    return yyparse();
}
```
