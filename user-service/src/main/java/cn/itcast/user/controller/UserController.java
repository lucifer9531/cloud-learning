package cn.itcast.user.controller;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserService;
import cn.itcast.user.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
// @RefreshScope
public class UserController {

    private final UserService userService;

    // @Value("${pattern.dateformat}")
    // private String dateformat;

    private final PatternProperties properties;

    @GetMapping("prop")
    public PatternProperties properties() {
        return properties;
    }

    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> queryById(
            @PathVariable("id") Long id,
            @RequestHeader(value = "Truth", required = false) String truth
    ) throws InterruptedException {
//        if (id == 1) {
//            // 休眠 触发熔断
//            Thread.sleep(60);
//        } else if (id == 2) {
//            throw new RuntimeException("故意出错，触发熔断");
//        }
        System.out.println("truth: " + truth);
        return ResponseEntity.ok(userService.queryById(id));
    }
}
