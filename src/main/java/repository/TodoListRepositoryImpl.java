package repository;

import entity.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {

    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {

        String sql = "SELECT id, todo FROM todolist";

        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            List<TodoList> list = new ArrayList<>();
            while (resultSet.next()) {
                TodoList todolist = new TodoList();
                todolist.setId(resultSet.getInt("id"));
                todolist.setTodo(resultSet.getString("todo"));
                list.add(todolist);
            }
            return list.toArray(new TodoList[]{});
        } catch (SQLException exception) {
            throw new RuntimeException();
        }

    }

    @Override
    public void add(TodoList todolist) {

        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             statement.setString(1, todolist.getTodo());
             statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

    }

    private boolean isExists(Integer number) {

        String sql = "SELECT id FROM todolist WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, number);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Override
    public boolean remove(Integer number) {

        if (isExists(number)) {
            String sql = "DELETE FROM todolist WHERE id = ?";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, number);
                statement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            return false;
        }

    }
}
