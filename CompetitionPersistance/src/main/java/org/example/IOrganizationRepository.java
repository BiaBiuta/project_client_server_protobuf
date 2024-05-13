package org.example;




public interface IOrganizationRepository extends IRepository<Integer, Organizing>{
    Organizing findByName(String username, String password);
}
