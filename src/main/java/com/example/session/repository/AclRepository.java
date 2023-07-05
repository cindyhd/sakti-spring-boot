package com.example.session.repository;

import com.example.session.entity.Acl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AclRepository extends CrudRepository<Acl, Long> {
    @Query(value = "SELECT COUNT(*) FROM ADM_R_SEC_ACL " +
            "WHERE KODE_ACL = 'FORM' " +
            "AND kode_kelompok_pengguna IN (SELECT ROLE_ID FROM ADM_R_SEC_USER_ROLE WHERE USER_ID = :userId) " +
            "AND ACL_OBJECT_ID IN (:form) " +
            "AND REKAM = 1", nativeQuery = true)
    int countFormAclCreateByUserAndFormId(@Param("userId") String userId, @Param("form") Integer form);


    @Query(value = "SELECT COUNT(*) FROM ADM_R_SEC_ACL " +
            "WHERE KODE_ACL = 'FORM' " +
            "AND kode_kelompok_pengguna IN (SELECT ROLE_ID FROM ADM_R_SEC_USER_ROLE WHERE USER_ID = :userId) " +
            "AND ACL_OBJECT_ID IN (:form) " +
            "AND UBAH = 1", nativeQuery = true)
    int countFormAclUpdateByUserAndFormId(@Param("userId") String userId, @Param("form") Integer form);


    @Query(value = "SELECT COUNT(*) FROM ADM_R_SEC_ACL " +
            "WHERE KODE_ACL = 'FORM' " +
            "AND kode_kelompok_pengguna IN (SELECT ROLE_ID FROM ADM_R_SEC_USER_ROLE WHERE USER_ID = :userId) " +
            "AND ACL_OBJECT_ID IN (:form) " +
            "AND HAPUS = 1", nativeQuery = true)
    int countFormAclDeleteByUserAndFormId(@Param("userId") String userId, @Param("form") Integer form);

    @Query(value = "SELECT COUNT(*) FROM ADM_R_SEC_ACL " +
            "WHERE KODE_ACL = 'FORM' " +
            "AND kode_kelompok_pengguna IN (SELECT ROLE_ID FROM ADM_R_SEC_USER_ROLE WHERE USER_ID = :userId) " +
            "AND ACL_OBJECT_ID IN (:form) " +
            "AND BACA = 1", nativeQuery = true)
    int countFormAclReadByUserAndFormId(@Param("userId") String userId, @Param("form") Integer form);
}
