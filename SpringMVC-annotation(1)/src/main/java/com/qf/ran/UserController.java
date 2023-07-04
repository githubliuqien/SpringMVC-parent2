package com.qf.ran;

import com.qf.ran.entity.po.User;
import com.qf.ran.entity.vo.RespResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/6/30
 */
//@Controller
//被 RestController 修饰的控制层，所有的方法都经过消息转换器
@RestController
@RequestMapping("/user")
public class UserController {

    /*@RequestMapping("/login")
    //代表响应的内容需要经过消息转换器转换成 json 格式数据
    @ResponseBody
    public void login(HttpSession session,String username, String password){
    }*/

    // value 约束请求路径，请求映射路径为 /login 或者 /toLogin
    // method 约束提交方式,请求提交方式为 post
    // params 约束请求的参数,至少包含指定的参数
    @RequestMapping(value={"/login","/toLogin"},method = {RequestMethod.POST},
            params = {"id","username","password"})
    //根据对象的 set() 给对象赋值
    public RespResult login(User user){
        System.out.println(user);
        return RespResult.respSuccess("登录成功",null);
    }


    //restful 风格
    //get提交方式的注解
   /* @GetMapping(value={"/login","/toLogin"},params = {"username","password"})
    //根据对象的 set() 给对象赋值
    public RespResult login(User user){
        System.out.println(user);
        return RespResult.respSuccess("登录成功",null);
    }*/

    /*
     * consumes = "multipart/*"
     * 表示该方法可以接收 multipart 类型请求,multipart 一般为文件上传的请求类型
     *
     * headers = "content-type=multipart/form-data"
     * 指定请求内容的类型必须是 multipart/form-data
     */
   @RequestMapping(value="/upload",method=RequestMethod.POST,consumes = "multipart/*",headers = "content-type=multipart/form-data")
   public RespResult upload(MultipartFile file){
       //根据文件名获取后缀名
       System.out.println("文件名:"+file.getOriginalFilename());
       try {
           //拷贝文件到指定路径
           file.transferTo(new File("E:/file/",file.getOriginalFilename()));
       } catch (IOException e) {
           e.printStackTrace();
       }
       return RespResult.respSuccess("上传成功",null);
   }
}
