package org.example;




public interface IChildRepository extends IRepository<Integer, Child>{
    Child update(Child entityForUpdate);

    Child findByName(String name);
}
