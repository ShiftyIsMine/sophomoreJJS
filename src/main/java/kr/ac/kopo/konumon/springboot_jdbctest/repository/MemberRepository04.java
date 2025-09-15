package kr.ac.kopo.konumon.springboot_jdbctest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import kr.ac.kopo.konumon.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

//EM을 사용할 때는 JPA Repository를 상속 받지 않음 ㅇㅇ
//@persistenceContext는 EM의 참조값을 주입 받음

@Repository
public class MemberRepository04 {
    @PersistenceContext
    private EntityManager em;

    public List<Member> selectMethod(){
        String jpql = "select entity from Member entity";
        Query query = em.createQuery(jpql);
        List<Member> memberList = query.getResultList();
        return memberList;
    }

//    @Transactional
//    public void insertMethod(String name, int age, String email) {
//        Member member = new Member();
//        member.setName(name);
//        member.setAge(age);
//        member.setEmail(email);
//        em.persist(member); // 엔티티를 영속성 컨텍스트에 저장
//    }

    @Transactional
    public void insertMethod(Member member) {
        String jpql = "insert into Member (name,age,email) values (:e_name, :e_age, :e_email)";
        Query query = em.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.executeUpdate();

    }

}
