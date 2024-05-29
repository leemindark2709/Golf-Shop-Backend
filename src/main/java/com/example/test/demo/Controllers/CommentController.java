package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Comment;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id) {
        Optional<Comment> foundComment = commentRepository.findById(id);
        if (foundComment.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query comment successfully", foundComment));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "can not find comment with id =" + id, "")
            );
        }
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertComment(@RequestBody Comment newComment) {
        if (newComment.getName() == null || newComment.getContent() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("failed", "comment name and content cannot be null", "")
            );
        }

        newComment.setCreateByDate(new Date());
        Comment savedComment = commentRepository.save(newComment);
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "insert comment successfully", savedComment)
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateComment(@RequestBody Comment newComment, @PathVariable int id) {
        if (!commentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "comment not found with id: " + id, "")
            );
        }

        Comment updatedComment = commentRepository.findById(id)
                .map(comment -> {
                    comment.setName(newComment.getName());
                    comment.setCreateByDate(new Date());
                    comment.setContent(newComment.getContent());
                    comment.setIdProduct(newComment.getIdProduct());
                    return commentRepository.save(comment);
                }).orElse(null);

        if (updatedComment != null) {
            return ResponseEntity.ok().body(
                    new ResponseObject("ok", "update successfully", updatedComment)
            );
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseObject("failed", "failed to update comment with id: " + id, "")
            );
        }
    }

    @GetMapping("/product/{idProduct}")
    ResponseEntity<ResponseObject> findByIdProduct(@PathVariable int idProduct) {
        List<Comment> foundComments = commentRepository.findByIdProduct(idProduct);
        if (!foundComments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query comments successfully", foundComments));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "can not find comments with product id =" + idProduct, "")
            );
        }
    }
}
