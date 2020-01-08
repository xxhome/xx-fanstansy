package com.fantasy.xxtest.expression;

import com.fantasy.xxbase.entity.XXSimpleEntity;
import com.fantasy.xxtest.base.BaseTest;
import org.joda.time.DateTime;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author li.fang
 * @since 2017/6/27
 */
public class ExpressionTest extends BaseTest {

    @Test
    public void testExpression01() {
        String greetingExp = "Hello, #{ #user }";
        ExpressionParser parser = new SpelExpressionParser();

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user", "world");

        Expression expression = parser.parseExpression(greetingExp, new TemplateParserContext());
        logger.info("result : {}", expression.getValue(context, String.class));
    }

    @Test
    public void testExpression02(){
        String greetingExp = "Hello, item=#{#item.id}, item.name=#{ #item.name }";
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        XXSimpleEntity item = new XXSimpleEntity();
        item.setId("123");
        item.setName("Item Name is world.");
        context.setVariable("item", item);

        TemplateParserContext templateParserContext = new TemplateParserContext();
        Expression expression = parser.parseExpression(greetingExp, templateParserContext);
        logger.info(expression.getValue(context, String.class));
    }

    @Test
    public void testExpression03(){
        String greetingExp = "Hello, " +
                "item=${item.id}, " +  //item=123
                "item.name=${item.name }, " + //item.name=Item Name is world.
                "value=${1+i}, " + // value=11
                "value=1+${i}, " + // value=1+10
                "str='abc'+${str}, " + // str='abc'+test str
                "str2=${'abc'+str}, " + // str2=abctest str
                "b1=${10==i}, " + //b1=true
                "b2=${'test str'==str}," + //b2=true
                "b3=${getDayOfMonth(1)?pattern=}" +
                "";
        XXSimpleEntity item = new XXSimpleEntity();
        item.setId("123");
        item.setName("Item Name is world.");
        ELRootObj elRootObj = new ELRootObj();
        elRootObj.setItem(item);
        elRootObj.setId("10");
        elRootObj.setStr("test str");

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(elRootObj);

        TemplateParserContext templateParserContext = new TemplateParserContext("${", "}"); //可以自定义前缀和后缀。这里是用${}取代#{}。
        Expression expression = parser.parseExpression(greetingExp, templateParserContext);
        logger.info(expression.getValue(context, String.class));
    }


    @Test
    public void testExpression04(){

        String exprStr = "#{getAfterDate('1d')}, #{getAfterDate('1h')}";

        ExprRootObject rootObject = new ExprRootObject();

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(rootObject);

        TemplateParserContext templateParserContext = new TemplateParserContext();
        Expression expression = parser.parseExpression(exprStr, templateParserContext);
        logger.info(expression.getValue(context, String.class));
    }


    class ELRootObj{
        private XXSimpleEntity item;
        private String id;
        private String str;
        private int i;

        public Date getDayOfMonth(int day){
            return new DateTime(new Date()).plusDays(day).toDate();
        }

        public XXSimpleEntity getItem() {
            return item;
        }

        public void setItem(XXSimpleEntity item) {
            this.item = item;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
