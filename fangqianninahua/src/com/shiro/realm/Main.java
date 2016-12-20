//package com.shiro.realm;
//
//import java.security.Key;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.LockedAccountException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.codec.Hex;
//import org.apache.shiro.config.IniSecurityManagerFactory;
//import org.apache.shiro.crypto.AesCipherService;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.util.Factory;
//import org.junit.Assert;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Main { 
//
//    private static final transient Logger log = LoggerFactory.getLogger(Main.class);
//
//    public static void main(String[] args) {
//        //获取SecurityManager的实例
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//        SecurityManager securityManager = factory.getInstance();
//
//        SecurityUtils.setSecurityManager(securityManager);
//
//        Subject currenUser = SecurityUtils.getSubject();
//
//        
//        
//        
//        AesCipherService aesCipherService = new AesCipherService();  
//        aesCipherService.setKeySize(128); //设置key长度  
//        //生成key  
//        Key key = aesCipherService.generateNewKey();  
//        byte[] a = key.getEncoded();
//        String text = "hello";  
//        //加密  
//        String encrptText =   
//        aesCipherService.encrypt(text.getBytes(), a).toHex();  
//      
//        //解密  
//        String text2 =  
//         new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());  
//        Assert.assertEquals(text, text2);
//        
//        
//     
//        
//   
//        
//        
//        
//        
//        
//        //如果还未认证
//        if(!currenUser.isAuthenticated()){
//            UsernamePasswordToken token = new UsernamePasswordToken("admin","123");
//            token.setRememberMe(true);
//            try {
//                currenUser.login(token);
//            } catch (UnknownAccountException uae) {
//                log.info("没有该用户： " + token.getPrincipal());
//            } catch (IncorrectCredentialsException ice) {
//                log.info( token.getPrincipal() + " 的密码不正确!");
//            } catch (LockedAccountException lae) {
//                log.info( token.getPrincipal() + " 被锁定 ，请联系管理员");
//            }catch (AuthenticationException ae) {
//                //其他未知的异常
//            }
//        }
//       // currentUser.logout(); 注销
//        if(currenUser.isAuthenticated())
//            log.info("用户 "+currenUser.getPrincipal() +" 登录成功");
//
//        //是否有role1这个角色
//        if(currenUser.hasRole("role1")){
//            log.info("有角色role1");
//        }else{
//            log.info("没有角色role1");
//        }
//        //是否有对打印机进行打印操作的权限
//        if(currenUser.isPermitted("printer:print")){
//            log.info("可以对打印机进行打印操作");
//        }else {
//            log.info("不可以对打印机进行打印操作");
//        }
//    }
//
//}