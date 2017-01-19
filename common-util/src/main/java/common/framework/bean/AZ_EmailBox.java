package common.framework.bean;

import constant.AZ_Constant;
import org.springframework.mail.SimpleMailMessage;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.Assert;

/**
 * 邮件投递箱（这个里面的邮件有专门的邮件服务线程自动处理）
 * @author Fuzhong.Yan
 */
public class AZ_EmailBox {
    /**
     * 简单邮件存放的队列
     */
    private static ArrayBlockingQueue<SimpleMailMessage> SIMPLEMAILMESSAGEQUEUE = new ArrayBlockingQueue<SimpleMailMessage>(1000);
    /**
     * 复杂邮件存放的队列
     */
    private static ArrayBlockingQueue<MimeMessage > MIMEMESSAGEQUEUE = new ArrayBlockingQueue<MimeMessage >(1000);
    /**
     * 投递邮件
     * @param simpleMailMessage
     * @throws InterruptedException
     */
    public static void push(SimpleMailMessage simpleMailMessage) throws InterruptedException{
        Assert.notNull(simpleMailMessage, "simpleMailMessage_null");
        Assert.hasLength(simpleMailMessage.getText(),"text_null");
        Assert.noNullElements(simpleMailMessage.getTo(),"to_noNullElements");
        Assert.notNull(simpleMailMessage.getFrom(), "from_null");
        SIMPLEMAILMESSAGEQUEUE.put(simpleMailMessage);
    }
    /**
     * 投递邮件
     * @throws InterruptedException
     */
    public static SimpleMailMessage takeSimpleMailMessage() throws InterruptedException{
        return SIMPLEMAILMESSAGEQUEUE.take();
    }
    /**
     * 取邮件
     * @param mimeMessage
     * @throws InterruptedException
     */
    public static void push(MimeMessage mimeMessage) throws InterruptedException{
        Assert.notNull(mimeMessage, "mimeMessage_null");
        MIMEMESSAGEQUEUE.put(mimeMessage);
    }
    /**
     * 取邮件
     * @throws InterruptedException
     */
    public static MimeMessage takeMimeMessage() throws InterruptedException{
        return MIMEMESSAGEQUEUE.take();
    }
}
