package com.example.demo1.Controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1.common.Result;
import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public Result save(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 查看单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getOne(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public Result list() {
        return Result.success(userService.list());
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userService.removeById(id);
        return Result.success();
    }

    /**
     * 用户分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(
                userService.page(new Page<>(pageNum, pageSize))
        );
    }

}
