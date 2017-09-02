package com.fantasy.xxtest.antlr4.demo02;


import com.fantasy.xxtest.base.BaseTest;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @since 2017/8/23 22:09
 */
public class ArrayInitTest extends BaseTest {

    @Test
    public void testArrayInit(){

        ANTLRInputStream is = new ANTLRInputStream("{1, 2,{5,6,7}, 3}");

        ArrayInitLexer lexer = new ArrayInitLexer(is);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ArrayInitParser parser = new ArrayInitParser(tokens);

        ParseTree tree = parser.init();

        logger.info("tree : {}", tree.toStringTree(parser));
    }

}
