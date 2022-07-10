package reflect;

import com.sun.org.apache.xml.internal.security.utils.ClassLoaderUtils;

import java.lang.reflect.Proxy;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/6/2911:33 PM
 */
public class Test {
    public static void main(String[] args){
        // 构建代理器
        JDKProxy proxy = new JDKProxy(new RealHello());
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // 把生成的代理类保存到文件
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 生成代理类
        Hello test = (Hello) Proxy.newProxyInstance(classLoader, new Class[]{Hello.class}, proxy);
        // 方法调用
        System.out.println(test.say());
    }
}
