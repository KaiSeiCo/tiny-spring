package cn.neko.springframework.test;


/**
 * @Author: Elaina
 * @Date: 2022/3/26 9:46
 */


import cn.neko.springframework.aop.AdvisedSupport;
import cn.neko.springframework.aop.MethodMatcher;
import cn.neko.springframework.aop.TargetSource;
import cn.neko.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.neko.springframework.aop.framework.Cglib2AopProxy;
import cn.neko.springframework.aop.framework.JdkDynamicAopProxy;
import cn.neko.springframework.aop.framework.ReflectiveMethodInvocation;
import cn.neko.springframework.test.bean.IUserService;
import cn.neko.springframework.test.bean.UserService;
import cn.neko.springframework.test.bean.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Target : AOP 通过预编译方式和运行期间动态代理实现程序功能的统一维护
 *
 */

public class ApiTest {

    private static final String POINT_CUT_EXPRESSION
            = "execution(* cn.neko.springframework.test.bean.IUserService.*(..))";

    @Test
    public void test_proxy_method() {
        // 目标对象
        Object targetObj = new UserService();
        // aop 代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                targetObj.getClass().getInterfaces(), new InvocationHandler() {
                    // 方法匹配器
                    MethodMatcher methodMatcher = new AspectJExpressionPointcut(POINT_CUT_EXPRESSION);

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (methodMatcher.matches(method, targetObj.getClass())) {
                            // 方法拦截器
                            MethodInterceptor methodInterceptor = invocation -> {
                                long start = System.currentTimeMillis();
                                try {
                                    return invocation.proceed();
                                } finally {
                                    System.out.println("监控 - Begin By AOP");
                                    System.out.println("方法名称：" + invocation.getMethod().getName());
                                    System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                                    System.out.println("监控 - End\r\n");
                                }
                            };
                            // 反射调用
                            return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                        }
                        return method.invoke(targetObj, args);
                    }
                });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut(POINT_CUT_EXPRESSION));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut
                = new AspectJExpressionPointcut(POINT_CUT_EXPRESSION);

        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

}
