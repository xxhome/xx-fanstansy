
grammar Hello; //定义一个名称为Hello的语法

r   :   'hello' ID; //匹配一个关键字为hello和一个紧随其后的字符

ID  :   [a-z]+;//匹配小写字母组成的标识符

WS  :   [ \t\r\n]+ -> skip;//忽略空格、Tab、换行及回车
