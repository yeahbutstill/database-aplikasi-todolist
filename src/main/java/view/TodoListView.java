package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    /**
     * Menampilkan view todo list
     */
    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("===============================");
            System.out.println("- MENU -");
            System.out.println("===============================");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");
            System.out.println("===============================");

            var input = InputUtil.input("Pilih");
            System.out.println("===============================");
            if (input.equals("1")) {
                addTodoList();
            } else if(input.equals("2")) {
                removeTodoList();
            } else if(input.equals("0")) {
                break;
            } else {
                System.out.println("Maaf tidak ada didaftar menu");
            }
        }
    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public void addTodoList() {
        System.out.println("MENAMBAH TODO LIST");
        var todo = InputUtil.input("Todo (Tekan '0' Jika Batal)");
        if (todo.equals("0")) {
            // batal
        } else {
            System.out.println("===============================");
            todoListService.addTodoList(todo);
        }
    }

    /**
     * Menampilkan view menghapus todo list
     */
    public void removeTodoList() {
        System.out.println("MENGHAPUS TODO LIST");
        var number = InputUtil.input("Nomor yang dihapus (Tekan '0' Jika Batal)");
        if (number.equals("0")) {
            // batal
            System.out.println("===============================");
            System.out.println("Gagal menghapus todo list : " + number);
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }

}
