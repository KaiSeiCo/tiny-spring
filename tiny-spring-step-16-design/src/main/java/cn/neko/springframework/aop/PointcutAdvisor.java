package cn.neko.springframework.aop;

/**
 * @Author: Elaina
 * @Date: 2022/3/28 19:15
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * Get the Pointcut that drives this advisor.
     * @return
     */
    Pointcut getPointcut();
}
