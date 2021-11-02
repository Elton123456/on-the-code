利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的[耦合度](http://baike.baidu.com/view/1599212.htm)降低；

业务逻辑仅仅只关注业务本身，将日志记录，性能统计，安全控制，事务处理，[异常处理](http://baike.baidu.com/view/1072586.htm)等代码从业务逻辑代码中划分出来；



![在这里插入图片描述](https://img-blog.csdnimg.cn/20201016194259600.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L211X3dpbmQ=,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201016201545227.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L211X3dpbmQ=,size_16,color_FFFFFF,t_70#pic_left)



## 第一个实例:入门简单实例

```java
//首先需要引入 AOP 的依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

```java
//创建一个AOP切面类，只要在类上加个 @Aspect 注解即可。@Aspect 注解用来描述一个切面类，定义切面类的时候需要打上这个注解。@Component 注解将该类交给 Spring 来管理。在这个类里实现advice

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
    // 定义一个切点：所有被GetMapping注解修饰的方法会织入advice
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut() {}

	// Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logAdvice(){
    	// 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("get请求的advice触发了");
    }
}
```



```java
//创建一个接口类，内部创建一个get请求：

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/aop")
public class AopController {
    @GetMapping(value = "/getTest")
    public JSONObject aopTest() {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
    
	@PostMapping(value = "/postTest")
    public JSONObject aopTest2(@RequestParam("id") String id) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
}
```



## 第二个实例：自定义注解

1. 自定义一个注解`PermissionsAnnotation`
2. 创建一个切面类，切点设置为拦截所有标注`PermissionsAnnotation`的方法，**截取到接口的参数**，进行简单的权限校验
3. 将`PermissionsAnnotation`标注在测试接口类的测试接口`test`上

```java
//使用@Target、@Retention、@Documented自定义一个注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation{
}
```

```java
//创建第一个AOP切面类，类上加 @Aspect 注解即可。@Aspect 注解用来描述一个切面类，定义切面类的时候需要打上这个注解。@Component 注解将该类交给 Spring 来管理。在这个类里实现第一步权限校验逻辑：

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {

	// 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.mu.demo.annotation.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================第一个切面===================：" + System.currentTimeMillis());

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        Long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id1->>>>>>>>>>>>>>>>>>>>>>" + id);
        System.out.println("name1->>>>>>>>>>>>>>>>>>>>>>" + name);

        // id小于0则抛出非法id的异常
        if (id < 0) {
            return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
        }
        return joinPoint.proceed();
    }
}

```

```java
//创建接口类，并在目标方法上标注自定义注解 PermissionsAnnotation：

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/permission")
public class TestController {
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    // 添加这个注解
    @PermissionsAnnotation()
    public JSONObject getGroupList(@RequestBody JSONObject request) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
}
```

#### 如果我一个接口想设置多个切面类进行校验怎么办？这些切面的执行顺序如何管理？

```java
//一个自定义的AOP注解可以对应多个切面类，这些切面类执行顺序由@Order注解管理，该注解后的数字越小，所在切面类越先执行。
//创建第二个AOP切面类，在这个类里实现第二步权限校验：

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class PermissionSecondAdvice {

   @Pointcut("@annotation(com.mu.demo.annotation.PermissionAnnotation)")
   private void permissionCheck() {
   }

   @Around("permissionCheck()")
   public Object permissionCheckSecond(ProceedingJoinPoint joinPoint) throws Throwable {
       System.out.println("===================第二个切面===================：" + System.currentTimeMillis());

       //获取请求参数，详见接口类
       Object[] objects = joinPoint.getArgs();
       Long id = ((JSONObject) objects[0]).getLong("id");
       String name = ((JSONObject) objects[0]).getString("name");
       System.out.println("id->>>>>>>>>>>>>>>>>>>>>>" + id);
       System.out.println("name->>>>>>>>>>>>>>>>>>>>>>" + name);

       // name不是管理员则抛出异常
       if (!name.equals("admin")) {
           return JSON.parseObject("{\"message\":\"not admin\",\"code\":403}");
       }
       return joinPoint.proceed();
   }
}
```

