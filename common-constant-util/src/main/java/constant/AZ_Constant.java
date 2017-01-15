package constant;

/**
 * Created by Fuzhong.Yan on 16/11/13.
 */
public class AZ_Constant {
    /**菜单打开*/
    public final static int MENU_OPEN = 1;
    /**菜单关闭*/
    public final static int MENU_CLOSE = 0;
    /**普通用户*/
    public final static int ROLE_TYPE_ORDINARY= 0;
    /**角色容量无穷大*/
    public final static int ROLE_SIZE_INFINITE = 0;
    /**角色锁定*/
    public final static int ROLE_LOCK = 1;
    /**角色解锁*/
    public final static int ROLE_UNLOCK = 0;
    /**男*/
    public final static int MEMBER_MALE = 0;
    /**女*/
    public final static int MEMBER_FEMALE = 1;
    /**锁定会员*/
    public final static int MEMBER_LOCK = 1;
    /**解锁会员*/
    public final static int MEMBER_UNLOCK = 0;
    /**会员已经认证*/
    public final static int MEMBER_AUDITED = 2;
    /**会员认证中*/
    public final static int MEMBER_AUDITING = 1;
    /**会员默认语言*/
    public final static String MEMBER_DEFAULT_LANGUAGE = "en";
    /**会员未认证*/
    public final static int MEMBER_UN_AUDIT = 0;
    /**会员默认级数*/
    public final static int MEMBER_DEFAULT_LEVEL = 0;
    /**会员失败登陆最大次数*/
    public final  static  int MEMBER_MAX_LOGIN_FAILED_NUMBER = 3;
    /**调用方法前*/
    public final static int LOG_BEFORE_METHOD_INVOKE = 0;
    /**调用方法前*/
    public final static int LOG_AFTER_METHOD_INVOKE = 1;
    /**调用方法前*/
    public final static int LOG_EXCEPTION_METHOD_INVOKE = 3;
    /**日志最大记录的文本的长度(多余自动删除)*/
    public final static int LOG_CONTENT_MAX_SIZE = 1024;
    /**文件路径前缀*/
    public final static String FILE_PATH_PREFIX="http://localhost:8080/";
    /**生成文件路径基*/
    public final static int FILE_PATH_RADIX_BASE=16;
    /**数据流块大小*/
    public final static int FILE_BLOCK_SIZE = 1;
    /**数据流块单位B*/
    public final static int FILE_BLOCK_UNIT_BYTE = 1;
    /**数据流块单位KB*/
    public final static int FILE_BLOCK_UNIT_KB = 1024*FILE_BLOCK_UNIT_BYTE;
    /**数据流块单位M*/
    public final static int FILE_BLOCK_UNIT_M = 1024*FILE_BLOCK_UNIT_KB;
    /**数据流块单位G*/
    public final static int FILE_BLOCK_UNIT_G = 1024*FILE_BLOCK_UNIT_M;
}
