

// {1, 2, 3,{5, 8}, 4}
grammar ArrayInit;

init    :   '{' value (',' value)* '}';

value   :   init
        |   INT
        ;

INT     :   [0-9]+;

WS      :   [ \n\r\t]+ -> skip;