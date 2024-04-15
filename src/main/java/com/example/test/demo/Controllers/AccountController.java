package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Account;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("")
    List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "truy vấn tài khoản thành công", foundAccount));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "không thể tìm thấy tài khoản với id =" + id, "")
            );
        }
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertAccount(@RequestBody Account newAccount) {
        Optional<Account> existingAccount = accountRepository.findById(newAccount.getId());
        if (existingAccount.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "tài khoản với id " + newAccount.getId() + " đã tồn tại", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "chèn tài khoản thành công", accountRepository.save(newAccount))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteAccount(@PathVariable int id) {
        boolean exists = accountRepository.existsById(id);
        if (!exists) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Xóa tài khoản thành công", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "không thể tìm thấy tài khoản để xóa", "")
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateAccount(@RequestBody Account newAccount, @PathVariable int id) {
        Account updatedAccount = accountRepository.findById(id)
                .map(account -> {
                    account.setUsername(newAccount.getUsername());
                    account.setPassword(newAccount.getPassword());
                    account.setName(newAccount.getName());
                    account.setAddress(newAccount.getAddress());
                    account.setPhone(newAccount.getPhone());
                    account.setRole(newAccount.isRole());
                    return accountRepository.save(account);
                }).orElseGet(() -> {
                    newAccount.setId(id);
                    return accountRepository.save(newAccount);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "cập nhật thành công", updatedAccount)
        );
    }
}
