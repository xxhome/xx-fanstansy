package com.xxbase.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

/**
 * @author li.fang
 * @since 2017/02/18.
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private com.octo.captcha.service.CaptchaService imageCaptchaService;

    /**
     * 生成验证码
     *
     * @param captchaId 验证ID
     * @return
     */
    @Override
    public BufferedImage buildCaptchaImage(String captchaId) {
        return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
    }


    /**
     * 校验验证码是否有效
     *
     * @param captchaId 验证ID
     * @param captcha   验证码(忽略大小写)
     * @return
     */
    @Override
    public boolean isValid(String captchaId, String captcha) {
        if (StringUtils.isNotEmpty(captchaId) && StringUtils.isNotEmpty(captcha)) {
            try {
                return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase());
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
