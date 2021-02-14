package io.github.mat3e.todo;

import io.github.mat3e.HibenateUtil;

import java.util.List;
import java.util.Optional;

public class TodoRepository {
    List<Todo> findAll() {
        var session = HibenateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Todo", Todo.class).list();
        transaction.commit();
        session.close();
        return result;
    }

    Todo toggleTodo(Integer id) {
        var session = HibenateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var todo = session.get(Todo.class, id);
        todo.setDone(!todo.getDone());
        transaction.commit();
        session.close();
        return todo;
    }

   Todo addTodo(Todo newTodo){
        var session = HibenateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        newTodo.setDone(false);
        session.persist(newTodo);
        transaction.commit();
        session.close();
        return newTodo;
    }
}
