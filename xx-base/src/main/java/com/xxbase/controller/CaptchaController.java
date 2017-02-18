package com.xxbase.controller;

import com.xxbase.service.CaptchaService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * Created by admin on 17/02/18.
 */
@RestController
@RequestMapping("/xxbase/captcha")
public class CaptchaController extends BaseController {

    @Autowired
    private CaptchaService captchaService;

    @RequestMapping("/get")
    public void get(@RequestParam String captchaId, HttpServletRequest request, HttpServletResponse response) {

        if (StringUtils.isEmpty(captchaId)) {
            captchaId = request.getSession().getId();
        }

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            BufferedImage bufferedImage = captchaService.buildCaptchaImage(captchaId);
            ImageIO.write(bufferedImage, "jpg", servletOutputStream);
            servletOutputStream.flush();
        } catch (Exception e) {

        } finally {
            IOUtils.closeQuietly(servletOutputStream);
        }
    }


}
