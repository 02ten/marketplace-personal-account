package com.personal.personal_account.Controller;

import com.personal.personal_account.Model.User;
import com.personal.personal_account.Service.AccountService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal")
@RequiredArgsConstructor
public class PersonalAccountController {
    private final AccountService accountService;
    private final Tracer tracer;
    @GetMapping("/account/{id}")
    public ResponseEntity<User> getPersonalData(@PathVariable Long id){
        Span span = tracer.buildSpan("Getting personal data").start();
        Tags.HTTP_METHOD.set(span, "GET");
        Tags.HTTP_URL.set(span, "/api/personal/account/"+id);
        span.finish();
        User user = accountService.getUserInfo(id);
        return ResponseEntity.ok(user);
    }
}
