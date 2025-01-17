package com.example.exercise.service.impl;

import com.example.exercise.model.Book;
import com.example.exercise.repository.BookRepository;
import com.example.exercise.service.BookService;
import com.example.exercise.service.QuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void saveBorrow(Book book) throws QuantityException {
        if (book.getBookQuantity() > 0) {
            book.setBookQuantity(book.getBookQuantity() - 1);
            bookRepository.save(book);
        } else {
            throw new QuantityException();
        }

    }

    @Override
    public void saveReturn(Book book) {
        book.setBookQuantity(book.getBookQuantity() + 1);
        bookRepository.save(book);
    }
//
//    @Override
//    public int increment(Book book) {
//        return book.increment();
//    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }
}
