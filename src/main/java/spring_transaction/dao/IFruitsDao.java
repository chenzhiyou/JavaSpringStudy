package spring_transaction.dao;

import spring_transaction.entity.Fruits;

public interface IFruitsDao {
    Fruits getFruits();

    void sub();

    void save();
}
