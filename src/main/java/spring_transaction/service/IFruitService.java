package spring_transaction.service;

import spring_transaction.entity.Fruits;

public interface IFruitService {
    Fruits getFruits();

    void sub();
    void trans();
    void save();
}
