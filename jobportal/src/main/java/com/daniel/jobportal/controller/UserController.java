package com.daniel.jobportal.controller;

import com.daniel.jobportal.entity.User;
import com.daniel.jobportal.entity.UserType;
import com.daniel.jobportal.exception.ErrorCode;
import com.daniel.jobportal.service.UserService;
import com.daniel.jobportal.service.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller // Đánh dấu đây là một Controller trong Spring MVC
public class UserController {

    // Khai báo các service để xử lý logic liên quan đến User và UserType
    private final UserTypeService userTypeService;
    private final UserService userService;

    // Constructor dùng để Spring tự động inject 2 service vào Controller
    public UserController(UserTypeService userTypeService, UserService userService) {
        this.userTypeService = userTypeService;
        this.userService = userService;
    }

    /**
     * Xử lý yêu cầu GET đến đường dẫn "/register"
     * Mục đích: hiển thị form đăng ký người dùng
     */
    @GetMapping("/register")
    public String register(Model model) {
        // Gọi service để lấy danh sách tất cả loại người dùng (UserType)
        List<UserType> userTypes = userTypeService.getAll();

        // Thêm danh sách UserType vào model để view (HTML) dùng hiển thị dropdown
        model.addAttribute("getAllTypes", userTypes);

        // Thêm một đối tượng User rỗng để form binding dữ liệu đầu vào
        model.addAttribute("user", new User());

        // Trả về tên view "register" -> tương ứng file register.html
        return "register";
    }

    /**
     * Xử lý POST từ form đăng ký, gửi đến "/register/new"
     * @param user: đối tượng User chứa dữ liệu từ form
     * @param model: đối tượng dùng để gửi dữ liệu trở lại view nếu cần
     * @return: điều hướng đến dashboard nếu thành công, hoặc quay lại trang register nếu có lỗi
     */
    @PostMapping("/register/new")
    public String userRegiteration(@Valid User user, Model model) {
        // Kiểm tra xem email đã tồn tại trong hệ thống chưa
        Optional<User> optionalUser = userService.getUserByEmail(user.getEmail());

        if(optionalUser.isPresent()) {
            // Nếu đã có user với email này -> báo lỗi

            // Đưa thông báo lỗi vào model để hiển thị trên form, "error" là 1 thuộc tính bên register.html
            model.addAttribute("error", ErrorCode.EMAIL_EXISTED.getMessage());

            // Lấy lại danh sách loại người dùng để hiển thị lại dropdown
            List<UserType> userTypes = userTypeService.getAll();
            model.addAttribute("getAllTypes", userTypes);

            // Đưa một User rỗng mới vào model để làm mới form (nếu muốn giữ lại dữ liệu đã nhập thì dùng lại biến `user`)
            model.addAttribute("user", new User());

            // Trả về lại trang "register" (register.html) để người dùng sửa lại form
            return "register";
        }

        // Nếu email chưa tồn tại -> tiến hành thêm user mới vào hệ thống
        userService.addNewUser(user);

        // Chuyển hướng đến trang dashboard (có thể là trang chào mừng hoặc quản lý người dùng)
        return "dashboard";
    }
}
