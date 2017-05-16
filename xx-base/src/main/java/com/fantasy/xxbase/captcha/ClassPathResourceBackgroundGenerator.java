package com.fantasy.xxbase.captcha;


import com.octo.captcha.component.image.backgroundgenerator.FileReaderRandomBackgroundGenerator;
import org.springframework.core.io.ClassPathResource;

import java.awt.image.BufferedImage;
import java.io.File;

public class ClassPathResourceBackgroundGenerator extends FileReaderRandomBackgroundGenerator {

    public ClassPathResourceBackgroundGenerator(Integer width, Integer height, String rootPath) {
        super(width, height, rootPath);
    }

    @Override
    protected File findDirectory(String rootPath) {
        String captchaImagePath = new ClassPathResource(rootPath, this.getClass()).getPath();
        return new File(captchaImagePath);
    }

    @Override
    public BufferedImage getBackground() {
        return super.getBackground();
    }
}
