package com.codecool.app.backend.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.codecool.app.backend.model.User;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static org.postgresql.jdbc.EscapedFunctions.INSERT;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    @Override
    Optional<User> findById(UUID id);

    Optional<User> findByUserName(String name);

    @Transactional
    @Modifying
    @Query(value = "insert into app_user_friends (user_id, friends_id)" +
            " VALUES (:id, :friends_id)", nativeQuery = true)
    void saveFriends(
            @Param("id") UUID userId,
            @Param("friends_id") UUID friendsId);





    @Query(value = "select * from app_user\n" +
            "left join app_user_friends on app_user.id =  app_user_friends.friends_id\n" +
            "where :user_id = app_user_friends.user_id", nativeQuery = true)
    Set<User> getFriendsByUserId(@Param("user_id") UUID userId);


    @Query(value = "select * from app_user\n" +
            "left join app_user_friends on app_user.id =  app_user_friends.user_id\n" +
            "where :app_user_friends.friends_id = app_user_friends.friends_id", nativeQuery = true)
    void getFriendsByFriendsId(@Param("app_user_friends.friends_id") UUID friends_id);
}
