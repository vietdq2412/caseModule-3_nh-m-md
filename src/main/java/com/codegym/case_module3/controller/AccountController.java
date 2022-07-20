package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Account;
import com.codegym.case_module3.model.Role;
import com.codegym.case_module3.service.account.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AccountServlet", urlPatterns = "/accounts")
public class AccountController extends HttpServlet {
    AccountService accountService;

    @Override
    public void init() {
        accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "signup":
                    showFormSignUp(request, response);
                case "create":
                    showFormCreate(request, response);
                    break;
                case "edit":
                    showFormEdit(request, response);
                    break;
                case "login":
                    fromLogin(request, response);
                    break;
                case "admin":
                    showAccountByRole(request, response, 1);
                    break;
                case "user":
                    showAccountByRole(request, response, 2);
                    break;
                default:
                    showAllAccount(request, response);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAccountByRole(HttpServletRequest request, HttpServletResponse response, int role) throws ServletException, IOException {
        HashMap<Integer, Account> accounts = accountService.findByRole(role);
        request.setAttribute("listAccount", accounts.values());
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("views/account/list.jsp");
        resRequestDispatcher.forward(request, response);

    }

    private void fromLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("index.jsp");
        resRequestDispatcher.forward(request, response);
    }

    private void showFormSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login-signup/signup.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account u = accountService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/account/edit.jsp");
        request.setAttribute("accountEdit", u);
        requestDispatcher.forward(request, response);
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        accountService.delete(id);
        response.sendRedirect("/accounts");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/account/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAllAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Integer, Account> accounts = accountService.find("");
        request.setAttribute("listAccount", accounts.values());
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("views/account/list.jsp");
        resRequestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if(action == null){
            action = "";
        }
        try {
            switch (action) {
                case "login":
                    loginAcount(request, response, session);
                    break;
                case "signup":
                    signupAccount(request, response);
                    break;
                case "create":
                    createAccount(request, response);
                    break;
                case "edit":
                    editAccount(request, response);
                    break;
                case "profile":
                    editProfile(request, response);
                    break;
                case "delete":
                    deleteAccount(request, response);
                    break;
                default:
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void signupAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Account Account = getAccount(request, response,"");
        accountService.create(Account);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Account account = getAccount(request, response, "edit");
        int id = Integer.parseInt(request.getParameter("id"));
        int roleID = Integer.parseInt(request.getParameter("role"));
        Role role;
        if(roleID == 1){
            role = new Role(1,"ROLE_ADMIN");
        }
        else {
            role = new Role(2, "ROLE_USER");
        }
        account.setId(id);
        account.setRoleId(role);
        System.out.println(account);
        accountService.update(account);
        response.sendRedirect("/accounts");

    }
    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Account account = getAccount(request, response, "edit");
        int id = Integer.parseInt(request.getParameter("id"));
        int roleID = Integer.parseInt(request.getParameter("role"));
        Role role;
        if(roleID == 1){
            role = new Role(1,"ROLE_ADMIN");
        }
        else {
            role = new Role(2, "ROLE_USER");
        }
        account.setId(id);
        account.setRoleId(role);
        System.out.println(account);
        accountService.update(account);
        response.sendRedirect("/accounts?action=edit&id="+account.getId());

    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Account Account = getAccount(request, response,"");
        accountService.create(Account);
        response.sendRedirect("/accounts");
    }

    private Account getAccount(HttpServletRequest request, HttpServletResponse response, String name) {
        String fullName = request.getParameter(name+"fullName");
        String username = request.getParameter(name+"username");
        String email = request.getParameter(name+"email");
        String password = request.getParameter(name+"password");
        String address = request.getParameter(name+"address");
        String phoneNumber = request.getParameter(name+"phoneNumber");

        return new Account(fullName, username,password, address, email, phoneNumber, new Role(2, "User"));
    }

    private void loginAcount(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        String email = request.getParameter("_email");
        String password = request.getParameter("_password");

        Account account = accountService.findByEmailAndPass(email, password);
        if(account != null){
            session.setAttribute("userId", account.getId());
            session.setAttribute("username", account.getUsername());
            session.setAttribute("password", account.getPassword());
            session.setAttribute("phone", account.getPhoneNumber());
            session.setAttribute("name" , account.getFullName());
            session.setAttribute("roleId", account.getRoleId());
            session.setAttribute("email", account.getEmail());
            if(account.getRoleId().getId() == 1){
                response.sendRedirect("/accounts?action=edit&id="+account.getId());
            }
            else {
                response.sendRedirect("/books?action=shop");
            }

        }
        else {
            RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("index.jsp");
            resRequestDispatcher.forward(request, response);
        }
    }
}
