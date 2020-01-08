package com.fantasy.xxbase.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author li.fang
 * @since 2017/9/25 10:46
 */
@Component
public class XXBannerApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(XXBannerApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //防止重复执行
        if(event.getApplicationContext().getParent() == null){
            logger.info("--------------------------------------------------------------------------------------------");

            logger.info("              {}", "__   ____   __     ______ ___   _   _ _____ ___   _______   __");
            logger.info("              {}", "\\ \\ / /\\ \\ / /     |  ___/ _ \\ | \\ | |_   _/ _ \\ /  ___\\ \\ / /");
            logger.info("              {}", " \\ V /  \\ V /______| |_ / /_\\ \\|  \\| | | |/ /_\\ \\\\ `--. \\ V /");
            logger.info("              {}", " /   \\  /   \\______|  _||  _  || . ` | | ||  _  | `--. \\ \\ /");
            logger.info("              {}", "/ /^\\ \\/ /^\\ \\     | |  | | | || |\\  | | || | | |/\\__/ /| |");
            logger.info("              {}", "\\/   \\/\\/   \\/     \\_|  \\_| |_/\\_| \\_/ \\_/\\_| |_/\\____/ \\_/");

            logger.info("--------------------------------------------------------------------------------------------");
        }
    }
}
