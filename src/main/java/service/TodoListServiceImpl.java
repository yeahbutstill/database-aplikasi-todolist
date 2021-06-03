package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    /**
     * Menampilkan todo list
     */
    @Override
    public void showTodoList() {
        TodoList[] data = todoListRepository.getAll();

        System.out.println(""+
                "▀█▀ ▄▀▄ █▀▄ ▄▀▄   █   █ ▄▀▀ ▀█▀\n" +
                " █  ▀▄▀ █▄▀ ▀▄▀   █▄▄ █ ▄██  █");
        for (var i = 0; i < data.length; i++) {
            var todolist = data[i];
            var no = i + 1;

            if (todolist != null) {
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    /**
     * Menambahkan todo ke list
     */
    @Override
    public void addTodoList(String todo) {
        TodoList todolist = new TodoList(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses Menambah Todo -> " + todo);
    }

    /**
     * Menghapus todo dari list
     */
    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("Sukses Menghapus Todo Pada Nomer -> " + number);
        } else {
            System.out.println("Gagal Menghapus Todo Pada Nomer -> " + number);
        }
    }

}
