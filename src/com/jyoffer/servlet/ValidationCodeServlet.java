package com.jyoffer.servlet;
import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.image.BufferedImage; 
import java.awt.image.BufferedImageOp; 
import java.io.IOException; 
import java.io.OutputStream; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Random; 
import javax.imageio.ImageIO; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;  
import org.patchca.background.BackgroundFactory; 
import org.patchca.color.ColorFactory; 
import org.patchca.color.RandomColorFactory; 
import org.patchca.filter.ConfigurableFilterFactory; 
import org.patchca.filter.library.AbstractImageOp; 
import org.patchca.filter.library.WobbleImageOp; 
import org.patchca.font.RandomFontFactory; 
import org.patchca.service.Captcha; 
import org.patchca.service.ConfigurableCaptchaService; 
import org.patchca.text.renderer.BestFitTextRenderer; 
import org.patchca.text.renderer.TextRenderer; 
import org.patchca.word.RandomWordFactory; 
 
   
 
/** 
 * ��֤�������� 
 * 
 * ʹ�ÿ�Դ��֤����Ŀpatchca���� 
 * ����jar����patchca-0.5.0.jar 
 * ��Ŀ��ַ��https://code.google.com/p/patchca/ 
 * @author zyh
 * @version 1.00  2012-7-12 New 
 */ 
 
public class ValidationCodeServlet extends HttpServlet { 
 
    private static final long serialVersionUID = 5126616339795936447L; 
    private ConfigurableCaptchaService configurableCaptchaService = null; 
    private ColorFactory colorFactory = null; 
    private RandomFontFactory fontFactory = null; 
    private RandomWordFactory wordFactory = null; 
    private TextRenderer textRenderer = null; 
 
    public ValidationCodeServlet() { 
        super(); 
    } 
    
    /**
     * Servlet���ٷ���,����������ʹ����Դ
     */ 
    public void destroy() { 
        wordFactory = null; 
        colorFactory = null; 
        fontFactory = null; 
        textRenderer = null; 
        configurableCaptchaService = null; 
        super.destroy(); // Just puts "destroy" string in log 
    } 
   
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        doPost(request, response); 
 
    } 
 
   
 
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("image/png"); 
        response.setHeader("cache", "no-cache"); 
        HttpSession session = request.getSession(true); 
        OutputStream outputStream = response.getOutputStream(); 
        // �õ���֤�����,����֤��ͼƬ����֤���ַ��� 
        Captcha captcha = configurableCaptchaService.getCaptcha(); 
        // ȡ����֤���ַ�������Session 
        String validationCode = captcha.getChallenge(); 
        session.setAttribute("validationCode", validationCode); 
        // ȡ����֤��ͼƬ����� 
        BufferedImage bufferedImage = captcha.getImage(); 
        ImageIO.write(bufferedImage, "png", outputStream); 
        outputStream.flush(); 
        outputStream.close(); 
    } 
 
   
 
    /**
 
     * Servlet��ʼ������
 
     */ 
 
    public void init() throws ServletException { 
        configurableCaptchaService = new ConfigurableCaptchaService(); 
        // ��ɫ��������,ʹ��һ����Χ�ڵ����ɫ 
        colorFactory = new RandomColorFactory(); 
        //configurableCaptchaService.setColorFactory(colorFactory);
        configurableCaptchaService.setColorFactory(new ColorFactory() {
        	 Random random = new Random();
        	@Override
            public Color getColor(int x) {
                int[] c = new int[3];
                int i = random.nextInt(c.length);
                for (int fi = 0; fi < c.length; fi++) {
                    if (fi == i) {
                        c[fi] = random.nextInt(71);
                    } else {
                        c[fi] = random.nextInt(256);
                    }
                }
                return new Color(c[0], c[1], c[2]);
            }
        }); 
        // ������������� 
        fontFactory = new RandomFontFactory();
        fontFactory.setMaxSize(32);
        fontFactory.setMinSize(28);
        configurableCaptchaService.setFontFactory(fontFactory); 
        // ����ַ�������,ȥ�������׻�������ĸ������,��o��0�� 
        wordFactory = new RandomWordFactory(); 
        wordFactory.setCharacters("abcdefghkmnpqstwxyz23456789"); 
        wordFactory.setMaxLength(5); 
        wordFactory.setMinLength(5); 
        configurableCaptchaService.setWordFactory(wordFactory); 
        // �Զ�����֤��ͼƬ���� 
 
        MyCustomBackgroundFactory backgroundFactory = new MyCustomBackgroundFactory(); 
        configurableCaptchaService.setBackgroundFactory(backgroundFactory); 
        // ͼƬ�˾����� 
 
        ConfigurableFilterFactory filterFactory = new ConfigurableFilterFactory(); 
        List<BufferedImageOp> filters = new ArrayList<BufferedImageOp>(); 
        WobbleImageOp wobbleImageOp = new WobbleImageOp(); 
        wobbleImageOp.setEdgeMode(AbstractImageOp.EDGE_MIRROR); 
        wobbleImageOp.setxAmplitude(2.0); 
        wobbleImageOp.setyAmplitude(1.0); 
        filters.add(wobbleImageOp); 
        filterFactory.setFilters(filters); 
        configurableCaptchaService.setFilterFactory(filterFactory); 
        // ������Ⱦ������ 
 
        textRenderer = new BestFitTextRenderer(); 
        textRenderer.setBottomMargin(3); 
        textRenderer.setTopMargin(3); 
        configurableCaptchaService.setTextRenderer(textRenderer); 
        // ��֤��ͼƬ�Ĵ�С 
        configurableCaptchaService.setWidth(82); 
        configurableCaptchaService.setHeight(32); 
    } 
    
    /**
     * �Զ�����֤��ͼƬ����,��Ҫ��һЩ���͸�����
 
     */ 
 
    private class MyCustomBackgroundFactory implements BackgroundFactory { 
        private Random random = new Random();
        
        public void fillBackground(BufferedImage image) { 
            Graphics graphics = image.getGraphics(); 
            // ��֤��ͼƬ�Ŀ�� 
            int imgWidth = image.getWidth(); 
            int imgHeight = image.getHeight(); 
            // ���Ϊ��ɫ���� 
            graphics.setColor(Color.WHITE); 
            graphics.fillRect(0, 0, imgWidth, imgHeight); 
            // ��100�����(��ɫ��λ�����) 
            for(int i = 0; i < 100; i++) { 
                // �����ɫ 
                int rInt = random.nextInt(255); 
                int gInt = random.nextInt(255); 
                int bInt = random.nextInt(255); 
                graphics.setColor(new Color(rInt, gInt, bInt)); 
                // ���λ�� 
                int xInt = random.nextInt(imgWidth - 3); 
                int yInt = random.nextInt(imgHeight - 2);  
                // �����ת�Ƕ� 
                int sAngleInt = random.nextInt(360); 
                int eAngleInt = random.nextInt(360);
                // �����С 
                int wInt = random.nextInt(6); 
                int hInt = random.nextInt(6); 
                graphics.fillArc(xInt, yInt, wInt, hInt, sAngleInt, eAngleInt); 
                // ��5�������� 
                if (i % 20 == 0) { 
                    int xInt2 = random.nextInt(imgWidth); 
                    int yInt2 = random.nextInt(imgHeight); 
                    graphics.drawLine(xInt, yInt, xInt2, yInt2); 
                } 
            } 
        } 
    } 
}
