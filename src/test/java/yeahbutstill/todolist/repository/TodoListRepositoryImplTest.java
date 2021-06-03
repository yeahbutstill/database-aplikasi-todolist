package yeahbutstill.todolist.repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import util.DatabaseUtil;

public class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {

        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);

    }

    @Test
    void testAdd() {

        TodoList todolist = new TodoList();
        todolist.setTodo("Mangga");

        todoListRepository.add(todolist);

    }

    @Test
    void testRemove() {

        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
        System.out.println(todoListRepository.remove(4));

    }

    @Test
    void testGetAll() {

        todoListRepository.add(new TodoList("Jeruk"));
        todoListRepository.add(new TodoList("Apple"));
        todoListRepository.add(new TodoList("Pisang"));

        TodoList[] todolist = todoListRepository.getAll();
        for (var todo : todolist) {
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }

    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
