package common.framework.runnable;

import common.framework.bean.AZ_EmailBox;
import common.framework.interfaces.Log;
import common.framework.service.AZ_EmailHelper;
import common.framework.service.AZ_LogFactory;
import common.framework.service.AZ_ThreadPoolService;
import enums.AZ_LogType;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.Assert;
/**
 * 简单邮件消费者
 * @author Fuzhong.Yan
 */
public class AZ_SimpleEmailConsumerRunnable implements Runnable {
    private Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,AZ_SimpleEmailConsumerRunnable.class);
    private AZ_ThreadPoolService threadPoolService = null;
    public AZ_SimpleEmailConsumerRunnable() {
    }
    public AZ_SimpleEmailConsumerRunnable(AZ_ThreadPoolService threadPoolService) {
        this.threadPoolService = threadPoolService;
    }
    public void run() {
        while (true) {
            try {
                JavaMailSenderImpl javaMailSenderImpl = AZ_EmailHelper.createMailSender();
                SimpleMailMessage simpleMailMessage = AZ_EmailBox.takeSimpleMailMessage();
                if (threadPoolService == null) {
                    log.info("取得邮件开始邮件服务");
                    new EmailService(javaMailSenderImpl,simpleMailMessage).run();
                    log.info("已经完成邮件服务");
                }else {
                    log.info("取得邮件准备投入线程池");
                    threadPoolService.execute(new EmailService(javaMailSenderImpl,simpleMailMessage));
                    log.info("已经投入邮件线程池");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public AZ_ThreadPoolService getThreadPoolService() {
        return threadPoolService;
    }
    public void setThreadPoolService(AZ_ThreadPoolService threadPoolService) {
        this.threadPoolService = threadPoolService;
    }
    /**
     * 电子邮件服务
     * @author Fuzhong.Yan
     */
    class EmailService implements Runnable {
        private MailSender mailSender = null;
        private SimpleMailMessage simpleMailMessage = null;
        public EmailService(MailSender mailSender,SimpleMailMessage simpleMailMessage) {
            Assert.notNull(mailSender,"mailSender_null");
            Assert.notNull(simpleMailMessage,"simpleMailMessage_null");
            this.mailSender = mailSender;
            this.simpleMailMessage = simpleMailMessage;
        }
        public void run() {
            Assert.notNull(mailSender,"mailSender_null");
            Assert.notNull(simpleMailMessage,"simpleMailMessage_null");
            try {
                mailSender.send(simpleMailMessage);
                log.info("发送成功");
            } catch (MailException e) {
                log.info("发送失败:"+e.getMessage());
            }
        }
    }
}
