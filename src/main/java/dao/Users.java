package dao;

public interface Users {

    User findByUsername(String username);
        long insert(User user);
    }

