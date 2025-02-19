lexer grammar DecaLexer;

options {
   language=Java;
   // Tell ANTLR to make the generated lexer class extend the
   // the named class, which is where any supporting code and
   // variables will be placed.
   superClass = AbstractDecaLexer;
}

@members {
}

// Deca lexer rules.

ASM : 'asm';
CLASS : 'class' ;
EXTENDS : 'extends' ;
ELSE : 'else' ;
FALSE : 'false'; 
IF : 'if';
INSTANCEOF : 'instanceof' ;
NEW : 'new' ;
NULL : 'null'; 
READINT : 'readInt'; 
READFLOAT : 'readFloat'; 
PRINT : 'print';
PRINTLN : 'println' ;
PRINTLNX : 'printlnx' ;
PRINTX : 'printx' ;
PROTECTED : 'protected' ;
RETURN : 'return' ;
THIS : 'this';
TRUE : 'true' ;
WHILE : 'while';


LT : '<' ;
GT : '>' ;
EQUALS : '=' ;
TIMES : '*' ;
SLASH : '/' ;
PERCENT : '%' ;
DOT : '.' ;
COMMA : ',' ;
OPARENT : '(';
CPARENT : ')';
OBRACE : '{';
CBRACE : '}';
EXCLAM : '!';
SEMI : ';' ;
EQEQ : '==' ;
NEQ : '!=' ;
GEQ : '>=' ;
LEQ : '<=' ;
AND : '&&' ;
OR : '||';
PLUS : '+' ; 
MINUS : '-' ;


fragment EOL : '\n';

fragment STRING_CAR :   ~('"' | '\\' | '\n');

STRING : '"' (STRING_CAR | '\\n' | '\\"' | '\\\\')* '"' { getText();};

MULTI_LINE_STRING : '"' (STRING_CAR | EOL | '\\"' | '\\\\')* '"' { getText();};

fragment LETTER : 'a' .. 'z' | 'A' .. 'Z'; 

fragment DIGIT : '0' .. '9' ;

IDENT : (LETTER | '$' | '_') (LETTER | DIGIT | '$' | '_')* { getText();};

fragment POSITIVE_DIGIT : '1' .. '9';

INT : '0' | (POSITIVE_DIGIT DIGIT*) { getText();};

fragment NUM : DIGIT+;

fragment SIGN : ('+' | '-')?;

fragment EXP : ('E' | 'e') SIGN NUM;

fragment DEC : NUM '.' NUM;

fragment FLOATDEC : (DEC | DEC EXP) ('F' | 'f')?;

fragment DIGITHEX : '0' .. '9' | 'A' .. 'F' | 'a' .. 'f';

fragment NUMHEX : DIGITHEX+;

fragment FLOATHEX : ('0x' | '0X') NUMHEX '.' NUMHEX ('P' | 'p') SIGN NUM ('F' | 'f')?;

FLOAT : FLOATDEC | FLOATHEX { getText();};


fragment COMMENT : '/*' .*? '*/' ;

fragment SINGLE_LINE_COMMENT : '//' .*? EOL ;

fragment SPACE : ' ' ;

fragment TAB : '\t' ;

fragment RETOUR_CHARIOT : '\r';

SEPARATOR : (COMMENT | SINGLE_LINE_COMMENT | SPACE | EOL | TAB | RETOUR_CHARIOT) { skip(); } ;

fragment FILENAME : (LETTER | DIGIT | '.' | '-' | '_')+ ;

INCLUDE : '#include' (SPACE)* '"' FILENAME '"' { doInclude(getText());  };

DEFAULT : '.' { if(true) {throw new DecaRecognitionException( this, getInputStream());} };