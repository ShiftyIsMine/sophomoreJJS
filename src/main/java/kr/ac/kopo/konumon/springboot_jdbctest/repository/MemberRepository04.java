package kr.ac.kopo.konumon.springboot_jdbctest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import kr.ac.kopo.konumon.springboot_jdbctest.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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

    public Member selMethod(int id) {
        String jpql = "select entity from Member entity where id=:e_id";
        Query query = em.createQuery(jpql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getSingleResult();
        return member;
    }

    public Member updateMethod(Member member) {
        String jpql = "update Member set name=:e_name, age=:e_age,email=:e_email where id=:e_id";
        Query query = em.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.setParameter("e_id", member.getId());
        query.executeUpdate();
        return member;
    }

    public Member deleteMethod(int id) {
        String jpql = "delete from Member where id=:e_id";
        Query query = em.createQuery(jpql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getResultList();
        return member;
    }



}
