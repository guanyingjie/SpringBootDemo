package com.springboot.restful.Domain.Repository;

import com.springboot.restful.Domain.DTO.UserDTO;
import com.springboot.restful.Domain.Entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
//    Person person = new Person("Angie",22);
    Optional<Person>findByName(String name);
    List<Person>findByAgeGreaterThan(int age);
    //根据name查找person
    @Query("select p from Person p where p.name = :name")
    Optional<Person>findByNameQuery(@Param("name") String name);

    //避免select操作
    @Query("select p.name from Person  p where p.id=:id")
    Optional<Person>findByIdQuery(@Param("id") Long id);

    //update name
    @Modifying
    @Query("update Person p set p.name = ?1 where p.id = ?2")
    void updatePersonNameById(String name,Long id);

    //连表查询
    @Query(value = "select new com.springboot.restful.Domain.DTO.UserDTO(p.name,p.age,c.companyName,s.schoolName)"+
            "from Person p left  join Company c on p.companyId = c.id"+
            "left join School s on p.schoolId = s.id")
    Optional<UserDTO>getUserInfomation(@Param("personId") Long personId);

    //实现分页
    @Query(value = "select new com.springboot.restful.Domain.DTO.UserDTO(p.name,p.age,c.companyName,s.schoolName)"+
            "from person p left join Company c on p.companyId = c.id"+
            "left join School s on p.schoolId = s.id",
            countQuery = "select count(p.id)"+
                    "from Person p left join Company c on p.companyId=c.id"+
                    "left join School s on p.schoolId=s.id"
    )
    Page<UserDTO>getUserInfomationList(Pageable pageable);
}
